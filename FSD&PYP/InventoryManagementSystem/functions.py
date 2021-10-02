import time

def menu():
    """function for displaying the menu"""
    print("Hello, This is the menu of UTOMOBILE PARTS INVENTORY MANAGEMENT SYSTEM")
    time.sleep(1)
    print("""
    1.Parts Inventory Creation in Warehouses
    2.Parts Inventory Update
    3.Parts Inventory Tracking
    4.Searching Functionalities
    5.Exit
    """)
    return None

def AssemblySections_CodeList():
    """function for creating assembly list containing assembly code """
    list_assembly = [] # initialize assembly_sections variable in local scope
    while True: # Loop validation that input numebr large must be at least three
        num_sections = int(input("How many assembly sections are there in total?:"))
        if num_sections < 3:
            print("Sorry, there should be at least 3 assembly sections in each warehouse")
            time.sleep(1)
            continue
        else:
            for num in range(num_sections):
                section = input(f"What is the {num+1} assembly section?:")
                list_assembly.append(section) # append individual section input to assembly sections list
            break
    return list_assembly

def Warehouses_CodeList():
    """function for creating list containing warehouse code"""
    list_warehouse = [] # initialize the empty list for warehouse code in local scope
    while True: # While Loop to enter the warehouses
        num_warehouses = int(input("How many warehouses are there in total?:"))
        if num_warehouses >= 3: # at least three warehouses
            for num in range(num_warehouses):
                warehouse = input(f"What is the {num+1} warehouse?:")
                list_warehouse.append(warehouse) # append individual section input to assembly sections list
            break
        else:
            print("Sorry, there should be at least 3 warehouses")
            time.sleep(1)
            continue
    time.sleep(1)
    print(f"Successfully create all warehouses:{list_warehouse}")
    return list_warehouse

def Part_Creation(Part_ID,sections,suppliers):
    """function for creating part and its assembly section and suppliers details at once iteration"""
    while True:
        P_id = input("What is the unique id for this part?:")
        Part_ID.append(P_id)
        Assem_name = input("What assembly section is this part used for:")
        sections.append(Assem_name)
        S_detail = input("what suppiler is this part by:")
        suppliers.append(S_detail)
        confirm_continue = int(input("Continue to enter next part? 1.Yes 2.No:"))
        if confirm_continue == 1:
            continue
        else:
            break
    return zip(Part_ID,sections,suppliers) # zip the three list into list of tuple

def simulate_warehouse(warehouses,Part_ID,total_quantity,warehouse_dict):
    """void function that simulate at least three warehouses and record at least 5 parts under each of them.
    access global variable and do calculation on them within this function"""
    for ware in warehouses: # iterate through warehouses list
        print(f"This is {ware} warehouse")
        innerdict = {} # inner dict for warehouses dict's value
        for part in Part_ID: # iterate through Part_ID list
            quantity = int(input(f"What is the initial quantity for {part}:"))
            innerdict[part] = quantity
            total_quantity[part] += quantity # add up tp total quantity
        warehouse_dict[ware] = innerdict # append innerdict into warehouse_dict
    return None

def search(Part_ID,Supplier_Details):
    while True:
        id_Search = input("Enter Part's ID for search and 0 for exit:")
        if id_Search not in Part_ID:
            print("Sorry, pls enter a valid Part ID")
        elif id_Search == str(0):
            break
        else:
            index = Part_ID.index(id_Search) # access the index number from Part_ID list
            supplier_name,part_name = Supplier_Details[index][2],Supplier_Details[index][0] # access the suppier detail and part it supplies
            print(f"{supplier_name} is the supplier {id_Search}")
    return None        