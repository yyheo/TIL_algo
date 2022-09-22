# Greenplum
- zoom: 916 8685 2058 / Greenplum
- putty : gpadmin / changeme
- dbeaver : testuser / testuser
## 1. Greenplum Architecture 
### Quiz
- Greenplum에서 데이터가 저장되고 연산,처리되는 곳은 마스터
- Greenplum의 시스템 장애에 따른 데이터 유실을 방지하고 지속적인 서비스를 제공하고자 구성한 장애 대응 방법은 세그먼트 미러링
- 쿼리가 실행될 때 각각의 세그먼트는 별도의 최적화된 쿼리 플랜을 만들어 실행하고 마스터로 결과를 보낸다 
## 2. Greenplum Installation
- Start Greenplum
	- gpstart
- Stop Greenplum
	- gpstop
- Reload Greenplum configurations
	- gpstop -u (stop 아니고 reload !!)
- Check the status of Greenplum
	- gpstate
	- gpstate -f
	- gpstate -m
- SELECT * FROM gp_segment_configuration
## 3. Greenplum Utilities
- PSQL로 DB 연결해서 query
```
psql gplab
gplab =# SELECT * FROM foo;
```
- psql은 앞 sql이 실패되어도 skip하고 뒤 sql이 실행되기 때문에 따로 처리해야 함 `-
v ON_ERROR_STOP=1`

### 실습
- 실습자료 3~6 page

## 4. Database Structure & Access Control
### Schemas
- 각 Database, 각 Schema는 독립적
- schema 여러개에 동일한 name의 table이 있으면 search_path 참조
- 다음 schema 들은 모든 database에 존재
	`PUBLIC, pg_catalog, gp_toolkit, information_schema 등`
#### Quiz
- 그린플럼 인스턴스 당 데이터베이스는 하나씩 사용해야한다 : X
- 스키마 이름은 User와 일치해야 사용할 수 있다 : X
- 스키마 이름을 명시하지 않았을 경우 스키마 이름을 찾는 순서를 나타내는 변수의 이름은 : search_path
### Access Control
- User Role : login 가능
- Group Role : login 불가
#### Quiz
- 테이블을 조회하기 위한 최소한의 권한은 DB레벨:Connect, 스키마레벨:Usage, 테이블레벨:Select
- 사용자(Role)를 생성하고 데이터베이스, 스키마, 테이블에 대한 적절한 사용 권한을 부여하면 데이터베이스에 연결할 수 있다 : X (데이터베이스 연결은 인증이 있어야 함)
### 실습
- 서버에서 ip확인 ifconfig
- user 등록하고 권한주기, pg_hba.conf 수정하고 gpstop-u : 이것도 dbeaver에서 할 수 있나..?
- dbeaver connection
- 7~11
```sql
-- schema 생성
CREATE SCHEMA temp;
CREATE TABLE temp.test (id int) distributed by (id);
SELECT * FROM temp.test;
SELECT * FROM test; -- ERROR
show search_path; -- public, public, "$user"
show search_path; -- public, temp
SELECT * FROM test; -- 가능

-- Role 생성
CREATE ROLE reader WITH LOGIN;
GRANT reader TO testuser;
set role reader;
select * from temp.test; -- 권한 없음
set role testuser; -- (or) reset role;
GRANT CONNECT ON DATABASE testdb TO reader;
GRANT USAGE ON SCHEMA temp TO reader;
GRANT SELECT ON TABLE temp.test TO reader;
set role reader;
SELECT * from temp.test;
select current_user;
INSERT INTO temp.test VALUES (1); -- 권한 없음
```
## 5. Data Definition Language
### Tables
- Storage model
	- Heap Storage : update/delete 많은 table에 유리
	- Append-Optimized Storage
		> use appendonly = true option
- Defining Default Table Storage Options
	```sql
	ALTER ROLE STUDENT SET
	GP_DEFAULT_STORAGE_OPTIONS APPENDONLY TRUE,COMPRESSTYPE ZLIB
	SET ROLE STUDENT;
	```
#### quiz
- OX퀴즈-테이블을 생성할 때 지정한 스토리지 옵션은 alter table 구문으로 변경할 수 있다 : X
- Appendonly로 지정한 테이블은 Insert 구문으로 데이터를 저장하는 것만 가능하므로 데이터를 수정하기 위해서는 appendoptimized 옵션을 써야 한다 : X
- 그린플럼 테이블을 생성할 때 압축률과 성능이 가장 우수한 알고리즘은 : zStd (6버전에서만 가능)

