SELECT title, internationalSales-movieBudget
FROM Movie,Boxoffice
WHERE Movie.movieID=Boxoffice.movieID AND internationalSales-movieBudget>0
ORDER BY internationalSales-movieBudget DESC;

SELECT director,USsales+internationalSales AS 'Total Sales'
FROM Movie,Boxoffice
WHERE Movie.movieID=Boxoffice.movieID
ORDER BY director ASC,USsales+internationalSales ASC;

SELECT title,director,yearReleased,rating,internationalSales/1000000 AS 'Sales (m)'
FROM Movie,Boxoffice
WHERE internationalSales>150000000 AND rating >=8 AND Movie.movieID = Boxoffice.movieID;

SELECT title,CAST (durationMins/60 AS INT) AS 'Hours',durationMins-((CAST (durationMins/60 AS INT)) * 60) AS 'Minutes'
FROM Boxoffice,Movie
WHERE Movie.movieID = Boxoffice.movieID
ORDER BY CAST (durationMins/60 AS INT) DESC,durationMins-(CAST (durationMins/60 AS INT) * 60) DESC;

SELECT title,director,rating*10 AS 'Rating %'
FROM Boxoffice,Movie
WHERE Movie.movieID = Boxoffice.movieID
ORDER BY rating DESC,title ASC;



