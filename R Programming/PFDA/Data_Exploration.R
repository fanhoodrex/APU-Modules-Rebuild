#DATA EXPLORATION

#package installation and loading for visualization purpose
install.packages("ggplot2")
library(ggplot2)

#--------------------------------------------
#read_file
sample_data = read.csv("C:\\Users\\minnu.helen\\Desktop\\R\\IRIS.csv",header=FALSE)
sample_data

#assigning headers
names(sample_data)=c("SEPAL_LENGTH","SEPEL_WIDTH","PETAL_LENGTH","PETAL_WIDTH"
                     ,"SPECIES")
sample_data

#different viewing methods
# for first 6 lines
head(sample_data) 
head(sample_data,10) 

#for last 6 lines
tail(sample_data) 
tail(sample_data,3) 

#view all data 
sample_data
View(sample_data) 

#view only title\heading
names(sample_data) 

#how data stored
class(sample_data) 

#no:of column
length(sample_data) 

ncol(sample_data) #no: of column

nrow(sample_data) #no: of rows


#Categorize the Species
iris_Species = factor(sample_data$SPECIES) 
iris_Species

sample_data$SEPEL_WIDTH
max(sample_data$SEPEL_WIDTH)
min(sample_data$SEPEL_WIDTH)

max(sample_data$SEPAL_LENGTH)  # finding highest sepel_length value
min(sample_data$PETAL_WIDTH) # finding lowest petal_width value

sample_data[2,3]  # 2nd row and 3rd column value
sample_data[142,]   # complete 142nd row

summary(sample_data$SEPAL_LENGTH)

#Get all "Iris-versicolor"
sample_data[sample_data$SPECIES=="Iris-versicolor",]

# Get first 5 rows of each subset
subset(sample_data, SPECIES == "Iris-virginica")[1:5,]

sample_data[sample_data$SEPEL_WIDTH>4,]

nrow(sample_data[sample_data$SEPEL_WIDTH>4,])

sample_data[(sample_data$SEPEL_WIDTH>4) & (sample_data$PETAL_WIDTH>0.3),]

#read excel file
library(readxl)
excel1<-read_excel('C:\\Users\\minnu.helen\\Desktop\\1.xlsx',sheet=1)
excel1

#read database file

library(RSQLite)
Db<-download.file("http://www.jaredlander.com/data/diamonds.db",
                  destfile = "C:\\Users\\minnu.helen\\Desktop\\diamonds.db", mode='wb')
drv <- dbDriver('SQLite')
con <- dbConnect(drv, "C:\\Users\\minnu.helen\\Desktop\\diamonds.db")

dbListTables(con)

dbListFields(con, name='diamonds')   

diamondsTable <- dbGetQuery(con,"SELECT * FROM diamonds",stringsAsFactors=FALSE)
diamondsTable