-- Creates a database entitled "ravosa_game_store", and
-- defines 10 logically related tables

CREATE DATABASE ravosa_game_store;
USE ravosa_game_store;

CREATE TABLE Address_T
		(AddressID		 INT NOT NULL AUTO_INCREMENT,
		StreetAndNumber	 VARCHAR(30) NOT NULL,
		City			 VARCHAR(20) NOT NULL,
		State			 CHAR(2) NOT NULL,
		PostalCode		 VARCHAR(9) NOT NULL,
CONSTRAINT Address_PK PRIMARY KEY (AddressID));

CREATE TABLE Person_T
		(PersonID		 INT NOT NULL AUTO_INCREMENT,
		PersonName		 VARCHAR(25) NOT NULL,
		PersonEmail		 VARCHAR(40) NOT NULL,
		AddressID		 INT NOT NULL,
CONSTRAINT Person_PK PRIMARY KEY (PersonID),
CONSTRAINT Person_FK FOREIGN KEY (AddressID) REFERENCES Address_T (AddressID));

CREATE TABLE Publisher_T
		(PublisherID		 INT NOT NULL AUTO_INCREMENT,
		PublisherName		 VARCHAR(25) NOT NULL,
		AddressID			 INT NOT NULL,
CONSTRAINT Publisher_PK PRIMARY KEY (PublisherID),
CONSTRAINT Publisher_FK FOREIGN KEY (AddressID) REFERENCES Address_T (AddressID));

CREATE TABLE Developer_T
		(DeveloperID		 INT NOT NULL AUTO_INCREMENT,
		DeveloperName	 	 VARCHAR(25) NOT NULL,
		AddressID		 	 INT,
CONSTRAINT Developer_PK PRIMARY KEY (DeveloperID),
CONSTRAINT Developer_FK FOREIGN KEY (AddressID) REFERENCES Address_T (AddressID));

CREATE TABLE Platform_T
		(PlatformID		 	 INT NOT NULL AUTO_INCREMENT,
		PlatformName		 VARCHAR(20),
		DeveloperID		 	 INT NOT NULL,
		NumberInStock		 INT NOT NULL,
CONSTRAINT Platform_PK PRIMARY KEY (PlatformID),
CONSTRAINT Platform_FK FOREIGN KEY (DeveloperID) REFERENCES Developer_T (DeveloperID));
CREATE TABLE VideoGame_T
		(GameID		 	 INT NOT NULL AUTO_INCREMENT,
		GameTitle		 VARCHAR(40),
		PublisherID		 INT NOT NULL,
		DeveloperID		 INT NOT NULL,
		Rating			 VARCHAR(4),
		Price			 DECIMAL(4,2),
		NumberInStock	 INT NOT NULL,
CONSTRAINT VideoGame_PK PRIMARY KEY (GameID),
CONSTRAINT VideoGame_FK1 FOREIGN KEY (DeveloperID) REFERENCES Developer_T (DeveloperID),
CONSTRAINT VideoGame_FK2 FOREIGN KEY (PublisherID) REFERENCES Publisher_T (PublisherID));

CREATE TABLE JobTitle_T
		(JobID			 INT NOT NULL AUTO_INCREMENT,
		JobName			 VARCHAR(30),
CONSTRAINT JobTitle_PK PRIMARY KEY (JobID));

CREATE TABLE Employee_T
		(EmployeeID		 INT NOT NULL,
		JobID			 INT NOT NULL,
		BirthDate		 VARCHAR(15),
CONSTRAINT Employee_PK PRIMARY KEY (EmployeeID),
CONSTRAINT Employee_FK1 FOREIGN KEY (EmployeeID) REFERENCES Person_T (PersonID),
CONSTRAINT Employee_FK2 FOREIGN KEY (JobID) REFERENCES JobTitle_T (JobID));

CREATE TABLE Order_T
		(OrderID		 INT NOT NULL AUTO_INCREMENT,
		OrderDate		 TIMESTAMP DEFAULT NOW(),
		CustomerID		 INT NOT NULL,
CONSTRAINT Order_PK PRIMARY KEY (OrderID),
CONSTRAINT Order_FK FOREIGN KEY (CustomerID) REFERENCES Person_T (PersonID));

CREATE TABLE OrderLine_T
		(OrderID		 INT NOT NULL,
		GameID		 	 INT NOT NULL,
CONSTRAINT OrderLine_PK PRIMARY KEY (OrderID, GameID),
CONSTRAINT OrderLine_FK1 FOREIGN KEY (OrderID) REFERENCES Order_T (OrderID),
CONSTRAINT OrderLine_FK2 FOREIGN KEY (GameID) REFERENCES VideoGame_T (GameID));