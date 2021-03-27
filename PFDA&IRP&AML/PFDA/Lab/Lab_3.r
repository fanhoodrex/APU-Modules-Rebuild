# - - - - - - - - - -  Quick Review: Data Types - - - - - - - - - - - -
# Numeric: 100 vs 100L
x=100
class(x)
is.numeric(x)
y=as.interger(100)
class(y)
# Character: "John"
name="he"
name
# Date: Date vs POSIXct
data=as.Date("1980-1-1")
dataTime=as.POSIXct("2021-3-26 15:29:00")

# Logical: TRUE, T, 1
x>100 #== #>= #<=


# Vector: c("Ali", "Abu")
names=c("xiao","feng")
vector=1:10

# Factor: level: "Female" "Male"
gender=c("Female","Male","Female","Female","Male")
fgender=factor(gender)
fgender

# - - - - - - - - - - - - Matrix/Matrices - - - - - - - - - - - -

# ~~~~~~~~~~~~~~~~~~~~~~ Question 1 ~~~~~~~~~~~~~~~~~~~~~~
# Write an R program to create a blank matrix with matrix().
# ====================== Answer ==========================
m=matrix()
m
# ~~~~~~~~~~~~~~~~~~~~~~ Question 2 ~~~~~~~~~~~~~~~~~~~~~~
# Write an R program to create a matrix taking a given vector of numbers as input.
# Then, display the matrix.
# ====================== Answer ==========================
m1=matrix(1:10)  
m1
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
#       [,1]
# [1,]    1
# [2,]    2
# [3,]    3
# [4,]    4
# [5,]    5
# [6,]    6
# [7,]    7
# [8,]    8
# [9,]    9
# [10,]   10

m1=matrix(1:8, 2,4)     m1=matrix(data=1:8 , nrow=2,ncol=4)
m1
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
#      [,1] [,2] [,3] [,4]
# [1,]    1    3    5    7
# [2,]    2    4    6    8
m1=matrix(1:8 , 2,4 ,TRUE)  # TURE 按行row填充
m1
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
#      [,1] [,2] [,3] [,4]
# [1,]    1    2    3    4
# [2,]    5    6    7    8


# ~~~~~~~~~~~~~~~~~~~~~~ Question 3 ~~~~~~~~~~~~~~~~~~~~~~
# Write an R program to create a matrix taking a given vector of numbers as input.
#     v1 = 1:10
# Then, give names for its columns and rows. Finally, display the matrix.
# matrix(data = NA, nrow = 1, ncol = 1, byrow = FALSE, dimnames = NULL)
# ====================== Answer ==========================
v1=1:10
m1=matrix(v1,2,5)
colnames(m1)=c("c1","c2","c3","c4","c5")
rownames(m1)=c("r1","r2")
m1
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# c1 c2 c3 c4 c5
# r1  1  3  5  7  9
# r2  2  4  6  8 10


# ~~~~~~~~~~~~~~~~~~~~~~ Question 4 ~~~~~~~~~~~~~~~~~~~~~~
# Write an R program to create two 2x3 matrices then Add, Subtract, Multiply
# and Divide the matrices.
# Note: Matrix Multiplication is A %*% B
# ====================== Answer ==========================
v1 = 1:6
m1 = matrix(v1, 2, 3)
m2 = matrix(10:15, 2, 3)
madd=m1+m2
madd
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# [,1] [,2] [,3]
# [1,]   11   15   19
# [2,]   13   17   21
msub= m1-m2
msub
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# [,1] [,2] [,3]
# [1,]   -9   -9   -9
# [2,]   -9   -9   -9

mml=m1*m2
mml
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# [,1] [,2] [,3]
# [1,]   10   36   70
# [2,]   22   52   90

m5=m1/m2
m5
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
#           [,1]      [,2]      [,3]
# [1,] 0.1000000 0.2500000 0.3571429
# [2,] 0.1818182 0.3076923 0.4000000



# ~~~~~~~~~~~~~~~~~~~~~~ Question 5 ~~~~~~~~~~~~~~~~~~~~~~
# Write an R program to access the element(s) of a given matrix stored in the following
# indices:
#   a.	2nd row and 3rd column,
#   b.	the 3rd row,
#   c.	the 4th column.
# ====================== Answer ==========================

# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
#      [,1] [,2] [,3] [,4] [,5]
# [1,]    1    5    9   13   17
# [2,]    2    6   10   14   18
# [3,]    3    7   11   15   19
# [4,]    4    8   12   16   20

m1=matrix(1:20,4,5)
m1[2,3]
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# [1] 10

m1[3,]
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# [1]  3  7 11 15 19

m1[,4]
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# [1] 13 14 15 16


# ~~~~~~~~~~~~~~~~~~~~~~ Question 6 ~~~~~~~~~~~~~~~~~~~~~~
# Write an R program to multiply the value stored in the 2nd row and 3rd column
# by the value stored in the 1nd row and 2rd column.
# ====================== Answer ==========================
m1[2,3]*m1[1,2]
  
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# [1] 50


