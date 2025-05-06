-- 코드를 입력하세요
with hour24 as(
   select 0 as hour
  from dual 
    union all
    select 1 as hour
    from dual
    union all
    select 2 as hour
    from dual
    union all
    select 3 as hour
    from dual
    union all
    select 4 as hour
    from dual
    union all
    select 5 as hour
    from dual
    union all
    select 6 as hour
    from dual
    union all
    select 7 as hour
    from dual
    union all
    select 8 as hour
    from dual
    union all
    select 9 as hour
    from dual
    union all
    select 10 as hour
    from dual
    union all
    select 11 as hour
    from dual
    union all
    select 12 as hour
    from dual
    union all
    select 13 as hour
    from dual
    union all
    select 14 as hour
    from dual
    union all
    select 15 as hour
    from dual
    union all
    select 16 as hour
    from dual
    union all
    select 17 as hour
    from dual
    union all
    select 18 as hour
    from dual
    union all
    select 19 as hour
    from dual
    union all
    select 20 as hour
    from dual
    union all
    select 21 as hour
    from dual
    union all
    select 22 as hour
    from dual
    union all
    select 23 as hour
    from dual
)

SELECT h.hour, count(datetime) COUNT
from ANIMAL_OUTS o
right join hour24 h
on to_number(to_char(datetime, 'HH24')) = h.hour
group by h.hour
order by hour