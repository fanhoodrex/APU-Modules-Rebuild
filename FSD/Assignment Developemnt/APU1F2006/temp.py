models = ['BS','AY','BR']
warehouses = ['WBS','WAY','WBR']
sections=['ES','BWS','AS']
Part_ID = ['Part1','Part2','Part3']
total_quantity = {'Part1':0,'Part2':0,'Part3':0,'Part4':0,'Part5':0}
warehouse_dict = {}
part_section = {}
# When testing the program, you should simulate at least three warehouses and record 
# at least 5 parts under each of them.
for ele in Part_ID:
    while True:
        section_used = input(f"What assembly section is {ele} used by?:")
        if section_used in sections:
            part_section[ele] = section_used
            break
        else:
            print("Pls enter corrent assemblt section")
            continue
print(part_section)

for ware in warehouses:
    print(f"This the warehouse is {ware}")
    innerdict = {} # inner dict for warehouses dict's value
    for part in Part_ID:
        quantity = int(input(f"What is the initial quantity for {part}:"))
        innerdict[part] = quantity
        total_quantity[part] += quantity # add up tp total quantity
    warehouse_dict[ware] = innerdict
    print(warehouse_dict)

for k,v in warehouse_dict.items():
    print(f"{k}:{v}")
print(total_quantity)

# Initial quantity of each parts and the assembly section they are used by need to be 
# recorded in parts inventory file(s)


