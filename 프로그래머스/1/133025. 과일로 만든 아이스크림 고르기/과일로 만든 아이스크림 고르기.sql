-- 코드를 입력하세요
select f.flavor
from FIRST_HALF f, icecream_info i
where f.flavor = i.flavor and (f.total_order >= 3000) and (i.ingredient_type = 'fruit_based')
order by f.total_order desc;
