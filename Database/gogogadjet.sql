SELECT *
FROM item
WHERE Category = 'Boys Toys';

SELECT OrderNo,Description,Price
FROM item,OrderItem
WHERE item.ItemID=OrderItem.ItemID
ORDER BY OrderNo ASC;

SELECT Forename,Surname,OrderDate
FROM Customer,CustOrder
WHERE Surname LIKE '%em%' AND Customer.CustomerID=CustOrder.CustomerID
ORDER BY Surname ASC, Forename ASC;

SELECT orderitem.OrderNo,OrderDate,Description,Quantity,Price,Quantity*Price AS 'Order Price'
FROM OrderItem,CustOrder,item
WHERE OrderItem.ItemID=item.ItemID AND CustOrder.OrderNo=OrderItem.OrderNo
ORDER BY OrderDate ASC;

SELECT OrderNo,Description,Price,Price*0.05 AS 'Discount',Price-Price*0.05 AS 'Final Price',Quantity
FROM item,OrderItem
WHERE Quantity>=4 AND item.ItemID=OrderItem.ItemID;

SELECT Forename,Surname,OrderItem.OrderNo,OrderDate,Description,Quantity,Price,Price*Quantity AS 'Total Price'
FROM item,CustOrder,OrderItem,Customer
WHERE OrderItem.ItemID=item.ItemID AND CustOrder.OrderNo=OrderItem.OrderNo AND Customer.CustomerID=CustOrder.CustomerID AND Forename = 'Mari' AND Surname = 'Singer'
ORDER BY OrderDate ASC;

SELECT Category, count()
FROM item
GROUP BY Category
ORDER BY count(Category) DESC;

SELECT orderitem.OrderNo,OrderDate,Price*Quantity AS 'Total Price'
FROM item,OrderItem,CustOrder
WHERE OrderDate LIKE '2008-01-__' AND OrderItem.ItemID=item.ItemID AND CustOrder.OrderNo=OrderItem.OrderNo
ORDER BY OrderDate ASC;

SELECT Forename,Surname,CustomerEmail
FROM Customer
WHERE CustomerEmail LIKE '%mobilelife%';

SELECT Category,count(custorder.OrderNo),Quantity
FROM CustOrder,OrderItem,item
WHERE Category='Office Distractions' AND CustOrder.OrderNo=OrderItem.OrderNo AND OrderItem.ItemID=item.ItemID
GROUP BY Category;

SELECT Category, round(avg(Price),2)
FROM item
GROUP BY Category;

SELECT custorder.OrderNo, Forename, Surname, sum(Quantity)
FROM Customer,OrderItem,CustOrder
WHERE Customer.CustomerID = CustOrder.CustomerID AND CustOrder.OrderNo = OrderItem.OrderNo AND Surname LIKE '%i_g%'
GROUP BY Forename;

SELECT customer.CustomerID,Postcode,count(CustOrder.OrderNo)
FROM Customer,CustOrder
WHERE Customer.CustomerID = CustOrder.CustomerID AND OrderDate LIKE '2008-__-__'
GROUP BY customer.CustomerID
ORDER BY count(CustOrder.OrderNo) DESC,Postcode ASC;

SELECT orderitem.OrderNo,OrderDate,sum(Price*Quantity) AS 'Price',sum(Price*Quantity)*0.05 AS 'Discount',sum(Price*Quantity) - sum(Price*Quantity)*0.05 AS 'Discounted Price'
FROM CustOrder,OrderItem,item 
WHERE CustOrder.OrderNo=OrderItem.OrderNo AND OrderItem.ItemID=item.ItemID AND OrderDate LIKE '2007-12-__'
GROUP BY orderitem.OrderNo
ORDER BY OrderDate DESC, orderitem.OrderNo ASC;

