df_csv = read.csv("4. Hourly weather data.csv",
                  header = TRUE) # load csv data into R
View(df_csv) # display the dateset
str(df_csv) # check the attributes' data types of the dataset
head(df_csv) # inspecrt the first six of the dataframe loaded 

# analyse the categorical data
summary(df_csv) # summary data on each attribute of dataset
tab_cnt <- table(df_csv$origin,df_csv$year) # assign the contingency table between origin and year fields to tab_cnt
print(tab_cnt) # inspect the contingency table
prop.table(tab_cnt)
ggplot(df_csv,aes(x=origin))+geom_bar() # simple barchart counting on origin field 

# 1.analyze the numerical variable data of temp (temperature) by three types of chart
ggplot(df_csv,aes(x = temp)) +
  geom_histogram() + # histogram plot 
  facet_wrap(~origin) # faceted by origin variable

ggplot(df_csv,aes(x = temp)) + 
  geom_density() + # Density plot
  facet_wrap(~origin) # faceted by origin variable

ggplot(df_csv,aes(x=1,y=temp)) + 
  geom_boxplot() + # Boxplot
  facet_wrap(~origin) # faceted by origin variable

# 2.analyze the numerical variable data of dewp (dewpoint) by three types of chart
ggplot(df_csv,aes(x = dewp)) +
  geom_histogram() + # histogram plot 
  facet_wrap(~origin) # faceted by origin variable

ggplot(df_csv,aes(x = dewp)) + 
  geom_density() + # Density plot
  facet_wrap(~origin) # faceted by origin variable

ggplot(df_csv,aes(y=dewp)) + 
  geom_boxplot() + # Boxplot
  facet_wrap(~origin) # faceted by origin variable

# 3.analyze the numerical variable data of humid (Relative humidity) by three types of chart
ggplot(df_csv,aes(x = humid)) +
  geom_histogram() + # histogram plot 
  facet_wrap(~origin) # faceted by origin variable

ggplot(df_csv,aes(x = humid)) + 
  geom_density() + # Density plot
  facet_wrap(~origin) # faceted by origin variable

ggplot(df_csv,aes(y=humid)) + 
  geom_boxplot() + # Boxplot
  facet_wrap(~origin) # faceted by origin variable

# 4.analyze the numerical variable data of wind_dir (Wind direction) by three types of chart
ggplot(df_csv,aes(x = wind_dir)) +
  geom_histogram() + # histogram plot 
  facet_wrap(~origin) # faceted by origin variable

ggplot(df_csv,aes(x = wind_dir)) + 
  geom_density() + # Density plot
  facet_wrap(~origin) # faceted by origin variable

ggplot(df_csv,aes(y= wind_dir)) + 
  geom_boxplot() + # Boxplot
  facet_wrap(~origin) # faceted by origin variable

# 5.analyze the numerical variable data of wind_speed (Wind speed) by three types of chart
ggplot(df_csv,aes(x = wind_speed)) +
  geom_histogram() + # histogram plot 
  facet_wrap(~origin) # faceted by origin variable

ggplot(df_csv,aes(x = wind_speed)) + 
  geom_density() + # Density plot
  facet_wrap(~origin) # faceted by origin variable

ggplot(df_csv,aes(y= wind_speed)) + 
  geom_boxplot() + # Boxplot
  facet_wrap(~origin) # faceted by origin variable