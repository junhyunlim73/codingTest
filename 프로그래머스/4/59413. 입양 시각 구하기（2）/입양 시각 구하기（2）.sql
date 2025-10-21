-- 코드를 입력하세요
with hour24 as( SELECT 0 as hour
from dual
union
select 1 as hour
from dual
union
select 2 as hour
from dual
union
select 3 as hour
from dual
union
select 4 as hour
from dual
union
select 5 as hour
from dual
union
select 6 as hour
from dual
union
select 7 as hour
from dual
union
select 8 as hour
from dual
union
select 9 as hour
from dual
union
select 10 as hour
from dual
union
select 11 as hour
from dual
union
select 12 as hour
from dual
union
select 13 as hour
from dual
union
select 14 as hour
from dual
union
select 15 as hour
from dual
union
select 16 as hour
from dual
union
select 17 as hour
from dual
union
select 18 as hour
from dual
union
select 19 as hour
from dual
union
select 20 as hour
from dual
union
select 21 as hour
from dual
union
select 22 as hour
from dual
union
select 23 as hour
from dual)

select h.hour, count(o.datetime) as COUNT
from ANIMAL_OUTS o
right join hour24 h
on hour(o.DATETIME) = h.hour
group by h.hour
