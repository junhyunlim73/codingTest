-- 코드를 입력하세요
SELECT CAR_ID, max(
  case 
  when  '2022-10-16' between to_char(start_date, 'YYYY-MM-DD') and to_char(end_date, 'YYYY-MM-DD') then '대여중'
  else '대여 가능' 
  end) as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
order by CAR_ID desc