-- Correlated subquery which returns every order of "Super Mario Odyssey"

SELECT DISTINCT OrderID, GameID
FROM OrderLine_T
WHERE EXISTS
	(SELECT * FROM VideoGame_T WHERE GameID  = OrderLine_T.GameID
	 AND GameTitle = “Super Mario Odyssey”);
