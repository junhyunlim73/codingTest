-- 코드를 입력하세요
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, decode(STATUS, 'DONE', '거래완료', 'SALE', '판매중',
                                                'RESERVED', '예약중') as "STATUS"
from USED_GOODS_BOARD
where TO_CHAR(CREATED_DATE, 'YYYY-MM-DD') = '2022-10-05'
order by board_id desc