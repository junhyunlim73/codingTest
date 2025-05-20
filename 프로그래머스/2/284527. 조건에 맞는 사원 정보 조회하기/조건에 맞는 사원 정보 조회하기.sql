-- 코드를 작성해주세요
select sum(score) score, e.EMP_NO, EMP_NAME, POSITION, EMAIL
from HR_EMPLOYEES e
join HR_GRADE g
on e.EMP_NO = g.EMP_NO
where g.year = 2022
group by e.EMP_NO, EMP_NAME, POSITION, EMAIL
order by score desc
limit 1