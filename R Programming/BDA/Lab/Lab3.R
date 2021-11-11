# Lab 3
# Missing data
ls()

dataset1<-data.frame(ID=c(100,101,102,103,104),
                     Name=c("MAY","YUVANJI","SHYU","MOHAMMAD","TAN"),
                     Age=c(25,26,26,28,29),
                     Gender=c("F","F","M","M","F"),
                     Income=c(18000,NA,7500,6800,7300))
dataset1

#Checking for missing data
is.na.data.frame(dataset1)

#sum(is.na.data.frame(dataset1))
is.na(dataset1$Income)

#Taking care of missing data

#replace with mean
dataset1$Income = ifelse(is.na(dataset1$Income),
                         ave(dataset1$Income, FUN = function(x) mean(x, na.rm = TRUE)),
                         dataset1$Income)
dataset1

# replace with median
dataset1$Income = ifelse(is.na(dataset1$Income),
                         median(dataset1$Income, FUN = function(x) mean(x, na.rm = TRUE)),
                         dataset1$Income)

# replace with mode