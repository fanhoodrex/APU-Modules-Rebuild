
def HR():
    again = "Yes" or "yes"
    while((again == "Yes")or(again == "yes")):
        print("Menu:")
        print("1.Create a Lectruer's profile")
        print("2.Create a Academic Leader's profile")
        print("3.Check the lecturer's profile")
        print("4.Check the employee leave status")
        print("5.Upload the yearly leaves")
        print("6.Upload the holyday")
        print("7.Upload the FAQs")
        x = int(input('Select the function you want to do : '))
        if x == 1:
            L_name = input("Enter name: ")
            L_password = input("Enter password: ")
            f = open("Lectruer.txt","a")
            f.write(L_name)
            f.write(":")
            f.write(L_password)
            f.write("\n")
            f.write("\n")
            again = input("Do you want to use again?  (Yes/No) :")
        elif x == 2:
            A_name = input("Enter name: ")
            A_password = input("Enter password: ")
            f = open("academic_leader","a")
            f.write(A_name)
            f.write(":")
            f.write(A_password)
            f.write("\n")
            f.write("\n")
            again = input("Do you want to use again?  (Yes/No) :")
        elif x == 3:
            f = open("Lectruer.txt")
            y = f.read()
            print(y)
            again = input("Do you want to use again?  (Yes/No) :")
        elif x == 4:
            f = open("Employee leave.txt")
            y = f.read()
            print(y)
            again = input("Do you want to use again?  (Yes/No) :")
        elif x == 5:
            f = open("Yearly leave.txt")
            y = f.read()
            print(y)
            again = input("Do you want to use again?  (Yes/No) :")
        elif x == 6:
            f = open("Holidays.txt","a")
            Holidays = input("Enter holidays: ")
            f.write(Holidays)
            f.write("\n")
            again = input("Do you want to use again?  (Yes/No) :")
        elif x == 7:
            FAQs = input("Enter FAQs: ")
            f = open("FAQs.txt","a")
            f.write(FAQs)
            f.write("\n")
            f.write("\n")
            again = input("Do you want to use again?  (Yes/No) :")


def HR_Login():
    
    x = input("Enter your ID. ;")
    y = input("Enter your password :")
    f = open("HR_Login.txt")
    if x and y in f.read():
        HR()
    else:
        print("Wrong ID or password.")
                                 
def HR_register():
    ch = "Yes"or"yes"
    print("Welcome to HR register system.")
    while((ch == "Yes")or(ch == "yes")):
        x = input("Please enter the register code. :")
        code = "123456789"
        if x == code:              # register code for HR
            f1 = open("HR_Login.txt","a")
            f1.write("\n")

            f1.write("\n")
            y = input("Enter your ID :")
            z = input("Enter your password :")
            f1.write(y)
            f1.write(":")
            f1.write(z)
        else:
            print("Wrong register code.")
        ch = input("Do you want to use again?  (Yes/No) :")
    
    

print("Welcome to the Employees Leave Management System.")
x = int(input("What is your profession?  \n1.HR \n2.Lectruer \n3.Academic Leader \n4.HR register \nChoose one number :"))
if x == 1:
    HR_Login()
elif x == 4:
    HR_register()
            
        
            
    
