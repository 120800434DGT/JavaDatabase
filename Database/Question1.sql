          SELECT Forename,Surname,test1+test2+test3+test4 AS 'Total Mark'  
FROM Question1;

SELECT Forename,test1,test2,test3,test4,(test1+test2+test3+test4)/4 AS 'Average Score'
FROM Question1
ORDER BY (test1+test2+test3+test4)/4 DESC ;

SELECT Forename,Surname, hourlyRate*hoursWorked
FROM Question2;

SELECT Forename,Surname, hourlyRate*hoursWorked
FROM Question2
WHERE hourlyRate*hoursWorked>200;

SELECT round(test1/16.0*100,0),round(test2/16.0 *100,0),round(test3/16.0 *100,0),round(test4/16.0 *100,0),round(test5/16.0 *100,0)
FROM Question3;

SELECT Forename,Surname,(round(test1/16.0*100,0)+round(test2/16.0 *100,0)+round(test3/16.0 *100,0)+round(test4/16.0 *100,0)+round(test5/16.0 *100,0))/5 AS 'Total %'
FROM Question3
ORDER BY (round(test1/16.0*100,0)+round(test2/16.0 *100,0)+round(test3/16.0 *100,0)+round(test4/16.0 *100,0)+round(test5/16.0 *100,0))/5 ASC,Surname ASC;

SELECT productName,priceUK,round(priceUK*1.13,2) AS 'Euro Price'
FROM Question5;

SELECT productName,priceUK,productID,round(priceUK*1.39,2) AS 'US Price'
FROM Question5
WHERE priceUK*1.39>40 
ORDER BY priceUK ASC,productID ASC;

SELECT fishType,pricePerKilo*numberOfKilos AS 'Total Price'
FROM Question6;

SELECT fishType,pricePerKilo*numberOfKilos AS 'Total Price'
FROM Question6
WHERE pricePerKilo*numberOfKilos>20 AND pricePerKilo*numberOfKilos<50
ORDER BY pricePerKilo*numberOfKilos ASC;


