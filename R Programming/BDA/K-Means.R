# Importing the dataset
dataset = read.csv(file.choose())

#Feature Selection
fs = dataset[4:5] # select the 4st, 5st column

#Pre-processing
na=sum(is.na(fs))

#Data Partition
#install.packages('caTools')
library(caTools)
set.seed(123)

partition = sample.split(fs,SplitRatio = 0.7)
partition

training_data = fs[partition == TRUE,]
training_data
test_data = fs[partition == FALSE,]
test_data

# Using the elbow method to find the optimal number of clusters
wcss = vector()
for (i in 1:10) {
        wcss[i] = sum(kmeans(fs, i)$withinss)
}

wcss_tot = vector()
for (i in 1:10) {
        wcss_tot[i] = kmeans(fs, i)$tot.withinss
}

# plot(x axis value=no of cluster,y axis value=wcss,type of the graph,title of the graph,x axis label,y axis label)
plot(1:10,
     wcss,
     type = 'b',
     main = paste('The Elbow Method'),
     xlab = 'Number of clusters',
     ylab = 'WCSS')

# Fitting K-Means to the dataset
set.seed(29)
kmeans = kmeans(x = fs, centers = 5) # why use
y_kmeans = kmeans$cluster

# Visualising the clusters
#install.packages("cluster")
library(cluster)
clusplot(fs,
         y_kmeans,
         lines = 0,
         shade = TRUE,
         color = TRUE,
         labels = 2,
         plotchar = FALSE,
         span = TRUE,
         main = paste('Clusters of customers'),
         xlab = 'Annual Income',
         ylab = 'Spending Score')