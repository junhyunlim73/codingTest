-- 코드를 입력하세요
SELECT CATEGORY, price "MAX_PRICE", PRODUCT_NAME
from (SELECT CATEGORY, PRODUCT_NAME, price, rank() over(partition by CATEGORY order by PRICE desc) RANK
     from FOOD_PRODUCT
     where category in ('과자', '국', '김치', '식용유'))
where rank = 1
order by MAX_PRICE desc