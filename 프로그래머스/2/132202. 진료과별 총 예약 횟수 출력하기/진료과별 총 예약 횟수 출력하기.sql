-- 코드를 입력하세요
SELECT MCDP_CD, count(*) as "5월예약건수"
from APPOINTMENT
where month(APNT_YMD) = 5
group by MCDP_CD
order by 5월예약건수, MCDP_CD