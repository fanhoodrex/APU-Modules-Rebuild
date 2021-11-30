# the code down will install the all packages 
# and the librabry in R
install.packages("UsingR")
library(UsingR)

# Import dataset and summarize the data
Hourly_weather_data = read.csv('Hourly_weather_data.csv')
summary(Hourly_weather_data)

# Get the sum for all the missing value for each column using the sapply function
sapply(Hourly_weather_data, function(x) sum(is.na(x)))

# replacing the missing value by the mean for pressure column
Hourly_weather_data$wind_gust = ifelse(is.na(Hourly_weather_data$wind_gust),
                                       ave(Hourly_weather_data$wind_gust,
                                           FUN = function(x) 
                                             mean(x, na.rm = 'TRUE')),
                                       Hourly_weather_data$wind_gust)

# Replacing the column by Zero for the all values in dewp Columns
Hourly_weather_data[["dewp"]][is.na(Hourly_weather_data[["dewp"]])] <- 0
head(Hourly_weather_data$dewp)

# checking the outlier for pressure
ggplot(Hourly_weather_data, mapping = aes(x = 1, y = wind_speed, fill = wind_speed)) + 
  geom_boxplot(outlier.colour = "red", outlier.shape = 5, outlier.size = 4)+
  labs(title="Outlier for Pressure variable")

# removing the outlier inside pressure column
outlier_norm <- function(x){
  qntile <- quantile(x, probs=c(.25, .75))
  caps <- quantile(x, probs=c(.05, .95))
  H <- 1.5 * IQR(x, na.rm = T)
  x[x < (qntile[1] - H)] <- caps[1]
  x[x > (qntile[2] + H)] <- caps[2]
  return(x)
}

Hourly_weather_data$wind_speed=outlier_norm(Hourly_weather_data$day)
ggplot(Hourly_weather_data, mapping = aes(x = 1, y = wind_speed, fill = wind_speed)) + 
  geom_boxplot(outlier.colour = "orange", outlier.shape = 8, outlier.size = 4)+
  labs(title="Removing the Outlier for Pressure variable")

# Lolipop chart between day and wind_speed
ggplot(Hourly_weather_data, aes(wind_speed, day, color = "red")) +
  geom_segment(aes(x = 1, y = day, xend = wind_speed, yend = day), color = "grey50") +
  geom_point()+ labs(title = "Lolipop chart between day and wind_speed")

# Histogram for wind_gust
theme_set(theme_classic())+ filter(Hourly_weather_data, month = 3, day = 10)
g <- ggplot(Hourly_weather_data, aes(wind_gust)) + scale_fill_brewer(palette = "Spectral")
g + geom_histogram(aes(fill=wind_gust), 
                   binwidth = .1, 
                   col="orange", 
                   size=.1) +  # change binwidth
  labs(title="Histogram with Auto Binning",
       subtitle="Histogram for wind_gust ")  

g + geom_histogram(aes(fill=wind_gust), 
                   bins=5, 
                   col="red", 
                   size=.1) +   # change number of bins
  labs(title="Histogram for wind_gust") 

# BoxPlot between day and wind_dir grouping by month.
theme_set(theme_classic())
g <- ggplot(Hourly_weather_data, aes(x=day, wind_dir,grouping(month)))
g + geom_boxplot(varwidth=T, fill="plum") + 
  labs(y="wind_dir")+ 
  labs(title="Boxplots day and wind_dir grouping them by month")

# creating new column to get good information about the temperature
Hourly_weather_data$temp_status <-
  ifelse(Hourly_weather_data$temp >= 0 & Hourly_weather_data$temp <= 20, 'low',
         ifelse(Hourly_weather_data$temp >=20 & Hourly_weather_data$temp <=30, 'medium',
                ifelse(Hourly_weather_data$temp >=30, 'High', ' High')))

# Barchart of the temp_status
ggplot(data = Hourly_weather_data,aes(x= temp_status,fill = temp_status))+ 
  geom_bar()+ 
  labs(title = "Barchart of the temp_status")

# count plot between day and month
ggplot(Hourly_weather_data, aes(x = day, y = month)) + 
  geom_count() +
  labs(title="The co-variation between day and month",
       x="day", y="month")

# Line between hour and wind_speed
Mitty <- ggplot(Hourly_weather_data, aes(x = wind_speed, y = hour ))
Mitty + geom_line(aes(color = hour))+ 
  labs(title = "The geom_line between hour and wind_speed")

# geom_point between hour and temp_status
ggplot(Hourly_weather_data, aes(x = hour, y = temp_status)) +
  geom_point(aes(color = temp_status, size = temp_status))+
  labs(title = "Graph of geom_point between hour and temp_status ")

# Histogram of the wind_gust using color
ggplot(data=Hourly_weather_data, aes(x=wind_gust, 
                                     origin = "LGK", 
                                     day = 20)) + 
  geom_histogram(col="red", fill="green")+
  labs(title = "Histogram of the wind_gust ")

# the frequency polygone between wind_speed and precipitation
ggplot(Hourly_weather_data, aes(precip, colour = wind_speed)) +
  geom_freqpoly()+ 
  labs(title = "Frequency polygone between wind_speed and precipitation")

# facetting  by visib and temperature with color
ggplot(Hourly_weather_data, aes(x=visib, y=temp, color=hour)) + 
  geom_point() + 
  facet_wrap(~hour) + labs(title = "facetting  by visib and temperature")

# Court frequency
ggplot(Hourly_weather_data, aes(x = precip, fill = precip)) + 
  geom_bar(col = "green", fill = "blue")+ 
  ylab("Count") + xlab("precip")+
  labs(title = "Court frequency of the precipitation")

# Scatterplot 
#The co-variation between hour and visibility
ggplot(Hourly_weather_data, aes(x=hour, y=visib)) + 
  geom_point(col = "green", fill= "blue") + 
  geom_smooth()+
  labs(title="The co-variation between hour and visibility", x=" hour", y="visibility ")

# facetting of the humidity for the all days
ggplot(Hourly_weather_data, aes(x=humid)) + 
  geom_histogram(col = "white", fill = "blue") +
  facet_wrap(~day)+
  labs(title = "The facet_wrap of the humidity")

# box plot between wind_speed and visib
ggplot(Hourly_weather_data, aes(group=month ,x = visib, y = wind_speed)) + 
  geom_boxplot() +
  labs(title="The co-variation between visib and  wind_speed", 
       x="visib", y="wind_speed")