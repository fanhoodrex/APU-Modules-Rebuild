# ZHANG QUNHAO
# TP061415

print ('''Welcome to REAL CHAMPIONS SPORT ACADEMY SYSTEM 
Please select the type of account you want to log in:
1.Admin
2.Student''')
choice = int(input("Enter your choice:"))  # Get options 
if choice == 1:  # Judgment options 
    from Admin import Admin  # From the Admin folder, call the Admin module
else:
    print('''=================
Please select the system you want to log in
1.All students
2.Registered Student''')
    Choice = int(input("Enter your choice:"))  # Get options 
    if Choice == 1:  # Judgment options
        from Student import AllStudent  # From the Student folder, call the AllStudent module
    elif Choice == 2:
        from Student import LogIn  # From the Student folder, call the Login module
