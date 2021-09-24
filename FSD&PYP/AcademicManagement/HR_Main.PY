import time
from HR_Functions import * 

while True:
    HR_login_id = input("Enter login id:") #create user input for HR
    HR_password = input("Enter password:")

    if HR_login_id != str(1) or HR_password != str(1) : # condition check on id and password
        print("Login id or password wrong, pls try again.......")
        time.sleep(1)
        continue

    else:
        print("\nLog in successfully, Welcome to HR page\nSelect your lecturer opetion as below:\n")
        time.sleep(1)
        while True:
            HR_Choice = input("1.Create Lecturer or Academic Leader profile\n2.View, search and modify profile.\n3.View the employee leave status.\n4.Upload the Public and University Holidays\n5.Update and upload FAQs about University’s Leave Policies\nPLs Enter selection:")
            if HR_Choice == str(1): # create new Lecturer/ Academic Leader’s profile
                AC_Lec_profiles = create_profile() # call for the create_profile function from other file and assignment profile data to dictionary
                
                with open("Dict_of_Dict.txt",'w') as f: # Write the profile dictionary data into plain txt file
                    f.write(str(AC_Lec_profiles))
                break

            elif HR_Choice == str(2): # Can View, search and modify profile
                edit_profile() # call for the edit_profile function from other file module
                break

            elif HR_Choice == str(3): # Can view the employee leave status.
                pass

            elif HR_Choice == str(4): # Can upload the Public and University Holidays.
                PU_holidays = upload_holiday() # Call for the upload_holiday function from other file
                break

            elif HR_Choice == str(5): # Can update and upload FAQs about University’s Leave Policies in system
                while True:
                    choice6 = input("1.Upload the FAQs policy or 2.Update the FAQs policy [-1] to exit:")
                    
                    if choice6 == str(1):
                        FAQs = Upload_FAQs() # Assignment of the FAQs dictionary
                        continue

                    elif choice6 == str(2):
                        if FAQs is not None: # if the FAQs is Uploaded as prerequsite of update
                            Update_FAQs() # call for the Update_FAQs function from other file
                            continue
                        else: # if the FAQs is not Uploaded before update operation
                            print("Sorry, there is no FAQs in system yet, pls Upload FAQs first")
                            time.sleep(1)
                            FAQs = Upload_FAQs()
                            continue

                    elif choice6 == str(-1):
                        print("Exit successfully ! ")
                        break
                        
                    else:
                        print("Pls enter integer within [1,2,-1]")
                        continue
                    
            else:
                print("Pls enter integer number within [1,2,3,4,5,6] ......")
                time.sleep(2)
                continue