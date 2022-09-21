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

### Distribution
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
	- Data Skew
	- Processing Skew : 기간을 distribute key로 잡았을 때, 실제 query를 날릴 때는 특정 기간만 보는 경우가 많아서 skew 발생. 날짜와 관련된 column은 distribute key에서 피하는 것이 좋음
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
	- distribution은 병렬화를 위한 것, partitioning은 데이터를 쪼갠 것!
	- Range / List Partitioning
	- 일정한 구간으로 나눌 수 있는 partition 중요
- Creating Partitioned Tables
	- partition은 table 생성시에만, `CREATE TABLE`로 설정
	- local index
	- 멀티 레벨은 가급적 사용 X
- 내일 다시 정리..
#### Quiz
- 테이블 파티션을 설정할 컬럼은 데이터분포도가 좋은 PK에 유사할 수록 효과적이다 : X
	분산키 설명. 파티션은 groupping 하기 좋아야 함. 분포도가 높은!
- 일반 테이블을 파티션을 하기 위해 ALTER TABLE로 적용할 수 없으므로 새로 만들어야한다 : O
  이미 있는 파티션 테이블은 수정 가능
### Temporary Tables
- session에서 생겼다가 사라지는 table
- join 성능 향상을 위해 분산키 사용해서 temp table 만들 때 사용
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
#### Quiz (맞는 것 고르기
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
