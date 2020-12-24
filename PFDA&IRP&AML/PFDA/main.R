library(ggplot2)
library(dplyr)

data("diamonds", package="ggplot2")
data("flights", package="nycflights13")

p1<-ggplot(diamonds, aes(carat)) +
  geom_histogram(col="white", fill="blue")

pd <- ggplot_build(p1)
hist_data=data.frame(xmin=pd$data[[1]]$xmin,xmax=pd$data[[1]]$xmax,y=pd$data[[1]]$y)

ggplot(flights, aes(x=dep_delay, y=arr_delay)) + 
  geom_point() + 
  geom_smooth()+
  labs(title="The co-variation between deparature and arrival delay", x="Deparature delay", y="Arrival delay")

ff=filter(diamonds, carat>3)
ff=filter(diamonds, cut=="Fair", color== "I")
ff=filter(flights, dep_delay>500)

cor(x=flights$dep_delay,y=flights$arr_delay, use= "complete.obs")


p2=ggplot(diamonds, aes(x = cut, y = color)) + 
  geom_count()
pd <- ggplot_build(p2)

v <- c(1,2,3,4,NA,5,5,8,NA,NA)
avg = mean(v, na.rm = TRUE)
v_new <- ifelse(is.na(v), avg, v)
v_new


# Data
sensorData=data.frame(minutes=c(1,  1,1, 3,4, 4, 4,4,5,5), 
                sensorReading=c(10,NA,NA,5,NA,11,10,8,7,NA))

# Extract the NA values then select minutes column then get the unique values
minutesContainNA=filter(sensorData, is.na(sensorReading)) %>% 
  select(minutes) %>% 
  unique()

# Create new column sensorReading_n
sensorData = mutate(sensorData, sensorReading_n=sensorReading)

for (i in minutesContainNA$minutes){
  # return non NA to calculate the mean
  fd= filter(sensorData, minutes==i, !is.na(sensorReading)) %>% 
    select(sensorReading)
    
  # calculate the mean
  avg = mean(fd$sensorReading, na.rm = TRUE)
  
  # Replace NA with the mean in the new column sensorReading_n
  sensorData = mutate(sensorData, 
                      sensorReading_n=
                        ifelse(is.na(sensorReading) & minutes==i, avg, sensorReading_n))
}
