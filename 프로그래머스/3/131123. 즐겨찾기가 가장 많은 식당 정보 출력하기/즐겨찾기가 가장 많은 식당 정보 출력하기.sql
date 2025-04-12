-- 코드를 입력하세요
select FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from REST_INFO
where (food_type, FAVORITES) in (
    SELECT FOOD_TYPE, max(FAVORITES) FAVORITES
from REST_INFO
group by FOOD_TYPE)
order by FOOD_TYPE desc