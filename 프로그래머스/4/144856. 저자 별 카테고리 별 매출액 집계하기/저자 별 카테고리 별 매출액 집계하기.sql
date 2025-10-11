-- 코드를 입력하세요
select bs.AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum(TOTAL_SALES) as "TOTAL_SALES"
from (SELECT AUTHOR_ID, s.BOOK_ID, CATEGORY, PRICE * sum(SALES) as "TOTAL_SALES"
from BOOK b
join BOOK_SALES s
on b.BOOK_ID = s.BOOK_ID
where month(SALES_DATE) = 1
group by AUTHOR_ID, s.BOOK_ID, CATEGORY, price) bs
join AUTHOR a
on bs.AUTHOR_ID = a.AUTHOR_ID
group by bs.AUTHOR_ID, AUTHOR_NAME, CATEGORY
order by bs.AUTHOR_ID, CATEGORY desc