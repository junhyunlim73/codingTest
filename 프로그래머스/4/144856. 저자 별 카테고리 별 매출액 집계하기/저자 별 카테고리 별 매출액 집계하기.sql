-- 코드를 입력하세요
select bs.AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum(TOTAL_SALES) TOTAL_SALES
from (SELECT b.book_id, CATEGORY, AUTHOR_ID, price * sum(s.SALES) TOTAL_SALES
from BOOK b
join BOOK_SALES s
on b.BOOK_ID = s.BOOK_ID
where to_char(SALES_DATE, 'YYYY-MM') = '2022-01'
group by b.BOOK_ID, CATEGORY, AUTHOR_ID, price) bs
join AUTHOR a
on bs.AUTHOR_ID = a.AUTHOR_ID
group by bs.AUTHOR_ID, AUTHOR_NAME, CATEGORY
order by bs.AUTHOR_ID, CATEGORY desc