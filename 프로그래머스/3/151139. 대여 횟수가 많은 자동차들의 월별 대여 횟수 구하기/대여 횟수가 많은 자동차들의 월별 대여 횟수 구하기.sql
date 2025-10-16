-- 코드를 입력하세요
SELECT month(START_DATE) as "MONTH", CAR_ID, count(*) as "RECORDS"
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where month(START_DATE) between 8 and 10
and car_id in (select car_id
              from CAR_RENTAL_COMPANY_RENTAL_HISTORY
              where month(START_DATE) between 8 and 10
              group by car_id
              having count(*) >= 5)
group by month(START_DATE), CAR_ID
order by MONTH, car_id desc