
/* Macro for data details */
%macro contents_of(ABC);
	proc contents data=&ABC order=varnum;
	run;
%mend contents_of;

/* Macro for data frequency */
%macro freq_of(ABC);
	proc freq data=&ABC;
	run;
%mend freq_of;

/* Macro for data missing values check */
%macro miss_check(ABC);
	proc means data=&ABC nolabels nmiss stackodsoutput;
	/*ods output Summary = MissingValues;*/
	run;
	quit;
%mend miss_check;


/* Macro for converting character variables into nummeric */
%macro char_num(ABC);
	data &ABC._v1;
	set &ABC;
	Cust_Prop_new = input(Cust_Prop, best32.);
	Gender_new = input(Gender, best32.);
	Status_Cust_new = input(Status_Cust, best32.);
	run;
%mend char_num;


/* Macro for converting qualitative to quantitative */
%macro quali_quanti(ABC);
	data &ABC;
	set &ABC;
	if Cust_Prop = 'U' then Cust_Prop_new = '0';
	else if Cust_Prop = 'H' then Cust_Prop_new = '1';
	if Gender = 'F' then Gender_new = '0';
	else if Gender = 'M' then Gender_new = '1';
	if Status_Cust = 'E' then Status_Cust_new = '0';
	else if Status_Cust = 'A' then Status_Cust_new = '1';
	else if Status_Cust = 'N' then Status_Cust_new = '2';
	else if Status_Cust = 'F' then Status_Cust_new = '3';
	else if Status_Cust = 'L' then Status_Cust_new = '4';
	else if Status_Cust = 'S' then Status_Cust_new = '5';
	run;
%mend quali_quanti;


/* Macro for droping character variables */
%macro drop_char(ABC);
	data &ABC;
	set &ABC;
	drop Cust_Prop Gender Status_Cust;
	rename Cust_Prop_new=Cust_Prop Gender_new=Gender Status_Cust_new=Status_Cust;
	run;
%mend drop_char;


/* Macro for creating missing value indicator */
%macro indicator(ABC);
	data &ABC;
	set &ABC;
	if Cust_Last_Purchase = . then Cust_Last_Purchase_Ind = 1;
	else Cust_Last_Purchase_Ind = 0;
	if Pur_3_years_Avg_Indirect = . then Pur_3_years_Avg_Indirect_Ind = 1;
	else Pur_3_years_Avg_Indirect_Ind = 0;
	if Age = . then Age_Ind = 1;
	else Age_Ind = 0;
	if Gender = . then Gender_Ind = 1;
	else Gender_Ind = 0;
	run;
%mend indicator;



/* Macro for Correlation Matrix Plot */
/* libnamex REQUIRED: The libref of the dataset to be used for the correlation matrix
	dsname REQUIRED: The name of the dataset to be used for the correlation matrix
	vars REQUIRED: The list of variables to be included in the matrix
	savpath REQUIRED: The path where the Excel file should be saved
	savfile Optional: The name of the Excel file (default is CORRMATX)
	hight Optional: The threshold at which correlations should be flagged by a red cell color.
	 Must be a value greater than 0 and less than 1. Default value: .5
	NESUG 2009 And Now, Presenting ...
	8
	medt Optional: The threshold at which correlations should be flagged by an orange cell color.
	 Must be a value greater than 0 and less than hight. Default: nothing flagged as orange.
	lowt Optional: The threshold at which correlations should be flagged by a yellow cell color.
	 Must be a value greater than 0 and less than medt. Should only be specified when both hight
	 and medt were specified. Default: nothing flagged as yellow. */
%macro corrmatx(libnamex=, dsname=, vars=, savpath=, savfile=CORRMATX, hight=.5,
	medt=0, lowt=0);
	options missing='';
	%let cmvarn = %sysfunc(countw(&vars));
	%local i;
	proc corr data = &libnamex..&dsname outp=corrmtx nomiss;
	var &vars;
	run;
	proc template;
	define style corrmatx;
	 style table / borderwidth=10;
	end;
	run;
	* suppress titles and footnotes;
	title; footnote;
	data corrmtx2;
	set corrmtx (where=(_type_='CORR'));
	halfmatflg+1;
	array deletes(&cmvarn) &vars;
	do i = 1 to &cmvarn;
	if halfmatflg =< i then deletes(i) = .;
	end;
	drop halfmatflg i;
	format &vars 5.2;
	run;
	proc format;
	value corrfmtx
	low - -&hight, &hight - high = 'red'
	%if &medt ne 0 %then %do;
	-&hight< - -&medt, &medt -< &hight = 'orange' %end;
	%if &lowt ne 0 %then %do;
	-&medt< - -&lowt, &lowt -< &medt = 'yellow'; %end;
	run;
	proc sql;
	select '%NRSTR(%NRSTR(' || 'line "' || trim(name) || ': ' || trim(label) || '"));'
	into :legend separated by ' '
	from dictionary.columns
	where libname=%UPCASE("&libnamex") and memname=%UPCASE("&dsname")
	and name in (
	%do i = 1 %to &cmvarn;
	"%scan(&vars, &i) "
	%end;
	);
	quit;
	ods html file = "&savpath\&savfile..xls"
	headtext="<style> td {mso-number-format:\@} </style>" style=corrmatx;
	proc report data = corrmtx2
	style(header)={htmlstyle="mso-rotate:90; height:50pt"};
	column _name_ &vars;
	define _name_ / display '' style=[font_weight=bold];
	%do i = 1 %to &cmvarn;
	define %scan(&vars, &i) / display " %scan(&vars, &i)" style=[background=corrfmtx.];
	%end;
	compute after / style=[just=left];
	line ' ';
	&legend
	endcomp;
	run;
	ods html close;
	options missing='.'; /* restore default */
%mend corrmatx;


/* Macro for regression model */
%macro reg_model(ABC,DEF);
	proc reg data= &ABC;
	model Potential_Customer= &DEF / vif tol collin;
	run;
%mend reg_model;


/* Macro for Logistics model */
%macro log_model(ABC,DEF);
	ODS GRAPHICS ON;
	PROC LOGISTIC DATA=&ABC plots=(roc effect);
	MODEL Potential_Customer (event='1') = &DEF / ctable pprob=0.5 
	rsquare link=logit expb;
	RUN;
	ODS GRAPHICS OFF;
%mend log_model;


/* Macro for box plot */
%macro box_plot(ABC);
	%let DSName = &ABC;
	%let Stat = Median; /* or mean, stddev, qrange, skew, etc */
	/* standardize variables to [0,1] */
	proc stdize method=range data=&DSName out=MyData; run;
	 
	proc means data=MyData &Stat STACKODSOUTPUT; 
	ods output Summary=StatOut;
	run;
	
	/* put ordered variable names into macro variable */
	proc sql noprint;                              
	 select Variable into :varlist separated by ' '
	 from StatOut order by &Stat;
	quit;
	
	data Wide / view=Wide;     
	retain &varlist;           /* reorder vars by statistic */
	set MyData;
	obsNum = _N_;              /* add ID for subject (observation) */
	keep obsNum &varlist;
	run;
	 
	/* transpose from wide to long data format; VARNAME is a categorical var */
	proc transpose data=Wide name=VarName 
	               out=Long(rename=(Col1=_Value_) drop=_LABEL_);
	by obsNum;
	run;
	
	title "Box Plots of Standardized Variables, Ordered by &Stat";
	proc sgplot data=Long;
	   label _Value_ = "Standardized Value" VarName="Variable";
	   vbox _Value_ / category=VarName;
	   xaxis discreteorder=data display=(nolabel);        /* respect ordering */
	run;
%mend box_plot;