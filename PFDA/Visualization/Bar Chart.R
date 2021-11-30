#BAR CHART
library(ggplot2)

data <- data.frame( name=c("A","B","C","D","E") ,  value=c(3,12,5,18,45))

# Barplot
ggplot(data, aes(x=name, y=value)) + geom_bar(stat = "identity")

#width of bars
ggplot(data, aes(x=name, y=value)) + geom_bar(stat = "identity",width=0.1)

#with colour
ggplot(data, aes(x=name, y=value)) + geom_bar(stat = "identity",color="blue")

#fill the bar
ggplot(data, aes(x=name, y=value)) + geom_bar(stat = "identity",color="blue",fill="red")

#assign label
ggplot(data, aes(x=name, y=value)) + geom_bar(stat = "identity",color="blue",fill="red")+
  geom_text(aes(label=value))

sample_data = read.csv("D:\\College\\PFDA\\IRIS.csv",header=FALSE)
sample_data  

names(sample_data)=c("SEPAL_LENGTH","SEPEL_WIDTH","PETAL_LENGTH","PETAL_WIDTH"
                     ,"SPECIES")

#BARPLOT WITH DATASET
ggplot(data=sample_data, aes(x=SEPEL_WIDTH, y=PETAL_WIDTH)) +geom_bar(stat="identity")

# width of bars
ggplot(data=sample_data, aes(x=SEPEL_WIDTH, y=PETAL_WIDTH)) +geom_bar(stat="identity",width=0.1)

#with colour
ggplot(data=sample_data, aes(x=SEPEL_WIDTH, y=PETAL_WIDTH)) +geom_bar(stat="identity",color="blue")


#assign labels
ggplot(data=sample_data, aes(x=SEPEL_WIDTH, y=PETAL_WIDTH)) +geom_bar(stat="identity",color="blue",fill="white")+
  geom_text(aes(label=PETAL_WIDTH))

#HISTOGRAM

#histogram
ggplot(sample_data, aes(x=PETAL_WIDTH)) + geom_histogram()

#width
ggplot(sample_data, aes(x=PETAL_WIDTH)) + geom_histogram(binwidth=0.1)

#change colour
ggplot(sample_data, aes(x=PETAL_WIDTH)) + geom_histogram(colour="orange")

#fill
ggplot(sample_data, aes(x=PETAL_WIDTH)) + 
  geom_histogram(colour="orange",fill="red")


ggplot(sample_data, aes(x=PETAL_WIDTH)) + 
  geom_histogram(colour="orange",aes(fill=..count..))+
  scale_fill_gradient("Count", low="green", high="red")

#SCATTERPLOT(show strength and type of relationship)
ggplot(sample_data, aes(x=SEPAL_LENGTH, y=PETAL_WIDTH)) + geom_point()

#with colour
ggplot(sample_data, aes(x=SEPAL_LENGTH, y=PETAL_WIDTH)) + 
  geom_point(aes(color=PETAL_WIDTH))

#seperate colour
ggplot(sample_data, aes(x=SEPAL_LENGTH, y=PETAL_WIDTH)) + 
  geom_point(aes(color=PETAL_WIDTH))+
  facet_wrap(~PETAL_WIDTH)

#BOXPLOT(Centre range and symmetry value)
ggplot(sample_data, aes(y=PETAL_WIDTH, x=SPECIES)) + geom_boxplot()

ggplot(sample_data, aes(y=PETAL_WIDTH, x=SPECIES,color=SPECIES)) + 
  geom_boxplot()
