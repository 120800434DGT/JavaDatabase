SELECT Gender,name FROM keeper
WHERE Gender = 'M';

SELECT name,Status FROM keeper
WHERE Status = 'full-time'
ORDER BY name ASC ;

SELECT Species,Endangered FROM animal
WHERE Endangered = true ;

SELECT Species,Lifespan FROM animal
WHERE Lifespan <= 17
ORDER BY Lifespan DESC;

SELECT Species,Origin FROM animal
WHERE Origin = 'Australia' OR Origin = 'Asia';

SELECT Keeper.KeeperID,name,Species FROM animal,keeper
WHERE  Keeper.KeeperID  = 'KPR003';

SELECT Species,Class,Origin FROM animal
WHERE Class = 'Mammal' AND Origin = 'North America' OR Origin = 'South America';

DELETE FROM keeper
WHERE KeeperID = 'KP009';

INSERT INTO Keeper (gender,KeeperID,name,Status,PhoneExt,DateEmployed)
VALUES ('F','KP009','S Macleod','Part-Time','626','2020-20-20');

SELECT *
FROM keeper
WHERE KeeperID = 'KP009';

DELETE FROM animal
WHERE Species = 'Hippopotamus';

INSERT INTO animal (Endangered,Origin,Class,Species,KeeperID,Habitat,Food,Colour,Lifespan,averageSize)
VALUES (false,'Africa','Mammal','Hippopotamus','KPR009','Savannah','Plants','Grey',50,3.0);

SELECT *
FROM animal
WHERE Species = 'Hippopotamus';

UPDATE keeper 
SET Status ='Full-time'
WHERE KeeperID ='KPR007';

SELECT *
FROM keeper
WHERE KeeperID = 'KP007';


