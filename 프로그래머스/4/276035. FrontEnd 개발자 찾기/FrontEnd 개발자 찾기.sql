-- 코드를 작성해주세요
select distinct id, email, first_name, last_name
from DEVELOPERS d
join ( select code
from SKILLCODES   
where CATEGORY = 'Front End') c
on (d.SKILL_CODE & c.code)
order by id