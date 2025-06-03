-- 코드를 작성해주세요
select ID , 
case 
 ntile(4) over (order by SIZE_OF_COLONY desc)
 when 1 then 'CRITICAL' 
 when 2 then 'HIGH' 
 when 3 then 'MEDIUM'
 when 4 then 'LOW'
 end as "COLONY_NAME"
from ECOLI_DATA
order by id