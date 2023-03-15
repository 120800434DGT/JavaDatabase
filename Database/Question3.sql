SELECT cityName,Population/1000 'Population (Thousands)'
FROM Country,City
WHERE Country.countryCode=City.countryCode AND countryName='Ethiopia';

SELECT countryName,TotalPopulation/Area AS 'Population Density'
FROM Country
WHERE countryName LIKE 'M%';

SELECT cityName,Population,Area*0.39 AS 'Area (Squared Miles)'
FROM Country,City
WHERE Country.countryCode=City.countryCode AND cityName=capital AND Population>2000000 AND Area*0.39>500000;

SELECT countryName,cityName,round(Longitude/15,2) AS 'Time Difference (Hours)'
FROM Country,City
WHERE Country.countryCode=City.countryCode AND cityName=capital AND Longitude>0
ORDER BY Longitude DESC,countryName ASC ;

SELECT cityName,round((Latitude-51.5)*113,1) AS 'Kilometres North of London'
FROM Country,City
WHERE cityName=capital AND Longitude<35 AND Latitude>51.5
ORDER BY cityName ASC;



