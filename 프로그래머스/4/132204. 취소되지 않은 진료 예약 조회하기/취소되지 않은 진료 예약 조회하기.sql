-- 코드를 입력하세요
SELECT a.apnt_no, p.pt_name, a.pt_no, a.MCDP_CD, d.dr_name, a.apnt_ymd
from APPOINTMENT a
join PATIENT p 
on a.PT_NO = p.PT_NO
join doctor d
on a.MDDR_ID = d.DR_ID
where to_char(a.APNT_YMD,'YYYY-MM-DD') = '2022-04-13'
and a.APNT_CNCL_YN = 'N'
order by a.APNT_YMD