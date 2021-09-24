FILENAME REFFILE '/home/usmanash930/DM/carInsurance_train.csv';

PROC IMPORT DATAFILE=REFFILE
	DBMS=CSV
	OUT=WORK.INS_TRAIN;
	GETNAMES=YES;
RUN;

PROC CONTENTS DATA=WORK.INS_TRAIN; 
RUN;

proc means data=WORK.INS_TRAIN min max n std mean median skewness;
	var Id Age Default Balance HHInsurance CarLoan LastContactDay NoOfContacts 
		DaysPassed PrevAttempts;
run;

proc means data=WORK.INS_TRAIN VAR p5 p25 p50 p75 p95;
	var Id Age Default Balance HHInsurance CarLoan LastContactDay NoOfContacts 
		DaysPassed PrevAttempts;
run; 

proc freq data=WORK.INS_TRAIN;
	tables Job Marital Education Communication LastContactMonth Outcome Carloan 
		Default CarInsurance HHInsurance ;
run;

proc means data=WORK.INS_TRAIN nmiss;
format Id Age Default Balance HHInsurance CarLoan LastContactDay NoOfContacts 
		DaysPassed PrevAttempts _nmissprint.;
		run;
		
proc format;
	value _nmissprint low-high="Non-missing";
	value $_cmissprint " "=" " other="Non-missing";
run;

proc freq data=WORK.INS_TRAIN;
	title3 "Missing Data Frequencies";
	title4 h=2 "Legend: ., A, B, etc = Missing";
	format Id Age Default Balance HHInsurance CarLoan LastContactDay NoOfContacts 
		DaysPassed PrevAttempts _nmissprint.;
	format Job Marital Education Communication LastContactMonth Outcome CallStart 
		CallEnd CarInsurance $_cmissprint.;
	tables Job Marital Education Communication LastContactMonth Outcome CallStart 
		CallEnd CarInsurance Id Age Default Balance HHInsurance CarLoan 
		LastContactDay NoOfContacts DaysPassed PrevAttempts / missing nocum;
run;

ods graphics / reset width=6.4in height=4.8in imagemap;

proc sgplot data=WORK.INS_TRAIN;
	histogram Age /;
	yaxis grid;
run;

ods graphics / reset;

ods graphics / reset width=6.4in height=4.8in imagemap;

proc sgplot data=WORK.INS_TRAIN;
	histogram Balance /;
	yaxis grid;
run;

ods graphics / reset;

PROC FREQ DATA=WORK.INS_TRAIN;
TABLE Age;
RUN;

data WORK.INS_TRAIN;
set WORK.INS_TRAIN;
if Age >= 1 and Age <= 20 then Age_Bin = 19;
if Age >= 21 and Age <= 25 then Age_Bin = 23;
if Age >= 26 and Age <= 30 then Age_Bin = 28;
if Age >= 31 and Age <= 35 then Age_Bin = 33;
if Age >= 36 and Age <= 40 then Age_Bin = 38;
if Age >= 41 and Age <= 45 then Age_Bin = 43;
if Age >= 46 and Age <= 50 then Age_Bin = 48;
if Age >= 51 and Age <= 55 then Age_Bin = 53;
if Age >= 56 and Age <= 60 then Age_Bin = 58;
if Age >= 61 and Age <= 65 then Age_Bin = 63;
if Age >= 66 and Age <= 70 then Age_Bin = 68;
if Age >= 71 and Age <= 75 then Age_Bin = 73;
if Age >= 76 and Age <= 80 then Age_Bin = 78;
if Age >= 81 and Age <= 85 then Age_Bin = 83;
if Age >= 86 and Age <= 90 then Age_Bin = 88;
if Age >= 91 and Age <= 95 then Age_Bin = 93;
if Age >= 96 and Age <= 100 then Age_Bin = 98;
run;

ods graphics / reset width=6.4in height=4.8in imagemap;

proc sgplot data=WORK.INS_TRAIN;
	hbar Age_Bin / stat=percent;
	xaxis grid;
run;

ods graphics / reset;

proc sql;
select Count(*) as Neagtive_Values_Balance 
from WORK.INS_TRAIN
where Balance < 0;
quit;

data WORK.INS_TRAIN;
  set WORK.INS_TRAIN;
  if Balance<0 then call missing(of Balance);
run;

ods noproctitle;
proc format;
	value _nmissprint low-high="Non-missing";
run;
proc freq data=WORK.INS_TRAIN;
	title3 "Missing Data Frequencies";
	title4 h=2 "Legend: ., A, B, etc = Missing";
	format Balance _nmissprint.;
	tables Balance / missing nocum;
run;

proc stdize data=WORK.INS_TRAIN reponly missing=mean out=WORK.INS_TRAIN;
var Balance;
run;