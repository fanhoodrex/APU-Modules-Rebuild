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

# analyse the numerical on single temp (temperature) variable
ggplot(df_csv,aes(x = temp)) +
  geom_histogram() + # histogram plot 
  facet_wrap(~origin) # faceted by origin variable

ggplot(df_csv,aes(x = temp)) + 
  geom_density() + # Density plot
  facet_wrap(~origin) # faceted by origin variable

ggplot(df_csv,aes(x=1,y=temp)) + 
  geom_boxplot() + # Boxplot
  facet_wrap(~origin) # faceted by origin variable
