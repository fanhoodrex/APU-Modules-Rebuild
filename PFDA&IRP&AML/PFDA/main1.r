df_csv = read.csv("4. Hourly weather data.csv",
                  header = TRUE) # load csv data into R

str(df_csv) # check the attributes' data types of the dataset
head(df_csv) # inspecrt the first six of the dataframe loaded 

# analyse the categorical data of origin
summary(df_csv) # summary data on each attribute of dataset
sapply(df_csv, function(x) sum(is.na(x)))# summary all the missing value for each column using the sapply function

options(scipen = 999, digits = 3) # Simplify display format
tab_cnt_year <- table(df_csv$origin,df_csv$year) # contingency table by origin and year fields
tab_cnt_month <- table(df_csv$origin,df_csv$month) # contingency table by origin and month fields
prop.table(tab_cnt_year) # inspect the tab_cnt_year in proportion
prop.table(tab_cnt_month) # inspect the tab_cnt_month in proportion 

library(ggplot2) # activate the ggplot2 package
ggplot(df_csv, aes(x=month,fill=origin)) + # plot the contingency table 
  geom_histogram() +
  facet_wrap(~origin)

# Data manipulation
# summarize all the missing value for each column using the sapply function
sapply(df_csv, function(x) sum(is.na(x)))

# Replacing the column by Zero for the all values in dewp Columns
df_csv[["dewp"]][is.na(df_csv[["dewp"]])] <- 0
head(df_csv$dewp)

# removing the outlier inside pressure column
outlier_norm <- function(x){
  qntile <- quantile(x, probs=c(.25, .75))
  caps <- quantile(x, probs=c(.05, .95))
  H <- 1.5 * IQR(x, na.rm = T)
  x[x < (qntile[1] - H)] <- caps[1]
  x[x > (qntile[2] + H)] <- caps[2]
  return(x)
}

# 1.analyze the numerical variable data of temp (temperature) by three types of chart
ggplot(df_csv,aes(x = temp)) +
  geom_histogram() + # histogram plot 
  facet_wrap(~origin)
ggplot(df_csv,aes(x = temp)) + 
  geom_density() + # Density plot
  facet_wrap(~origin) # faceted by origin variable
ggplot(df_csv,aes(x=1,y=temp)) + 
  geom_boxplot()  # Boxplot

# 2.analyze the numerical variable data of dewp (dewpoint) by three types of chart
ggplot(df_csv,aes(x = dewp)) +
  geom_histogram() + # histogram plot 
ggplot(df_csv,aes(x = dewp)) + 
  geom_density() + # Density plot
ggplot(df_csv,aes(y=dewp)) + 
  geom_boxplot() + # Boxplot

# 3.analyze the numerical variable data of humid (Relative humidity) by three types of chart
ggplot(df_csv,aes(x = humid)) +
  geom_histogram() + # histogram plot 
ggplot(df_csv,aes(x = humid)) + 
  geom_density() + # Density plot
ggplot(df_csv,aes(y=humid)) + 
  geom_boxplot() + # Boxplot
  facet_wrap(~origin) # faceted by origin variable

# 4.analyze the numerical variable data of wind_dir (Wind direction) by three types of chart
ggplot(df_csv,aes(x = wind_dir)) +
  geom_histogram() + # histogram plot
ggplot(df_csv,aes(x = wind_dir)) + 
  geom_density() + # Density plot
ggplot(df_csv,aes(y= wind_dir)) + 
  geom_boxplot() + # Boxplot

# 5.analyze the numerical variable data of wind_speed (Wind speed) by three types of chart
ggplot(df_csv,aes(x = wind_speed)) +
  geom_histogram() + # histogram plot 
ggplot(df_csv,aes(x = wind_speed)) + 
  geom_density() + # Density plot
ggplot(df_csv,aes(y= wind_speed)) + 
  geom_boxplot() + # Boxplot

# 6. Numerical data on wind_gust
ggplot(df_csv,aes(x = wind_gust)) +
  geom_histogram() + # histogram plot 
ggplot(df_csv,aes(x = wind_gust)) + 
  geom_density() + # Density plot
ggplot(df_csv,aes(y= wind_gust)) + 
  geom_boxplot() + # Boxplot

# 7. Numerical data on precip
ggplot(df_csv,aes(x = precip)) +
  geom_histogram() + # histogram plot 
ggplot(df_csv,aes(x = precip)) + 
  geom_density() + # Density plot
ggplot(df_csv,aes(y= precip)) + 
  geom_boxplot() + # Boxplot
  
# 8. Numerical data on pressure
ggplot(df_csv,aes(x = pressure)) +
  geom_histogram() # histogram plot 
ggplot(df_csv,aes(x = pressure)) + 
  geom_density() # Density plot
ggplot(df_csv,aes(y= pressure)) + 
  geom_boxplot() # Boxplot

# 9. Numerical data on visib
ggplot(df_csv,aes(x = visib)) +
  geom_histogram() # histogram plot 
ggplot(df_csv,aes(x = visib)) + 
  geom_density() # Density plot
ggplot(df_csv,aes(y= visib)) + 
  geom_boxplot() # Boxplot

# 10. Numerical data on time_hour
ggplot(df_csv,aes(x = time_hour)) +
  geom_histogram() # histogram plot 
ggplot(df_csv,aes(x = time_hour)) + 
  geom_density() # Density plot
