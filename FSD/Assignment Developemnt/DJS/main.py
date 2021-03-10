from Functions import *

while True:
    print("""
    "Welcome tp MEDILIFE HELATH INSURANCE SCHEME"
    1. Insurance Plan Subscription
    2. Claim Processing
    3. Accounts Information
    4. Searching Functionalities
    """)
    choice = int(input("Pls select (1-4),0 for quit:"))
    if choice == 1:
        Subscription()
        print("\n")
        print(id_list)
        print(name_list)
        print(subscribers)
    elif choice == 2:
        pass
    elif choice == 3:
        pass
    elif choice == 4:
        search()
        continue
    elif choice == 0:
        print("Quit successfully")
        break
    else:
        print("Invalid input, pls type in integer within 1-4")
        continue
