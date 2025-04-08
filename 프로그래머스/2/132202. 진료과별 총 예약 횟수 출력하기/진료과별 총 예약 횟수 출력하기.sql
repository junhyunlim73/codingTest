-- 코드를 입력하세요
SELECT MCDP_CD "진료과 코드", count(*) "5월예약건수"
from APPOINTMENT
where to_char(APNT_YMD, 'YYYY-MM') = '2022-05'
group by MCDP_CD
order by "5월예약건수", "진료과 코드"