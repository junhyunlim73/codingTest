-- 코드를 입력하세요
SELECT b.WRITER_ID,  u.NICKNAME,
CITY || ' ' || STREET_ADDRESS1 || ' ' || STREET_ADDRESS2 as "전체주소",
substr(TLNO, 1, 3) || '-' || substr(TLNO, 4, 4) || '-' || substr(TLNO, 8, 12) as "전화번호"
from USED_GOODS_BOARD b
join USED_GOODS_USER u
on b.WRITER_ID = u.USER_ID
group by b.WRITER_ID, NICKNAME, CITY, STREET_ADDRESS1, STREET_ADDRESS2, TLNO
having count(*) >= 3
order by b.WRITER_ID desc