### Distribution ★중요★
- GP의 병렬 구조를 잘 사용하기 위해 중요!
- DISTRIBUTED BY (column_name)
	- 분산키를 만들 때 조인 고려
	- 큰 테이블의 경우 로컬 조인(동일화된 조인)을 통해 성능 향상
- DISTRIBUTED RANDOMLY
	- 데이터를 모든 segment에 분산
	- 작은 table에서만 사용 가능
- DISTRIBUTED REPLICATED
	- 동일한 data set이 모든 segment에 동일하게 저장
	- 로컬 join이 일어남
	- storage가 많이 필요, 작은 table에서만 사용 가능
- Distribution Keys and Skew
	- Data Skew : 데이터가 어느 한쪽에 몰려있는 경우
	- Processing Skew : 기간을 distribute key로 잡았을 때, 실제 query를 날릴 때는 특정 기간만 보는 경우가 많아서 skew 발생. 날짜와 관련된 column(query filter에서 사용되는 column)은 distribute key에서 피하는 것이 좋음
- Distribute Key를 지정하지 않았을 경우에는, Primary key가 있으면 Primary key, 없으면 첫 column으로 분산키로 지정 됨.
- Management of Distribution Key
	- 분산 키 변경 (drop, recreate 필요 없음)
		```sql
		ALTER TABLE tab_test set distributed by (c);
		ALTER TABLE tab_test set distributed randomly;
		```
	- 분산 성능 Check. 각 segment별로 row 수가 비슷해야 좋음
		```sql
		Select gp_segment_id as num_segment,count (1) as nb_lig
		from tab_test
		group by gp_segment_id
		order by gp_segment_id
		```
- 피해야 할 분산 전략
	- 분산만을 위해 열을 만들어서 지정 금지
		(join에 사용되지 않아서 비효율적)
	- boolean type 금지
	- cardinality가 낮은 key 금지
	- floating point type 금지
	- 편하다는 이유로 randomly 방식 사용 금지
#### Quiz
- 테이블을 생성할 때 분산키를 지정하지 않으면 테이블의 첫번째 컬럼이 분산키로 설정된다
- 분산키는 데이터의 분포도가 좋은 값을 가지는 컬럼이 바람직하므로 데이터를 처리한 timestamp값을 가진 컬럼이 좋은 후보가 된다 : X

### Data Types
- Data Type 모범 사례
	- join에 사용되는 양 컬럼은 동일한 data type으로 설정. (그렇지 않을 경우 resource intensive)
	- join에 사용되는 양 컬럼은 data type의 자리수도 동일해야 함. (for local join)
	- char은 안되는데 varchar은 됨..

 ### Indexes
 ### Other Objects
 - View
 - Sequence
 #### Quiz
 - 그린플럼에서는 인덱스를 만들면 안된다 : X
 - 그린플럼에서 뷰에 직접적으로 데이터를 업데이트 할 수 없다 : O
 - 그린플럼은 여러 노드에서 병렬로 동작하므로 각 노드의 시퀀스가 다른 노드의 시퀀스값과 중복될 가능성이 있다 : O

### 실습
## 6. Storage Optimization
### Tablespace
### Partitioning ★중요★
- Partition?
	- 쿼리 성능 개선을 위함
	- distribution은 병렬화를 위한 것 (ㅣㅣㅣ), partitioning은 데이터를 쪼갠 것! (ㅡ ㅡ ㅡ)
	- cardinality가 낮은 key로 잡음
	- Range / List Partitioning
	- 일정한 구간으로 나눌 수 있는 partition 중요
- Creating Partitioned Tables
	- partition은 table 생성시에만, `CREATE TABLE`로 설정
	- local index
	- 멀티 레벨, 너무 많은 파티션은 가급적 사용 X
	- default partition은 안 쓸수록 좋음
#### Quiz
- 테이블 파티션을 설정할 컬럼은 데이터분포도가 좋은 PK에 유사할 수록 효과적이다 : X
	분산키 설명. 파티션은 groupping 하기 좋아야 함.
- 일반 테이블을 파티션을 하기 위해 ALTER TABLE로 적용할 수 없으므로 새로 만들어야한다 : O
  이미 있는 파티션 테이블은 수정 가능
### Temporary Tables
- session에서 생겼다가 사라지는 table
- join 성능 향상을 위해 분산키 사용해서 temp table 만들 때 사용
- 일반 table의 storage 옵션을 적용할 수 있음 (column/compress)
- mirror 영역 사용하지 않음
- inert 할때 성능향상 가능한 옵션 : `SET AUTOSTATS_MODE = NONE;`
- Unlogged tables
	- temp 테이블처럼 mirror 영역 사용하지 않는 일반 테이블
	- 세션이 끝났다고 사라지진 않음
