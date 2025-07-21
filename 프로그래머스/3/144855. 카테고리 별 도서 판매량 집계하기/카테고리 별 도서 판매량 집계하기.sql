-- 코드를 입력하세요
SELECT CATEGORY, sum(SALES) as "TOTAL_SALES"
from BOOK b
join BOOK_SALES s
on b.book_id = s.book_id
where SALES_DATE like '2022-01%'
group by CATEGORY
order by CATEGORY