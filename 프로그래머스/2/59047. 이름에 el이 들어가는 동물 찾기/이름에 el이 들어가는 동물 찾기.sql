-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
from ANIMAL_INS
where instr(lower(name), 'el') > 0
and ANIMAL_TYPE = 'Dog'
order by NAME