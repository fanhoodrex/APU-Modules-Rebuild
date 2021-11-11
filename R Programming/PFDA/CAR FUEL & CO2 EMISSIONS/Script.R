# packages import
install.packages("UsingR")
install.packages("ggplot2")
install.packages("dplyr")
install.packages("readr")
install.packages("purrr")
install.packages("tibble")
install.packages("stringr")
install.packages("forcats")
install.packages("naniar")
install.packages("VIM")
install.packages("hrbrthemes")
install.packages("gganimate")

# Libraries
library(UsingR)
library(ggplot2)
library(gganimate)
library(dplyr)
library(tidyr)
library(readr)
library(purrr)
library(tibble)
library(stringr)
library(forcats)
library(naniar)
library(VIM)
library(hrbrthemes)

data = read.csv("dataset.csv",
                  header = TRUE) # load csv data into R

# to check the summary of the data
summary(data)

#creating a copy of the dataset
# let drop some variables as 80% of their columns are null
# like "tax_band","date_of_change", "thc_nox_emissions", "particulates_emissions","fuel_cost_12000_miles","fuel_cost_6000_miles","standard_12_months", "standard_6_months" ,"first_year_12_months" and "first_year_6_months" 

#function to drop a particular column
assi_copy <- data[ , ! names(data) %in% c("tax_band","date_of_change", "thc_nox_emissions", "particulates_emissions",
                                          "fuel_cost_12000_miles","fuel_cost_6000_miles","standard_12_months",
                                          "standard_6_months" ,"first_year_12_months", "first_year_6_months" )]

# we have removed 10 variable and to view a new table where the columns have been removed
view(assi_copy)

# Get the sum for all the missing value for each column using the sapply function
sapply(assi_copy, function(x) sum(is.na(x)))

pct_miss(assi_copy) # percentage of missing value in the data.
n_miss(assi_copy) # number of missing values in the data

# Showing the missing value percentage of each column
vis_miss(assi_copy, sort_miss = TRUE, warn_large_data = FALSE) 

# visualizing all missing value
gg_miss_var(assi_copy)
res<-summary(aggr(assi_copy, sortVar=TRUE))$combinations
matrixplot(assi_copy, sortby = 2)

# Some visualization showing in red the missing value for 2 variables using scatter plot
marginplot(assi_copy[,c("combined_metric","combined_imperial")])

# finds the missing values for each column and replace them
sapply(assi_copy, function(x) sum(is.na(x)))

# this function above will helps us to find the highest frequency of any string variable therefore see the highest frequency for "transmission_type"

# Create the function
getmode <- function(v){
  uniqv <- unique(v)
  uniqv[which.max(tabulate(match(v, uniqv)))]
}

# finding the mode of transmission_type
result <- getmode(assi_copy$transmission_type)
print(result)

# Since "Manual is the most we replace all the NA by "Manual"
assi_copy$transmission_type[is.na(assi_copy$transmission_type)]<-"Manual"
view(assi_copy$transmission_type)

# replacing "Engine Capacity missing values" as it is continuous variable we will use the mean to replace the missing values
assi_copy$engine_capacity[is.na(assi_copy$engine_capacity)]<-mean(assi_copy$engine_capacity,na.rm=TRUE)

# replacing missing values for "extra_urban_metric" variables
assi_copy <- assi_copy %>%
  mutate(extra_urban_metric = replace(extra_urban_metric,
                                is.na(extra_urban_metric),
                                mean(extra_urban_metric, na.rm = T)))

# replacing missing values for "combined_metric" variables
assi_copy <- assi_copy %>%
  mutate(combined_metric = replace(combined_metric,
                                      is.na(combined_metric),
                                      mean(combined_metric, na.rm = T)))
# replacing missing values for "urban_imperial" variables
assi_copy <- assi_copy %>%
  mutate(urban_imperial = replace(urban_imperial,
                                   is.na(urban_imperial),
                                   mean(urban_imperial, na.rm = T)))
# replacing missing values for "combined_imperial" variables
assi_copy <- assi_copy %>%
  mutate(combined_imperial = replace(combined_imperial,
                                  is.na(combined_imperial),
                                  mean(combined_imperial, na.rm = T)))
