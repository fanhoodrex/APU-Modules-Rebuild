# package installations are only needed the first time you use it
install.packages(c("UsingR","gridExtra","magrittr"))

library(MASS)
library(tidyverse)
library(caret)
library(MLmetrics)
library(hydroGOF)
library(nnet)
library(randomForest)
library(Matrix)
library(glmnet)
library(UsingR)
library(glmnet)
library(dplyr)
library(magrittr) # needs to be run every time you start R and want to use %>%
library(dplyr)
library(tidyverse)
library(mice)
library(caret)
library(ggcorrplot)
library(ggrepel)
library(gridExtra)
library(glmnet)
library(xgboost)

# Readilibrary(glmnet)ng data
# cars_data <- read.csv("ThreeCars2017.csv", TRUE, ",")
class(cars_data)
head(cars_data)
#summary stats
summary(cars_data)

#missing values
sapply(cars_data, function(x) sum(is.na(x)))

#preprocess age

#glimpse of data
glimpse(cars_data)

# checking the outlier for price
ggplot(cars_data, mapping = aes(x = 1, y = Price, fill = Price)) + 
  geom_boxplot(outlier.colour = "red", outlier.shape = 5, outlier.size = 4)+
  labs(title="Outlier for Age variable")

#glimpse into the data.
glimpse(cars_data)

# Drop the columns of the dataframe

select (cars_data,-c(X.2,X.1 ))
md.pattern(cars_data, rotate.names=FALSE)


#EXPLORATION
#price
cars_data %>% ggplot()+geom_histogram(aes(Price, ..density..), bins=50)+geom_density(aes(Price))

#age
cars_data %>% ggplot()+geom_histogram(aes(Age, ..density..), bins=50)+geom_density(aes(Age))

#mileage
cars_data %>% ggplot()+geom_histogram(aes(Mileage , ..density..), bins=50)+geom_density(aes(Mileage ))

#price and age
cars_data %>% ggplot(aes(Age, Price))+geom_boxplot(aes(group=Age))+geom_jitter(alpha=0.1)+geom_smooth(method="loess")+scale_y_log10()

str_split(cars_data$CarType, " ", simplify=TRUE) %>% subset(select=1) %>% unique() -> car_makes
car_makes[car_makes=="Toyota"] <- "Toyota Maxima"
car_makes[car_makes=="Mazda"] <- "Mazada6 Maxima"
car_makes[car_makes=="Honda"] <- "Honda Accord"
car_makes_regex <- paste(car_makes, collapse="|")
str_extract(cars_data$CarType, car_makes_regex) -> make
cars_data %>% mutate(Make = str_to_title(make)) -> cars_data

grid.arrange(

  ggplot(cars_data, aes(reorder(CarType, Price, median), Price))+geom_boxplot()+geom_jitter(alpha=0.1)+geom_hline(aes(yintercept=median(Price)))+scale_y_log10()+coord_flip()+xlab("CarType ordered by median Price"),
  ggplot(cars_data, aes(reorder(CarType, Price, median)))+geom_bar(stat="count")+theme(axis.title.y=element_blank(), axis.text.y=element_blank(), axis.ticks.y=element_blank())+coord_flip(),
  ncol=3, nrow=1,
  layout_matrix=t(c(1,1,2)))
  
#All correlation
cars_data %>% select(CarType, Price, Age, Mileage, Model) %>% cor() %>% ggcorrplot(lab=TRUE)

#age
ggplot(data=cars_data, aes(x=Age, 
                                     origin = "LGK", 
                                     day = 20)) + 
  geom_histogram(col="red", fill="blue")+
  labs(title = "Histogram of the Age of used car  ")

#price
ggplot(data=cars_data, aes(x=Price, 
                           origin = "LGK", 
                           day = 20)) + 
  geom_histogram(col="red", fill="green")+
  labs(title = "Histogram of the Age of used car  ")

# Barchart of the cartype
ggplot(data = cars_data,aes(x= CarType ,fill = CarType))+ 
  geom_bar()+ 
  labs(title = "Barchart of the CarType")


ggplot(data = cars_data, aes(x = Mileage, y = CarType)) +
  geom_point() +
  geom_smooth(method='lm') +
  xlab('Mileage') +
  ylab('Age') +
  ggtitle('Mileage vs. Age: Entire Sample')

str_split(cars_data$CarType, " ", simplify=TRUE) %>% subset(select=1) %>% unique() -> car_makes
car_makes[car_makes=="Toyota"] <- "Toyota Maxima"
car_makes[car_makes=="Mazda"] <- "Mazada6 Maxima"
car_makes[car_makes=="Honda"] <- "Honda Accord"
car_makes_regex <- paste(car_makes, collapse="|")
str_extract(cars_data$CarType, car_makes_regex) -> make
cars_data %>% mutate(Make = str_to_title(make)) -> cars_data

#new price
cars_data %>% pull(New_Price) %>% str_split(" ", simplify=TRUE) %>% subset(select=2) %>% table()

cars_data %>% pull(new_mileage) %>% str_split(" ", simplify=TRUE) -> new_price_preprocess
new_mileage <- as.numeric(new_mileage_preprocess[,1])
new_mileage_unit <- new_mileage_preprocess[,2]

new_mileage[new_mileage=="Km/hr"] <- 
  new_mileage[new_mileage_unit=="Km/hr"]*
  1000

cars_data %>% mutate(new_mileage = new_mileage) -> data
rm(new_mileage_preprocess, new_mileage, new_mileage)

# Replacing the column by Zero for the all values in Age Columns
cars_data[["Age"]][is.na(cars_data[["Age"]])] <- 0
head(cars_data$Age)

#price bs km
ggplot(data = cars_data(cars, 
                     !is.na(kilometer)),
       aes(x = kilometer, y = log_price)) +
  geom_point(colour = 'lightskyblue3', shape = '.', alpha = .25, 
             position = 'jitter') +
  scale_x_continuous(breaks = c(0, as.numeric(levels(cars$km_cat)))) +
  geom_smooth()

ggplot(data = cars_data(cars, !is.na(km_cat)),
       aes(x = km_cat, y = log_price)) +
  geom_boxplot(colour = 'deepskyblue4', fill = 'deepskyblue1') +
  geom_point(aes(x = km_cat, y = log_price), stat = 'summary', fun.y = mean,
             shape = 18, 
             size = 4, colour = 'brown')