print('''=================
Functionalities of Registered Student
1.View Detail
2.Modify Self Record
3.Provide feedback and Star to Coach
4.Exit''')
choice = int(input("Enter your choice:"))#Get options 
if choice == 1:  # Judgment options 
    print('''=================
Please select the content you want to view
a.Coach
b.Self-Record
c.Registered Sport Schedule only''')
    choice_a = input("Enter your choice:")  # Get options
