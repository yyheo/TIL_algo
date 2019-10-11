-- 없어진 기록 찾기
-- ANIMAL_OUTS 테이블에는 있으나 ANIMAL_INS에는 없는 동물의 ID, 이름을 ID 순으로 조회
SELECT ANIMAL_ID, name
from ANIMAL_OUTS i
where not exists (select 1 from ANIMAL_INS o where i.ANIMAL_ID = o.ANIMAL_ID)
order by ANIMAL_ID;

-- 있었는데요 없었습니다
-- animal_outs의 datetime이 danimal_ins의 datetime보다 더 빠른 동물의 아이디와 이름 조회
-- 보호 시작일이 빠른 순으로 조회
SELECT i.ANIMAL_ID, i.NAME
from ANIMAL_INS i, ANIMAL_OUTS o
where i.ANIMAL_ID = o.ANIMAL_ID and i.DATETIME > o.DATETIME
order by i.DATETIME;

-- 오랜 기간 보호한 동물(1)
-- in 테이블엔 있지만 out 테이블엔 없는 동물 중, 가장 오래 보호소에 있었던 동물 3마리 출력
-- 결과는 보호 시작일 순으로 조회
SELECT name, datetime
from ANIMAL_INS i
where not exists (select 1 from animal_outs o where i.ANIMAL_ID = o.ANIMAL_ID)
order by i.datetime
limit 3;

-- 보호소에서 중성화한 동물
-- in 테이블에는 중성화 되지 않았찌만 out 테이블에는 중성화된 동물 정보 출력
-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.ANIMAL_TYPE, i.NAME
from ANIMAL_INS i, ANIMAL_OUTS o
where i.ANIMAL_ID = o.ANIMAL_ID and SEX_UPON_INTAKE like '%Intact%' and
    (SEX_UPON_OUTCOME like '%Spayed%' or SEX_UPON_OUTCOME like '%Neutered%')
order by i.ANIMAL_ID;