# ~~~~~~~~~~~~~~~~~~~~~~ Question 7 ~~~~~~~~~~~~~~~~~~~~~~
# Write an R program to concatenate two given matrices of same number of columns but
# different number of rows with rbind().
# ====================== Answer ==========================
m1 = matrix(1:6, 2, 3)
m2 = matrix(1:12, 4, 3)
rbind(m1,m2)
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
#      [,1] [,2] [,3]
# [1,]    1    3    5
# [2,]    2    4    6
# [3,]    1    5    9
# [4,]    2    6   10
# [5,]    3    7   11
# [6,]    4    8   12


# ~~~~~~~~~~~~~~~~~~~~~~ Question 8 ~~~~~~~~~~~~~~~~~~~~~~
# Write an R program to concatenate two given matrices of same number of rows but
# different number of columns with cbind().
# ====================== Answer ==========================
m1 = matrix(1:8, 2, 4)
m2 = matrix(1:4, 2, 2)
cbind(m1,m2)
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
#      [,1] [,2] [,3] [,4] [,5] [,6]
# [1,]    1    3    5    7    1    3
# [2,]    2    4    6    8    2    4


# ~~~~~~~~~~~~~~~~~~~~~~ Question 9 ~~~~~~~~~~~~~~~~~~~~~~
# Write an R program to find the maximum and minimum value in a given matrix.
# ====================== Answer ==========================
m1 = matrix(1:8, 2, 4)
max(m1)
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# [1] 8
min(m1)
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# [1] 1


# ~~~~~~~~~~~~~~~~~~~~~~ Question 10 ~~~~~~~~~~~~~~~~~~~~~~
# Write an R program to find the row and column index of the maximum and minimum
# value in a given matrix.
# which(x, arr.ind = FALSE, useNames = TRUE)
# which.min(x)
# which.max(x)
# ====================== Answer ==========================
m1 = matrix(1:8, 2, 4)
m1

which(m1==max(m1),arr.ind=TRUE)  # find the max number location
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
#      row col
# [1,]   2   4

which.max(m1)
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# [1] 8

which(m1==min(m1),arr.ind=TRUE)
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
#      row col
# [1,]   1   1

which.min(m1)
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# [1] 1



# - - - - - - - - - - - - Array - - - - - - - - - - - -

# ~~~~~~~~~~~~~~~~~~~~~~ Question 1 ~~~~~~~~~~~~~~~~~~~~~~
# Write an R program to create an array from two 3x3 matrices with array().
# array(data = NA, dim = length(data), dimnames = NULL)
# ====================== Answer ==========================
myArr=array(data=1:9, dim=c(3,3,1))
myArr
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# , , 1
# 
# [,1] [,2] [,3]
# [1,]    1    4    7
# [2,]    2    5    8
# [3,]    3    6    9


# ~~~~~~~~~~~~~~~~~~~~~~ Question 2 ~~~~~~~~~~~~~~~~~~~~~~
# From a given array, print the elements stored in the second row of the
# second matrix of the array. Then, print the element in the 3rd row and 3rd
# column of the 1st matrix in the array.
# ====================== Answer ==========================
myArr=array(1:24,c(3,4,2))
myArr
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# , , 1
# 
# [,1] [,2] [,3] [,4]
# [1,]    1    4    7   10
# [2,]    2    5    8   11
# [3,]    3    6    9   12
# 
# , , 2
# 
# [,1] [,2] [,3] [,4]
# [1,]   13   16   19   22
# [2,]   14   17   20   23
# [3,]   15   18   21   24

myArr[2,,2]
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# [1] 14 17 20 23

myArr[3,3,1]
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# [1] 9


# ~~~~~~~~~~~~~~~~~~~~~~ Question 3 ~~~~~~~~~~~~~~~~~~~~~~
# Given a vector of 24 elements, write an R program to create a 3 dimensional array
# with dim().
# ====================== Answer ==========================
vector=1:24
dim(vector)=c(3,4,2)
which(myArr==max(myArr),arr.ind=TRUE)
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# , , 1
# 
# [,1] [,2] [,3] [,4]
# [1,]    1    4    7   10
# [2,]    2    5    8   11
# [3,]    3    6    9   12
# 
# , , 2
# 
# [,1] [,2] [,3] [,4]
# [1,]   13   16   19   22
# [2,]   14   17   20   23
# [3,]   15   18   21   24


# ~~~~~~~~~~~~~~~~~~~~~~ Question 4 ~~~~~~~~~~~~~~~~~~~~~~
# Rename the rows, columns and matrix
# ====================== Answer ==========================
row_name=c("ROW1","ROW2","ROW3")
col_name=c("COL1","COL2","COL3","COL4")
matrix_name=c("MATRIX1","MARITX2")
myArr=array(1:24,dim=c(3,4,2),dimnames=list(row_name,col_name,matrix_name))
myArr
# ~~~~~~~~~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~~~~~~~~~~
# , , MATRIX1
# 
# COL1 COL2 COL3 COL4
# ROW1    1    4    7   10
# ROW2    2    5    8   11
# ROW3    3    6    9   12
# 
# , , MATIRX2
# 
# COL1 COL2 COL3 COL4
# ROW1   13   16   19   22
# ROW2   14   17   20   23
# ROW3   15   18   21   24