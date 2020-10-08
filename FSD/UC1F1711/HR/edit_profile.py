
"""
{
name1:{},
name2:{},
name2:{},
}

profile type: dictionary of dictionaries

requirement:
Can modify, view and search lecturer profile accordingly
"""

import time
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

