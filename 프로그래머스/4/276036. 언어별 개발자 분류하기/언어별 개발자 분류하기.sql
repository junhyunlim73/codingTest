-- 코드를 작성해주세요

select case 
when d.SKILL_CODE & p.code != 0 and d.SKILL_CODE & f.code != 0 then 'A'
when d.SKILL_CODE & c.code != 0 then 'B'
when d.SKILL_CODE & f.code != 0 then 'C'
end as "GRADE", id, email
from (select code from SKILLCODES where name = 'Python') p, (select sum(code) as "code" from SKILLCODES where CATEGORY = 'Front End') f, (select code from skillcodes where name = 'C#') c, DEVELOPERS d
group by grade, ID, EMAIL
having grade is not null
order by grade, id