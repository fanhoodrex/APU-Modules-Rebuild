-- Note: before creating the stored procedure make sure that the query works well
-- create stored procedure without any parameter
USE Dreamhome
GO

CREATE PROC SPstaff
AS 
(SELECT * FROM staff)

-- execute the procedure SPstaff
EXECUTE SPstaff

-- If this procedure is the first statement within a batch
SPstaff

-- alter procedure SPstaff
ALTER PROC SPstaff
AS 
SELECT fname,lname
 FROM staff

-- Drop procedure SPstaff
DROP PROC SPstaff

-- Returning more than one result set
CREATE PROCEDURE SPmutli
AS
SELECT * FROM BRANCH 
SELECT * FROM STAFF

-- Execute procedure SPmutli
EXEC SPmutli

-- Create procedure with 1 parameter
CREATE PROC SPstaff_name 
@fname1 varchar(20)
AS
SELECT * 
FROM Staff
WHERE fname = @fname1;

-- execute proc SPstaff_name
EXEC SPstaff_name 'mary'

-- Create procedure with 2 parameters
-- position and salary

CREATE PROC SPstaff_Pos_Sal 
@pos varchar(20), @sal  int
AS
(SELECT fname,position, salary, gender
 FROM staff
 WHERE position = @pos AND salary > @sal)

-- execute the SPstaff_Pos_Sal
-- I can execute this procedure in many ways
EXEC SPstaff_Pos_Sal 'manager', 20000 
EXECUTE SPstaff_Pos_Sal 'manager', 8000
EXECUTE SPstaff_Pos_Sal @sal = 8000 ,@pos = 'manager' 

-- sp_depends 'sys stored procedure' to get information about objects in Database
-- get info about SPstaff_Pos_Sal stored procedure
EXEC sp_depends @objname = 'Staff'
EXEC sp_depends @objname = 'Branch'

-- get info about object related to staff table
EXEC sp_depends @objname = 'staff'

-- Create Procedure Branch_Insert_Update
-- this procedure checks for the existance of branch, in case that
-- the branch exists it will update it otherwise a new row will be inserted
CREATE PROC Branch_Insert_Update
@branchNo varchar (20),
@street varchar (20),
@city varchar (20),
@postcode varchar (20)
AS
If EXISTS (Select * from Branch Where branchNo = @branchNo)
    Begin
	UPDATE Branch
	set street = @street,
	    city = @city,
	    postcode = @postcode
	WHERE branchno = @branchNo
	Print (@branchno)+ ' row updated' 
	End
ELSE
   Begin
   INSERT into Branch 
	values (@branchNo ,
			@street ,
			@city ,
			@postcode)
    Print ' New row inserted' 
    END
    
    drop proc Branch_Insert_Update

-- exec Branch_Insert_Update
EXEC Branch_Insert_Update 'B015', 'x446', 'w446', 'bukit446'

-- drop Branch_Insert_Update
DROP PROC Branch_Insert_Update

-- Create procedure with OUTPUT parameter
CREATE PROCEDURE sum_salary
@SUM_SAL money OUTPUT
AS
SELECT @SUM_SAL = SUM(salary)
FROM staff;

-- Execute sum_salary procdure
DECLARE @SUM_SAL1 money
EXECUTE sum_salary @SUM_SAL1 OUTPUT

IF @SUM_SAL1 < 130000
	BEGIN
	Print (@sum_sal1)
	PRINT 'Salary sum is less than 130000'
	END
ELSE
	BEGIN
	Print (@sum_sal1)
	PRINT 'Salary sum is more than 130000'
	END

-- input and output stored procedures
Create PROCEDURE sum_salary2
@SUM_SAL money OUTPUT,
@sal money
AS
SELECT @SUM_SAL = SUM(salary)
FROM staff
Where salary > @sal;

-- Execute sum_salary procdure
DECLARE @SUM_SAL1 money
EXECUTE sum_salary2 @SUM_SAL1 OUTPUT, 20000

IF @SUM_SAL1 < 130000
	BEGIN
	Print (@sum_sal1)
	PRINT 'Salary sum is less than 130000'
	END
ELSE
	BEGIN
	Print (@sum_sal1)
	PRINT 'Salary sum is more than 130000'
	END