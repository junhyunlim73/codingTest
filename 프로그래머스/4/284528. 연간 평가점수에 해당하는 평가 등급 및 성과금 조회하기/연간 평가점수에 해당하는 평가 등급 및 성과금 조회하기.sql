-- 코드를 작성해주세요
select e.EMP_NO,  e.EMP_NAME, 
case 
 when floor(avg(score)) between 80 and 89 then 'B'
  when floor(avg(score)) between 90 and 95 then 'A'
 when  floor(avg(score)) >= 96 then 'S'
 else 'C'
 end as 'GRADE',
 case 
 when floor(avg(score)) between 80 and 89 then sal * 0.1
  when floor(avg(score)) between 90 and 95 then sal * 0.15
 when  floor(avg(score)) >= 96 then sal * 0.2
 else sal * 0
 end as 'BONUS'
from HR_EMPLOYEES e
join HR_GRADE g
on e.EMP_NO = g.EMP_NO
group by e.EMP_NO, e.EMP_NAME
order by e.EMP_NO