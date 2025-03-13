-- 코드를 입력하세요
SELECT ANIMAL_TYPE, nvl(NAME, 'No name') "Name", SEX_UPON_INTAKE
FROM ANIMAL_INS
order by ANIMAL_ID