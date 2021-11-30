install.packages(c("ggplot2","tidyverse","caTools","dplyr","randomForest","caret","e1071","ROCR","neuralnet","nnet","magicfor","R6","corrplot"))

library(dplyr)
library(ggplot2)
library(tidyverse)
library(caTools)
library(randomForest)
library(caret)
library(e1071)
library(ROCR)
library(neuralnet)
library(nnet)
library(magicfor)            
library(R6)
library(readr)
library(corrplot)

# Data Exploration
str(heart)
summary(heart)

# FREQUENCY PLOTS

# Frequency plot of Age.
ggplot(heart, aes(age)) + geom_bar(fill = "green") 

# Frequency plot of Sex
ggplot(heart, aes(sex)) + geom_bar(fill = "red")

# Geom_bar of Age
ggplot(heart, aes(x=as.factor(age), fill=as.factor(target) )) +
  geom_bar( )
# Geom_bar of Sex 
ggplot(heart, aes(x=as.factor(sex), fill=as.factor(target) )) +
  geom_bar( )

#BOXPLOT

# Boxplot for one variable to see the outlier
ggplot(heart, mapping = aes(x = 1, y = trestbps, fill = trestbps)) + 
  geom_boxplot(outlier.colour = "red", outlier.shape = 5, outlier.size = 4)+
  labs(title="Outlier for trestpbs variable")

# Boxplot for two categorical variables to see the outliers and grouping them by sex.
box_plot <- ggplot(heart, aes(group= sex, x = chol, y = oldpeak))
box_plot +
  geom_boxplot(outlier.colour = "red", outlier.shape = 5, outlier.size = 4)+
  labs(title="Outlier for trestpbs variable")

# Removing the outliers for "chol" column
outlier_norm <- function(x){
  qntile <- quantile(x, probs=c(.25, .75))
  caps <- quantile(x, probs=c(.05, .95))
  H <- 1.5 * IQR(x, na.rm = T)
  x[x < (qntile[1] - H)] <- caps[1]
  x[x > (qntile[2] + H)] <- caps[2]
  return(x)
}
heart$chol=outlier_norm(heart$chol)
ggplot(heart, mapping = aes(x = 1, y = chol, fill = chol)) + 
  geom_boxplot(outlier.colour = "orange", outlier.shape = 8, outlier.size = 4)+
  labs(title="Removing the Outlier for chol variable")

# Removing the outliers for "trestbps" column
outlier_norm <- function(x){
  qntile <- quantile(x, probs=c(.25, .75))
  caps <- quantile(x, probs=c(.05, .95))
  H <- 1.5 * IQR(x, na.rm = T)
  x[x < (qntile[1] - H)] <- caps[1]
  x[x > (qntile[2] + H)] <- caps[2]
  return(x)
}
heart$trestbps=outlier_norm(heart$trestbps)
ggplot(heart, mapping = aes(x = 1, y = trestbps, fill = trestbps)) + 
  geom_boxplot(outlier.colour = "orange", outlier.shape = 8, outlier.size = 4)+
  labs(title="Removing the Outlier for trestbps variable")

# Removing the outliers for "oldpeak" column
outlier_norm <- function(x){
  qntile <- quantile(x, probs=c(.25, .75))
  caps <- quantile(x, probs=c(.05, .95))
  H <- 1.5 * IQR(x, na.rm = T)
  x[x < (qntile[1] - H)] <- caps[1]
  x[x > (qntile[2] + H)] <- caps[2]
  return(x)
}
heart$oldpeak=outlier_norm(heart$oldpeak)
ggplot(heart, mapping = aes(x = 1, y = oldpeak, fill = oldpeak)) + 
  geom_boxplot(outlier.colour = "orange", outlier.shape = 8, outlier.size = 4)+
  labs(title="Removing the Outlier for oldpeak variable")


# Removing the outliers for "ca" column
outlier_norm <- function(x){
  qntile <- quantile(x, probs=c(.25, .75))
  caps <- quantile(x, probs=c(.05, .95))
  H <- 1.5 * IQR(x, na.rm = T)
  x[x < (qntile[1] - H)] <- caps[1]
  x[x > (qntile[2] + H)] <- caps[2]
  return(x)
}
heart$ca=outlier_norm(heart$ca)
ggplot(heart, mapping = aes(x = 1, y = ca, fill = ca)) + 
  geom_boxplot(outlier.colour = "orange", outlier.shape = 8, outlier.size = 4)+
  labs(title="Removing the Outlier for ca variable")


# now we can check if the outliers are removed.
boxplot(heart$chol)
boxplot(heart$trestbps)
boxplot(heart$oldpeak)
boxplot(heart$ca)


# Random Forest Model Predictive:

heart$target = as.factor(heart$target)

# Splitting the data
set.seed(100)
split = sample.split(heart$target, SplitRatio = 0.7)
train = subset(heart, split==TRUE)
test = subset(heart, split==FALSE)
table(heart$target)

