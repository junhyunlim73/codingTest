-- 코드를 작성해주세요
select m.year, (m.SIZE_OF_COLONY - e.SIZE_OF_COLONY) as "YEAR_DEV", id 
from ECOLI_DATA e, (select year(DIFFERENTIATION_DATE) as "YEAR", max(SIZE_OF_COLONY) as "SIZE_OF_COLONY"
                 from ECOLI_DATA
                  group by year(DIFFERENTIATION_DATE)
) m
where year(e.DIFFERENTIATION_DATE) = m.year
order by m.year, YEAR_DEV