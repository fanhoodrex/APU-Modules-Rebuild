import time
# first design: creating part and its supplier at the same time each iteration
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

for item in Warehouses_CodeList():
    print(item)

IDList = []
SupplierList = []
TupleList = []
partid = 1 # initialize the partid counter as 1

num_part = int(input("Enter at least 5 parts under this warehouse\npart id::"))

while True:
    part_id = input(f"Enter the {partid} id for this parts: ")
    initial_quantity = int(input("How many is the initial quantity for this part?:")) # assign the initial quantity key/value for part dict
    Sname = input("Enther the supplier details for this part:")
    part_tuple = (part_id,initial_quantity,Sname) # using tuple to store part_id and part_intial quantity
    print(part_tuple)
    IDList.append(part_id) # append list
    SupplierList.append(Sname)
    TupleList.append(part_tuple)
    partid += 1 # counter plus one
    print(TupleList)

SupplierList.append(Sname)

# second design: creating parts first then create supplier for each part 
while True:
    part = input("To which par is thie supplier supply with?:")
    if part not in IDList:
        print("Sorry, you entered a invalid part id, pls enter again")
        continue

