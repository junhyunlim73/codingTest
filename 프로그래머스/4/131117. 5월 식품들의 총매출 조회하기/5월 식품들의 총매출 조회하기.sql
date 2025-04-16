-- 코드를 입력하세요
SELECT PRODUCT_ID, PRODUCT_NAME, sum(PRICE) TOTAL_SALES
from (
select o.PRODUCT_ID, p.PRODUCT_NAME, (amount*PRICE) PRICE
from FOOD_PRODUCT p 
join FOOD_ORDER o
on p.product_id = o.product_id
where to_char(PRODUCE_DATE, 'YYYY-MM') = '2022-05'
) op
group by PRODUCT_ID, PRODUCT_NAME
order by TOTAL_SALES desc, PRODUCT_ID