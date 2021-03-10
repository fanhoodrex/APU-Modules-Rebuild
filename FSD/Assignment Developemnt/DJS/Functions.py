import time
id_list = []
name_list = []
subscribers = []

id = 1 # global scope
def subscriber_dict():
    """add each subscriber details to dictionary type value"""
    pass

def Subscription():
    """input for subscriber details and write into txt file"""
    global id
    indiv_subscriber = {} # Empty dictionary

    while True: # The upper while-True loop
        name = input("What is your name?:")
        while True: # inner while true loop to validate the age
            age = int(input("What is your age?:")) # try/except clause might needed to be used in user input 
            if 15 <= age <= 25: # all of three plans are applicable
                print("""Below is the plan and benefits apply to your age group
                
                Plan > Plan150(RM) | Plan200(RM) | Plan300(RM)
                Monthly Premium > 150 | 200 | 300
                Annual Claim Limit > 100,000 | 200,000 | 300,000
                Lifetime Claim Limit > 500,000 | 1,000,000 | 2,000,000
                
                Benefit > Plan150 | Plan200 | Plan300
                Room Charges > 150/day | 200/day | 300/day
                Intensive Care Unit (ICU) Charges > 300/day | 500/day | 900/day
                Hospital Supplies and Services > As charged. Subject to approval by EZMediLife.
                Surgical Fees > As charged. Subject to approval by EZMediLife.
                Other Fees > As charged. Subject to approval by EZMediLife.
                """)
            elif 26 <= age <= 35: # both plan200&plan300 are applicable
                print("""Below is the plan and benefits apply to your age group
                
                Plan > Plan200(RM) | Plan300(RM)
                Monthly Premium > 200 | 300
                Annual Claim Limit > 200,000 | 300,000
                Lifetime Claim Limit > 1,000,000 | 2,000,000
                
                Benefit > Plan200 | Plan300
                Room Charges > 200/day | 300/day
                Intensive Care Unit (ICU) Charges > 500/day | 900/day
                Hospital Supplies and Services > As charged. Subject to approval by EZMediLife.
                Surgical Fees > As charged. Subject to approval by EZMediLife.
                Other Fees > As charged. Subject to approval by EZMediLife.
                """)
            elif 36 <= age <= 50: # only plan300 are applicable
                print("""Below is the plan and benefits apply to your age group
                
                Plan > Plan300(RM)
                Monthly Premium > 300
                Annual Claim Limit > 300,000
                Lifetime Claim Limit > 2,000,000
                
                Benefit > Plan300
                Room Charges > 300/day
                Intensive Care Unit (ICU) Charges > 900/day
                Hospital Supplies and Services > As charged. Subject to approval by EZMediLife.
                Surgical Fees > As charged. Subject to approval by EZMediLife.
                Other Fees > As charged. Subject to approval by EZMediLife.
                """)
            else:
                print("Pls enter valid age between 15 and 50 !")
                time.sleep(2)
                continue
            break
        contact = input("What is your contact number?:")
        address = input("where is your address?:")
        healthHistory = input("What is your health history?")
        while True: # inner while true loop to validate the claim limit type
            limit_type = input("What type of claim limit type do u want? Either 'Annual' or 'Lifetime':") # try/except clause might needed to be used in user input 
            if limit_type == "Annual":
                print("Subscript to Annual Claim Limit successfully !")
            elif limit_type == "Lifetime":
                print("Subscript to Lifetime Claim Limit Subscription successfully !")
            else:
                print("Pls enter valid type of either 'Annual' or 'Lifetime'.")
                time.sleep(2)
                continue
            break

        indiv_subscriber['id'] = id
        indiv_subscriber['name'] = name
        indiv_subscriber['age'] = age
        indiv_subscriber['contact'] = contact
        indiv_subscriber['address'] = address
        indiv_subscriber['health history'] = healthHistory
        
        print(f"\nsubscriber's id is {id}")
        print(f"subscriber's name is {name}")
        print(f"subscriber's age is {age}")
        print(f"subscriber's contact number is {contact}")
        print(f"subscriber's address is {address}")
        print(f"subscriber's health history is {healthHistory}")
        print(f"subscriber's claim limit type is {limit_type}")

        with open("subscriber.txt",'w',encoding = 'utf-8') as f: # with-open clause to write data into txt file
            f.write(f"The subscriber's id is {id}\n")
            f.write(f"The subscriber's name is {name}\n")
            f.write(f"subscriber's age is {age}")
            f.write(f"The subscriber's contact number is {contact}\n")
            f.write(f"The subscriber's address is {address}\n")
            f.write(f"The subscriber's health history is {healthHistory}\n") 
            f.write(f"subscriber's claim limit type is {limit_type}\n\n")

        id_list.append(id)
        name_list.append(name)
        subscribers.append(indiv_subscriber)

        id = id + 1 # increment of the id
        if input("\nEnter next subscriber details?: Type 1 for Yes & Other key for No:") == str(1):
            continue
        else:
            break
    return None

def search():
    """The function should have options to search for a subscribers record by name or id: """
    id_name = input("pls enter subscriber's name:")
    if id_name in name_list:
        print(subscribers[id_name.index(id_name)]) # access the key/value element in dictionary
    else:
        print("Sorry, the subscriber with this id/name doesn't exist.\n")
        time.sleep(1)
    return None