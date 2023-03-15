/*SELECT garageName,sum(cost) AS "Total sales"
FROM job,garage
WHERE job.garageID = garage.garageID AND dateOut = "2020-01-19"
GROUP BY garageName;

SELECT JULIANDAY(dateOut) - JULIANDAY(dateIn) AS "Number of days",regNo,garageName
FROM job,garage, (SELECT max(JULIANDAY(dateOut) - JULIANDAY(dateIn)) AS "Number of days"
FROM job) AS "query 1"
WHERE job.garageID = garage.garageID AND JULIANDAY(dateOut) - JULIANDAY(dateIn)="Number of days" ;

SELECT forename, surname, ROUND(AVG(cost)  , 2) AS [Average Job Cost]
FROM   Customer, Car, Job
WHERE  Customer.customerID = Car.customerID AND Car.regNo = Job.regNo
GROUP BY customer.customerID
ORDER BY AVG(cost) DESC;*/

SELECT forename,surname,address,job.regNo
FROM car,customer,job, (SELECT max(cost) AS "expensive" FROM job) AS "Query 1"
WHERE Customer.customerID = Car.customerID AND Car.regNo = Job.regNo AND cost = expensive;

SELECT make,model
FROM car,job, (SELECT min(cost) AS "cheap" FROM job) AS "query 1"
WHERE Car.regNo = Job.regNo AND cost<cheap+20;

SELECT garageName
FROM garage,(SELECT count(*) AS "jobs" FROM job) AS "query 1"
WHERE jobs<15;