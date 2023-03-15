SELECT gnomeName,sum(quantity) AS "Total gnomes sold"
FROM Gnome,GnomePurchase
WHERE Gnome.gnomeID = GnomePurchase.gnomeID AND description LIKE "%solar%"
GROUP BY Gnome.gnomeID
ORDER BY sum(quantity) DESC;

SELECT emailAddress,CustOrder.orderID,quantity
FROM Customer,CustOrder,GnomePurchase,Gnome,(SELECT max(unitPrice) AS "expensive" FROM Gnome)
WHERE Gnome.gnomeID = GnomePurchase.gnomeID AND GnomePurchase.orderID = CustOrder.orderID 
    AND CustOrder.customerID = Customer.customerID
    AND unitPrice = expensive AND quantity >= 3;