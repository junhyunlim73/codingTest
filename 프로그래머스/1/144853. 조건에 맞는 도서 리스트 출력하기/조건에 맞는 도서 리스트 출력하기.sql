-- 코드를 입력하세요
SELECT book_id, TO_char(published_date, 'YYYY-MM-DD') published_date
from book
where category = '인문'
and TO_char(published_date, 'YYYY') = '2021'
order by published_date