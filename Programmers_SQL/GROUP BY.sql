-- 고양이와 개는 몇 마리 있을까
SELECT animal_type, count(*)
from ANIMAL_INS
group by animal_type;

-- 동명 동물 수 찾기
SELECT NAME, count(NAME) as COUNT
from ANIMAL_INS
group by name
having COUNT >= 2
order by name;

-- 입양 시각 구하기(1)
-- 시간대 별로 입양이 몇건이나 발생했는지 조회. 테이블에 있는 값만
SELECT HOUR(DATETIME) as HOUR, COUNT(*)
from ANIMAL_OUTS
group by HOUR
having HOUR >= 9 and HOUR <= 19
order by HOUR

-- 입양 시각 구하기(2)
-- 시간대별로 입양이 된 count 구하기. hour 변수 사용. 테이블에 없는 시간대도 조회
set @hour:=-1;
select @hour:=@hour+1 as HOUR, (select count(*) from ANIMAL_OUTS where HOUR(DATETIME) = @hour) as COUNT
from ANIMAL_OUTS
where @hour <= 22;