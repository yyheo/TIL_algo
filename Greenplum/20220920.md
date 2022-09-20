# Greenplum
- zoom: 916 8685 2058 / Greenplum
- putty : gpadmin / changeme
- dbeaver : testuser / testuser
---
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
	- Heap Storage
	- Append-Optimized Storage
		> use appendonly =true option
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
