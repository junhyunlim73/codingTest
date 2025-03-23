-- 코드를 입력하세요
select a.name, a.datetime
from (SELECT i.name, i.datetime
from ANIMAL_INS i
left join ANIMAL_OUTS o
on i.animal_id = o.animal_id
where o.animal_id is null
order by i.datetime) a
where rownum <= 3