import time,os # import python standard library
from functions import * # import all the user defined function written in functions.py

while True:
    PartList = [] # the part list in local scope
    menu() # call for menu function

    choice = int(input("Select your choice:"))
    if choice == 1:
        while True:
            sel = int(input("\n1.Create Warehouses\n2.Create Assembly Sections\n3.Create part's detail\n0.Exit to main menu\nEnter:")) # Sub-menu for Parts Inventory Creation in Warehouses
            if sel == 1:
                Warehouses_CodeList = Warehouses_CodeList() # call for warehouse function and return the warehouses code list
            elif sel == 2:
                AssemblySections_CodeList = AssemblySections_CodeList() # call for assembly function and assign returned value to variable in local scope
            elif sel == 3:
                while True: # repeatedly create parts using while loop
                    single_part = Part() # call for Part function to create individual part
                    PartList.append(single_part) # append the single part detail to PartList
                    if int(input("\nDo you wanna add next part?:1.Yes 2.No\nEnter:")) == 1:
                        continue
                    else:
                        break # jump tp line 31
            elif sel == 0:
                break
            else:
                print("Pls enter integer within the range of [1,2,3]")
                time.sleep(1)
                continue

            os.system("cls") # clear all the output screen for a clear sub-menu for Parts Inventory Creation in Warehouses
            time.sleep(3)
            print("All the parts created are shown as below")
            for item in PartList: # iterate all the element in the PartList
                print(item)
                time.sleep(1)
    elif choice == 2:
        pass
    elif choice == 3:
        pass # Parts Inventory Tracking
    elif choice == 4:
        pass # Searching Functionalities
    elif choice == 5:
        print("Exit the system successfully")
        break
    else:
        print("Pls enter ingeter between 1 and 5 !")
        time.sleep(2)
    os.system('cls') # clear all the output screen for main menu