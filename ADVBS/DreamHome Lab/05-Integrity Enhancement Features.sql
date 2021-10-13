/* 
Title: Integrity Enhancement Feature
Database: DreamHome
*/

-- Required Data
-- Example, every member of staff must have an associated job position 
-- (for example, Manager, Assistant, and so on)

ALTER TABLE Staff 
	ALTER column position varchar (50) Not Null

-- Domain Constraints

-- example, the gender of a member of staff is either 'M' or 'F', 
-- so the domain of the column gender of the Staff table is 
-- a single character string consisting of either 'M' or 'F'
-- The column has a value that violates the constraint. Therefore, 
-- WITH NOCHECK is used to prevent the constraint from being validated 
-- against existing rows, and to allow for the constraint to be added.

ALTER TABLE Staff WITH NOCHECK 
	ADD CONSTRAINT CK_gender check (gender = 'm' OR gender = 'f')
-- OR 
ALTER TABLE Staff WITH NOCHECK 
	ADD CONSTRAINT CK_gender check (gender in ('f','m'))

-- DROP CK_gender constraint
ALTER TABLE Staff 
	DROP CONSTRAINT CK_gender

-- Entity Integrity
-- Defining Primary Key
-- use unique keyword

-- ADD Unique constraint to DOB column
ALTER  TABLE Staff 
	ADD UNIQUE (dob)
	
-- add new column "address" to staff table 
ALTER  TABLE Staff
	ADD address varchar(50)

-- remove the column "address" from staff table
ALTER  TABLE Staff
	DROP column address 
	
-- add new column with check constraint
ALTER  TABLE staff
	ADD status varchar(10) 
	constraint CK_status check (status in ('active','inactive'))

-- add new "default" constrain for existing column position
-- Hint: the default value will appear when the user insert new row

ALTER TABLE Staff
	ADD CONSTRAINT DEF_job default 'manager' FOR Position

-- Referential action 
-- specified using ON UPDATE and ON DELETE subclauses:
-- NO ACTION, SET NULL, CASCADE, SET DEFAULT
-- the Two tables used are PrivateOwner and PropertyForRent

-- show all foreign keys information
SELECT * FROM sys.foreign_keys

-- drop foreign key FK_PropertyForRent_PrivateOwner
ALTER TABLE PropertyForRent
      drop constraint [FK__PropertyF__owner__403A8C7D]

-- Add foreign key constraint with 'NO ACTION' option
-- Hint: no action will happened 
ALTER TABLE PropertyForRent
	ADD constraint FK_NoAction foreign key (ownerNo) references PrivateOwner(ownerNo) 
	ON DELETE NO ACTION ON UPDATE NO ACTION

-- Alter foreign key constraint with 'SET NULL' option
-- Hint: all the related rows in the child table will be set to NULL

ALTER TABLE PropertyForRent
	ADD constraint FK_SetNull foreign key (ownerNo) references PrivateOwner(ownerNo) 
	ON DELETE SET NULL ON UPDATE SET NULL
	
-- Alter foreign key constraint with 'SET DEFAULT' option
-- Hint: all the related rows in the child table will be set to Default
-- Default value: is the auto value that will be inserted in the column in case that the 
-- user didn't fill it.

-- 1) the default value must be specificed
ALTER TABLE PropertyForRent
	ADD CONSTRAINT DEF_ownerNo default 'CO87' FOR ownerNo

-- 2) set the referential action to Default on update and delete
ALTER TABLE PropertyForRent
	ADD constraint FK_SetDefault foreign key (ownerNo) references PrivateOwner(ownerNo) 
	ON DELETE SET DEFAULT ON UPDATE SET DEFAULT
	
-- Alter foreign key constraint with 'CASCADE' option
-- Hint: all the related rows in the child table will be deleted
ALTER TABLE PropertyForRent
	ADD constraint FK_Cascade foreign key (ownerNo) references PrivateOwner(ownerNo) 
	ON DELETE CASCADE ON UPDATE CASCADE