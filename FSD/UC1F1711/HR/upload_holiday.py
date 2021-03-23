import time

def upload_holiday():
    """ HR's Function that used for Uploading Public and University Holidays,
    and store the holidays in dictionary of list data type afterward write it to plain text file. 
    Note: Dictionary Key is holidays name and the value is a list consisting of only start date and end date, 2 elements """

    PU_holidays = {} # initialize the empty FAQs dictionary 
    n = 1 # Declare the holiday counting number 

    while True:
        holiday_name = input(f"\nPls Enter the name for {n} Public and University Holidays and integer [-1] for exit:") # user input for holiday
        
        if holiday_name == str(-1): #Exit the Uploading
            print("Upload the Public and University Holidays and exit successfully!!! ")
            time.sleep(1)
            break

        else: # Enter the Leave holiday rule 
            holiday_range = [] # initialize the empty list for storing holidays range
            start_date = input(f"Enter starting date for {holiday_name} in YYYY-MM-DD form:")
            holiday_range.append(start_date)
            end_date = input(f"Enter ending date for {holiday_name} in YYYY-MM-DD form:")
            holiday_range.append(end_date)

            PU_holidays[holiday_name] = holiday_range # add the key,value pair to holiday dictionary
            print(f"\nsuccessfully add the {holiday_name} holiday and the current Public and University holidays shown as below\n")
            time.sleep(1)
            print(PU_holidays)
            n += 1
            continue
    
    with open("Public&University_Holidays.txt","w") as f: # write the policies to plain txt file
        for k,v in PU_holidays.items(): # iterate the holiday dictionary 
            f.write(f"{k}:{v}\n")
    
    return PU_holidays

