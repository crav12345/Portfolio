-- Inner join which returns persons who have placed an order

SELECT Person_T.PersonID, PersonName, 
Order_T.CustomerID, OrderID 
FROM Person_T INNER JOIN Order_T ON 
Person_T.PersonID = Order_T.CustomerID 
ORDER BY PersonName;