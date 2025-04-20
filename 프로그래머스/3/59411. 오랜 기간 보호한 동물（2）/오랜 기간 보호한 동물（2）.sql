-- 코드를 입력하세요
select ANIMAL_ID, NAME
from (SELECT  i.ANIMAL_ID, i.name
from ANIMAL_INS i
join ANIMAL_OUTS o
on i.ANIMAL_ID = o.ANIMAL_ID
order by (o.DATETIME - i.DATETIME) desc) io
where rownum <= 2