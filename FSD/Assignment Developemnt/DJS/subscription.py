import time

while True:
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

while True:
    limit_type = input("What type of claim limit type do u want? Either Annual or Lifetime\n:") # try/except clause might needed to be used in user input 
    if limit_type == "Annual":
        print("Annual Claim Limit Subscription")
    elif limit_type == "Lifetime":
        print("Lifetime Claim Limit Subscription")
    else:
        print("Pls enter valid type of either Annual or Lifetime.")
        time.sleep(2)
        continue
    break

def subscriber_details():
    """input for subscriber details and write into txt file"""
    return None

def Subscription():
    id = 1 # global scope
    while True:
        name = input("What is your name?:")
        contact = input("What is your contact number?:")
        address = input("where is your address?:")
        HealthHistory = input("What is your health history?")
        id = id + 1

        print(f"subscriber's id is {id}")
        print(f"subscriber's name is {name}")
        print(f"subscriber's contact number is {contact}")
        print(f"subscriber's address is {address}")
        print(f"subscriber's health history is {HealthHistory}")

        with open("subscriber.txt",'a',encoding = 'utf-8') as f: # with-open clause to data into plain txt file
            f.write(f"The subscriber's name is {name}\n")
            f.write(f"The subscriber's contact number is {contact}\n")
            f.write(f"The subscriber's address is {address}\n")
            f.write(f"The subscriber's health history is {HealthHistory}\n")
        
        if input("Enter next subscriber details?: Type 1 for Yes & Other key for No") == 1:
            continue
        else:
            break
    return None