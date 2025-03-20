-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, nvl(TLNO, 'NONE') TLNO
from PATIENT
where age <= 12
and gend_cd = 'W'
order by age desc, pt_name