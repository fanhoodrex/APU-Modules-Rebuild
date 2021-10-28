-- 1) Use stored Procedure sp_addlogin to create logins under general database Security
-- (Server --> Security --> Logins)
EXECUTE sp_addlogin @loginame =  'ali', @passwd = '1'

-- 2) After logins created a user should be created under
-- (DreamHome_DB --> Security --> Users). Try to login as ali.
EXECUTE sp_adduser 'ali', 'ali'

-- 3) Grant Select to ali to be able to view the staff table 
-- (admin --> ali)
-- Note: If I want to give same privileges to other users in this case then add users seperated by comma after (TO)
GRANT SELECT 
ON staff
TO ali

-- 4) Grant update privileges on salary and position columns only to ali 
-- (admin --> ali)
GRANT UPDATE (salary, position) 
ON staff
TO ali

--5) Admin revokes ali's select privilege. This leaves ali with only the update privilege.
-- (admin --> ali)
REVOKE SELECT 
ON Staff
FROM ali

UPDATE staff
SET salary = 13000
WHERE staffNo = 'SA9'

-- 6) The following steps are used to Create groups ( Users who have the same privileges) 
-- (admin --> ali)
REVOKE ALL privileges
ON staff 
FROM ali

-- 7) Create (roles or groups) using sp_addrole stored procedure
-- (DreamHome --> Security --> Roles --> Database roles)
EXECUTE sp_addrole @rolename = 'HR'

-- 8) Grant SELECT, INSERT, UPDATE privileges to (HR group or role)
-- (DreamHome --> Security --> Roles --> Database roles --> under securables)
-- Notice the check boxes under grant
GRANT SELECT, INSERT, UPDATE
ON staff
TO HR

-- 9) After creating roles sp_addrolemember stored procedure used to 
-- Assign user to group/role. Check ali's privileges.
EXECUTE sp_addrolemember @rolename = 'HR' , @membername = 'ali'