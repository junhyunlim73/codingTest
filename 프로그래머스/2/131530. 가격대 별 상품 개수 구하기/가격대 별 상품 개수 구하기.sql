-- 코드를 입력하세요
SELECT (trunc((price / 10000), 0) * 10000) "PRICE_GROUP", count(*) PRODUCTS
from PRODUCT
group by trunc((price / 10000), 0)
order by trunc((price / 10000), 0)