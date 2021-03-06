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
