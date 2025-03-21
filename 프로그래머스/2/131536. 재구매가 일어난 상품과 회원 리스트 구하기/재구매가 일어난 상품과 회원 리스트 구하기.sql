-- 코드를 입력하세요
SELECT distinct user_id, product_id
from ONLINE_SALE o
where exists (
select 'X'
from ONLINE_SALE i
where o.USER_ID = i.USER_ID
and o.product_id = i.product_id
and o.SALES_DATE <> i.SALES_DATE
)
order by user_id, product_id desc