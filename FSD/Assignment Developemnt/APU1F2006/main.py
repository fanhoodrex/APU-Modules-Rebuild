import time,os # import python standard library
from functions import * # import all the user defined function written in functions.py

models = ['BS','AY','BR']
warehouses = ['WBS','WAY','WBR']
Part_ID = ['Part1','Part2','Part3']
sections=['ES','BWS','AS']
suppliers = []
total_quantity = {'Part1':0,'Part2':0,'Part3':0,'Part4':0,'Part5':0}
warehouse_dict={}
part_section = {}
Supplier_Details = [('p1', 'ES', 'fang'),('p2', 'BWS', 'marong'), ('p3', 'AS', 'chen')]


while True:
    menu() # call for menu function

    choice = int(input("Select your choice:"))
    if choice == 1: # Parts Inventory Creation in Warehouses
        Supplier_Details = list(Part_Creation(Part_ID,sections,suppliers)) # assign new zipped tupel list to variables
        print(Supplier_Details) # call for Part_Creationa and list the zipped tuple element
        simulate_warehouse(warehouses,Part_ID,total_quantity,warehouse_dict) # call for this functino function for simulate warehouse dict
        os.system("cls") # clear all the output screen for a clear sub-menu for Parts Inventory Creation in Warehouses
        time.sleep(1)
        print("All the warehouses inventory stuatus is shown below")
        for k,v in warehouse_dict.items():
            print(f"{k}:{v}")

    elif choice == 2: # Parts Inventory Update
        while True:
            ware_code = input("Enter warehosue code for updating:")
            if ware_code not in warehouses:
                print(f"Pls enter valid warehouse code within f{warehouses}")
                continue
            else:
                part_code = input("Which part should be updated?:")
                change_quantity = int(input("Enter the quantity of change, positive for increase, negative for decrease:"))        
                warehouse_dict[ware_code][part_code] += change_quantity # update the quantity in warehouse_dict
                total_quantity[part_code] += change_quantity # sync with total_quantity
                if input("Continue to update? 1.Yes, enter other key to finish:") == 1:
                    continue
                else:
                    break
    
    elif choice == 3: # Parts Inventory Tracking
        sel3 = int(input("1.Sort all parts by id in ascending order\n2.Show all the parts that have quantity less than 10 units"))
        if sel3 == 1:
            for key in sorted(total_quantity): # This will return a list containing the keys in sorted order then iterate through them
                print(f"{key}>{total_quantity[key]}")
        elif sel3 == 2: # Records of all parts that has stock quantity less than 10 units by warehouse
            for outkey,outvalue in warehouse_dict.items(): # return list containing all warehouses code
                for innerkey,innervalue in outvalue.items():
                    if innervalue < 10: # check inner value inside warehouse_dict by iteration
                        print(f"warehouse {outkey} has less than 10 quantity of {innerkey}")
        elif sel3 == 3:
            pass # iii. The parts and quantity provided to each assembly section by warehouse.
    
    elif choice == 4: # Searching Functionalities
        search(Part_ID,Supplier_Details) # pass in Part_ID and Supplier_Details parameter to search function 
            
    elif choice == 5: # Exit
        print("Exit the system successfully")
        break

    else:
        print("Pls enter ingeter between 1 and 5 !")
        time.sleep(2)
    os.system('cls') # clear all the output screen for main menu