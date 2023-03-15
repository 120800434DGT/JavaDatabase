SELECT firstName, surname,voucher.voucherID,CAST(price£*quantityPurchased AS INT) AS "Amount of Money Spent on Voucher £"
FROM Customer,CustomerOrder,Voucher
WHERE Customer.custID = CustomerOrder.custID AND CustomerOrder.voucherID = Voucher.voucherID AND category = 'Adventure' AND voucherName LIKE "%Escape room%" 
ORDER BY voucher.voucherID;

SELECT voucher.voucherID,supplierName,voucherName,(quantityAvailable-(sum(quantityPurchased))) AS "Still Available"
FROM Voucher,Supplier,CustomerOrder
WHERE Voucher.supplierCode = Supplier.supplierCode AND CustomerOrder.voucherID = Voucher.voucherID AND voucher.voucherID = "V543";

SELECT Supplier.supplierName, Voucher.voucherName, Voucher.price£, count(Voucher.price£) AS [Number of Customers] 
FROM CustomerOrder, Supplier, Voucher
WHERE CustomerOrder.voucherID=Voucher.voucherID AND Supplier.supplierCode=Voucher.supplierCode AND Voucher.price£<15 AND Voucher.category="Family"
GROUP BY Supplier.supplierName, Voucher.voucherName, Voucher.price£
ORDER BY count(Voucher.price£) DESC;

