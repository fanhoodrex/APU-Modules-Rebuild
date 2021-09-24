%contents_of(dap.train_original);

%freq_of(dap.train_original);

/* Continuous variables exploration*/
proc means data=dap.train_original n std mean median mode min max ;
run;

/* Catagorical variables exploration*/
proc gchart data= dap.train_original;
hbar Status_Cust Status_Latest_Ad Cust_Prop Gender/ discrete 
type=percent subgroup= Potential_Customer;
run;

/* Continuous variables exploration BOX PLOT */
%box_plot(dap.train_original);
     

/*Change attribute type from CHAR to NUM */									/* version 1 */
%char_num(dap.train_original);
%contents_of(dap.train_original_v1);


/* Convert Qualitative to Quantitative */
%quali_quanti(dap.train_original_v1);


/* Drop CHAR attributes */
%drop_char(dap.train_original_v1);
%contents_of(dap.train_original_v1);


/* CHECK MISSING VALUES */
%miss_check(dap.train_original_v1);

proc univariate data=dap.train_original_v1;
var Cust_Last_Purchase
Pur_3_years_Avg_Indirect
Age
Gender;
run;

proc freq data=dap.train_original_v1;
tables Gender;
run;



/* Create Indicator Variable */
%indicator(dap.train_original_v1);
%contents_of(dap.train_original_v1);

/* Missing Value Percentage */
proc freq data=DAP.TRAIN_ORIGINAL_V1;
	format Cust_Last_Purchase Pur_3_years_Avg_Indirect Age Gender
		_nmissprint.;
	tables Cust_Last_Purchase Pur_3_years_Avg_Indirect Age Gender / missing;
run;

/* --------------------------------------------------------------------------------------- */

/* Mean Imputation */

/* Missing value imputation by Mean for continuous */
proc stdize data=DAP.TRAIN_ORIGINAL_V1 reponly 
missing=mean out=DAP.TRAIN_ORIGINAL_V2;									/* version 2 */
var Cust_Last_Purchase Pur_3_years_Avg_Indirect Age;
run;

/* Missing value imputation for catagorical */
data DAP.TRAIN_ORIGINAL_V2; 
set DAP.TRAIN_ORIGINAL_V2; 
if missing(Gender) 
	then if rand("uniform") < 0.6 then Gender = 0;		
else Gender =1;
run;

%miss_check(dap.train_original_v2);

%contents_of(dap.train_original_v2);

/* All independent variables MACRO VARIABLE */
%let IV1 = Cust_Last_Purchase--Status_Cust;			

/* Logistics Regression Model */
%log_model(dap.train_original_v2,&IV1);

/* --------------------------------------------------------------------------------- */


/* Multiple Imputataion */

/* Miss pattern */
proc mi data=dap.train_original_v1 nimpute=0 ;
var &IV1;
ods select misspattern;
run;

proc mi data=dap.train_original_v1 nimpute=10
		out=dap.train_original_v4 seed=54321;								/* version 4 */
var &IV1;
run;


%contents_of(dap.train_original_v4);
%miss_check(dap.train_original_v4);

proc logistic data = dap.train_original_v4 ;
model Potential_Customer = &IV1 ;
by _imputation_;
ods output ParameterEstimates=dap.train_original_v5;						/* version 5 */
run;
quit;

%miss_check(dap.train_original_v5);


proc mianalyze parms = dap.train_original_v5;
modeleffects Intercept Cust_Last_Purchase Pur_3_years Pur_5_years 
 Pur_3_years_Indirect Pur_5_years_Indirect Pur_latest Pur_3_years_Avg 
 Pur_5_years_Avg InAct_Last InAct_First Ad_Res_1_year 
 Ad_Res_3_Year Ad_Res_5_Year Ad_Res_Ind_1_Year Ad_Res_Ind_3_Year Ad_Res_Ind_5_Year 
 Status_Latest_Ad Age Cust_Ann_Income Cust_Prop Gender Status_Cust;
run;


/* Logistics Regression Model */
%log_model(dap.train_original_v4,&IV1);


/* --------------------------------------------------------------------------------------- */

/* Pairwise */

PROC CORR DATA=dap.train_original_v1 COV OUTP=dap.train_original_v6;		/* version 6 */
VAR Potential_Customer &IV1;
RUN;

%let IV2 = Pur_3_years--Status_Cust;

/* Logistics Regression Model */
%log_model(dap.train_original_v1,&IV2);

/* --------------------------------------------------------------------------------------- */

/* Listwise */

