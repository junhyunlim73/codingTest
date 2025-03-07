-- 코드를 입력하세요
SELECT name
from (
    select *
    from ANIMAL_INS
order by DATETIME)
where ROWNUM <= 1;