-- 코드를 입력하세요
select FLAVOR
from (SELECT f.FLAVOR
from FIRST_HALF f
join (
select flavor, sum(TOTAL_ORDER) as "TOTAL_ORDER"
from july
group by flavor
) j
on f.FLAVOR = j.FLAVOR
order by (f.total_order + j.total_order) desc)
where rownum <= 3