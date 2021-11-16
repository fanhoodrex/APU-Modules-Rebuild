-- 13
CREATE PROCEDURE InsertNewDepartment
    @DeptName NVARCHAR(50),
    @Address NVARCHAR(50),
    @City NVARCHAR(50)
AS
IF EXISTS (SELECT * FROM Department WHERE DeptName = @DeptName)
    BEGIN
        UPDATE Department
        SET Address = @Address, City = @City
        WHERE DeptName = @DeptName
    Print 'Update Existing Department'  
    END
ELSE
   Begin
   INSERT into Department 
	values (@DeptName,
			@Address,
			@City,)
    Print 'New Department inserted' 
    END

-- 14
SELECT DeptName, COUNT(*) AS Total_Employees
FROM Department
INNER JOIN Employee
ON Department.Dno = Employee.Dno
GROUP BY DeptName

-- 15
CREATE TRIGGER SalaryBelow20K
ON Department
AFTER UPDATE
AS
	SELECT * FROM inserted
	IF EXISTS ( SELECT Salary FROM inserted WHERE Salary >= 20000 )
	BEGIN 
		PRINT 'Salary Must be Less than 20000'
		ROLLBACK
	END

-- 16
CREATE PROCEDURE listAllCurrentEmployees
    @Dno NVARCHAR(50)
AS
    SELECT Dno, eNo, Name
    FROM Department
    INNER JOIN Employee
    ON Department.Dno = Employee.Dno
    WHERE Dno = @Dno

-- 17
CREATE TRIGGER PreventDeletion
    @eNo
ON Employee
INSTEAD OF DELETE
AS
BEGIN
    SELECT * FROM deleted
	RAISERROR('Employee Can''t be deleted', 16,10)
    UPDATE Employee
    SET Employed = "False"
    WHERE eNo = @eNo    
END