### 실습
## 7. Loading Data
- Insert (소량) : 가장 기본 insert 구문
- Copy (소량) : postegreSQL에서 제공하는 문법
	- 모든 데이터를 master를 통해 받음
	```sql
	COPY mytable FROM '/data/myfile.csv' WITH CSV HEADER;
	COPY 'select * from mytable' TO '/data/my_output_file'
	```
	- Error Handling : LOG ERRORS
- External Tables & gpfdist protocol (대량)
	- 병렬처리를 하면서 data load 하는 방식
	- gpfdist가 각 segment와 통신
	- gpfdist / pxf ...
	- External table create 시점에는 error 모름. select 할 때 알게 됨
- GPLOAD (대량)
	- 위 방식을 simple 하게 만들어놓은 utility
	- YAML  파일을 설정
	- 실행 : `gpload -f <YAML conf file>`
	- merge가 필요할 경우, stage table에 넣고 join delete, insert하는게 더 좋음!
	- 분산키 맞추고 join delete 하면 더 좋음. local join 발생
- Data Loading Performance TIps
	- index는 삭제하고 데이터 로드 후에 다시 만드는게 빠름
	- 대량 로드 후엔 vacuum/analyzer 필수
### Integration with Hadoop
- PXF(Greenplum Platform Extension Framework)
	- pxf config에서 어떤 format인지 설정
#### Quiz (맞는 것 고르기)
Insert 문으로는 한번에 한 row만 입력한다
-> select insert 써서 여러개 가능,,
**copy를 이용하여 데이터를 로드,언로드 모두 할 수 있다**
external table은 데이터 로드 전용 인터페이스이다
-> 로드, 언로드 다 가능
**gpload를 사용하기 위해서는 yaml 파일 정의가 필요하다
pxf 프로토콜을 통해 이기종 데이터베이스와 연결할 수 있다**
copy를 이용해 하둡시스템의 데이터를 로드할 수 있다
-> pxf
gpfdist 프로세스는 external table을 drop 하면 kill된다
-> 서로 상관 없음
#### 실습 : Lab6
- error log 확인하는 법!

## 8. Data Manipulation Language
### Managing data
- Updating Data
	- 기존 Data 삭제 -> Insert 구조
- Data 삭제
	- 삭제가 됐다고 해서, 삭제 된 자리가 채워지는게 아니라 남아 있음. -> bloat 현상. vacuum 작업으로 처리 필요
- Recursive query
	- oracle의 connect by와 유사
	- 병렬처리와는 맞지 않는 듯..
- WITH
### Transaction
- greenplum은 Autocommit
- MVCC: MultiVersion Concurrency Control
- Isolation level of Transactions
	- 동시에 사용할때 생길 수 있는 문제점들을 위한 격리 수준
	- Greenplum은 READ COMMITTED(Default), SERIALIZABLE 사용
- Lock Concflict
	- 어려워..
#### Quiz
- update 문으로 분산키 컬럼의 값을 변경할 수 없다 : X
- 그린플럼이 사용하는 transaction isolation 레벨은? read committed

## 9. Function
### Internal Functions
- NOW() vs TIMEOFDAY()
	NOW(), current_timestamp 는 트랜젝션의 시작 값을 반환 함. 트랜젝션 안에서 NOW()은 항상 같은 값, TIMEOFDAY(), clock_timestamp은 항상 다른 값 반환
### SQL Functions
- Function Overloading 제공
- returning sets ?
### PL/PGSQL
- 프로시저 랭귀지
- Dynamic SQL - Prepare And Execute
- Exception 처리
- Function: COST
  함수에 대해 cost가 얼마나 발생할지 미리? 알려주는 것
### Anonymous Blocks

## 10. Physical design
### 고려사항
> - Data distribution and distribution key selection
> - Checking for data skew
> - Choosing appropriate data types
> - To partition or not
> - Defining constraints
- Data Distribution
	- high cardinality
	- key 값은 table 생성 후에도 변경될 수 있음
	- unique pk나 index가 있으면 분산 키는 이 중 일부여야 함
- 분산 Default (이대로 설정 안되는게 좋음)
	- 분산키 없으면, pk가 분산키가 되고, pk가 없으면 첫번째 컬럼이 지정 됨
	- 적합한 열이 없으면 random 방식
