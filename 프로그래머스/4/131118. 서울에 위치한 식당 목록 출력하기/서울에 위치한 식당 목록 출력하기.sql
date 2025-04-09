-- 코드를 입력하세요
SELECT i.REST_ID, REST_NAME, FOOD_TYPE, i.favorites, address, round(avg(REVIEW_SCORE), 2) "SCORE"
from REST_INFO i
join REST_REVIEW r
on i.rest_id = r.rest_id
where ADDRESS like '서울%'
group by i.rest_id, FOOD_TYPE, REST_NAME, i.favorites, address 
order by SCORE desc, i.favorites desc