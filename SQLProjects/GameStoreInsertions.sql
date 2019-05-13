INSERT INTO Address_T (StreetAndNumber, City, State, PostalCode) VALUES 
(“2207 Bridgepointe Pkwy”, “San Mateo”, “CA”, 94404),
(“1 Microsoft Way”, “Redmond”, “WA”, 98052),
(“4600 150th Ave NE”, “Redmond”, “WA”, 98052),
(“3399 North Road”, “Poughkeepsie”, “NY”, 12601),
(“Room 00201”, “Forward Unto Dawn”, “MS”, 00001),
(“Redacted”, “Redacted”, “UK”, 0004),
(“The Skag Cave”, “Fyrestone”, “PA”, 90011),
(“2051 Mission College Blvd”, “Santa Clara”, “CA”, 95054),
(“103 Bloodborn Drive”, “Atlanta”, “GA”, 30120),
(“222 Dragon Street”, “Bethesda”, “MD”, 04341),
(“No Sleep Blvd”, “San Diego”, “CA”, 90340),
(“01 Beecher’s Hope”, “Great Planes”, “CO”, 01203),
(“123 Abstergo Lane”, “Chicago”, “IL”, 06759),
(“3 Black Mesa Way”, “Las Vegas”, “NV”, 01204);

INSERT INTO Developer_T (DeveloperName, AddressID) VALUES
(“Sony Interactive”, 001),
(“Microsoft”, 002),
(“Nintendo”, 003),
(“Various Developers”, Null),
(“From Software”, 009),
(“id Software”, 010),
(“Insomniac Games”, 011);

INSERT INTO Platform_T (PlatformName, DeveloperID, NumberInStock) VALUES
(“PlayStation 4”, 001, 12),
(“Xbox One”, 002, 15),
(“Nintendo Switch”, 003, 11),
(“PC”, 004, 9);

INSERT INTO Person_T (PersonName, PersonEmail, AddressID) VALUES 
(“Chris Ravosa”, “christopher.ravosa1@marist.edu”, 004),
(“Master Chief”, “theDemon@unsc.gov”, 005),
(“Soap MacTavish”, “soap@sas.gov”, 006),
(“Nine Toes”, “awYeah@gearbox.com”, 007),
(“John Marston”, “gunsl1nger@rockstar.com”, 011),
(“Desmond Miles”, “eziosBoy@ac.org”, 012),
(“Gordon Freeman”, “freeman@blackmesa.org”, 013);

INSERT INTO Publisher_T (PublisherName, AddressID) VALUES
(“Nintendo”, 003),
(“Bandai Namco”, 008),
(“Bethesda Softworks”, 010),
(“Sony Interactive”, 001);

INSERT INTO VideoGame_T (GameTitle, PublisherID, DeveloperID, Rating, Price, NumberInStock) VALUES 
(“Super Mario Odyssey”, 001, 003, “E10+”, 45.99, 15),
(“Dark Souls III”, 002, 005, “M”, 39.99, 9),
(“Doom”, 003, 006, “M”, 34.99, 7),
(“Spider-Man”, 004, 007, “T”, 59.99, 16);

INSERT INTO JobTitle_T (JobName) VALUES
(“Sales Associate”),
(“Senior Sales Associate”),
(“Sales Manager”),
(“Social Media Manager”);

INSERT INTO Employee_T (EmployeeID, JobID, BirthDate) VALUES
(001, 003, “Apr 6 1999”),
(004, 001, “Nov 12 1998”),
(002, 002, “Aug 4 1997”),
(003, 002, “Dec 19 1996”);

INSERT INTO Order_T (CustomerID) VALUES
(001),
(004),
(005),
(005),
(006),
(007);

INSERT INTO OrderLine_T (OrderID, GameID) VALUES
(001, 003),
(002, 001),
(003, 004),
(004, 001),
(005, 001),
(006, 002);