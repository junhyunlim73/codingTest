-- 코드를 입력하세요
SELECT h.FLAVOR
from FIRST_HALF h
join ICECREAM_INFO i
on h.FLAVOR = i.FLAVOR
where TOTAL_ORDER > 3000
and INGREDIENT_TYPE like 'fruit%'
order by TOTAL_ORDER desc