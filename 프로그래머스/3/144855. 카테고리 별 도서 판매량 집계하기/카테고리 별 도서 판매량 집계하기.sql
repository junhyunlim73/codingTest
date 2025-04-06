-- 코드를 입력하세요
SELECT category, sum(sales) "TOTAL_SALES"
from  BOOK b
join BOOK_SALES bs
on b.book_id = bs.book_id
where TO_CHAR(SALES_DATE, 'YYYY-MM-DD') like '2022-01%'
group by category
order by category