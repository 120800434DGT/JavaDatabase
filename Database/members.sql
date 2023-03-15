SELECT Firstname, Surname, Postcode, monthOfRenewal
FROM Member
WHERE Surname LIKE 'D%';

SELECT membershipNumber, Postcode, Firstname, Surname
FROM Member
WHERE Surname LIKE '%oo%'
ORDER BY Surname ASC ;

SELECT Firstname, Town
FROM Member
WHERE Firstname LIKE '%o%' AND Town LIKE 'b%n';

SELECT Firstname, Surname
FROM Member
WHERE Surname LIKE 'L___';

SELECT membershipNumber, Town, Postcode
FROM Member
WHERE Postcode LIKE '%a_2%';

SELECT  Firstname,Surname,typeOfMembership
FROM Member
WHERE Surname LIKE '%l__e%';

SELECT membershipNumber,typeOfMembership,dateOfBirth
FROM Member
WHERE typeOfMembership = 'Adult' AND dateOfBirth LIKE '____-10-__' ;
