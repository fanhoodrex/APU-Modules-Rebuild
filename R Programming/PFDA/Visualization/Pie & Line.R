#DATA VISUALIZATION

install.packages("ggplot2")
library(ggplot2)

#pie
a=c(10,20,30)
pie(a)

#with lables
a=c(10,20,30)
b=c("Apple","Banana","Orange")
pie(a,b)

#with radius
pie(a,b,radius=1)

#with title
pie(a,b,radius=1,main="FRUITS_LIST")

#with colour
pie(a,b,radius=1,main="SAMPLE_ONE",col=c("green","blue","red"))

#with direction
pie(a,b,radius=1,main="SAMPLE_ONE",col=c("green","blue","red"),clockwise = TRUE)

# syntax
#pie(values,lables,radius,title,colour,direction)

#pie3D
install.packages("plotrix")
library(plotrix)

pie3D(a)
pie3D(a,labels=b)# for assign lables
pie3D(a,labels=b,explode=1)
pie3D(a,labels=b,explode=0,main="SAMPLE_DATA")
#pie3D(values,label,explode,title)

#LINE GRAPH
x=c(25,38,20,10)
plot(x)

#assign which type
plot(x,type="p")

#assign labels
plot(x,type="o",xlab = "COUNTRY",ylab="TEMP")

#assign title
plot(x,type="o",xlab = "COUNTRY",ylab="TEMP",main="CLIMATE")

#assign colour
plot(x,type="o",xlab = "COUNTRY",ylab="TEMP",main="CLIMATE",col="red")

#assign more line
x=c(25,38,20,10)
y=c(22,19,34,12)
plot(x,type="o",xlab = "COUNTRY",col="red",ylab="TEMP",main="CLIMATE")
lines(y,type="o",xlab = "COUNTRY",col="blue",ylab="TEMP",main="CLIMATE")


#syntax
# plot(value,type,colour,xlabel,ylabel,title)

#sample

sample_data = read.csv("/Users/xiaofeng/Documents/PFDA Dataset/IRIS.csv",header=FALSE)
sample_data  

names(sample_data)=c("SEPAL_LENGTH","SEPEL_WIDTH","PETAL_LENGTH","PETAL_WIDTH"
                     ,"SPECIES")
sample_data
View(sample_data)

# Create a pie chart inorder to analyse the IRIS-FLOWER species count based on the dataset
iv=nrow(sample_data[sample_data$SPECIES=="Iris-versicolor",])
iv
ise=nrow(sample_data[sample_data$SPECIES=="Iris-setosa",])
ise
ivir=nrow(sample_data[sample_data$SPECIES=="Iris-virginica",])
ivir
a=c(iv,ise,ivir)
l=c("Iris-versicolor","Iris-setosa","Iris-virginica")
pie(a,l,radius=1,main="IRIS_FLOWER",col=c("green","blue","red"),clockwise = TRUE)

#LINE USING IRIS
plot(x=sample_data$PETAL_LENGTH,type="o")

plot(x=sample_data$PETAL_LENGTH,y=sample_data$PETAL_WIDTH,type="o")

#ggplot(data = <DATA>, mapping = aes(<MAPPINGS>)) +  <GEOM_FUNCTION>()

ggplot(sample_data, aes(x=PETAL_LENGTH, y=PETAL_WIDTH))

ggplot(sample_data, aes(x=PETAL_LENGTH, y=PETAL_WIDTH)) + geom_line()

ggplot(sample_data, aes(x=PETAL_LENGTH, y=PETAL_WIDTH)) + geom_point()

ggplot(sample_data, aes(x=PETAL_LENGTH, y=PETAL_WIDTH))+
  geom_point(aes(shape = factor(SPECIES), colour = factor(SPECIES)))

ggplot(sample_data, aes(x=PETAL_LENGTH, y=PETAL_WIDTH))+
  geom_point(aes(shape = factor(SPECIES), colour = factor(SPECIES)))+
  ggtitle (" PETAL_LENGTH Vs PETAL_WIDTH based on Species" )
  