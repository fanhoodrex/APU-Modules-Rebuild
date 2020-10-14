%web_drop_table(WORK.IMPORT);


FILENAME REFFILE '/home/tp0481150/sasuser.v94/DTM assignment/Data_Set.csv';

PROC IMPORT DATAFILE=REFFILE
	DBMS=CSV
	OUT=WORK.IMPORT;
	GETNAMES=YES;
RUN;

PROC CONTENTS DATA=WORK.IMPORT; RUN;


%web_open_table(WORK.IMPORT);

data new1;
set WORK.customer_data;
if job_type = '?' then job_type = '';
run;


/* identify duplicates */
proc sort data=customer_data out=sort_customer_data;
by age  job_type qualification_education years_in_education marital_status 
job relationship_status race capital_gain capital_loss work_per_week country salary;
run;

data dups nodupds;
set sort_customer_data;
by age  job_type qualification_education years_in_education marital_status 
job relationship_status race capital_gain capital_loss work_per_week country salary ;
if first.age and last.age then output nodups;
run;

/* remove dups */
proc sort data=customer_data out= sort_customer_data noduprecs;
by _all_;
run;




/* Summary stats for (age)  */

proc means data=WORK.CUSTOMER_DATA chartype mean std min max median n nmiss var 
		mode range vardef=df q1 q3 qmethod=os;
	var;
ods noproctitle;
run;


proc sort data=customer_data dupout= sort_customer_data 
nodupkey;
by age;
run;





