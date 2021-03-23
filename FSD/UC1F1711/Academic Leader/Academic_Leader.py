"""1. Can view lecturer’s leave application.
2. Can approve/reject the leave.
3. Can view all public and University Holidays, also University’s Leave Policies."""
import time

while True:
    ACleader_login_id = input("Enter login id:") #create user input for AC
    ACleader_password = input("Enter password:")

    if ACleader_login_id != str(1) or ACleader_password != str(1)  : # condition check on id and password
        continue

    else:
        print("Log in successfully, Welcome to Academic Leader page\n")
        while True:
            ACleader_Choice = int(input("\n1.view lecturer’s leave application.\n2.Can approve/reject the leave.\n3.View all public and University Holidays, also University’s Leave Policies.\nSelect the lecturer's choice:"))
            if ACleader_Choice == 1:
                pass
            elif ACleader_Choice == 2:
                pass
            elif ACleader_Choice == 3:
                with open('#.txt','r') as f:
                    holiday_policy = f.read()
                    print(holiday_policy)
                pass
            else:
                print("Pls enter correct number......")
                time.sleep(2)
                continue
    break