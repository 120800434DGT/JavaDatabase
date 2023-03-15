SELECT forename,surname,(childTicket*2)+(adultTicket*5.5)+(concessionTicket*1.5) AS 'Tax (£)'
FROM Customer,Booking,Flight
WHERE Customer.customerID = Booking.customerID AND Booking.flightID=Flight.flightID AND customer.customerID='GR01932' AND flight.flightID='QH182'; 

SELECT forename,surname
FROM Booking,Customer
WHERE Booking.customerID=Customer.customerID AND childTicket =(Select max(childTicket) FROM Booking);

