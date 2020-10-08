# QUESTION A1 (Total: 10 x 1 = 10 Marks)
"""
 Answer
 1. False
 2. False
 3. True
"""


# QUESTION A2 (Total: 10 x 1 = 10 Marks)
"""
 Answer: 
 1.D 
 2.A 
 3.C
"""

# QUESTION A3 (Total: 20 Marks)
"""
numbers = [] 
N = int(input('Enter value of N:'))

for i in range(N):
    num = int(input('Enter a number:'))
    numbers.append(num) 

count = 0 
sort.numbers()
for num in numbers: 
    if num == 5:
        count = count + 1 
print(count)
"""

# QUESTION A4 (Total: 20 Marks)

# Answer to a.
mark = int(input("Pls enter the mark,[-1 to end]:"))
while True:
    if (mark >= 80) and (mark<=100):
        grade = "A"
    elif (70<=grade<=79):
        grade = "B"
    elif (60<=grade<=69):
        grade = "C"
    elif (50<=grade<=59):
        grade = "C-"
    else:
        grade = "F"
    print("Grade = ",grade)
    mark = int(input("Pls enter the mark,[-1 to end]:"))

# Answer to b.
num = int(input("How many students needed to enter mark?:"))
for i in range(num):
    mark = int(input("Pls enter the mark,[-1 to end]:"))
    if (mark >= 80) and (mark<=100):
        grade = "A"
    elif (70<=grade<=79):
        grade = "B"
    elif (60<=grade<=69):
        grade = "C"
    elif (50<=grade<=59):
        grade = "C-"
    else:
        grade = "F"
    print("Grade = ",grade)

# QUESTION B1 (Total: 20 Marks)
f = open('fav_mov.txt','w')
i = 1
for i in range(start=1,stop=10,step=1):
    fmov = input("Enter your fav movie:")
    f.write(f"fmov + \n")
    i = i + 1
f.close('fav_mov.txt')

# QUESTION B2 (Total: 20 Marks)
def mystery(t=['Lab Test', 'Exam', 'Exam'],a=0, b=1, c=-1):
    s = ['XML', 'FSD']
    s.extend(t)
    s.insert(a,'WDT')
    s.insert(b, 'DMP')
    s.insert(c, 'ICP')
    print(s)

mystery()
# Answer to a. mystery() 
"""
output is: ['WDT', 'DMP', 'XML', 'FSD', 'Lab Test', 'Exam', 'ICP', 'Exam']

Explanation: 
1. When the mystery function is called, the list s = ['XML','FSD']
is initialized in local scope in mystery function first. 

2. Then s.extend(t) method extends the t=['Lab Test', 'Exam', 'Exam']
passed in mystery function as parameters behind the s list, appending 
the 'Lab Test', 'Exam', 'Exam' those 3 elements after the 'FSD' element in s list

3. s.insert(a,'WDT') does insert the 'WDT' element at the index value of a
passed in the function as parameter in the s list.

4. The final two lines of code, s.insert(b, 'DMP') and s.insert(c, 'ICP') both do
the same as the s.insert(a,'WDT'), only the index values are different, 
b = 1 at the second position of s list and c = -1 at the last position of s list
"""

# Answer to b. mystery(['Assignment', 'Project'],-1,0)
"""
This do exactly same as mystery() in steps above, instead it comes with different function parameters
passed in: t = ['Assignment', 'Project']; a = -1 ; b = 0 and the last parameter c is not provided, 
Unlike the default parameters given in mystery()
"""
