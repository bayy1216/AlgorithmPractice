-- 코드를 입력하세요
SELECT NAME, DATETIME FROM ANIMAL_INS
WHERE ANIMAL_ID NOT IN (
    SELECT ANIMAL_INS.ANIMAL_ID from ANIMAL_INS JOIN ANIMAL_OUTS ON 
    ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
) ORDER BY DATETIME LIMIT 3;