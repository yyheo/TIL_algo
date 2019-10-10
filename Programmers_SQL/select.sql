-- 모든 레코드 조회하기
SELECT * from ANIMAL_INS order by ANIMAL_ID;

-- 역순 정렬하기
SELECT NAME, DATETIME from ANIMAL_INS order by ANIMAL_ID desc;

-- 아픈 동물 찾기
SELECT ANIMAL_ID, NAME from ANIMAL_INS
WHERE INTAKE_CONDITION = 'Sick';

-- 어린 동물 찾기
SELECT ANIMAL_ID, NAME from ANIMAL_INS
WHERE INTAKE_CONDITION != 'Aged'
order by ANIMAL_ID;

-- 동물의 아이디와 이름
SELECT ANIMAL_ID, NAME
from ANIMAL_INS
order by ANIMAL_ID;

-- 여러 기준으로 정렬하기
SELECT ANIMAL_ID, name, DATETIME
from ANIMAL_INS
order by name, datetime desc;

-- 상위 n개 레코드
SELECT name from ANIMAL_INS
order by datetime
limit 0, 2;