-- 코드를 입력하세요
SELECT year(SALES_DATE) as "YEAR", month(SALES_DATE) as "MONTH", GENDER, count(distinct u.user_id) as "USERS"
from USER_INFO u
join ONLINE_SALE o
on u.USER_ID = o.USER_ID
where gender is not null
group by year(SALES_DATE), month(SALES_DATE), GENDER
order by year(SALES_DATE), month(SALES_DATE), GENDER