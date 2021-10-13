/* Title: Triggers
   Database: DreamHome
*/

-- Use DreamHome Database

USE Dreamhome

-- ADD constraint on Salary Table (Domain Constraint)

ALTER TABLE Staff 
     ADD CONSTRAINT chk_sal CHECK ( Salary <= 90000)


ALTER TABLE Staff
     DROP CONSTRAINT chk_sal 
     
-- Create Domian constraint using trigger
CREATE TRIGGER ChkSal
ON STAFF
AFTER UPDATE
AS
	SELECT * FROM inserted
	IF EXISTS ( SELECT salary FROM inserted WHERE Salary >= 30000 )
	BEGIN 
		PRINT 'Salary Must be Less than 30000'
		ROLLBACK
	END

-- Use drop command to delete the trigger

DROP TRIGGER ChkSal

-- Show Staff table details

SELECT * FROM STAFF

-- Update Staff 'SL41' Salary to be 35000

UPDATE Staff
SET salary = 35000
WHERE Staffno = 'SL41'

-- Alter trigger to remove the rollback statement

ALTER TRIGGER ChkSal
ON STAFF
AFTER UPDATE
AS
	IF EXISTS ( SELECT salary FROM inserted WHERE  Salary >= 30000 )
	BEGIN
		PRINT 'Salary Must be Less than 30000'
	END

-- Create a trigger to ensure that the salary of a manager will not
-- exceed 30000

CREATE TRIGGER sal_pos_check
ON Staff
AFTER UPDATE
AS

IF EXISTS (SELECT * FROM inserted WHERE position = 'manager' AND Salary > 30000) 
	BEGIN
		PRINT 'Manager Salary must not exceed 30000'
		ROLLBACK
	END
	
-- Update Staff Susan's salary to be 28000 rather than 24000
-- Hint: the trigger will not fire because it didn't meet the criteria

UPDATE Staff
SET salary = 28000
WHERE Staffno = 'SG5'


UPDATE Staff
SET  salary = 50000
Where staffno = 'SG37'


-- Update Staff Susan's salary to be 35000 rather than 28000
-- Hint: the trigger will be fired and no action will happen as a result of the 
-- rollback statement

UPDATE Staff
SET salary = 35000
WHERE staffno = 'SG5'


-- get triggers information using sys.triggers

SELECT * FROM sys.triggers

-- Using INSTEAD OF to Prevent Staff member from being deleted

CREATE TRIGGER STAFF_DEL1235
ON STAFF
INSTEAD OF DELETE
AS
BEGIN
	SELECT * FROM deleted
	RAISERROR('Staff Can''t be deleted', 16,10)
END

SELECT * FROM deleted


-- Use delete statement to delete staff 'SG5'

DELETE FROM Staff
WHERE staffno = 'SG5'

-- Add column status to staff table to check If Staff is active or Inactive

ALTER TABLE Staff
	ADD status VARCHAR(10)
	
--Drop trigger STAFF_DEL1235

DROP TRIGGER STAFF_DEL1235

--Create a new INSTEAD OF trigger to include the staff status

CREATE TRIGGER STAFF_DEL
ON STAFF
INSTEAD OF DELETE
AS
BEGIN
	RAISERROR ('Staff cant''t be deleted.  Staff
	changed to inactive status.', 14, 11)
	 
	SELECT * FROM deleted -- this statement to show the deleted records in the deleted table
	
	UPDATE Staff
	SET status = 'Inactive'
	FROM Staff AS s INNER JOIN deleted AS d   
	ON s.Staffno = d.Staffno
END

-- Delete the Staff who holds the staffno SG5

DELETE FROM Staff
WHERE Staffno = 'SG5'


-- Try to show the deleted table info outside the trigger

SELECT * FROM deleted


-- Create Audit Table ClientAudit

CREATE TABLE ClientAudit
(
ClientNo VARCHAR(50) not null,
fname VARCHAR(50) ,
lname VARCHAR(50) ,
telno VARCHAR(50) ,
preftype VARCHAR(50),
maxrent INT,
InsDelDate DATE,
flag CHAR(1)
)


-- Create ClientAud trigger to save the inserted and deleted rows 
-- from the Client table to the ClientAudit table

CREATE TRIGGER ClientAud
ON Client
AFTER INSERT, DELETE
AS

INSERT INTO ClientAudit 
SELECT ClientNo, fname, lname, telno, preftype, maxrent , getdate(), 'I'
FROM inserted

SELECT * FROM inserted

INSERT INTO ClientAudit 
SELECT ClientNo, fname, lname, telno, preftype, maxrent , getdate(), 'D'
FROM deleted

SELECT * FROM deleted

-- Insert new row to Client table

INSERT INTO Client
VALUES ('CR95','Alex', 'Max','01498-22222', 'House', 500)

-- Delete the previously inserted record

DELETE FROM Client
WHERE Clientno = 'CR95'

 
