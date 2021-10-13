/*
Lab Exercise – Stored Procedures
Write a stored procedure (on the DreamHome database) that reads the branch number entered by
the user and displays the details of the staff at that branch as well as the total number of properties
handled by each of those staff.

Include appropriate validation messages to alert the user if an invalid branch number is given as the input.  

Format for stored procedure call below:
EXEC spStaffDetails ‘B005’

Sample output:
branchno	staffno	fname	lname	totalProperties
B005		SL21	John	White	0
B005		SL41	Julie	Lee	1
*/

ALTER PROC spStaffDetails
@branchNum nvarchar(20)
AS
BEGIN
IF EXISTS (select * from Staff Where branchNo = @branchNum) -- if the staff from specified branch exist
	select Staff.branchNo,Staff.staffNo,Staff.fname,Staff.lname,count(PropertyForRent.staffNo) as totalProperties
	from Staff
	left join PropertyForRent
	on Staff.staffNo = PropertyForRent.staffNo
	where Staff.branchNo = @branchNum
	group by Staff.branchNo,Staff.staffNo,Staff.fname,Staff.lname
ELSE
	print 'invalid input of branch number'
END

EXEC spStaffDetails 'B003'