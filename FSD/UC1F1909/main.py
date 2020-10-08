#WANG SHAOKUN
#TP053170

from functions import * # import all function from functions.py file to which i wrote every functionality/modules
import time,random 

def main():
    """main program that execute all different modules/functions"""

    A_apartments = [ "A"+ str(i+1) for i in range(20)] # simulate apartment A type and number in a list of 20 elements
    A_rooms = ["S"+ str(i+1) for i in range(len(A_apartments*2))] # simulate numeber of rooms in apartment A in a list of 40 elements
    B_apartments = ["B"+ str(i+1) for i in range(20)] # simulate apartment B type and number in a list of 20 elements
    B_maste_rooms = ["M"+ str(i+1) for i in range(len(B_apartments))] # simulate numeber of rooms in apartment A in a list of 40 elements
    B_single_rooms = ["S"+ str(i+1) for i in range(len(B_apartments*2))]
    
    A_single = combine_list(A_apartments,A_rooms) # form the list of all combinations of apartment A and single rooms
    B_single = combine_list(B_apartments,B_single_rooms) # combination of apartment B and single rooms  
    B_master = combine_list(B_apartments,B_maste_rooms) # combination of apartment B and master rooms
    
    with open('rooms_total.txt','w') as f:
        """store rooms combination data to a txt file"""
        f.write(str(A_single))
        f.write('\n')
        f.write(str(B_single))
        f.write('\n')
        f.write(str(B_master))
        f.write('\n')       

    Type_A_infor = {
        "No.of Apartments":20,
        "No.of Rooms":2,
        "Room Type":"Single Room",
        "Monthly Rental per Room(RM)":400,
        "Facilities":('Kitchen','Laundry'),
        "Internet Fee Monthly":50
        }

    Type_B_info = {
        "No.of Apartments":20,
        "No.of Rooms":3,
        "Room Type":("1 Master Bedroom","2 Single Room"),
        "Monthly Rental per Room(RM)":{
            "Master Bedroom":500,
            "Single Bedroom":300
            },
        "Facilities":{
            "Master Bedroom":("Laundry"),
            "Single Rooms":("Kitchen","Laundry")
            },
        "Internet Fee Monthly":40
        }

    register_name = [] # initialize a empty list for student name
    register_TP = [] # initialize a empty list for student TP number
    name_allocated = [] # for storing the student name who have allocated room
    rooms_allocated = [] # for storing the rooms that have been allocated by students
    student_record = {} # for storing the selection detail of students in dict 

    while True:
        manu_display() # call for manu display function 
        choice = input("Pls enter your choice or '0' for quit:")
        
        if choice == str(1):
            register_name,register_TP = register(register_name,register_TP)
            print(f'\nlist of student name who have registered: {register_name}')
            print(f'list of student TP number who have registered: {register_TP}')
            name_tp = list(zip(register_name,register_TP)) # zip two iterable first and turn it into list type            
            
            with open("student_registered.txt","w") as f:
                for line in name_tp:
                    f.write(str(line))
            time.sleep(1)
            continue

        elif choice == str(2):
            vali_data = input("Pls enter your name or TP number:")
            if vali_data in register_name or vali_data in register_TP: # validation on user input
                print(f"\nHello {vali_data}, You could proceed to select the apartment type")
                time.sleep(1)
                allocation(name_allocated,rooms_allocated,Type_A_infor,Type_B_info,A_single,B_single,B_master,vali_data,student_record)
                time.sleep(1)
                with open('name_allocated.txt','w') as f:
                    """store all the name_allocated data to txt file"""
                    f.write(str(name_allocated))

                with open('rooms_allocated','w') as f:
                    """store all the rooms_allocated data to txt file"""
                    f.write(str(rooms_allocated))

                allocation_zipped = list(zip(name_allocated,rooms_allocated))
                print(f"\nAllocation Room Record: {allocation_zipped}")
                time.sleep(1)
                print(F"\nAlocation Student Record {student_record}")
                time.sleep(2)
                with open('student_record.txt','w') as f:
                    """store all student allocation record to txt file"""
                    for key,value in student_record.items():
                        f.write(f"{key}:{value}")
            else:
                print("You haven't registered yet, pls register first in order to proceed with allocation")
                time.sleep(1)
            continue

        elif choice == str(3):
            if len(name_allocated) > 0: # if the name_allocated list is not empty
                total_deposit = len(name_allocated) * 100
                print(f"Total deposit collected:{total_deposit}RM")
            else:
                print("Sorry, there is no any allocation now, pls allocate first")
                time.sleep(1)
            continue

        elif choice == str(4):
            if len(name_allocated) > 0: # if the name_allocated list is not empty
                for item in name_allocated: 
                    total_amount += item['Total Bill'] # iterate name_allocated list to sum up each allocation's total bill amount
                total_amount -= len(name_allocated) * 100 # Substract total deposit amount from total_amount calculated above
                print(f"Total amount collected excluding the deposit:{total_deposit}RM")
                time.sleep(1)
            else:
                print("Sorry, there is no any allocation now, pls allocate first")
                time.sleep(1)
            continue

        elif choice == str(5): # the logic basically same as code below choice 4
            if len(name_allocated) > 0: # if the name_allocated list is not empty
                for item in name_allocated: 
                    total_amount += item['Total Bill'] # iterate name_allocated list to sum up each allocation's total bill amount
                print(f"Total amount receivable from the students:{total_deposit}RM")
                time.sleep(1)
                
            else:
                print("Sorry, there is no any allocation now, pls allocate first")
                time.sleep(1)
            continue

        elif choice == str(6):
            search_student(register_name,register_TP,name_allocated) # call for search function defined 
            continue

        elif choice == str(7):
            search_apartment(name_allocated,rooms_allocated)
            continue
        
        elif choice == str(0):
            print("Exit successfully")
            time.sleep(1)
            break

        else:
            print("Error! Pls enter the corrent integer between 1-7 ")
            time.sleep(1)
            continue
    return None
main()

