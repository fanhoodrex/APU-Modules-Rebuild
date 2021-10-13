/*
1. Cross Join
2. Simple Join
3. Simple Join using alias
4. INNER JOIN
5. Three Tables join - Simple join
6. Three Tables Join (INNER JOIN)
7. Outer Joins
	7.1 LEFT JOIN
	7.2 RIGHT JOIN
	7.3 Full OUTER JOIN
	7.4 LEFT JOIN EXCLUDING INNER JOIN
	7.5 RIGHT JOIN EXCLUDING INNER JOIN
	7.6 OUTER JOIN EXCLUDING INNER JOIN
*/
-- Cross Join 'cartesian product'
SELECT Branch.branchNo, branch.city, Staff.Staffno, Staff.fname
FROM Branch CROSS JOIN Staff

-- Simple Join
SELECT Branch.branchNo, Branch.city, Staff.Staffno, Staff.fname
FROM Branch, staff
WHERE Branch.branchNo = Staff.branchno;

-- Simple Join using alias
SELECT b.branchNo, b.city, s.Staffno, s.fname
FROM Branch b, staff s
WHERE b.branchNo = s.branchno;

-- using 'Inner Join'
SELECT b.branchNo, b.city, s.Staffno, s.fname
FROM Branch b INNER JOIN staff s 
ON b.branchNo = s.branchno;

-- Three Tables join
SELECT b.branchno, b.city, S.Staffno, S.fname, p.propertyNo, p.city
FROM Branch b, Staff s, PropertyForRent p
WHERE b.branchNo = s.branchno AND s.Staffno = p.StaffNo 

-- Three Tables Join (INNER JOIN)
SELECT b.branchno, b.city, S.Staffno, S.fname, p.propertyNo, p.city
FROM Branch b INNER JOIN Staff s 
ON b.branchNo = s.branchno
INNER JOIN PropertyForRent p 
ON s.Staffno = p.StaffNo 

-- Outer Join
-- This is INNER JOIN to show the result
SELECT b.branchNo, b.city, p.PropertyNo, p.city
FROM Branch b, PropertyForRent p
WHERE b.City = p.City;

-- Left Outer Join
-- Note: update table property for rent branchno "PL94" city column from "London" to "KL"
SELECT b.branchNo, b.city, p.PropertyNo, p.city
FROM Branch b LEFT JOIN PropertyForRent p
ON b.City = p.City


-- Right Outer Join
SELECT b.branchNo, b.city, p.PropertyNo, p.city
FROM Branch b right JOIN PropertyForRent p
ON b.City = p.City;

-- Full Outer Join
SELECT b.branchNo, b.city, p.PropertyNo, p.city
FROM Branch b FULL OUTER JOIN PropertyForRent p
ON b.City = p.City;

-- 7.4 LEFT JOIN EXCLUDING INNER JOIN
SELECT b.branchNo, b.city, p.PropertyNo, p.city
FROM Branch b LEFT JOIN PropertyForRent p
ON b.City = p.City
where p.city is null

-- 7.5 RIGHT JOIN EXCLUDING INNER JOIN
SELECT b.branchNo, b.city, p.PropertyNo, p.city
FROM Branch b Right JOIN PropertyForRent p
ON b.City = p.City
where b.city is null

-- 7.6 OUTER JOIN EXCLUDING INNER JOIN
SELECT b.branchNo, b.city, p.PropertyNo, p.city
FROM Branch b FULL OUTER JOIN PropertyForRent p
ON b.City = p.City
WHERE b.city is Null OR p.city is NULL;