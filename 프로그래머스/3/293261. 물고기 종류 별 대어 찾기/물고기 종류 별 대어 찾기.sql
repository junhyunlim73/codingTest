-- 코드를 작성해주세요
select ID, FISH_NAME, LENGTH
from FISH_INFO i
join FISH_NAME_INFO n
on i.FISH_TYPE = n.FISH_TYPE
where (i.fish_type, length) in (
select i.fish_type, max(LENGTH)
from FISH_INFO i
join FISH_NAME_INFO n
on i.FISH_TYPE = n.FISH_TYPE
group by i.FISH_TYPE
)
order by id