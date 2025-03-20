-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, TO_CHAR(date_of_birth, 'YYYY-MM-DD') DATE_OF_BIRTH
from MEMBER_PROFILE 
where TO_CHAR(date_of_birth, 'MM') = '03'
and gender = 'W'
and TLNO is not null
order by MEMBER_ID