import time

def create_profile():
    """ create new Lecturer/ Academic Leader’s profile, attribute include name, age
    type, teaching subject, date for enrollment, using dictionary as data type to storing the profile.
    therefore make it easy for user to search the profile by name keys"""

    AC_Lec_profiles = [] # initialize a empty list for storing academic leader and lecturer profile in local scope

    while True:
        print("\n")
        profile_type = input("1.Creating Profiles\n2.Finish Creating\nPls enter choice:")#  user input for choice

        if profile_type == str(1):

            profile = {} # initialize a empty dictionary for individual profile

            profile_name = input("Pls enter the name for the profile:") # User input for profile name as dictionary key later on
            # Construct a individual profile dictionary corresponding to the profiles name key finally
            for attribute in ['role','age','gender','teaching subject','enrollment date','login_id','Password']: # using for clause to loop through the list of every profile attribute
                data = input(f"Pls enter the {attribute} for the profile:") # f string to catch user input for profile attributes
                profile[attribute] = data # append the each attribute element to individual lecturer list
            
            AC_Lec_profiles[profile_name] = profile # append whole individual lecture list to lecturer profile list, forming the list of list
            print("Create profile successfully!")
            time.sleep(1)

        elif profile_type == str(2):
            print("Successfully create all profiles !!! ")
            time.sleep(1)    
            break

        else:
            print("pls enter correct integer within range in [1,2,3] ") # error message
            time.sleep(1)
            continue

    return AC_Lec_profiles

def file_handler():
    AC_Lec_profiles = create_profile()
    print(AC_Lec_profiles)

    with open("Dict_of_Dict.txt",'w') as f:
        f.write(str(AC_Lec_profiles))

        f.write("\n\nProfile list\n\n")
        for key,value in AC_Lec_profiles.items():
            f.write(f"{key}:{value}\n\n")

def Upload_FAQs():
    """HR's Function that used for Uploading University's FAQs, and store the policy in dictionary
    then write it to plain text file """

    FAQs = {} # initialize the empty FAQs dictionary 
    n = 1 # Declare the policy counting number 

    while True:
        policy = input(f"Pls Enter {n} University's Policies and integer [-1] for exit:") # string type user input
        
        if policy == str(-1): #Exit the Uploading
            print("Upload the policy and exit successfully!!! ")
            time.sleep(1)
            break

        else: # Enter the Leave policy rule 
            FAQs[n] = policy # add the policy value to the dictionary
            print(f"Add the {n} policy successfully and the current FAQs shown as below")
            time.sleep(1) # pause 1 second
            print(FAQs) # display current FAQs enter
            n += 1
            continue
    
    with open("Leave Policies.txt","w") as f: # write the policies to plain txt file
        for k,v in FAQs.items(): # iterate the policy dictionary 
            f.write(f"{k}:{v}\n")

    return FAQs

FAQs = Upload_FAQs()

def Update_FAQs():
    """Update the current FAQs by altering the FAQs dictionary then rewite to the plain txt file"""

    while True:
        choice = int(input("1.Add new policy OR 2.Change the current policy rule 3. Finished and Exit:"))

        if choice == 1: # Add new policy
            FAQs[len(FAQs)] = input("Enter new policy:")
            print("Successfully add the new policy !")
            time.sleep(1)
            print(FAQs)

        elif choice == 2: # Change the current policy rule
            print(FAQs) # display the FAQs first
            print("\n") # print one new line
            num = int(input("Which number of policy you wanna change?:")) # ask user input for the number of policy
            FAQs[num] = input("Enter the changed policy:") #ask user input for the policy content after changing
            print(f"Successfully change the content of {num} policy !")
            time.sleep(1)
            print(FAQs)

        else:
            print("Pls enter correct number within range [1,2,3]....")
            time.sleep(1)
            continue
    return None

