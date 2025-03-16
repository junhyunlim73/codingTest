-- 코드를 입력하세요
SELECT TO_NUMBER(TO_CHAR(DATETIME, 'HH24')) as hour, count(*) "COUNT"
from animal_outs
where to_char(datetime, 'HH24') between 09 and 19
group by to_char(datetime, 'HH24')
order by to_char(datetime, 'HH24')