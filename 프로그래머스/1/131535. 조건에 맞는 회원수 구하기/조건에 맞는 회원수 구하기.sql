-- 코드를 입력하세요
SELECT count(*) "USERS"
from USER_INFO
where TO_CHAR(JOINED, 'YYYY') = '2021'
and age between 20 and 29