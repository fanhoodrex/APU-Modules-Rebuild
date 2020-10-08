# Matrix
#1. Write a R program to create a blank matrix
blank_matrix = matrix(,nrow=10,ncol=5)

#2. Write a R program to create a matrix taking a given vector of numbers as input. Display the matrix.
row_names = c("row1", "row2", "row3", "row4")
col_names = c("col1", "col2", "col3", "col4")
M = matrix(c(1:16), nrow = 4, byrow = TRUE)
print("Original Matrix:")
print(M)

#3. Write a R program to create a matrix taking a given vector of numbers as input and define the column and row names. Display the matrix. 
row_names = c("row1", "row2", "row3", "row4")
col_names = c("col1", "col2", "col3", "col4")
M = matrix(c(1:16), nrow = 4, byrow = TRUE, dimnames = list(row_names, col_names))
print("Original Matrix:")
print(M)

#4. Write a R program to access the element at 3rd column and 2nd row, only the 3rd row and only the 4th column of a given matrix.
matrix4 = matrix(1:9,nrow=3,ncol=4,byrow = TRUE)
selection = matrix4[2,3] # [] select 2nd row and 3rd column elements from a matrix

#5. Write a R program to create two 2x3 matrix and add, subtract, multiply and divide the matrixes
add = 5
subtract = 1
multiply = 2
divide = 2
matrix5 = matrix(1:6,nrow=2,ncol=3,byrow = TRUE)
matrix5 + add
matrix5 - subtract
matrix5 * multiply
matrix5 / divide

#6. Write a R program to find row and column index of maximum and minimum value in a given matrix.
m = matrix(c(1:20),nrow = 4, byrow = TRUE)
print("Original Matrix")
Print(m)
result = which(m == max(m),arr.ind=TRUE)
print(result)
result = which(m == min(m),arr.ind=TRUE)
print("Row and column of minimum value of the said matrix:")
print(result)

#7. Write a R program to concatenate two given matrices of same column but different rows
matrix7_1 = matrix(1:12,nrow=4,ncol=3,byrow = TRUE)
matrix7_2 = matrix(1:6,nrow=2,ncol=3,byrow = TRUE)

#add rows to a matrix with the cbind() function, which merges matrices and/or vectors together by row
combined_matrix = rbind(matrix7_1,matrix7_2)


# Data Frames
# 1.Write a R program to create an empty data frame
empty_data_frame = data.frame()

# 2.Write a R program to create a data frame from four given vectors
name <- c("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
type <- c("Terrestrial planet", "Terrestrial planet", "Terrestrial planet", 
          "Terrestrial planet", "Gas giant", "Gas giant", "Gas giant", "Gas giant")
diameter <- c(0.382, 0.949, 1, 0.532, 11.209, 9.449, 4.007, 3.883)
rings <- c(FALSE, FALSE, FALSE, FALSE, TRUE, TRUE, TRUE, TRUE)

planets_df <- data.frame(name,type,diameter,rings)

# 3.Write a R program to extract specific column from a data frame using column name
planets_df['diameter'] # extract the diameter column from dataframe

# 4.Write a R program to extract first two rows from a given data frame
planets_df[1:2,]

# 5.Write a R program to add a new column in a given data frame
print("Original dataframe:")
print(planets_df)
print("New data frame after adding the 'country' column:")
planets_df$country = c("USA","China","Canada","Singapore","Malaysia","Belgium","Germany","Dutch")

# 6.Write a R program to add new row(s) to an existing data frame
exam_data = data.frame(
  name = c('Anastasia', 'Dima', 'Katherine', 'James', 'Emily', 'Michael', 'Matthew', 'Laura', 'Kevin', 'Jonas'),
  score = c(12.5, 9, 16.5, 12, 9, 20, 14.5, 13.5, 8, 19),
  attempts = c(1, 3, 2, 3, 2, 3, 1, 1, 2, 1),
  qualify = c('yes', 'no', 'yes', 'no', 'no', 'yes', 'yes', 'no', 'no', 'yes')
)
print("Original dataframe:")
print(exam_data)
new_exam_data = data.frame(
  name = c('Robert', 'Sophia'),
  score = c(10.5, 9),
  attempts = c(1, 3),
  qualify = c('yes', 'no')
)
exam_data =  rbind(exam_data, new_exam_data)
print("After adding new row(s) to an existing data frame:")
print(exam_data)

# 7.Write a R program to drop column(s) by name from a given data frame
exam_data = subset(exam_data, select = -c(qualify))



# list
# 1.	Write a R program to create a list containing strings, numbers, vectors and a logical value.
movie_title = "movie_title"
scores <- c(4.6, 5, 4.8, 5, 4.2)
comments <- c("I would watch it again", "Amazing!", "I liked it", "One of the best movies", "Fascinating plot")
logical_value = "True"

list1 = list(movie_title,scores,comments,logical_value)

# 2.	Write a R program to create a list containing a vector, matrix and a list give names to the elements in the list. and Access the first and second element of the list.

vector_1 = c("row1", "row2", "row3", "row4")
matrix_1 = matrix(c(1:20),nrow = 4, byrow = TRUE)

list2 = list(vector_1,matrix_1,list1)
names(list2) = c("name1","name2","name3")

list2[[1]] # Both $ and [[]] will select the data frame representing the reviews:
list2$name2




