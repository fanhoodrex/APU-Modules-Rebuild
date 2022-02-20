#LIU HAOYAN
#TP058826

#Data Import
data <- read.csv(file.choose())
attach(data)
sapply(data, function(x) sum(is.na(x)))

library(visdat)
vis_miss(data,sort_miss=T,warn_large_data=F)

str(data) #View data types
summary(data) #Summary

#Data Processing
library(Hmisc)
#The missing values are treated as random values
data$salary <- impute(data$salary,"random") 

#Data Exploration and Analysis
#Question 1: What is the relationship between the ssc_p and the hsc_p??
plot(data$ssc_p,data$hsc_p) #Scatter plot
cor(data$ssc_p,data$hsc_p) #Calculate the correlation coefficient

#Question 2: What is the age and sex ratio in the data set?
library(ggplot2)
ggplot(data,aes(age,fill=gender))+ 
  geom_histogram(binwidth=0.1) #Bar Graph of Student Age and sex

#Question 3: What is the relationship between age and degree?
ggplot(data,aes(age,degree_t))+
  geom_point(aes(color=degree_t)) #Scatter plot

#Question 4: Is the age and gender pay gap large?
library(ggpubr)
a=data$salary/10000
ggboxplot(data,x="age",y="a",
          color="gender",add="jitter")

#Question 5: What is the share of Mbas?
ggplot(data,aes(mba_p,transmission_type="Manual"))+
  geom_histogram(col="red",fill="pink")

#Question 6: What About Fathers Working and mothers working?
#Analysis6.1
ggplot(data,aes(Mjob))+
  geom_bar(col="red",fill="blue")

#Analysis6.2
ggplot(data,aes(Fjob))+
  geom_bar(col="red",fill="yellow")

#Question 7: How does a parent??s job affect an mba_p?
#Analysis7.1
ggplot(data,aes(mba_p,colour=Fjob))+
  geom_freqpoly()

#Analysis7.2
ggplot(data,aes(mba_p,colour=Mjob))+
  geom_freqpoly()

#Question8: Is the education of students greatly influenced by their families?
#Analysis8.1: The relationship between family educational support 
# and Higher Secondary Education percentage
ggplot(data,aes(factor(hsc_p),fill=famsup))+
  geom_bar(width=0.8,color="white")+
  xlab("Higher Secondary Education percentage")+ylab("Percentage")+
  ggtitle("Higher Secondary Education percentage and family support")

#Analysis8.2: The influence of Mother's Education on Secondary Education percentage
ggplot(data, aes(x=Medu,y=ssc_p))+
  geom_point(pch=17, color="blue", size=2) +
  geom_smooth(method = "lm", color="red", linetype=2) +
  labs(title="MEDU-SSC_P", x="mother's education", y="Secondary Education percentage")

#Analysis8.3: The influence of Father's Education on Secondary Education percentage
ggplot(data, aes(x=Fedu,y=ssc_p))+
  geom_point(pch=17, color="blue", size=2) +
  geom_smooth(method = "lm", color="Green", linetype=2) +
  labs(title="FEDU-SSC_P", x="father's education", y="Secondary Education percentage")

#Question9: What are the factors related to salary?
install.packages("ggthemes")
library("ggthemes")

#Analysis9.1: The relationship between undergraduate degree field and salary
ggplot(data, aes(x=salary, fill=degree_t)) +
  geom_density(alpha=.3)

ggplot(data, aes(x=mba_p, y=salary, color=specialisation)) +
  scale_color_manual(values=c("orange", "navy")) +
  geom_point(size=2)

#Analysis9.2: Salary by degree type and gender
mytheme <- theme(plot.title=element_text(face="bold.italic",
                                         size="14", color="brown"),
                 axis.title=element_text(face="bold.italic",
                                         size=10, color="brown"),
                 axis.text=element_text(face="bold", size=9,
                                        color="darkblue"),
                 panel.background=element_rect(fill="white",
                                               color="darkblue"),
                 panel.grid.major.y=element_line(color="grey",
                                                 linetype=1),
                 panel.grid.minor.y=element_line(color="grey",
                                                 linetype=2),
                 panel.grid.minor.x=element_blank(),
                 legend.position="top")

ggplot(data, aes(x=degree_t, y=salary, fill=gender)) +
  geom_boxplot() +
  labs(title="Salary by degree_t and gender", x="degree_t", y="Salary") +
  mytheme

#Question10: Is the placement of students related to Employability test percentage?
ggplot(data, aes(x = status, y= etest_p, fill = etest_p)) +
  geom_point(stat = "identity", aes(col = factor(etest_p)))+
  geom_line() +
  theme_classic() +
  labs(title = "The relationship between status and etest_p",
       x = "status",
       y = "etest_p")+
  theme(axis.title = element_text(size = rel(2),hjust = 0.5,
                                  color = "blue", lineheight = 1))