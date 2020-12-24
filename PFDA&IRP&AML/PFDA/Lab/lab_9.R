data(flights, package = "nycflights13")
View(flights)
library(dplyr)
library(ggplot2)

#Question 1
flights %>%
filter(arr_delay >= 3)
------------------------
#Question 2
flights%>%
filter(arr_delay > 3 & dep_delay == 0)

-----------------------
#Question 3# unclear
flights%>%
filter(arr_delay >= 1 & dep_delay >= 1 & flight > 50)

-----------------------------
#question 4# 1 zero is fine
flights %>%
filter(dep_time >= 0 & dep_time <= 0500)
-----------------------------
#Question 5
flights %>% filter(dep_delay == max(flights$dep_delay, na.rm = TRUE))
---------------------------
#Question 6
flights %>% filter(air_time == max(flights$air_time, na.rm = TRUE))
---------------------------
#Question 7
flights %>% filter(air_time == min(flights$air_time, na.rm = TRUE))
---------------------------
#Question 8
flights %>% select(flight, origin, dest)
---------------------------
#Question 9 
flights %>% filter(month == 6, year == 2013) %>%
select(flight, origin, dest)  
---------------------------  
#Question 10
flights %>% mutate(min_departure = dep_time%/%100*60 + dep_time%%100) %>%
select(dep_time,dept_time_min)
---------------------------  
#Question 11
flights %>% filter(flight==88) %>%
mutate(arr_delay=arr_delay+46)
---------------------------
#Question 12
flights %>% group_by(carrier) %>% 
summarise(flight=n(), mean_time_spent=mean(air_time, na.rm = TRUE), farthest_travel =max(air_time,na.rm = TRUE), shortest_travel =min(air_time,na.rm = T) ) %>%
arrange(desc(flight))
---------------------------
#Question 13
flights %>%  filter(month %in%(6:9)) %>%
group_by(carrier) %>% 
summarise(flight=n(), mean_time_spent=mean(air_time, na.rm = TRUE), farthest_travel =max(air_time,na.rm = TRUE), shortest_travel =min(air_time,na.rm = T) ) %>%
arrange(desc(flight))
---------------------------
#Question 14
flights %>%  filter(carrier >=5) %>%
group_by(dest) %>%
summarise(count = n())
---------------------------
#Question 15
flights %>% group_by(carrier) %>% # pipeline
summarise(avg_delay=mean(dep_delay, na.rm = T)) %>%
filter(avg_delay == min(avg_delay))  
  
---------------------------  
  

