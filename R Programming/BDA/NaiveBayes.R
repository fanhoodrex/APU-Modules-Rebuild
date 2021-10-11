#Libraries
install.packages("naivebayes", dependencies=TRUE, repos='http://cran.rstudio.com/')
library(naivebayes)
install.packages("e1071")
library(e1071)
install.packages("dplyr")
library(dplyr)
install.packages("ggplot2")
library(ggplot2)
install.packages("psych")
library(psych)

# Data
ndata <- read.csv(file.choose(), header = T)
str(ndata)

# CONVERTING numerical to factor
ndata$admit<-as.factor(ndata$admit)
str(ndata)
ndata$rank <- as.factor(ndata$rank)
str(ndata)

# Visualization
#pairs.panels(ndata [-1])
ndata %>%
         ggplot(aes(x=admit, y=gre, fill = admit)) +
         geom_boxplot() +
         ggtitle("Box Plot")

ndata %>% ggplot(aes(x=gpa, fill = admit)) +
         geom_density(alpha=0.8, color= 'black') +
         ggtitle("Density Plot")

# Data Partition(training & Test data)
set.seed(100)
ind <- sample(2, nrow(ndata), replace = T, prob = c(0.8, 0.2))
ind
training <- ndata[ind == 1,]
training
test <- ndata[ind == 2,]
test

# Naive Bayes Model
model <- naiveBayes(age ~ ., data = training, usekernel = T)
model1 <- naiveBayes(admit ~ rank, data = training, usekernel = T)

# model <- naiveBayes(admit ~ rank+gre, data = training, usekernel = T)
model
plot(model)
train %>%
         filter(admit == "1") %>%
         summarise(mean(gre), sd(gre))
# install.packages("Caret", repos="https://cran.rstudio")
# library(caret)
# plot(model)

# Predict
p1<-predict(model1,test)
p2 <- predict(model, test)

# Confusion Matrix - test data
conf_test<- table(p1, test$admit)
sum(diag(conf_test)) / sum(conf_test)
1 - sum(diag(conf_test)) / sum(conf_test)
plot(conf_test)
conf_test<- table(p2, test$admit)
sum(diag(conf_test)) / sum(conf_test)
1 - sum(diag(conf_test)) / sum(conf_test)
plot(conf_test)