models = ['BS','AY','BR']
sections=['ES','BWS','AS']
warehouses = ['WBS','WAY','WBR']
# Total_Quantity = {'part1':0,'part2':0,'part3':0}
warehouse_dict = {}

for ware in warehouses:
    print(f"This the warehouse {ware}")
    innerdict = {} # inner dict
    for sec in sections:
        quantity = int(input(f"What is the initial quantity for {sec}:"))
        innerdict[sec] = quantity
    warehouse_dict[ware] = innerdict 
    print(warehouse_dict)

for k,v in warehouse_dict.items():
    print(f"{k}:{v}")