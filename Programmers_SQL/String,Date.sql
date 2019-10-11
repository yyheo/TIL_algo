-- 루시와 엘라 찾기
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
from ANIMAL_INS
where NAME in ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty');

-- 이름에 el이 들어가는 동물 찾기
-- 이름에 el에 들어가고, 개인 동물 찾기. 이름 순 정렬
SELECT ANIMAL_ID, NAME
from ANIMAL_INS
where NAME like '%El%' and ANIMAL_TYPE='Dog'
order by name;

-- 중성화 여부 파악하기
SELECT ANIMAL_ID, NAME, if (SEX_UPON_INTAKE like '%Neutered%', 'O',
                        if (SEX_UPON_INTAKE like '%Spayed%', 'O', 'X')) as 중성화
from ANIMAL_INS

-- 오랜 기간 보호한 동물(2)
-- out 테이블에 있는 동물 중, 보호기간이 가장 길었던 동물 두 마리의 정보를 조회
-- 보호기간이 긴 순으로 조회
SELECT o.ANIMAL_ID, o.name
from ANIMAL_INS i, ANIMAL_OUTS o
where i.ANIMAL_ID = o.ANIMAL_ID
order by DATEDIFF(o.DATETIME, i.DATETIME) desc
limit 2;

-- DATETIME에서 DATE로 형 변환
-- 시각(시-분-초)을 제외한 날짜(년-월-일)만 보여주기
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d') as 날짜
from ANIMAL_INS
order by ANIMAL_ID