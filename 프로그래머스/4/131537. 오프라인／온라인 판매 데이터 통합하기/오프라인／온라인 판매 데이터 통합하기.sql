-- 코드를 입력하세요
SELECT date_format(SALES_DATE, '%Y-%m-%d') as "SALES_DATE", PRODUCT_ID, USER_ID, SALES_AMOUNT
from ONLINE_SALE
where month(SALES_DATE) = 3
union all
SELECT date_format(SALES_DATE, '%Y-%m-%d') as "SALES_DATE", PRODUCT_ID, null, SALES_AMOUNT
from OFFLINE_SALE
where month(SALES_DATE) = 3
order by SALES_DATE, PRODUCT_ID, USER_ID