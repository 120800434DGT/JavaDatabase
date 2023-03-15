SELECT title,hotel,airportdistance + 2.8 AS 'Old Distance',airportdistance 'New Distance',city
FROM Hotel,Holiday
WHERE city = 'Madrid' AND Hotel.hotelref=Holiday.hotelref;

SELECT hotel,roomprice+7.25 AS'Tax inclusive Price £' ,roomprice AS 'roomprice excluding tax in £',round(roomprice/1.13+7.25,2) AS 'Roomprice Euros'
FROM hotel,Holiday
WHERE city='Rome' AND Hotel.hotelref=Holiday.hotelref
ORDER BY roomprice+7.25 ASC ;

SELECT nights,hotel,
