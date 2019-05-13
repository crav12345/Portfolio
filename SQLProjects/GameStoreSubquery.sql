-- Subquery which returns name and email of persons who have placed orders
-- with no repeated values

SELECT PersonName, PersonEmail
FROM Person_T
WHERE PersonID IN
	(SELECT DISTINCT CustomerID FROM Order_T);