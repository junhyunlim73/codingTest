-- 코드를 입력하세요
SELECT convert(date_format(DATETIME, '%H'), unsigned) as "HOUR", count(*) as "COUNT"
from ANIMAL_OUTS
where convert(date_format(DATETIME, '%H'), unsigned) between 9 and 19
group by convert(date_format(DATETIME, '%H'), unsigned)
order by hour