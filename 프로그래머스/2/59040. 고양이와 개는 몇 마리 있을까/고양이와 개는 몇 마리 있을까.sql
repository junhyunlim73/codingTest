-- 코드를 입력하세요
SELECT ANIMAL_TYPE, count(*) as "COUNT"
from ANIMAL_INS
group by ANIMAL_TYPE
order by ANIMAL_TYPE