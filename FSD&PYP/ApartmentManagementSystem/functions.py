import time,random
from itertools import zip_longest

def apartment_manu():
    """apartment manu GUI display using print statement"""
    print("""
    Pls select the desired apartment type as shown below, be noted that there are 20 apartments available for rental 
    under each type. Each apartment can house exactly one student per room.

    Letter A refer to block A, number come after A refer to block number,
    Letter M mean master room and the number come after M mean romm number
    Letter S mean single room and the number come after S mean romm number
    ___________________________________________________________________________________________________________________
    |Type| No.of room per |    Room Type    | Monthly Rental | Facilities| Facilities | Internet (Optional) Monthly   |
    |    | per aparment   |                 |   Per Room     |  Kitchen  |   Laundry  | Subscription Fee per User(RM) |
    ___________________________________________________________________________________________________________________
    | A  |        2       | 2 Single Rooms  |       400      |    YES    |     YES    |              50               |
    | B  |        3       | 1 Master Bedroom|       500      |     NO    |     YES    |              40               |
    | B  |                | 2 Single Rooms  |       300      |    YES    |     YES    |              40               | 
    ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
    """)
    return None

def manu_display():
    """solely used for displaying manu"""
    print("""\nHello, welcome to UNIVERSITY STUDENT APARTMENT MANAGEMENT SYSTEM, Pls select you choice below\n
    1. Student Registration
    2. Apartment Room Allocation
    3. Display the Total deposit collected
    4. Display Total amount collected excluding the deposit.
    5. Display Total amount receivable from the students.
    6. Search for Student's record by TP number or name
    7. Search for Apartment type, apartment number and room number.
    """)
    return None

def register(list1,list2):
    """register individual student infor and return the profile dcit value"""
    # User input for registration on student name and TP as dictionary key
    name = input("Pls enter the student name:")
    TP_num = input("Pls enter the student TP number:")

    list1.append(name) # append user input to corresponding list
    list2.append(TP_num) 

    # output message and cease program for 1 second, appending to student list
    print("Regiser studnet successfully")
    time.sleep(1)
    return list1,list2

def allocation(name_allocated,rooms_allocated,Type_A_infor,Type_B_info,A_single,B_single,B_master,vali_data,student_record): # could pass in multiple parameters
    """registered student select the apartment type and internet subscription once a time"""
    semester,Amount,deposit = 5,0,100 # define varibale in local scope
    profile = {}
    time.sleep(1)

    apartment_manu() # call for apartment manu function to display manu 
    Apart_Type = input("Which Type of Apartment do you wanna select, A or B?:") # selection of apartment type (i.e. Type A or B)

    if Apart_Type == "A":
        print("Current available rooms in Apartment A are below.\n")
        print(A_single)
        time.sleep(1)
        room_code = input("Enter the code on room for your selection:")
        name_allocated .append(vali_data) # append the username logged in to the list
        rooms_allocated.append(room_code) # append the rooms selected to the list
        A_single.remove(room_code) # remove the selected item from the A_single list

        Amount = Type_A_infor["Monthly Rental per Room(RM)"] * semester + Type_A_infor["Internet Fee Monthly"] # calculate the rental charges
        profile["Apartment Type"] = (Apart_Type,"Single Room") # using tuple
        time.sleep(1) # program cease 1 second

    elif Apart_Type == "B":
        choice = int(input("What type of room do you wanna select? 1.Master Bedroom 2.Single Room: "))
        time.sleep(1)
        if choice == 1:
            print("\nCurrent availabe master room in Apartment B are below:\n")
            time.sleep(1)
            print(B_master)
            time.sleep(1)

            room_code = input("Enter the code on room for your selection:")
            name_allocated.append(vali_data) # append the username logged in to the list
            rooms_allocated.append(room_code) # append the rooms selected to the list
            B_master.remove(room_code) # remove the selected item from the A_single list

            # Append the Apartment Type and room type key value pair to profile
            profile["Apartment Type"] = (Apart_Type,"Master Bedroom")
            Amount = Type_B_info["Monthly Rental per Room(RM)"]["Master Bedroom"] * semester + Type_B_info["Internet Fee Monthly"] # calculation on monthly rental per room : Rental + Internet
        
        elif choice == 2:
            print("\nCurrent availabe single room in Apartment B are below:\n")
            time.sleep(1)
            print(B_single)
            time.sleep(1)

            room_code = input("Enter the code on room for your selection:")
            name_allocated.append(vali_data) # append the username logged in to the list
            rooms_allocated.append(room_code) # append the rooms selected to the list
            B_single.remove(room_code) # remove the selected item from the A_single list

            # Append the Apartment Type and Internet Subscription as key value to profile
            profile["Apartment Type"] = (Apart_Type,"Single Bedroom")
            Amount = Type_B_info["Monthly Rental per Room(RM)"]["Single Bedroom"] * semester + Type_B_info["Internet Fee Monthly"] # calculation on monthly rental per room : Rental + Internet
    
    profile['room code'] = room_code # add the room code key,value pair to the profile fict
    print("Successfully allocate the Room")
    time.sleep(1) # program cease for 1 second

    choice = int(input("Would u like to pay full or partial amount? 1.Full 2.partial:"))
    if choice == 1:
        profile["payment method"] = "Full payment"
        Amount_paid = Amount + deposit
        print(f"You need to pay {Amount_paid} RM")
    elif choice == 2:
        profile["payment method"] = "Partial payment"
        Amount_paid = Amount * 0.5 + deposit
        print(f"You need to pay {Amount_paid} RM as the minimum payment amount")
        time.sleep(1)
    else:
        print("Pls enter valid ingeter of either 1 or 2")
        time.sleep(1)
    
    profile["Total Bill"] = Amount_paid
    student_record[vali_data] = profile # append profile dict to student list
    
    return None 

def search_student(list1,list2,list3):
    """search for student based on student name or TP number then return None value"""
    data = input("enter the name or TP number of student you wanna search for:")
    if data in list1 and data not in list3: # name apear in register_name list but not in name_allocated list
        print("This registered student haven't selected rooms in system yet, pls do selection")

    elif data in list3: # name appear in name_allocated list
        room_code = list1[list3.index(data)]
        print(f"Room {room_code} is allocated to {data}")
        time.sleep(1)
        
    else: # exist in none of the list 
        print("Sorry, the student you search for has not been registered yet")
        time.sleep(1)
    return None

def search_apartment(name_allocated,rooms_allocated):
    """search for apartment based on apartment type, apartment number and rrom number"""
    room_code = input("Enter a room code in search for its record:")

    if room_code in rooms_allocated: # if the room code enter exist in rooms_allocated list
        name = name_allocated[rooms_allocated.index(room_code)] # point to the name by using the index from room list
        print(f"Room {room_code} is allocated to {name}")
        time.sleep(1)

    else:
        print("The room you search for has not been allocated yet so it is available")
        time.sleep(1)

def combine_list(list1,list2):
    """merge two list with different length into one, the first list represents apartment list,
    the other one represent room list, merged list could directly point to exact room within population"""
    if len(list1) != len(list2): # if the length of two list passed in is not equal
        index,combine_list = 0,[] # initial value
        for apart in list1: # run 20 times for single room
            for room in range(2): # access 2 elements from A_rooms list
                item = f"{apart}{list2[index]}"
                combine_list.append(item)
                index += 1
    elif len(list1) == len(list2): # if the length of two list given is equal
        combine_list = []
        for num in range(len(list1)):
            item = list1[num] + list2[num]
            combine_list.append(item)
    else: # otherwise raise customized exception error
        raise TypeError("pls pass in list type")
    return combine_list