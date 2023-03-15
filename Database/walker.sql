SELECT forename,surname,plannerNo,count(walker.walkerNo) AS "Total Participants"
FROM Walk,Route,walker
WHERE Walk.routeID = Route.routeID AND  Walk.walkerNo = Walker.walkerNo
GROUP BY plannerNo
ORDER BY count(walker.walkerNo) DESC;

SELECT walker.walkerNo,forename,surname,telNo
FROM Walker,walk,Route, (SELECT max(distance) AS "Longest" FROM Route) AS "QUERY1"
GROUP BY walker.walkerNo;

SELECT Route.routeID, woodName, description FROM Route
WHERE footwear LIKE "%shoes";

SELECT difficulty,AVG(distance)
FROM Route
GROUP BY difficulty;

SELECT town,count(*)
FROM Walker
GROUP BY town;

SELECT sum(distance), walkDate
FROM Walk,Route
WHERE Walk.routeID = Route.routeID
GROUP BY walkDate
ORDER BY sum(distance) DESC;

SELECT forename,surname,walk.walkerNo,count(*)
FROM Walker,Walk
WHERE Walker.walkerNo = Walk.walkerNo
GROUP BY walk.walkerNo;

SELECT count(forename),town
FROM Walker,walk,Route
WHERE Walk.routeID = Route.routeID AND Walker.walkerNo = Walk.walkerNo AND difficulty = "Difficult"
GROUP BY town;

SELECT forename,surname,distance*count(walkerNo)
FROM Planner,Route,walk
WHERE Walk.routeID = Route.routeID AND  Planner.plannerNo = Route.plannerNo
GROUP BY planner.plannerNo
ORDER BY distance*count(walkerNo) DESC;

SELECT forename,surname,max(distance),min(distance)
FROM Walker,Walk,Route
WHERE Walk.routeID = Route.routeID AND Walker.walkerNo = Walk.walkerNo AND forename = "Tami" AND surname = "Rasmussen" AND woodName = "Devilla"
GROUP BY walker.walkerNo;

SELECT walker.forename,walker.surname, AVG(distance)
FROM Walker,Walk,Route,Planner
WHERE walk.routeID = Route.routeID AND Walker.walkerNo = Walk.walkerNo AND Planner.plannerNo = Route.plannerNo AND town = "Carnock" AND Planner.surname = "Benton" AND Planner.forename = "Heidi"
GROUP BY walker.walkerNo;