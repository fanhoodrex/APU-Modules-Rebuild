#Read data file
mydata <- read.csv(file.choose())
head(mydata)
str(mydata)

mydata$NSP <- as.factor(mydata$NSP)
str(mydata)

# feature selection
X < -mydata[,c(1:3)]# x<-mydata[,c(1,4,7,9)]
X
Y <- mydata$NSP
Y

# Partition data into training and TEST/validation datasets
set.seed(100)

# Sample.split(dataset,training set ratio)
pred <- sample(2, nrow(mydata), replace = TRUE, prob = c(0.7,0.3))
pred
train <- mydata[pred == 1,] # dataset_name[row,column]
test <- mydata[pred == 2,] # dataset_name[row_id==2,(all column)]

# Decision tree with party (decision trees)
install.packages('party')
library(party)

# ctree(Y~X,dataset,controls=ctree_control(mincriterion & minsplit))
mytree1 <- ctree(NSP ~ LB + AC + FM, data = train, controls = ctree_control(mincriterion = 0.9, minsplit = 50))
print(mytree)
plot(mytree)

mytree2 <- ctree(NSP ~ ASTV + MSTV, data = train, controls = ctree_control(mincriterion = 0.9, minsplit = 50))
plot(mytree1)
predict(mytree,test,type="prob") # Prediction

# Misclassification error with test set
testmisclas <- predict(mytree,newdata=test) # predict(model_variable,testset)
misclassification <- table(testmisclas,test$NSP)
print(misclassification)
plot(misclassification)
# Accuracy calculation
Accuracy <- sum(diag(misclassification))/sum(misclassification)
Accuracy
Error<-1-Accuracy
Error