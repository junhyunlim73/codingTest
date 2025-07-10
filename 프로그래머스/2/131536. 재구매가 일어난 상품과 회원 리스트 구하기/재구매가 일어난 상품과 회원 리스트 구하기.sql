-- 코드를 입력하세요
SELECT distinct USER_ID, PRODUCT_ID
from ONLINE_SALE o
where exists
( select 'X'
from ONLINE_SALE s
where o.USER_ID = s.USER_ID
and o.PRODUCT_ID = s.PRODUCT_ID
and o.SALES_DATE <> s.SALES_DATE
)
order by USER_ID, PRODUCT_ID desc