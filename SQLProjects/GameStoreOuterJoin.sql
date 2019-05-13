-- Outer join which returns developers whose game the store carries

SELECT Developer_T.DeveloperID, DeveloperName, GameTitle
FROM Developer_T RIGHT OUTER JOIN VideoGame_T ON
Developer_T.DeveloperID = Videogame_T.DeveloperID;