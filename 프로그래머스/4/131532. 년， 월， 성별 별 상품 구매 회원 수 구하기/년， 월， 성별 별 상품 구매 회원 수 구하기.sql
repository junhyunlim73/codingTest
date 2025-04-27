-- 코드를 입력하세요
SELECT to_char(SALES_DATE, 'YYYY') "YEAR", to_number(to_char(SALES_DATE, 'MM')) "MONTH", gender,
count(distinct i.user_id) "USERS"
from USER_INFO i
join ONLINE_SALE o
on i.USER_ID = o.USER_ID
where gender is not null
group by to_char(SALES_DATE, 'YYYY'), to_number(to_char(SALES_DATE, 'MM')), gender
order by YEAR, MONTH, gender