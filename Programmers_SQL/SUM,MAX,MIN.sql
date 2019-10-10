-- 최댓값 구하기
SELECT datetime from ANIMAL_INS
order by datetime desc
limit 1;

-- 최솟값 구하기
SELECT datetime
from ANIMAL_INS
where datetime = (select min(datetime) from ANIMAL_INS);

-- 동물 수 구하기
SELECT count(*)
from ANIMAL_INS;

-- 중복 제거하기
SELECT count(distinct(name))
from ANIMAL_INS;