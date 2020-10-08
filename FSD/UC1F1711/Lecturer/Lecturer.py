"""Lecturer
1. Can apply for leave.
2. Can check the status of the leave application.
3. Can view all public and University Holidays, also University’s Leave Policies."""
import time

while True:
    lec_login_id = input("Enter login id:") #create user input
    lec_password = input("Enter password:")

    if lec_login_id != str(1) or lec_password != str(1) : # condition check on id and password
        print("Login id or password wrong, pls try again.......")
        time.sleep(1)
        continue

    else:
        print("\nLog in successfully, Welcome to Lecturer page\nSelect your lecturer opetion as below\n")
        time.sleep(1)
        while True:
            Lecturer_Choice = int(input("1.Apply for leave.\n2.check the status of the leave application.\n3.view all public and University Holidays, also University’s Leave Policies.\nSelect the lecturer's choice:"))
            if Lecturer_Choice == 1:
            # apply for leave
            
                break
            elif Lecturer_Choice == 2:
            # Can check the status of the leave application.
                with open('#.txt','r') as f:
                    leave_application = f.read()    
                    print(leave_application) 
                break
            elif Lecturer_Choice ==3:
            # Can view all public and University Holidays, also University’s Leave Policies.
                with open('#.txt','r') as f:
                    holiday_policy = f.read()
                    print(holiday_policy)
                break
            else:
                print("Pls enter correct number......")
                time.sleep(2)
                continue
    break