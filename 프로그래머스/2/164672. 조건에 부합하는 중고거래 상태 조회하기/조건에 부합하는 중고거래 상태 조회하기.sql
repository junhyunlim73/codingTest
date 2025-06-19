-- 코드를 입력하세요
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, 
case 
when STATUS = 'DONE' then '거래완료'
when STATUS = 'SALE' then '판매중'
when status = 'RESERVED' then '예약중'
end as "STATUS"
from USED_GOODS_BOARD
where date_format(CREATED_DATE, '%y%m%d') = '221005'
order by BOARD_ID desc