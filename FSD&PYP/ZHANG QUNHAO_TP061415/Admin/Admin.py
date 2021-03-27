print ('''=================
Login
=================''')
admin_name = input ("Username:")  # Get username 
admin_password = int (input("Pasword:"))  # Get password
if admin_name == "Mike" and admin_password == 123456:  # Judging the acquired content 
    print ('''Welcome back, Mike
=================
1.Add Record
2.Display All Record
3.Search Specific Record
4.Sort and Display Record
5.Modify Record
6.Exit''')
    admin_choice = int (input("Enter your choice:"))#Get options 
    if admin_choice == 1:  # Judgment options
        from Admin import AddRecord  # From the Admin folder, call the AddRecord module
    elif admin_choice == 2:
        from Admin import DisplayAllRecord  # From the Admin folder, call the DisplayAllRecord module
    elif admin_choice == 3:
        from Admin import SearchSpecificRecord  # From the Admin folder, call the SearchSpecificRecord module
    elif admin_choice == 4:
        from Admin import SortAndDisplayRecord  # From the Admin folder, call the SortAndDisplayRecord module
    elif admin_choice == 5:
        from Admin import ModifyRecord  # From the Admin folder, call the ModifyRecord module
else:
    print ('''=================
Wrong username or password''')