# replacing missing values for "noise_level" variables
assi_copy <- assi_copy %>%
  mutate(noise_level = replace(noise_level,
                                     is.na(noise_level),
                                     mean(noise_level, na.rm = T)))
# replacing missing values for "thc_emissions" variables
assi_copy <- assi_copy %>%
  mutate(thc_emissions = replace(thc_emissions,
                               is.na(thc_emissions),
                               mean(thc_emissions, na.rm = T)))
# replacing missing values for "co_emissions" variables
assi_copy <- assi_copy %>%
  mutate(co_emissions = replace(co_emissions,
                                 is.na(co_emissions),
                                 mean(co_emissions, na.rm = T)))
# replacing missing values for "nox_emissions" variables
assi_copy <- assi_copy %>%
  mutate(nox_emissions = replace(nox_emissions,
                                is.na(nox_emissions),
                                mean(nox_emissions, na.rm = T)))
# replacing missing values for "extra_urban_imperial" variables
assi_copy <- assi_copy %>%
  mutate(extra_urban_imperial = replace(extra_urban_imperial,
                                 is.na(extra_urban_imperial),
                                 mean(extra_urban_imperial, na.rm = T)))
# replacing missing values for "urban_metric" variables
assi_copy <- assi_copy %>%
  mutate(urban_metric = replace(urban_metric,
                                        is.na(urban_metric),
                                        mean(urban_metric, na.rm = T)))

# now the function below will show us that we no longer have any missing values for our dataset
sapply(assi_copy, function(x) sum(is.na(x)))

# You can use this code below to see the outlier for each just change the name of the y and run the code

# Outlier Detection
# boxplot to detect extreme value into the combined_metric column
ggplot(assi_copy) +
  aes(x = "", y = combined_metric) +
  geom_boxplot(fill = "#0c4c8a") +
  theme_minimal()

# checking the outliers for combined_metric
ggplot(assi_copy, mapping = aes(x = 1, y = extra_urban_imperial, fill = extra_urban_imperial)) + 
  geom_boxplot(outlier.colour = "red", outlier.shape = 5, outlier.size = 4)+
  labs(title="Outlier for extra_urban_imperial variable")

# REmoving Outliers 
# the code also below can work for each column
# you just need to change y value to a particular column to remove the outlier for that column

# removing the outlier inside extra_urban_imperial column
outlier_norm <- function(x){
  qntile <- quantile(x, probs=c(.25, .75))
  caps <- quantile(x, probs=c(.05, .95))
  H <- 1.5 * IQR(x, na.rm = T)
  x[x < (qntile[1] - H)] <- caps[1]
  x[x > (qntile[2] + H)] <- caps[2]
  return(x)
}

assi_copy$extra_urban_imperial=outlier_norm(assi_copy$year)

ggplot(assi_copy, mapping = aes(x = 1, y = extra_urban_imperial, fill = extra_urban_imperial)) + 
  geom_boxplot(outlier.colour = "orange", outlier.shape = 8, outlier.size = 4)+
  labs(title="Removing the Outlier for extra_urban_imperial variable")

# here the code below will visualize again the boxplot to show there is no existing outlier
# just also need to change the y value to see for othet columns after running the previous code which is outlier removing

ggplot(assi_copy, mapping = aes(x = 1, y = extra_urban_imperial, fill = extra_urban_imperial)) + 
  geom_boxplot(outlier.colour = "red", outlier.shape = 5, outlier.size = 4)+
  labs(title="Outlier for extra_urban_imperial variable")

# now let visualize to understand more our data to see the hidden patterns

# Histogram for co_emissions of each year
theme_set(theme_classic())+ filter(assi_copy$year, assi_copy)
g <- ggplot(assi_copy, aes(year)) + scale_fill_brewer(palette = "Spectral")
g + geom_histogram(aes(fill=year), 
                   binwidth = .1, 
                   col="blue", 
                   size=.1) +  # change binwidth
  labs(title="Histogram with Auto Binning", 
       subtitle="Histogram for co_emissions ")  

