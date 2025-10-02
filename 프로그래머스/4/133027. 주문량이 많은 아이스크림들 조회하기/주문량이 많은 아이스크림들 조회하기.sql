-- 코드를 입력하세요
SELECT f.FLAVOR
from FIRST_HALF f
join ( select flavor, sum(TOTAL_ORDER) as "TOTAL_ORDER"
from JULY
group by flavor
) j
on f.flavor = j.flavor
order by (f.TOTAL_ORDER + j.TOTAL_ORDER) desc
limit 3