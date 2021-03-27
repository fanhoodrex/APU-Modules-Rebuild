#  store the profile? list or dictionary in list of list form 
#  like this : [ [],[],[] ]

import time

def create_profile():
    """create new Lecturer/ Academic Leader’s profile, attribute include name, age
    type, teaching subject, date for enrollment, using list as data type to storing the profile"""

    academic_leader_profile = [] # initialize a empty list for storing academic profile in local scope
    lecturer_profile = [] # initialize a empty list for storing lecturer_profile in local scope

    while True:
        print("\n")
        profile_type = int(input("1.Creating Academic leader\n2.Creating Lecturer\n3.Finish Creating\nPls enter choice:"))# first selection for profile type
        if profile_type == 1 :
            Academic_leader = [] # initialize empty list for individual lecturer  
            for attribute in ['name','age','gender','teaching subject','enrollment date']: # using for clause to loop through the list of every profile attribute
                data = input(f"Pls enter the {attribute} for the academic leader:") # f string to catch user input for profile attributes
                Academic_leader.append(data) # append the each attribute element to individual lecturer list
            academic_leader_profile.append(Academic_leader) # append whole individual lecture list to lecturer profile list, forming the list of list
            print("Create Academic Leader profile successfully!")
            time.sleep(1)

        elif profile_type == 2:
            Lecturer = [] # initialize empty list for individual academic leader
            for attribute in ['name','age','gender','teaching subject','enrollment date']: # using for clause to loop through the list of every profile attribute
                data = input(f"Pls enter the {attribute} for the lecturer:") # f string to catch user input for profile attributes
                Lecturer.append(data) # append the each attribute element to individual academic leader list
                lecturer_profile.append(Lecturer) # append whole individual academic leader list to academic leader profile list, forming the list of list
            print("Create Lecturer profile successfully!")
            time.sleep(1)

        elif profile_type == 3:
            print("Done finishing creating all profile !!! ")
            time.sleep(1)    
            break

        else:
            print("pls enter correct integer within range in [1,2,3] ") # error message
            time.sleep(1)
            continue

    return lecturer_profile,academic_leader_profile

def main():
    lecturer_profile,academic_leader_profile = create_profile()
    print(lecturer_profile,academic_leader_profile)

    with open("List-of-List.txt",'w') as f:
        f.write(str(lecturer_profile))
        f.write('\n')
        f.write(str(academic_leader_profile))
        f.write('\n')

        f.write("Academic leader\n")
        for line in academic_leader_profile:
            f.write(str(line))
            f.write('\n')

        f.write("Lecturer\n")
        for line in lecturer_profile :
            f.write(str(line))

main()