# Random Forest Model
set.seed(100)
rf= randomForest(target~., data=train,
                   ntree = 300,
                   mtry = 3,
                   importance = TRUE,
                   proximity = TRUE)
print(rf)
attributes(rf)

# Predictive  and confusion Matrix of the model % Train data:
train1 = predict(rf, train)
confusionMatrix(train1, train$target)

# Confusion matrix & test data:
test1 = predict(rf, test)
confusionMatrix(test1, test$target)

# Plot of the Error rate of Random Forest
plot(rf)


p = ncol(train) - 1
oob.error.class <- double(p) #initializing empty vector
set.seed(1)
for(m in 1:p) {
  fit <- randomForest(target ~ ., data=train, mtry=m, ntree=300)
  conf.mat <- fit$err.rate[300]
  oob.error.class[m] <- fit$err.rate[300, 'OOB']
}

print(rf)
matplot(1:p, oob.error.class, pch=19, col="red", type="b", ylab="Misclassification Error", xlab="mtry")+
  title("Graph of Misclassification rate ")


# Number of nodes for the trees
hist(treesize(rf),
     main = "Number of Nodes for the Trees",
     col = "blue")

varImpPlot(rf, sort = T, main = "Variable Importance")
importance(rf)
varUsed(rf)

# Running on Test Set


lastTest = predict(rf, newdata = test)
table(lastTest, test$target)
mean(lastTest == test$target)
table(lastTest, test$target)
mean(lastTest == test$target)

# Haven't Finish yet for this model
# NEURAL NETWORK Model:

# when using Neural Network,we must convert variables into binary  0 & 1  
# Min-Max Normalization
heart$age <- (heart$age - min(heart$age))/(max(heart$age) - min(heart$age))
heart$cp <- (heart$cp - min(heart$cp))/(max(heart$cp) - min(heart$cp))
heart$trestbps <- (heart$trestbps - min(heart$trestbps))/(max(heart$trestbps)-min(heart$trestbps))
heart$chol <- (heart$chol - min(heart$chol))/(max(heart$chol) - min(heart$chol))
heart$fbs <- (heart$fbs - min(heart$fbs))/(max(heart$fbs) - min(heart$fbs))
heart$restecg  <- (heart$restecg  - min(heart$restecg ))/(max(heart$restecg ) - min(heart$restecg))
heart$thalach <- (heart$thalach - min(heart$thalach))/(max(heart$thalach) - min(heart$thalach))
heart$oldpeak <- (heart$oldpeak - min(heart$oldpeak))/(max(heart$oldpeak ) - min(heart$oldpeak ))
heart$slope <- (heart$slope - min(heart$slope))/(max(heart$slope) - min(heart$slope))
heart$ca <- (heart$ca - min(heart$ca))/(max(heart$ca) - min(heart$ca))
heart$thal <- (heart$thal - min(heart$thal))/(max(heart$thal) - min(heart$thal))

# Partition Of the Data.
glimpse(heart)

set.seed(222)

training.indices <- sample(1:nrow(heart), 0.7 * nrow(heart))
training <- heart[training.indices, ]
testing  <- heart[-training.indices, ]

for (i in c(1:10)) 
{ 
  ni <- neuralnet(target~. ,
                  heart = training,
                  hidden = i,
                  err.fct = "ce",
                  linear.output = FALSE,
                  likelihood = TRUE,
                  threshold = 0.2)
  # Plot
  #plot(ni)
  
  # Results including BIC
  #print(ni$result.matrix)
  
  # The 5th element of result.matrix vector is bic
  bic <- ni$result.matrix[5]
  
  # Prediction
  #outputi <- compute(ni, training[,-1])
  #head(outputi$net.result)
  # compare results with dataset
  #head(training[1,])
  
  # Confusion Matrix & Misclassification Error - training data
  train_outputi <- compute(ni, training[,-1])
  train_pi <- train_outputi$net.result
  train_predi <- ifelse(train_pi>0.5, 1, 0)
  train_tabi <- table(train_predi, training$target)
  
  #Accuracy
  #print(paste("accuracy train_ni:", train_accuracyi <- sum(diag(train_tabi))/sum(train_tabi)))
  train_accuracyi <- sum(diag(train_tabi))/sum(train_tabi)
  
  #Misclassification Error
  #1-sum(diag(train_tabi))/sum(train_tabi)
  
  # Confusion Matrix & Misclassification Error - testing data
  test_outputi <- compute(ni, testing[,-1])
  test_pi <- test_outputi$net.result
  test_predi <- ifelse(test_pi>0.5, 1, 0)
  test_tabi <- table(test_predi, testing$target)
  test_tabi
  
  #Accuracy
  print(paste("accuracy test_ni:", test_accuracyi <- sum(diag(test_tabi))/sum(test_tabi)))
}