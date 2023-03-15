SELECT countryName,capital,max(TotalPopulation)
FROM Country;

SELECT cityName,countryCode,Population
FROM City,(SELECT avg(Population) AS 'avgPop' FROM City) AS 'average population'
WHERE Population >= avgPop + 5000000;

SELECT cityName,city.Latitude,countryName
FROM City,Country,(SELECT Latitude AS 'Lat' FROM city WHERE cityName = 'Reykjavik') AS 'Lot'
WHERE city.Latitude>Lat AND City.countryCode=Country.countryCode;

SELECT cityName,Population,countryName
FROM City,Country,(SELECT AVG(Population) AS 'bol' FROM City,country WHERE countryName = 'Bolivia' AND City.countryCode=Country.countryCode)
WHERE countryName = 'United Kingdom' AND City.countryCode=Country.countryCode AND Population>bol
ORDER BY Population DESC ;

SELECT count()
FROM Country,(SELECT max(Area)*0.01 AS 'One' FROM Country)
WHERE Area>One;








