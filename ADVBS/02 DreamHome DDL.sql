CREATE DATABASE DreamHome;
GO

USE DreamHome;
GO

CREATE TABLE Branch
(branchNo VARCHAR(4) PRIMARY KEY,
street VARCHAR(50),
city VARCHAR(50),
postcode VARCHAR(50));
GO

CREATE TABLE Client
(clientNo VARCHAR(4) PRIMARY KEY,
fname VARCHAR(50),
lname VARCHAR(50),
telno VARCHAR(50),
preftype VARCHAR(50),
maxrent INT);
GO

CREATE TABLE PrivateOwner
(ownerNo VARCHAR(4) PRIMARY KEY,
fname VARCHAR(50),
lname VARCHAR(50),
address VARCHAR(50),
telno VARCHAR(50));
GO

CREATE TABLE Staff
(staffNo VARCHAR(4) PRIMARY KEY,
fname VARCHAR(50),
lname VARCHAR(50),
position VARCHAR(50),
gender VARCHAR(1),
dob DATE,
salary INT,
branchNo VARCHAR(4) REFERENCES Branch(branchNo));
GO

CREATE TABLE PropertyForRent
(propertyNo VARCHAR(4) PRIMARY KEY,
street VARCHAR(50),
city VARCHAR(50),
postcode VARCHAR(50),
type VARCHAR(50),
rooms INT,
rent INT,
ownerNo VARCHAR(4) REFERENCES PrivateOwner(ownerNo),
staffNo VARCHAR(4) REFERENCES Staff(staffNo),
branchNo VARCHAR(4) REFERENCES Branch(branchNo) );
GO

CREATE TABLE Registration
(clientNo VARCHAR(4) REFERENCES Client(clientNo),
branchNo VARCHAR(4) REFERENCES Branch(branchNo),
staffNo VARCHAR(4) REFERENCES Staff(staffNo),
datejoined DATE,
PRIMARY KEY (clientNo, branchNo));
GO

   
CREATE TABLE Viewing
(clientNo VARCHAR(4)REFERENCES Client(clientNo),
propertyNo VARCHAR(4) REFERENCES PropertyForRent(propertyNo),
viewdate DATE,
comment VARCHAR(50),
PRIMARY KEY (clientNo, propertyNo));
GO

--Add data into tables.
INSERT INTO Branch VALUES ('B002', '56 Clover Dr', 'London', 'NW106EU');
INSERT INTO Branch VALUES ('B003', '163 Main St', 'Glasgow', '6119QX');
INSERT INTO Branch VALUES ('B004', '32 Manse Rd', 'Bristol', 'BS991NZ');
INSERT INTO Branch VALUES ('B005', '22 Deer Rd', 'London', 'SW14EH');
INSERT INTO Branch VALUES ('B007', '16 Argyll St', 'Aberdeen', 'AB23SU');
GO

INSERT INTO Client VALUES ('CR56', 'Aline', 'Stewart', '0141-848-1825', 'Flat', 350);
INSERT INTO Client VALUES ('CR62', 'Mary', 'Tregear', '0122-19670', 'Flat', 600);
INSERT INTO Client VALUES ('CR74', 'Mike', 'Ritchie', '0145-392178', 'House', 750);
INSERT INTO Client VALUES ('CR76', 'John', 'Kay', '0207-774-5632', 'Flat', 425);
GO

INSERT INTO PrivateOwner VALUES ('CO40','Tina','Murphy', '63 Well St. Glasgow G42', '0141-943-1728');
INSERT INTO PrivateOwner VALUES ('CO46','Joe','Keogh', '2 Fregus Dr. Aberdeen AB275X', '01224-861212');
INSERT INTO PrivateOwner VALUES ('CO87','Carol','Farrel', '6 Achary St. Glasgow G329DX', '0141-357-7419');
INSERT INTO PrivateOwner VALUES ('CO93','Tony','Shaw', '12 Park Pl. Glasgow G40QR', '0141-225-7025');
GO

INSERT INTO Staff VALUES ('SA9', 'Mary', 'Howe', 'Assistant', 'F', '1970-02-19', 9270, 'B007');
INSERT INTO Staff VALUES ('SG14', 'David', 'Ford', 'Supervisor', 'M', '1958-03-24', 18000, 'B003');
INSERT INTO Staff VALUES ('SG37', 'Anne', 'Beech', 'Assistant', 'F', '1960-11-10', 12000, 'B003');
INSERT INTO Staff VALUES ('SG5', 'Susan', 'Brand', 'Manager', 'F', '1940-06-03', 24000, 'B003');
INSERT INTO Staff VALUES ('SL21', 'John', 'White', 'Manager', 'M', '1945-10-01', 30000, 'B005');
INSERT INTO Staff VALUES ('SL41', 'Julie', 'Lee', 'Assistant', 'F', '1965-06-13', 9000, 'B005');
GO

INSERT INTO PropertyForRent VALUES ('PA14', '16 Holhead', 'Aberdeen', 'AB75SU', 'House',6, 650, 'CO46', 'SA9', 'B007');
INSERT INTO PropertyForRent VALUES ('PG16', '5 Novar Dr', 'Glasgow', 'G129AX', 'Flat', 4, 450, 'CO93', 'SG14', 'B003');
INSERT INTO PropertyForRent VALUES ('PG21', '18 Dale Dr', 'Glasgow', 'G12', 'House', 5, 200, 'CO87', 'SG37', 'B003');
INSERT INTO PropertyForRent VALUES ('PG36', '2 Manor Rd', 'Glasgow', 'G324QX', 'Flat', 3, 375, 'CO93', 'SG37', 'B003');
INSERT INTO PropertyForRent VALUES ('PG4', '6 Lawrence St', 'Glasgow', 'G119QX', 'Flat', 3, 350, 'CO40', NULL, 'B003');
INSERT INTO PropertyForRent VALUES ('PL94', '6 Agryll St', 'London', 'NW2', 'Flat', 4, 400, 'CO87', 'SL41', 'B005');
GO

INSERT INTO Registration VALUES ('CR56', 'B003', 'SG37', '2003-04-11');
INSERT INTO Registration VALUES ('CR62', 'B007', 'SA9', '2003-03-07');
INSERT INTO Registration VALUES ('CR74', 'B003', 'SG37', '2002-11-16');
INSERT INTO Registration VALUES ('CR76', 'B005', 'SL41', '2004-01-02');
GO



INSERT INTO Viewing VALUES ('CR56', 'PA14', '2004-05-24', 'Too small');
INSERT INTO Viewing VALUES ('CR56', 'PG16', '2004-05-14', NULL);
INSERT INTO Viewing VALUES ('CR56', 'PG4', '2004-05-26', NULL);
INSERT INTO Viewing VALUES ('CR62', 'PA14', '2004-05-14', 'No dining room');
INSERT INTO Viewing VALUES ('CR76', 'PG4', '2004-04-20', 'Too remote');
GO