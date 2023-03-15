SELECT drugID, count(datePrescribed) as 'Times Prescribed'
FROM prescribedDrug
GROUP BY drugID
ORDER BY count(datePrescribed) DESC;

SELECT patientID,max(dosage)
FROM prescribedDrug,patient
WHERE 