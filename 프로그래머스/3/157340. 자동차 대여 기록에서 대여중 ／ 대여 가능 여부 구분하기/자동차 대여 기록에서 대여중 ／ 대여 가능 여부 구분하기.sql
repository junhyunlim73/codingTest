-- 코드를 입력하세요
select CAR_ID,
max(case 
when date('2022-10-16') between START_DATE and END_DATE then "대여중"
else "대여 가능" 
    end) as "AVAILABILITY"
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
order by car_id  desc 