-- 코드를 입력하세요
SELECT car_id, to_char(round(avg(end_Date - start_date + 1), 1), 'FM9990.0') "AVERAGE_DURATION"
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
having avg(end_Date - start_date + 1) >= 7
order by round(avg(end_Date - start_date + 1), 1) desc, car_id desc