ggplot(df_csv,aes(y= time_hour)) + 
  geom_boxplot() # Boxplot

# Visualizing bivariate relationships

# Scatter Plot of Dew Point against Temperature to show whether there is any relationship 
ggplot(data = df_csv, mapping = aes(x = temp, y = dewp, color = origin)) + 
  geom_point(alpha = 0.2) + stat_smooth(method = "lm") +
  labs(title = 'Scatter Plot of Dew Point against Temperature',x = 'Temperature ', y = 'Dew Point (F)')

ggplot(data = df_csv, mapping = aes(x = temp, y = pressure, color = origin, na.rm = TRUE)) + 
  geom_point(alpha = 0.2) + stat_smooth(method = "lm") +
  labs(title = 'Scatter Plot of Pressure against Temperature',x = 'Temperature ', y = 'Pressure (Milibars)')

ggplot(df_csv, aes(x=dewp,y=humid)) + # dewpoint and humidity
  geom_point(alpha = 0.2) +
  stat_smooth(method = "lm") +
  labs(title = 'Scatter Plot of Dew Point against Humidity',x = 'Temperature ', y = 'Dew Point (F)')

ggplot(data = df_csv, mapping = aes(x = humid, y = precip, color = origin)) + 
  geom_point(alpha = 0.2) + stat_smooth(method = "lm") + 
  labs(title = 'Scatter Plot between Precipitate and Humidity',x = 'Humid ', y = 'Precipitate (Inch)')

ggplot(df_csv,
       aes(x=wind_dir,y = wind_speed)) + # wind_direction and wind_speed
  geom_point()

ggplot(df_csv,
       aes(x=wind_dir,y = wind_gust)) + # wind_direction and wind_gust
  geom_point()

ggplot(df_csv,
       aes(x=wind_speed,y = wind_gust,na.rm(TRUE))) + # wind_speed and wind_gust
  geom_point(alpha = 0.2) + 
  stat_smooth(method = "lm") +
  labs(title = 'Scatter Plot of Wind Gust against Wind Speed',x = 'Wind Speed (MPH)', y = 'Wind Gust (MPH)')

ggplot(df_csv,
       aes(x=wind_dir,y = wind_speed)) + # precip and 
  geom_point()

#For this example,an analysis between Precipitate and visible using Box plot
ggplot(df_csv,
       mapping = aes(x = factor(visib), y = precip)) + 
  geom_boxplot() +
  labs(title = 'Boxplot of Precipitate against Visible',x = 'Visible (Miles)', y = 'Precipitate (Inch)')

# Extra feature 1
# an analysis in the distribution Temperature of data
ggplot(df_csv,aes(x = temp)) + 
  geom_histogram() +
  labs(title = 'Temperature histogram by month',x = 'Temperature (F)') +
  facet_wrap(~month) # faceted by 

# Extra feature 2
# an analysis in the distribution of Wind speed data 
ggplot(data = df_csv, mapping = aes(x = wind_speed, na.rm = TRUE)) + # remove the NA 
  geom_histogram() +
  labs(title = 'Histogram of Wind speed by origin',x = 'Wind speed (MPH)') +
  facet_wrap(~origin)

# Extra feature 3
# Analysis between pressure per month using Box plot
ggplot(data = df_csv, mapping = aes(x = factor(month), y = pressure, na.rm = TRUE)) + 
  geom_boxplot() +
  facet_wrap(~origin) # faceted by origin
  labs(title = 'BoxPlot of Pressure against Month',x = 'Month ', y = 'Pressure (Milibars)')

# Extra feature 4: 
# an analysis between Humid and visible using Box plot
ggplot(data = df_csv, mapping = aes(x = factor(visib), y = humid)) + 
  geom_boxplot() +
  facet_wrap(~origin) +
  labs(title = 'Boxplot of Humid against Visible',x = 'Visible (Miles)', y = 'Humid')

# Extra feature 5:
# an analysis between Precipitate and Month using box plot
ggplot(df_csv,mapping = aes(x = factor(month), y = precip)) + 
  geom_boxplot() +
  facet_wrap(~origin) +
  labs(title = 'Boxplot of Precipitate against Month',x = 'Month', y = 'Precipitate (Inch)')

# Extra feature 6
# an analysis between temp and month using Box plot
ggplot(data = df_csv, mapping = aes(x = factor(month), y = temp, color = origin)) + 
  geom_boxplot() +
  labs(title = 'Boxplot of Temperature against Month',x = 'Month', y = 'Temperature (F)')

# Extra Feature 7
# The Scatter Plot Matrix is plotted to get the general idea of the dataset
pairs(df_csv[,2:13],main = "Scatter Plot Matrix of Dataset")

# Extra Feature 8
# Polar Plot of Wind Direction to show the wind distribution in a year 
ggplot(data = df_csv) +
  geom_bar(mapping = aes(x = wind_dir, na.rm = TRUE)) +
  coord_polar() + # Polar bar plot fit the wind_direction field 
  labs(title = 'Polar Bar Plot of Wind Direction',x = 'Wind Direction')

# Extra Feature 9
# Polar Plot of Wind Direction to show the wind distribution in a year 
ggplot(data = df_csv) +
  geom_bar(mapping = aes(x = wind_dir, na.rm = TRUE)) +
  coord_polar() +
  labs(title = 'Polar Bar Plot of Wind Direction',x = 'Wind Direction ')