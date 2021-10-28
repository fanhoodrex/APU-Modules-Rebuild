Use DreamHome

--1. List full details of all staff. 
select * from Staff;

--2. Produce a list of salaries for all staff, showing only staff number, first and last names, and salary. 
select staffNo,fname,lname,salary from Staff;

--3. List the staff numbers of all staff who oversees a property. 
select staffNo from PropertyForRent where staffNo IS NOT NULL;

--4. Produce a list of monthly salaries for all staff, showing staff number, first and last name and salary details. 
select staffNo,fname,lname,salary/12 as "Monthly Salary" from Staff;

--5. List all staff with a salary greater than 10,000. 
select * from Staff where salary > 10000;

--6. List addresses of all branch offices in London or Glasgow.
select * from Branch where city in ('London','Glasgow');
select * from Branch where city = 'London' or city = 'Glasgow';

--7. List all staff with a salary between 20,000 and 30,000. 
select * from Staff where salary between 20000 and 30000;

--8. List all managers and supervisors.
select * from Staff where position = 'manager' or position = 'supervisors';
select * from Branch where city in ('manager','supervisors');

--9. Find all staff first names that contain the letter ‘a’. 
select * from Staff where fname LIKE '%a%';

--10. List details of all property for rent which has not been overseen by any staff. 
select * from PropertyForRent where staffNo IS NULL;

--11. List salaries for all staff, arranged in descending order of salary. 
select * from Staff order by salary;

--12. Produce abbreviated list of properties in order of property type. 
select * from PropertyForRent order by type;

--13. How many properties cost more than £350 per month to rent? 
select count(rent) as result from PropertyForRent where rent > 350;

--14. Find number of Managers and sum of their salaries. 
select count(position) as number, sum(salary) as sum
from Staff 
where position = 'Manager';

--15. Find minimum, maximum, and average staff salary.
select min(salary) as minimum,max(salary) as maximum,avg(salary) as average
from Staff;

--16. Find the total number of staffs in each branch and their total salaries. 
select distinct(branchNo),count(staffNo) as number_of_staffs,sum(salary) as total_salary
from Staff 
group by branchNo;

--17. For each branch with more than 1 member of staff, find number of staff in each branch and sum of their salaries. 
select distinct(branchNo),count(staffNo) as number_of_staffs,sum(salary) as total_salary
from Staff 
group by branchNo
having count(staffNo) > 1;

--18. List staffs who work in the branch located at '163 Main St'.
select * from Staff
inner join Branch
on Staff.branchNo = Branch.branchNo
where street = '163 Main St';

--19. List all staff whose salary is greater than the average salary, and show by how much. 
select * from Staff
where salary > (select avg(salary) from Staff);

--20. List properties handled by staff at '163 Main St'. 
select * from PropertyForRent
inner join Staff
on PropertyForRent.staffNo = Staff.staffNo
inner join Branch
on staff.branchNo = Branch.branchNo
where Branch.street = '163 Main St';

--21. List names of all staffs and branches details. 
select fname + ' ' + lname as names_of_all_staffs,branchNo
from Staff
inner join Branch
on Staff.branchNo = Branch.branchNo;

--22. For each branch, list staffs who manage properties, including city in which branch is located and properties they manage. 
select Staff.staffNo as staffs,branch.city,propertyNo
from staff
inner join Branch
on Staff.branchNo = Branch.branchNo
inner join PropertyForRent
on PropertyForRent.staffNo = Staff.staffNo;

--23. Find number of properties handled by each staff member. 
select PropertyForRent.staffNo,count(propertyNo) as number_of_properties
from Staff
inner join PropertyForRent
on PropertyForRent.staffNo = staff.staffNo
group by PropertyForRent.staffNo;

--24. Find all staffs who work in a London branch.
select staffNo
from Staff
inner join Branch
on Branch.branchNo = Staff.branchNo
where city = 'London';

--25. Insert a new row into Staff table supplying data for all columns.
INSERT INTO Staff VALUES ('SG16', 'Alan', 'Brown', 'Assistant','M','1957-05-25','8300','B003');

--26. Insert a new row into Staff table supplying data for all mandatory columns.
INSERT INTO Staff VALUES ('SG44', 'Anne', 'Jones', 'Assistant',NULL,NULL,'8100','B003');

--27. Increase staff SA9’s Salary by 3%.
update Staff
set salary = salary * 1.03
where staffNo = 'SA9'; 

--28. Give all Assistants a 10% salary increment.
update Staff
set salary = salary * 1.1
where position = 'Assistant';

--29. Promote Anne Jones (staffNo = 'SG44') to Manager and change her salary to £18,000.
update Staff
set position = 'Manager', salary = '18000'
where staffNo = 'SG44'; 

--30. Delete staffs that have the numbers SG44 and SG16.
DELETE FROM Staff WHERE staffNo in ('SG44','SG16');