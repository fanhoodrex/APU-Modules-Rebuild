seats = [] # global initiative

def getSeatDetails():
    """reads in seat's type and number of seats required"""
    # global seats # access the global variable in local context
    seat_type = str(input("Enter seat type [A for 'SofaForTwo' or B for 'Single]:'"))
    seats.append(seat_type)
    seat_num = int(input("Enter number of seat:"))
    seats.append(seat_num)
    return None 

def recordSeatDetails(seats):
    """Accept seats list and write the items of list into text file"""
    with open('ticket1.txt ','w') as f:
        for seat in seats:
            f.write(str(seat))
            f.write("\n")
    return None

def printTicket():
    """main funciton called for 5 customers"""
    for i in range(5):
        """store all the values first then write to file afterward"""
        getSeatDetails()
        print(seats)
    recordSeatDetails(seats) # one parameter is in local scope, the other is in global scope
    return None

printTicket() # call for main function
