import time

def getDailyService():
    """"read in AC number, labour charge and cost then store all these values in a list called service"""
    first = "first" # initialize the first, then replaced it with next after first input
    service = [] # initialize the empty service list in order to store all values

    for day in range(7):
        print(f"\nService done in day {day+1}")
        while True:
            AC_number = input(f"Enter {first} AC's number [-1 to end]:") # input string type
            if AC_number != str(-1):
                Labour_charge = float(input("Enter the labour charge:"))
                cost = float(input("Enter the cost of parts replaced:"))
                ser = [AC_number,Labour_charge,cost] # contribute to each individual list element
                service.append(ser) # append each individual list element to the service list
                first = "next" #change the "first" to "next"
            else:
                break
    return service

def calculateDailyBill(service):
    """Accept service list and calculate total bill for each AC for a particular day,
    each bill include 5% of gov tax and store the bill amount of each AC serviced for
    a particular day in a list called bill and return it"""
    bill = [] # initialize the empty list called bill, storing bill amount for each AC serviced for a particular day
    for service_ele in service:
        total = (service_ele[-1] + service_ele[-2]) * 1.05 # iterate the service list and sum up the labour_charge and cost replaced multiply 5% gov tax 
        bill.append(total) # append the total amount value to bill list
        # service[service.index(service_ele)] = total # using index to locate the list element and add the total value to the last in each list element
    return bill

def weeklyService():
    """Call the getDailyService function for 7 days and calling the
    calculatedDailyBill function after calling the getDailyService each time,
    in order to calculate the bill for every AC service in each day, finally 
    write every service and bill details in a "Weekly_Service.txt" file
    """
    service = getDailyService() # list of list
    time.sleep(1)
    bill = calculateDailyBill(service) # calculate the bill for every AC service in each day

    for item in service:
        index = service.index(item) # assign the index dynamic value for later on use
        append_total = bill[index] # get the corresponding total value for appending durint each iteration
        service[index].append(append_total) # appeng the value to each element in service list

    with open("Weekly_Service.txt",'w') as f: # opne file in write mode
        for ele in service:
            f.write(str(ele))
            f.write("\n")
            time.sleep(1)
    return None

weeklyService() # call for the main function