PROC LOGISTIC DATA=dap.train_original_v1 plots=(roc effect);
CLASS Status_Cust Cust_Prop Gender/PARAM=REF;
MODEL Potential_Customer (event='1') = Pur_3_years Pur_5_years 
 Pur_3_years_Indirect Pur_5_years_Indirect Pur_latest Pur_3_years_Avg 
 Pur_5_years_Avg InAct_Last InAct_First Ad_Res_1_year 
 Ad_Res_3_Year Ad_Res_5_Year Ad_Res_Ind_1_Year Ad_Res_Ind_3_Year Ad_Res_Ind_5_Year 
 Status_Latest_Ad Age Cust_Ann_Income Cust_Prop Gender Status_Cust/ ctable rsquare;
RUN;

/* --------------------------------------------------------------------------------------- */

/* --------------------------------------------------------------------------------------- */

/* Check Multi-collinearity */
proc corr data=dap.train_original_v2 pearson nosimple noprob;
run;

%corrmatx(libnamex=DAP,
 dsname=train_original_v2,
 vars=Potential_Customer Cust_Last_Purchase Pur_3_years Pur_5_years 
 Pur_3_years_Indirect Pur_5_years_Indirect Pur_latest Pur_3_years_Avg 
 Pur_5_years_Avg Pur_3_years_Avg_Indirect InAct_Last InAct_First Ad_Res_1_year 
 Ad_Res_3_Year Ad_Res_5_Year Ad_Res_Ind_1_Year Ad_Res_Ind_3_Year Ad_Res_Ind_5_Year 
 Status_Latest_Ad Age Cust_Ann_Income Cust_Prop Gender Status_Cust,
 savpath=/home/usmanash930/DAP);
 

/* Removing multicolinearity by variables VIF and model R^2 */
%reg_model(dap.train_original_v2,&IV1);

/* Higest VIF for Ad_Res_5_Year */
/* Variation high for Ad_Res_Ind_5_Year than Ad_Res_5_Year */
/* Comapre R^2 value */
%reg_model(dap.train_original_v2,Ad_Res_5_Year);				/* R^2 = 0.0080 */
%reg_model(dap.train_original_v2,Ad_Res_Ind_5_Year);			/* R^2 = 0.0062 */

/* Ad_Res_Ind_5_Year will not be in model because R^2 value is less */

%let step2 = Cust_Last_Purchase--Ad_Res_Ind_3_Year Status_Latest_Ad--Status_Cust;
%reg_model(dap.train_original_v2,&step2);

/* Ad_Res_5_Year will not be in model because highest VIF and Variation */

%let step3 = Cust_Last_Purchase--Ad_Res_3_Year Ad_Res_Ind_1_Year Ad_Res_Ind_3_Year 
	Status_Latest_Ad--Status_Cust;
%reg_model(dap.train_original_v2,&step3);

/* Pur_5_years_Indirect will not be in model because highest VIF and Variation */

%let step4 = Cust_Last_Purchase--Pur_3_years_Indirect Pur_latest--Ad_Res_3_Year 
	Ad_Res_Ind_1_Year Ad_Res_Ind_3_Year Status_Latest_Ad--Status_Cust;
%reg_model(dap.train_original_v2,&step4);

/* Dataset after removing multicollinearity */
Data dap.train_original_v3;													/* version 3 */
set dap.train_original_v2 (Keep= Potential_Customer &step4);
run;
%contents_of(dap.train_original_v3);

/* Logistics Regression Model */
ODS GRAPHICS ON;
PROC LOGISTIC DATA=dap.train_original_v3 outmodel=Mean_multi plots=(roc effect);
MODEL Potential_Customer (event='1') = Cust_Last_Purchase--Status_Cust / ctable pprob=0.5 
rsquare link=logit expb;
RUN;
ODS GRAPHICS OFF;

/* --------------------------------------------------------------------------------------- */

/* --------------------------------------------------------------------------------------- */

/* Factor Analysis */

proc factor DATA = dap.train_original_v2 scree;
	var &IV1;
run;

proc factor DATA = dap.train_original_v2 nfactors=5 
		rotate=varimax out=dap.train_original_v7;						/* version 7 */
	var &IV1;
run;

/* Logistics Regression Model */
ODS GRAPHICS ON;
PROC LOGISTIC DATA=dap.train_original_v7 outmodel=Mean_fact plots=(roc effect);
MODEL Potential_Customer (event='1') = Factor1 Factor2 Factor3 Factor4 Factor5/ 
ctable pprob=0.5 rsquare link=logit expb;
RUN;
ODS GRAPHICS OFF;


/* --------------------------------------------------------------------------------------- */

/* --------------------------------------------------------------------------------------- */