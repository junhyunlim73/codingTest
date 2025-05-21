-- 코드를 작성해주세요
select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS
where SKILL_CODE & 
       (select code
        from SKILLCODES
        where name in ('C#')) > 0
or SKILL_CODE & (select code
        from SKILLCODES
        where name in ('Python')) > 0
order by id