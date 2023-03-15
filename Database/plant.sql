SELECT plantName,Variety
FROM plant
WHERE Variety LIKE '%x%'
ORDER BY plantName ASC;

SELECT Category,plantName,code,Price
FROM plant 
WHERE code LIKE '__';

SELECT plantName, code, Height
FROM plant
WHERE code LIKE '%P%' AND plantName LIKE '%a_t%';

SELECT plantName,referenceID,Price
FROM plant
WHERE plantName LIKE '_a%a' 

