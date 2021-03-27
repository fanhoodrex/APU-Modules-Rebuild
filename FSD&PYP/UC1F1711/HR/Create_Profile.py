#  store the profile? list or dictionary in list of list form 
# { name1:{},
#   name2:{},
#   name3:{} }

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
