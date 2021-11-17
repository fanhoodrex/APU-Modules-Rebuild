attrition_data = read.csv('employee_attrition.csv')

head(attrition_data)
str(attrition_data)

library(ggplot2)
ggplot(data = attrition_data[attrition_data$STATUS == 'TERMINATED',], aes(x = city_name,fill = gender_short)) +
  geom_bar() +
  theme(axis.text.x = element_text(angle = 45, hjust = 1)) +
  ggtitle("Figure 1 : Distribution of terminated employees across cities") +
  ylab("Count of employees") +
  xlab("City Name")

ggplot(data = attrition_data,aes(x=city_name)) +
  geom_bar() +
  theme(axis.text.x = element_text(angle = 45, hjust = 1)) +
  ggtitle("Figure 2 : Distribution of all employees across cities") +
  ylab("Count of employees") +
  xlab("City Name")

# Lists if any changes on ['city_name','department_name','job_title','BUSINESS_UNIT'] for all duplicated EmployeeIDs
newDataset = dataset[['EmployeeID', 'city_name', 'department_name', 'job_title', 'BUSINESS_UNIT']]
newDataset = newDataset[newDataset.duplicated('EmployeeID', keep=False)]
duplicateds = newDataset[newDataset.duplicated(keep='last')]

merged = pd.merge(newDataset,duplicateds, how='outer', indicator=True)
merged.loc[merged._merge == 'left_only', ['EmployeeID']]

ggplot(data = attrition_data[attrition_data$STATUS=='TERMINATED',],aes(x=department_name,fill=gender_short)) +
  geom_bar() +
  theme(axis.text.x = element_text(angle = 45, hjust = 1)) +
  ggtitle("Figure 1 : Distribution of terminated employees across departments") +
  ylab("Count of employees") +
  xlab("Department Name")

hr_active=hr.copy()
cond=hr_active['EmployeeID'].isin(hr_terminated['EmployeeID'])
hr_active.drop(hr_active[cond].index, inplace = True)
hr_active = hr_active.drop_duplicates(subset="EmployeeID", keep="last",inplace=False).reset_index()

# Checks Active and Terminated columns because we keep last ones
statusTerminatedCount = len(dataset[dataset.STATUS == "TERMINATED"])
statusActiveCount = len(dataset[dataset.STATUS == "ACTIVE"])

ggplot(empset)+geom_bar(aes(x=BUSINESS_UNIT, fill=STATUS))

TerminateData<- empset %>% filter(STATUS=="Employees")

ggplot(TerminateData)+geom_bar(aes(x=STATUS_YEAR, fill=termtype_desc))

ggplot(TerminateData)+geom_bar(aes(x=STATUS_YEAR, fill=termreason_desc))

ggplot(TerminateData)+geom_bar(aes(x=as.factor(department_name), fill=as.factor(termreason_desc)))+
  theme(axis.text.x = element_text(angle=90, hjust=1,vjust=0.5))

library(rattle)
library(magrittr)
library(randomForest)
crv$seed=42 

set.seed(crv$seed) 

empNum<-nrow(empset)

empTrain<-subset(empset,STATUS_YEAR<2015)
empTest<-subset(empset,STATUS_YEAR==2015)

MYinput= c("age", "length_of_service",    "gender_full", "STATUS_YEAR", "BUSINESS_UNIT")
MYnumeric= c("age", "length_of_service", "STATUS_YEAR")
MYcategoric = c("gender_full", "BUSINESS_UNIT")
MYtarget= "STATUS"
MYident = "EmployeeID"
MYTrainingData<-empTrain[c(MYinput, MYtarget)]
MYTestData<-empTest[c(MYinput, MYtarget)]


library(rpart)
myrpart<-rpart(STATUS~.,
               data=empTrain[,c(MYinput,MYtarget)],
               method="class",
               parms = list(split="information"),
               control=rpart.control(usesurrogate = 0, maxsurrogate = 0))
myrpart

sub_col = c('age'
            ,'length_of_service'
            ,'city_name'
            ,'department_name'
            ,'job_title'
            ,'store_name'
            ,'gender_full'
            ,'STATUS_YEAR'
            ,'BUSINESS_UNIT'
            ,'STATUS')

attr_data_sub = attrition_data[,sub_col]

library(caret)
## Loading required package: lattice
set.seed(123456)
attr_data_sub$STATUS01 = ifelse(attr_data_sub$STATUS=='ACTIVE',1,0)
partitionIndex = createDataPartition(attr_data_sub$STATUS01,p=0.8,list=FALSE)

attr_data_sub.train = attr_data_sub[partitionIndex,]
attr_data_sub.test = attr_data_sub[-partitionIndex,]
prop.table(table(attr_data_sub.train$STATUS01))
prop.table(table(attr_data_sub.train$STATUS01))

library('DMwR')
# Loading required package: methods
# Loading required package: grid
attr_data_sub.train$STATUS01 <- as.factor(attr_data_sub.train$STATUS01)
attr_data_sub.train <- SMOTE(STATUS01 ~ ., attr_data_sub.train, perc.over = 100, perc.under=200)
prop.table(table(attr_data_sub.train$STATUS01))

set.seed(123456)
full_fit = glm(STATUS01 ~ . -STATUS,family=binomial,data=attr_data_sub.train)
summary(full_fit)

set.seed(123456)
attr_data_sub.test$predict = predict(full_fit,newdata = attr_data_sub.test,type = "response")
attr_data_sub.test$predict_final = ifelse(attr_data_sub.test$predict>0.5,"ACTIVE","TERMINATED")

table(attr_data_sub.test$STATUS,attr_data_sub.test$predict_final)

library(Metrics)
set.seed(123456)
pred <- prediction(attr_data_sub.test$predict,attr_data_sub.test$STATUS01)
perf <- performance(pred,measure = "tpr",x.measure = "fpr") 
plot(perf) > auc(attr_data_sub.test$STATUS01,attr_data_sub.test$predict)