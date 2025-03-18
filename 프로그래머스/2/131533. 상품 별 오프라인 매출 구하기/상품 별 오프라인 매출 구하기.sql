-- 코드를 입력하세요
SELECT p.product_code, (sum(sales_amount) * p.price) "SALES"
from PRODUCT p
join OFFLINE_SALE o
on p.product_id = o.product_id
group by p.product_code, p.price
order by "SALES" desc, p.product_code