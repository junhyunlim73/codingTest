-- 코드를 입력하세요
SELECT APNT_NO, PT_NAME, p.PT_NO, d.MCDP_CD, DR_NAME, APNT_YMD
from PATIENT p
join APPOINTMENT a
on p.PT_NO = a.PT_NO
join DOCTOR d
on d.DR_ID = a.MDDR_ID
where d.MCDP_CD = 'CS'
and  date_format(APNT_YMD, '%y-%m-%d') = '22-04-13'
and APNT_CNCL_YMD is null
order by APNT_YMD