-- 코드를 작성해주세요
select p.id, count(c.id) as "CHILD_COUNT"
from ECOLI_DATA p
left join ECOLI_DATA c
on p.ID = c.PARENT_ID
group by p.id
order by p.id