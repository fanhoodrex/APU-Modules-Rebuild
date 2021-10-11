avector<- vector()
class(avector)
avector

avector<- vector(mode = "integer",5)
class(avector)
avector

avector<- vector(mode = "logical",5)
class(avector)
avector 

avector<- vector(mode = "numeric",5)
class (avector)
avector

alist<- list(vector(mode = "logical",2), vector(mode = "numeric",5))
alist

y <- c(1.7, "a")
class(y)

y <- c(TRUE, 2)
class(y)

y <- c("a",TRUE)
class(y)

x <- 0:6
class(x)

x <-as.numeric(x)
class(x)

x <- c("a", "b", "c")
class(x)

m <- matrix(nrow = 2, ncol = 3)
class(m)
dim(m)

x<- 1:3
y<- 4:6
cbind(x,y)
rbind(x,y)

x <- factor(c("yes", "yes", "no", "yes", "no"))
class(x)

x
table(x)

X<-c(1,1.2,3,NA,40)
is.na(X)
sum(is.na(X))

X<- data.frame(foo=1:4, bar=c(T,T,F,F))
class(X)

dim(X)
attributes(X)

colnames(X)