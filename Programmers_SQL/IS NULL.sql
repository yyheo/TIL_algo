-- 이름이 없는 동물의 아이디
SELECT animal_id
from ANIMAL_INS
where NAME is null;

-- 이름이 있는 동물의 아이디
SELECT animal_id
from ANIMAL_INS
where NAME is not null;

-- NULL 처리하기
SELECT ANIMAL_TYPE, ifnull(name, "No name"), SEX_UPON_INTAKE
from ANIMAL_INS;