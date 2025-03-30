-- 코드를 입력하세요
SELECT substr(PRODUCT_CODE, 1, 2) "CATEGORY", count(*) "PRODUCTS"
from PRODUCT
group by substr(PRODUCT_CODE, 1, 2)
order by CATEGORY