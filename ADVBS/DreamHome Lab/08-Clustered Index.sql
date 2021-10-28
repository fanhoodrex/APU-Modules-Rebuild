--This script tests the effects of a clustered index on a given query.
--1. Create a Test database.
CREATE DATABASE TestDB

USE TestDB
GO

--Create the Sales table.
CREATE TABLE Sales(
 ID INT IDENTITY(1,1)
,ProductCode VARCHAR(20)
,Price FLOAT(53)
,DateTransaction DATETIME);

--3. The stored procedure inserts 200000 records into the Sales table.
CREATE PROCEDURE InsertIntoSales
AS 
SET NOCOUNT ON
BEGIN
DECLARE @PC VARCHAR(20)='A12CB'
DECLARE @Price INT = 50
DECLARE @COUNT INT = 0
      WHILE @COUNT<200000
      BEGIN
      SET @PC=@PC+CAST(@COUNT AS VARCHAR(20))
      SET @Price=@Price+@COUNT
      INSERT INTO Sales VALUES (@PC,@Price,GETDATE())
      SET @PC='A12CB'
      SET @Price=50
      SET @COUNT+=1
      END
END

--4. Execute the stored procedure (once only)
EXEC InsertIntoSales

--5. Check data in Sales table once stored procedure completes.
SELECT * FROM Sales

--6. Set statistics IO and TIME on to check on query execution.
SET STATISTICS IO ON
SET STATISTICS TIME ON
SELECT * FROM Sales WHERE ID=189923
SET STATISTICS IO OFF
SET STATISTICS TIME OFF

--7. Create a clusterd inded on the ID column
CREATE CLUSTERED INDEX CL_ID ON SALES(ID);

--8. Execute the same query in no.6 above and compare the results.
SET STATISTICS IO ON
SET STATISTICS TIME ON
SELECT * FROM Sales WHERE ID=189923
SET STATISTICS IO OFF
SET STATISTICS TIME OFF