g + geom_histogram(aes(fill=year), 
                   bins=5, 
                   col="red", 
                   size=.1) +   # change number of bins
  labs(title="Histogram for co_emissions") 


# BoxPlot between noise_level and fuel_type grouping by transmission_type
theme_set(theme_classic())
g <- ggplot(assi_copy, aes(x=noise_level, fuel_type,grouping(transmission_type)))
g + geom_boxplot(varwidth=T, fill="plum") + 
  labs(y="fuel_type")+ 
  labs(title="Boxplots noise_level and fuel_type grouping by transmission_type")


# the visualization between fuel type and co_emissions to see more which type of fuel polluate the most
assi_copy %>%
  mutate(name = fct_reorder(fuel_type, desc(co_emissions))) %>%
  ggplot( aes(x=fuel_type, y=co_emissions)) +
  geom_bar(stat="identity", fill="#f68060", alpha=.6, width=.4) +
  coord_flip() +
  xlab("") +
  theme_bw()

# Barchart of the transmission_type
ggplot(data = assi_copy,aes(x= transmission_type,fill = transmission_type))+ 
  geom_bar()+ 
  labs(title = "Barchart of the transmission_type")

# histogram  of co2
ggplot(assi_copy, aes(x = co2, y = year)) + 
  hist(x=co2 ) +
  labs(title="histogram  of co2h",
       x="co2", y="year")

# point between fuel_type and transmission_type
Mitty <- ggplot(assi_copy, aes(x = fuel_type, y = transmission_type ))
Mitty + geom_point(aes(color = transmission_type))+ 
  labs(title = "The geom_point between fuel_type and transmission_type")

# geom_point between year and co2
ggplot(assi_copy, aes(x = year, y = co2)) +
  geom_point(aes(color = year, size = co2))+
  labs(title = "Graph of geom_point between year and co2 ")

# Histogram of the engine_capacity using color
ggplot(data=assi_copy, aes(x=engine_capacity, 
                                     transmission_type = "Manual"
                                     )) + 
  geom_histogram(col="red", fill="blue")+
  labs(title = "Histogram of the engine_capacity ")

# the frequency polygon between noise_level and fuel_type
ggplot(assi_copy, aes(noise_level, colour = fuel_type)) +
  geom_freqpoly()+ 
  labs(title = "Frequency polygone between noise_level and fuel_type")

# faceting by co2 and co_emissions with color
ggplot(assi_copy, aes(x=co2, y=co_emissions, color=year)) + 
  geom_point() + 
  facet_wrap(~year) + labs(title = "facetting  by co2 and co_emissions")

# Court frequency
ggplot(assi_copy, aes(x = fuel_type, fill = fuel_type)) + 
  geom_bar(col = "green", fill = "blue")+ 
  ylab("Count") + xlab("precip")+
  labs(title = "Court frequency of the fuel_type")

# Scatterplot 
# The co-variation between engine_capacity and co2
ggplot(assi_copy, aes(x=engine_capacity, y=co2)) + 
  geom_point(col = "orange", fill= "blue") + 
  geom_smooth()+
  labs(title="The co-variation between engine_capacity and co2", x=" engine_capacity", y="co2 ")

# faceting of the co_emissions 
ggplot(assi_copy, aes(x=co_emissions)) + 
  geom_histogram(col = "white", fill = "blue") +
  facet_wrap(~co_emissions)+
  labs(title = "The facet_wrap of the co_emissions")

# box plot between transmission_type and co2
ggplot(assi_copy, aes(group=year ,x = transmission_type, y =co2 )) + 
  geom_boxplot() +
  labs(title="The co-variation between transmission_type and co2", 
       x="transmission_type", y="co2")


# times series for co2 emission for each year
co2_total = ts(assi_copy$co_emissions, start = c(2000,1), end = c(2013,6),  frequency = 10)
plot(co2_total, xlab = "Year", ylab = "co_emissions", main = "Time Series plot CO2 Emissions")

co2_fit = stl(window(co2_total, start = c(2000,1), end = c(2013,7)), t.window = 15, s.window = "periodic", robust = TRUE)
plot(co2_fit)