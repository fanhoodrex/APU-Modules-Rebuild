print('''=================
Login
=================''')
username = input("Username:")  # Get username
password = int(input("Password:"))  # Get password
if username == "Jhon" and password == 123456:  # Judging the acquired content 
    from Student import RegisteredStudent    # From the Student folder, call the RegisteredStudent module
else:
    print("Wrong username and password")
