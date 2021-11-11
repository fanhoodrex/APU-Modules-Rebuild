Needed <- c("tm", "SnowballCC", "RColorBrewer", "ggplot2", 
            "wordcloud", "biclust","cluster", "igraph", "fpc")
install.packages(Needed, dependencies = TRUE)
install.packages("Rcampdf", repos = "http://datacube.wu.ac.at/", type = "source")

cname <- file.path("D:", "texts")   
cname   
dir(cname)
library(tm)
## Loading required package: NLP
docs <- VCorpus(DirSource(cname))   
summary(docs) 
#details of documents
inspect(docs[5])
inspect(docs[3])
#Preprocessing
docs <- tm_map(docs,removePunctuation) 
for (j in seq(docs)) {
  docs[[j]] <- gsub("/", " ", docs[[j]])
  docs[[j]] <- gsub("@", " ", docs[[j]])
  docs[[j]] <- gsub("\\|", " ", docs[[j]])
  docs[[j]] <- gsub("\u2028", " ", docs[[j]])  # This is an ascii character that did not translate, so it had to be removed.
}
#Removing numbers:
docs <- tm_map(docs, removeNumbers)
#Converting to lowercase:
docs <- tm_map(docs, tolower)
#docs<-tm_map(docs,toupper)
docs <- tm_map(docs, PlainTextDocument)
DocsCopy <- docs
#Removing "stopwords" (common words) that usually have no analytic value.
docs <- tm_map(docs, removeWords, stopwords("english"))   
docs <- tm_map(docs, PlainTextDocument)
#Removing particular words
docs <- tm_map(docs, removeWords, c("syllogism", "tautology")) 
#Combining words that should stay together
for (j in seq(docs))
{
  docs[[j]] <- gsub("fake news", "fake_news", docs[[j]])
  docs[[j]] <- gsub("inner city", "inner-city", docs[[j]])
  docs[[j]] <- gsub("politically correct", "politically_correct", docs[[j]])
}
docs <- tm_map(docs, PlainTextDocument)
#Removing common word endings (e.g., "ing", "es", "s")
docs_st <- tm_map(docs, stemDocument)   
docs_st <- tm_map(docs_st, PlainTextDocument)
writeLines(as.character(docs_st[1]))
#add common endings to improve intrepretability
docs_stc <- tm_map(docs_st, stemCompletion, dictionary = DocsCopy, lazy=TRUE)
docs_stc <- tm_map(docs_stc, PlainTextDocument)
writeLines(as.character(docs_stc[1]))
#Stripping unnecesary whitespace from your documents
docs <- tm_map(docs, stripWhitespace)
#preprocessed documents as text documents
docs <- tm_map(docs, PlainTextDocument)
#create a document term matrix
dtm <- DocumentTermMatrix(docs)   
dtm   
#Transpose
tdm <- TermDocumentMatrix(docs)   
tdm  
#Explore your data
freq <- colSums(as.matrix(dtm))   
length(freq)
ord <- order(freq)
#Matrix to excel
m <- as.matrix(dtm)   
dim(m) 
write.csv(m, file="D:texts/DocumentTermMatrix.csv")   
#  Start by removing sparse terms(Infrequently used words)   
dtms <- removeSparseTerms(dtm, 0.2) # This makes a matrix that is 20% empty space, maximum.   
dtms
#most and least frequently occurring words
freq <- colSums(as.matrix(dtm))
head(table(freq), 20)
#most frequently used terms, we can use the 'tail()' function.
tail(table(freq), 20) 
#For a less
freq <- colSums(as.matrix(dtms))   
freq  
#Frequent list
freq <- sort(colSums(as.matrix(dtm)), decreasing=TRUE)   
head(freq, 14)   
#An alternate view of term frequency
findFreqTerms(dtm, lowfreq=50)
#another way
wf <- data.frame(word=names(freq), freq=freq)   
head(wf)
#Plot words that appear at least 50 times.
library(ggplot2)
p <- ggplot(subset(wf, freq>50), aes(x = reorder(word, -freq), y = freq)) +
  geom_bar(stat = "identity") + 
  theme(axis.text.x=element_text(angle=45, hjust=1))
p 
#Relationships Between Terms
findAssocs(dtm, c("country" , "american"), corlimit=0.85)
#Word Clouds!
## Loading required package: RColorBrewer
install.packages("RColorBrewer")
library(RColorBrewer)
install.packages("wordcloud")
library(wordcloud)
set.seed(142)   
wordcloud(names(freq), freq, min.freq=25)  
#Plot the 100 most frequently used words.
set.seed(142)   
wordcloud(names(freq), freq, max.words=100)   
#Add some color and plot words occurring at least 20 times.
set.seed(142)   
wordcloud(names(freq), freq, min.freq=20, scale=c(5, .1), colors=brewer.pal(6, "Dark2"))  
#Clustering by Term Similarity
dtmss <- removeSparseTerms(dtm, 0.15) # This makes a matrix that is only 15% empty space, maximum.   
dtmss
#k-clustering
library(fpc)   
library(cluster)
d <- dist(t(dtmss), method="euclidian")   
kfit <- kmeans(d, 2)   
clusplot(as.matrix(d), kfit$cluster, color=T, shade=T, labels=2, lines=0)  

