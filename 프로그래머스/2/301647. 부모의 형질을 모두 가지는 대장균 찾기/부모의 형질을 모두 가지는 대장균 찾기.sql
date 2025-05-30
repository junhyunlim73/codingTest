-- 코드를 작성해주세요
select c.id, c.GENOTYPE, p.GENOTYPE as "PARENT_GENOTYPE"
from ECOLI_DATA p
join ECOLI_DATA c
on p.ID = c.PARENT_ID
where c.GENOTYPE & p.GENOTYPE = p.GENOTYPE