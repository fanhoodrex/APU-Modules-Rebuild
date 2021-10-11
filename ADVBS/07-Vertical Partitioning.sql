--1. Create table EmployeeReports
CREATE TABLE EmployeeReports
(
ReportID INT IDENTITY (1,1) NOT NULL,
ReportName VARCHAR (100),
ReportNumber VARCHAR (20),
ReportDescription VARCHAR (MAX)
CONSTRAINT EReport_PK PRIMARY KEY CLUSTERED (ReportID)
)

--2. Insert records into EmployeeReports table 
DECLARE @i INT
SET @i = 1
 
BEGIN TRAN
WHILE @i<100000 
BEGIN
INSERT INTO EmployeeReports
(
ReportName,
ReportNumber,
ReportDescription
)
VALUES
(
'ReportName',
CONVERT (varchar (20), @i),
REPLICATE ('Report', 1000)
)
SET @i=@i+1
END
COMMIT TRAN
GO

--3. Check records in EmployeeReports
SELECT * FROM EmployeeReports

--4. Execute query and check statistics
SET STATISTICS IO ON
SET STATISTICS TIME ON
SELECT er.ReportID, er.ReportName, er.ReportNumber
FROM dbo.EmployeeReports er
WHERE er.ReportNumber LIKE '%33%'
SET STATISTICS IO OFF
SET STATISTICS TIME OFF

--5. Partition EmployeeReport table vertically
CREATE TABLE ReportsDesc 
( ReportID INT FOREIGN KEY REFERENCES EmployeeReports (ReportID),
  ReportDescription VARCHAR(MAX)
  CONSTRAINT PK_ReportDesc PRIMARY KEY CLUSTERED (ReportID)
 )
 
CREATE TABLE ReportsData
(
ReportID INT NOT NULL,
ReportName VARCHAR (100),
ReportNumber VARCHAR (20),
 
CONSTRAINT DReport_PK PRIMARY KEY CLUSTERED (ReportID)
)

--6. Insert the report ID, Name and Number only into ReportsData table
INSERT INTO dbo.ReportsData
(
    ReportID,
    ReportName,
    ReportNumber
) 
SELECT er.ReportID, 
er.ReportName, 
er.ReportNumber 
FROM dbo.EmployeeReports er

--7. Re-execute query 4, now accessing ReportsData table and check statistics
SET STATISTICS IO ON
SET STATISTICS TIME ON
SELECT er.ReportID, er.ReportName, er.ReportNumber
FROM ReportsData er
WHERE er.ReportNumber LIKE '%33%'
SET STATISTICS IO OFF
SET STATISTICS TIME OFF