- 분산 RANDOMLY
	- redistribute or broadcast motion이 일어날 수 밖에 없음
	- 큰 테이블엔 적합하지 않음!
- Distribution Best Practices
	- Default 값 사용 안하기
	- column은 적을 수록 좋음
	- where절에 사용할 colum(date, timestamp) 은 사용 안하기. 파티션으로 사용하는게 좋음
	- 파티션과 분산키 같으면 안됨
	- 데이터가 고르게 분포되어 있는지 확인
- Data Skew 확인
	- gp_toolkit.gp_skew_coefficients (data skew)
	- gp_toolkit.gp_skew_idle_fractions (processing skew)
	- 각 segment 별로 count
		```sql
		SELECT gp_segment_id , count(*)
		FROM table_name
		-- WHERE column='value’
		GROUP BY gp_segment_id
		```
- Data Type Best Practices
	- 분산키 간 data type, 자릿수 같아야 Local join 일어남
- Table Partitioning Best Practices
	- date 처럼 일정한 파틀 나뉠 수 있는 값 사용
	- 가능한 기본 partition 사용하지 않기
- Index
	- 꼭 필요한 경우에만 사용해야 함
### Quiz (맞는 말 고르기)
V 모든 테이블은 분산정책이 반드시 설정되어 생성된다
분산키를 지정하면 PK가 함께 생성된다
분산키와 파티션키를 일치시키면 성능이 좋다
데이터 스큐가 없는 테이블은 병렬 처리를 보장할 수 있다
-> processing skew도 있음
Local join을 위해서는 테이블의 데이터값이 일치하면 된다
-> 자릿수(length)도 일치해야 함
V 테이블 파티션을 할 때 cardinality가 비교적 낮은 컬럼이 좋은 후보다
V 테이블 파티션 컬럼으로 날짜형을 많이 쓰는 편이다
테이블 파티션을 적용하는 경우에는 인덱스 생성이 필요없다
## 11. Query Performance Analysis
### Query Profiling
### Analyzing Query Plan
#### Quiz
- 대용량 테이블을 조회하는데 있어서 효율적으로 사용되는 그린플럼의 조인 오퍼레이터는 Hash Join
- 쿼리플랜의 cost는 얼마나 많은 CPU연산이 일어나는지 확인하는 척도이다 X
	-> DISK I/O
- 일반적으로 redistribution motion보다는 broadcast motion이 효율적이다 X
### Statistics
- GP에서 analyze는 하는게 좋음
- 통계 정보는 batch process 끝날때 하는게 좋음
- 대규모 data에서는 필요한 컬럼만 analyze 하는게 좋음
#### Quiz
- 쿼리의 성능이 개선될 때까지 통계정보를 갱신하다가 어느 정도 일정 성능이 유지되면 더 이상 통계정보를 갱신할 필요가 없다 : X
- 대용량 테이블에 대한 통계정보갱신을 효율화하기 위해 조인컬럼이나 필터컬럼만 선별적으로 통계정보를 갱신한다 : O
- 데이터 테이블을 truncate하면 통계정보도 함께 truncate 된다 : X
	-> 갱신을 해야 함
### Performance Tips
- 옵션들 설명..
### PQO
- partition table에서
#### Quiz
- 쿼리성능개선을 위해 쿼리플랜을 확인할 때 체크해야할 정보가 아닌것은?
	- 쿼리비용(cost)
	- 데이터 압축 V
	- 조인 순서
	- 파티션 사용
- Short 쿼리 성능 개선을 위한 파라매터 설정이 아닌것은
	- gp_segments_for_planner=2 V
		broadcast 해라
	- statememt_mem=32MB
	- random_page_cost=1
	- enable_nestloop=ON
### 실습! Lab. 8 Query Tuning
- gp_autostats_mode가 on_no_stats이면, 통계정보가 없으면 auto로 갱신하라는 뜻
	- `set gp_autostats_mode=none;` 
- data skew 확인
	```sql
	SELECT 'training.customer' tb_nm, gp_segment_id, count(*)
	FROM training.customer
	GROUP BY gp_segment_id
	ORDER BY 2;
	
	SELECT 'customer' tb_nm
	, sum(row_count) t_cnt
	, Avg(Row_Count) avg_cnt
	, max(Row_Count) max_cnt
	,(1-(Avg(Row_Count)/Max(Row_Count)))*100 as Skew_Pct
	FROM (SELECT gp_segment_id, count(*) as Row_Count
	FROM customer
	GROUP BY gp_segment_id) A ;
	```

