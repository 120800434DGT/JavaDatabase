SELECT customerName,sum(quantity) AS "Numbers of books ordered"
FROM customer,orderDetails,orders
WHERE customer.customerID=orders.customerID AND orders.orderID = orderDetails.orderID
GROUP BY customer.customerID;

SELECT customerName,quantity
FROM customer,orderDetails,orders,(SELECT max(quantity) AS "most" FROM orderDetails) AS "Query 1"
WHERE customer.customerID=orders.customerID AND orders.orderID = orderDetails.orderID AND quantity = most;

SELECT bookTitle,author,price
FROM customer,orderDetails,orders,books
WHERE customer.customerID=orders.customerID AND orders.orderID = orderDetails.orderID AND books.bookID = orderDetails.bookID AND customerName LIKE "John Smith";
