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

def update():
    """update the quantity of parts in warehouse"""
    pass

def check(part):
    """check for available quantity in warehouse"""
    pass

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
        if num_warehouses >= 3:
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


def Part():
    """Function for creating individual part element"""
    part_details = {} # initialize part variable in local scope
    assembly_key = [] # initialize assembly_key variable in local scope
    warehouse_key = [] # initialize warehouse_key variable in local scope

    part_details['id'] = input("What is the unique id should be given for this parts?: ") # assign the unique id key/value for part dict
    part_details['initial_quantity'] = int(input("How much is the initial quantity for this part?:")) # assign the initial quantity key/value for part dict
    part_details['supplier'] = input("Enter the supplier for this part, leave space if supplier is excluded:") # assign the supplier key/value for part dict
    
    while True: # while loop for selecting those warehouses with which the each part are supplied 
        print(Warehouses_CodeList)
        ware_input = input("What warehouses is this part under? Enter 0 to finish:")
        if ware_input == str(0):
            break
        else:
            warehouse_key.append(ware_input)
            continue
            time.sleep(1)
    part_details['warehouse'] = warehouse_key # assign the warehouse list as value to the warehosue key in part dict

    while True: # while loop for selecting those assembly sections with which the each part are supplied 
        print(AssemblySections_CodeList)
        section_input = input("What assambly sections is this part supplied with, Enter 0 to finish:")
        if section_input == str(0):
            break
        else:
            assembly_key.append(section_input)
            continue
            time.sleep(1)
    part_details['assembly section'] = assembly_key # assign the assembly sections as value to the assembly section key in part dict

    time.sleep(1)
    print(f"""Successfully created a single part, shown as below
-----------------------------------------------------------------
{part_details}""") # use f-string with triple quotation
    return part_details
