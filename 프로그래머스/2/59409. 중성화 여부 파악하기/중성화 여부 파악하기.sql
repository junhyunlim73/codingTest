-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, decode(SEX_UPON_INTAKE, 'Neutered Male', 'O', 'Spayed Male', 'O', 'Neutered Female' ,'O',
'Spayed Female', 'O', 'X') as "중성화"
from ANIMAL_INS
order by ANIMAL_ID