AC_Lec_profiles ={'fang': {'role': '1', 'age': '1', 'gender': '1', 'teaching subject': '1', 'enrollment date': '1', 'login_id': '1', 'Password': '1'}, 'chen': {'role': '2', 'age': '2', 'gender': '2', 'teaching subject': '2', 'enrollment date': '2', 'login_id': '2', 'Password': '2'}}

def edit_profile():
    """HR can modify, view and search lecturer profile accordingly"""
    
    while True:
        choice = input("1.Modify profile\n2.View profile\n3.Search lecturer profile\nor [-1] to exit:")

        if choice == str(1):
            name = input("Pls enter the name of the profile:") # user input for name 
            print("The profile current attribute shown as below:\n")

            if name in AC_Lec_profiles.keys(): # if the name enter is in dictionary keys list
                for item in AC_Lec_profiles[name].items(): # access the profiles attributes as dictionary
                    print(item,end="\n")
                time.sleep(1)

                while True:
                    attr = input("What attribute of profile do you wanna modify? [-1] for exit:")
                    if attr == str(-1):
                        break

                    else:
                        if attr in AC_Lec_profiles[name].keys(): # if the attribure enter exist
                            AC_Lec_profiles[name][attr] = input("Pls enter the new attribute:")
                            time.sleep(1)
                            print(f"Successfully Modify the profile! Now the new profile is:\n{AC_Lec_profiles[name]}")
                            continue
                        else: # if the attribure enter does not exist
                            print("the attribute enter does not exist, pls try again:")
                            continue

            else:
                print("the name enter does not exist in profile, pls try again:")
                time.sleep(1)
                continue

        elif choice == str(2):
            for profile in AC_Lec_profiles.items():
                print(profile,end="\n") # print out the all current profiles created by HR
            time.sleep(1)
            continue

        elif choice == str(3): # Search the infor of profile
            name = input("Pls enter the name of the profile for search:") # user input for profile name

            if name in AC_Lec_profiles.keys(): # if the name enter is in dictionary keys list
                print(f"{name}:{AC_Lec_profiles[name]}",end="\n\n")
                time.sleep(1)
                continue
            else:
                print("the name enter does not exist in profile, pls try again:")
                time.sleep(1)
                continue

        elif choice == str(-1):
            print("Exit succesfully !")
            break

        else:
            print("Pls enter corrent integer within range [1,2,3,-1]")
            time.sleep(1)
            continue
        
    return None

def upload_holiday():
    """ HR's Function that used for Uploading Public and University Holidays,
    and store the holidays in dictionary of list data type afterward write it to plain text file. 
    Note: Dictionary Key is holidays name and the value is a list consisting of only start date and end date, 2 elements """

    PU_holidays = {} # initialize the empty FAQs dictionary 
    n = 1 # Declare the holiday counting number 

    while True:
        holiday_name = input(f"\nPls Enter the name for {n} Public and University Holidays and integer [-1] for exit:") # user input for holiday
        
        if holiday_name == str(-1): #Exit the Uploading
            print("Upload the Public and University Holidays and exit successfully!!! ")
            time.sleep(1)
            break

        else: # Enter the Leave holiday rule 
            holiday_range = [] # initialize the empty list for storing holidays range
            start_date = input(f"Enter starting date for {holiday_name} in YYYY-MM-DD form:")
            holiday_range.append(start_date)
            end_date = input(f"Enter ending date for {holiday_name} in YYYY-MM-DD form:")
            holiday_range.append(end_date)

            PU_holidays[holiday_name] = holiday_range # add the key,value pair to holiday dictionary
            print(f"\nsuccessfully add the {holiday_name} holiday and the current Public and University holidays shown as below\n")
            time.sleep(1)
            print(PU_holidays)
            n += 1
            continue
    
    with open("Public&University_Holidays.txt","w") as f: # write the policies to plain txt file
        for k,v in PU_holidays.items(): # iterate the holiday dictionary 
            f.write(f"{k}:{v}\n")
    
    return PU_holidays