# Nurfarah Hafina
# TP062800
# import some API
import datetime
import random

# List define to use them in any functions inside to this project
Loan_information = []
Customer_Register = []
Customer_Login_Approval = []
Loan_Details = []
loginList = []
user_approved = []
user_rejected = []
pay_Loan = []
view_Own_Transaction = []
# Viewing Lists
transactions_of_specific_Customer = []
transactions_of_specific_Loan_type = []
transaction_of_all_customer = []
transaction_of_all_types_Loan = []
# Loan Type
EL_Loan_type = []
CL_Loan_type = []
HL_Loan_type = []
PL_Loan_type = []

# List extension
transaction_of_all_customer.extend(EL_Loan_type)
transaction_of_all_customer.extend(CL_Loan_type)
transaction_of_all_customer.extend(HL_Loan_type)
transaction_of_all_customer.extend(PL_Loan_type)


transaction_of_all_types_Loan.extend(EL_Loan_type)
transaction_of_all_types_Loan.extend(CL_Loan_type)
transaction_of_all_types_Loan.extend(HL_Loan_type)
transaction_of_all_types_Loan.extend(PL_Loan_type)

loan_status = []

# Declaring the Global variables to be use everywhere
startover = ""
global payLoanInstalmentAmount,Instalment_Amount,balance,status

# Main function to display to main menu of the project
def main():
    menu = 0
    while menu<5:
        print(" ")

        print("""\t\t\t\t  $$$$$$$$$$$$$$@@@@@@@@@@@@@@@@@@@@@@@$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"
                 "$                                                                           $"
                 "$		            Bank Management System		                              $"
                 "$                                                                           $"
                 "$$$$$$$$$$$$$$@@@@@@@@@@@@@@@@@@@@@@@$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"
                 """)
        print('\t\t\t\t\t\t  [1] Admin \n\t\t\t\t\t\t'
              '  [2] New Customer \n\t\t\t\t\t\t'
              '  [3] Register Customer \n\t\t\t\t\t\t'
              '  [4] Quit \n ')

        menu = int(input('\tSelect User Type: '))
        print('----------------------------------------------------------------------------------------------------')

        if menu == 1:
            Admin_Login()
            break
        elif menu == 2:
            New_Customer_Menu()
            break
        elif menu == 3:
            loginUser()
            break
        elif menu == 4:
            print("Thanks for using our Banking System! Bye! ")
            exit()
            break
        else:
            print("Invalid User Input")
        restart = input("Do You Wish to Continue(Y/N): ").lower()
        if restart == 'y':
            main()
        else:
            exit()

# admin login to access the features of the functionalities of this part
def Admin_Login():
    print('\n******************************* ADMIN LOGIN PAGE *********************************')
    print("\nPlease enter your details to log in")

    username = "admin"
    password = "admin"
    
    username = input("Please enter your username: ")
    password = input("Please enter your password: ")

    if username == password:
        print("Welcome!")
        Admin_Menu()
    else:
        print("Username and Password Does Not Match!")
        Admin_Login()

    print('\n-----------------------------------------------------------------------------------')

# admin menu to show as under menu of main menu to see the see the features of admin menu
def Admin_Menu():
    # initialise the variable
    adminMenu = 0
    while adminMenu<9:
        print('\n******************************* ADMIN MAIN MENU PAGE *********************************')
        print(
            "\t\t[1] Viewing Customer request \n\t\t[2] Giving approval \n\t\t[3] Providing  Loan information")
        print(
            "\t\t[4] viewing all transactions of specific customer\n\t\t[5] viewing all transactions of specific Loan "
            "type ")
        print(
            "\t\t[6] viewing all transaction of all customer\n\t\t[7] viewing all transaction of all types Loan "
            "\n\t\t[8] Exit\n")

        adminMenu = int(input('Select Your Optional to enjoy the feature: '))

        if adminMenu == 1:
            Viewing_Cus_Request()
            break
        elif adminMenu == 2:
            Giving_approval(loginList)
            break
        elif adminMenu == 3:
            Provide_Loan_information()
            break
        elif adminMenu == 4:
            viewing_all_transactions_of_specific_customer()
            break
        elif adminMenu == 5:
            viewing_all_transactions_of_specific_Loan_type()
            break
        elif adminMenu == 6:
            viewing_all_transaction_of_all_customer()
            break
        elif adminMenu == 7:
            viewing_all_transaction_of_all_types_Loan()
            break
        elif adminMenu == 8:
            print("Thanks for using our Banking System! Bye! ")
        else:
            print("Invalid User Input")

        restart = str(input("Do You Wish to Continue(Y/N): ").lower())
        if restart == 'y':
            Admin_Menu()
        else:
            main()

# viewing customer request function
def Viewing_Cus_Request():
    print('\n****************************** CUSTOMER REGISTRATION REQUESTS **********************************')
    if len(Customer_Login_Approval) == 0:
        print("No Customer Authentication Requests At The Moment!")
    else:
        print("\n\tUser ID \t\tCustomer Name \t\tUserName \t\tPassword \t\tAuthentication Status")
        for x in range(len(Customer_Login_Approval)):
            print('\t')
            print(Customer_Login_Approval[x],"\t",end="")
        print()
        Giving_approval(loginList)

    print('\n---------------------------------------------------------------------------------------------------')
    restart = str(input("Do You Wish to start the process again(Y/N): ").lower())
    if restart == 'y':
        Viewing_Cus_Request()
    else:
        Admin_Menu()

# Giving approval of customer after seeing customer request function
def Giving_approval(loginList):
    status = str(input("\n\n\tEnter Yes/No for the above Customer Registration Approvals (Y/N) : "))

    if status == "y":
        print("Registration Successfully approved")
        a = open("Login.txt", "a")
        user_approved = loginList
        a.write(str(user_approved))
        a.write('\n')
        a.close()
    elif status == "n":
        user_rejected = loginList
    else:
        print("Invalid User Input")
        Giving_approval(loginList)

    restart = str ( input ( "Do You Wish to start the process again(Y/N): " ).lower ( ) )
    if restart == 'y' :
        Giving_approval (loginList)
    else :
        Admin_Menu ()

# viewing all transactions of specific customer by using their ID
def viewing_all_transactions_of_specific_customer():
    print ( '\n******************************* VIEWING ALL TRANSACTIONS OF SPECIFIC CUSTOMER ************************************' )

    tr = open('transaction of all customers.txt','a')

    print ( "Below will show a list of  all transaction of transactions of specific customer " )
    print ( "It will print the loan type and the transaction Amount" )
    Auth = input ( "Enter your ID here to see  Own Transaction: " )
    if Auth in pay_Loan :
        print (transactions_of_specific_Customer)
    else :
        print ( "The ID you enter has no transaction in the System" )
    print ( "\n--------------------------------------------------------------------------------------------------" )
    restart = str ( input ( "Do You Wish to start again(Y/N): " ).lower ( ) )
    if restart == 'y':
        viewing_all_transactions_of_specific_customer()
    else:
        Admin_Menu()

# viewing all transactions of specific loan type by using their loan type
def viewing_all_transactions_of_specific_Loan_type():
    print ('\n******************************* VIEWING ALL TRANSACTIONS OF SPECIFIC LOAN TYPE ************************************')

    print("Below will show a list of the all transaction of specific Loan type ")
    print("It will print the loan type and the transaction Amount")

    transaction = input("Enter the transactions Type (EL/CL/HL/PL) : ")
    if transaction in EL_Loan_type:
        print("The transaction of this specific type is/are: " + str(EL_Loan_type))
    elif transaction in CL_Loan_type:
        print("The transaction of this specific type is/are: " + str(CL_Loan_type))
    elif transaction in HL_Loan_type:
        print("The transaction of this specific type is/are: " + str(HL_Loan_type))
    elif transaction in PL_Loan_type :
        print ( "The transaction of this specific type is/are: " + str(PL_Loan_type))
    else:
        print("Wrong Loan Type enter. Please enter a valid Loan Type")
        viewing_all_transaction_of_all_types_Loan()

    print ( "\n--------------------------------------------------------------------------------------------------" )

    restart = str ( input ( "Do You Wish to start again(Y/N): " ).lower ( ) )
    if restart == 'y' :
        viewing_all_transactions_of_specific_Loan_type ( )
    else :
        Admin_Menu()

# viewing all transactions of all customer  by printing all transactions
def viewing_all_transaction_of_all_customer():
    print ('\n******************************* VIEWING ALL TRANSACTIONS OF ALL CUSTOMER ************************************')

    tr = open('transaction of all customers.txt', 'a')

    print("Below will show a list of the all transaction of customers only the numbers")
    print(transaction_of_all_customer)
    tr.write(str(transaction_of_all_customer))
    tr.write('\n')
    tr.close()

    print ( "\n--------------------------------------------------------------------------------------------------" )

    restart = str ( input("Do You Wish to start again(Y/N): ").lower())
    if restart == 'y' :
        viewing_all_transaction_of_all_customer()
    else :
        Admin_Menu ( )


# viewing all transactions of all type loan by printing all type loan type
def viewing_all_transaction_of_all_types_Loan():
    print ('\n******************************* VIEWING ALL TRANSACTIONS OF ALL LOAN TYPE ************************************')
    tl = open('transaction of all loan type.txt','a')

    print(str(transaction_of_all_types_Loan))
    tl.write(str(transaction_of_all_types_Loan))
    tl.write('\n')
    tl.close()
    print ( "\n--------------------------------------------------------------------------------------------------" )

    restart = str ( input ( "Do You Wish to start again(Y/N): " ).lower ( ) )
    if restart == 'y' :
        viewing_all_transaction_of_all_types_Loan ( )
    else :
        Admin_Menu ( )


def Exit():
    print("Exit the Program")

# New Customer menu to show the under menu of new customer
def New_Customer_Menu():
    # initialise variable
    newCustomerMenu = 0
    while newCustomerMenu <= 4:
        print("\t\t[1] Checking Loan detail  \n\t\t[2] Calculate to check Loan Amount \n\t\t[3] Information "
              "Registration")
        print("\t\t[4] Exit\n")

        newCustomerMenu = int(input('Select Your Optional to enjoy the feature: '))

        if newCustomerMenu == 1:
            view_loan_details()
            break
        elif newCustomerMenu == 2:
            print(
                "\t\t[1] Educational Loan Calculator  \n\t\t[2] Home Loan Calculator  \n\t\t[3] Car Loan Calculator  ")
            print("\t\t\[4] Personal Loan Calculator \n")

            choice = int(input('Select Your Loan Type: '))
            if choice == 1:
                edu_loan_calculator()
                break
            elif choice == 2:
                home_loan_calculator()
                break
            elif choice == 3:
                car_loan_calculator()
                break
            elif choice == 4:
                personal_loan_calculator()
                break
            break
        elif newCustomerMenu == 3:
            customer_registration()
            break
        elif newCustomerMenu == 4:
            Exit()
            print("Thanks for using our Banking System! Bye! ")
        else:
            print("Invalid User Input")
        restart = str(input("Do You Wish to Continue(Y/N): ").lower())
        if restart == 'y':
            New_Customer_Menu()
        else:
            main()

# Seeing Loan details
def view_loan_details():
    print('\n******************************* LOAN DETAILS PAGE *********************************')
    print("\nloan Types We Offer: \n\t\t[1] Educational Loan - interest rate: 2.5%")
    print("\n\t\t[2] Home Loan - interest rate: 3.5%")
    print("\n\t\t[3] Car Loan - interest rate: 3.0%")
    print("\n\t\t[3] Personal Loan - interest rate 3.5 %")

    print('\n------------------------------------------------------------------------------------')
    restart = str(input("Do You Wish to Continue(Y/N): ").lower())
    if restart == 'y':
        view_loan_details()
    else:
        New_Customer_Menu()

# Function to calculate loan
def edu_loan_calculator():
    print('\n******************************* EDUCATIONAL LOAN CALCULATOR ************************************')

    amount = float(input("\nEnter Loan Amount (RM): "))
    duration = int(input("Enter Loan Duration (month): "))
    print("Interest Rate: 2.5% ")
    loan = float((amount*0.025)+amount)/float(duration)
    print("Your Monthly Installment would be: "+str(round(loan,2))+" RM")

    print("\n--------------------------------------------------------------------------------------------------")
    restart = str(input("Do You Wish to Continue(Y/N): ").lower())
    if restart == 'y':
        edu_loan_calculator()
    else:
        New_Customer_Menu()

# home loan function calculator
def home_loan_calculator():
    print('\n******************************* HOME LOAN CALCULATOR ************************************')

    amount = float(input("\nEnter Property Price(RM): "))
    downPayment = float(input("\nEnter Down Payment Amount(RM): "))
    duration = int(input("Enter Loan Duration (month): "))
    print("Interest Rate: 3.5% ")

    loanAmount = float(amount-downPayment)
    loan = (((loanAmount*0.035)+loanAmount)/float(duration))
    # lanInfo = ("Your loan has been calculated, the Amount is: "+ loan)
    print("Your Monthly Installment would be: "+str(round(loan,2))+" RM")
    print("\n--------------------------------------------------------------------------------------------------")
    restart = str(input("Do You Wish to Continue(Y/N): ").lower())
    if restart == 'y':
        home_loan_calculator()
    else:
        New_Customer_Menu()

# car loan function calculator
def car_loan_calculator():
    print('\n******************************* CAR LOAN CALCULATOR ************************************')

    amount = float(input("\nEnter Car Value(RM): "))
    downPayment = float(input("\nEnter Car Down Payment Amount(RM): "))
    duration = int(input("Enter Loan Duration (month): "))
    print("Interest Rate: 3.0% ")

    loanAmount = float(amount-downPayment)
    loan = (((loanAmount*0.03)+loanAmount)/float(duration))
    print("Your Monthly Installment would be: "+str(round(loan,2))+" RM")
    print("\n--------------------------------------------------------------------------------------------------")
    restart = str(input("Do You Wish to Continue(Y/N): ").lower())
    if restart == 'y' :
        car_loan_calculator ( )
    else :
        New_Customer_Menu ( )

# personal loan function calculator
def personal_loan_calculator():
    print('\n******************************* PERSONAL LOAN CALCULATOR ************************************')

    amount = float(input("\nEnter Personal Loan Amount(RM): "))
    duration = int(input("Enter Loan Duration (month): "))
    print("Interest Rate: 3.5% ")
    loan = float((amount*0.035)+amount)/float(duration)
    print("Your Monthly Installment would be: "+str(round(loan,2))+" RM")
    print("\n--------------------------------------------------------------------------------------------------")
    restart = str(input("Do You Wish to Continue(Y/N): ").lower())
    if restart == 'y' :
        personal_loan_calculator ()
    else :
        New_Customer_Menu ( )

def choices():
    print("Please choose what you would like to do.")
    choice = int(input("Choose Your Option between : \n\t\t1. Sign Up \n\t\t2. Login \n\tEnter Number:"))
    if choice == 1:
        return getCredentials()
    elif choice == 2:
        return loginUser()
    else:
        raise TypeError

# Customer registration function
def customer_registration():
    startOver = ""
    print('\n******************************* NEW CUSTOMER REGISTRATION ************************************')
    userID = input("Enter The User ID : ")
    print("Your User ID is: "+str(userID))
    for line in open ( "RegisterDetails.txt", "r+" ).readlines ( ):
        if userID in Customer_Register :
            print ( "ID already exist try with another ID!" )
            customer_registration()
    Customer_Register.append(userID)
    Customer_Login_Approval.append(userID)
    pay_Loan.append(userID)
    transactions_of_specific_Customer.append(userID)
    transaction_of_all_customer.append(userID)
    return getCredentials()

# customer credential getting
def getCredentials():
    f2 = open('LoginApproval.txt', "a")
    print("----------------Please fill in the information below to Register-------------------")
    username = input("Enter your username here: ")
    password = input("Enter your password here: ")
    rePassword = input("Re-Enter your password here: ")
    if rePassword != password:
        print("Password Doesnt Match!")
        print("Re-Enter Your Details!")
        getCredentials()
    else:
        f = open('RegisterDetails.txt', "a")
        l = open('loginDetails.txt', 'a')
        print("----------------Please fill in the information below to Register--------------------")
        name = input("Enter your name here: ")
        Customer_Register.append(name)
        Customer_Login_Approval.append(name)
        address = input("Enter your address here: ")
        Customer_Register.append(address)
        email = input("Enter your email here: ")
        Customer_Register.append(email)
        contact_Number = int(input("Enter your Contact here: "))
        Customer_Register.append(contact_Number)
        Gender = input("Enter your Gender (m/f): ")
        Customer_Register.append(Gender)
        date = input("Enter your date of Birth (dd/mm/yy): ")
        Customer_Register.append(date)
        loan_Type = input("Enter the loan type (EL/CL/PL/HL): ")
        if loan_Type =='EL':
            EL_Loan_type.append(loan_Type)
        elif loan_Type =='CL':
            CL_Loan_type.append(loan_Type)
        elif loan_Type =='HL':
            HL_Loan_type.append(loan_Type)
        elif loan_Type =='PL':
            PL_Loan_type.append(loan_Type)

        Customer_Register.append(loan_Type)
        loan_terms = int(input("Enter the loan terms here (Years): "))
        Customer_Register.append(loan_terms)
        Instalment_Amount = float(input("Enter Your Instalment Amount (RM): "))
        Customer_Register.append(Instalment_Amount)
        pay_Loan.append(Instalment_Amount)
        loan_status.append(Instalment_Amount)
        f.write(str(Customer_Register))
        f.write('\n')
        f.close()
        Customer_Login_Approval.append(username)
        Customer_Login_Approval.append(password)
        Customer_Login_Approval.append('pending')
        f2.write(str(Customer_Login_Approval))
        f2.write('\n')
        f2.close()
        loginList.append(username)
        loginList.append(password)
        l.write(str(loginList))
        l.write('\n')
        l.close()
        print('Registration Approval Request sent to Admin! Wait For Approval! ')
        print("\n--------------------------------------------------------------------------------------------------")
        restart = str(input("Do You Wish to Continue(Y/N): ").lower())
        if restart == 'y':
            customer_registration()
        else:
            New_Customer_Menu()

# Customer Register Menu
def Register_Customer():
    newRegisterCustomerMenu = 0

    while newRegisterCustomerMenu <= 6:
        print('\n******************************* CUSTOMER MAIN MENU ************************************')
        print(
            "\t\t[1] Checking Loan detail \n\t\t[2] Paying Loan Instalment \n\t\t[3] Viewing  own "
            "transactions")
        print("\t\t[4] Checking the status of Loan \n\t\t[5] Exit")
        newRegisterCustomerMenu = int(input('Select Your Optional to enjoy the feature: '))
        if newRegisterCustomerMenu == 1:
            checking_Loan_details()
            break
        if newRegisterCustomerMenu == 2:
            Pay_Loan_Instalment()
            break
        if newRegisterCustomerMenu == 3:
            view_own_Transactions()
            break
        if newRegisterCustomerMenu == 4:
            checking_loan_status()
            break
        print("\n--------------------------------------------------------------------------------------------------")
        restart = str(input("Do You Wish to Continue(Y/N): ").lower())
        if restart == 'y':
            Register_Customer()
        else:
            main()
# Function to help customer to login to the system
def loginUser():
    print('\n******************************* CUSTOMER LOGIN PAGE *********************************')
    print("\nPlease enter your details to log in")
    username = input("Please enter your username: ")
    password = input("Please enter your password: ")

    for line in open("RegisterDetails.txt", "r").readlines():
        if username in Register_Customer():
            if password in Register_Customer():
                print("Welcome!")
                Register_Customer()
        else:
            print("Username and Password Does Not Exist! or Registration Request Declined! \nPlease Call the Bank!")
            loginUser()

    print('\n-----------------------------------------------------------------------------------')

# Providing loan information for the customer
def Provide_Loan_information():

    print('\n******************************* PROVIDE LOAN INFORMATION ************************************')
    f = open('Loan Information.txt',"a")

    print("--------Registration Information Part----------")
    loan_id = input("Enter the loan ID here: ")
    print("Your Loan ID is: "+str(loan_id))
    for line in open ( "Loan Information.txt", "r" ).readlines ( ):
        if loan_id in Loan_Details :
            print ( "ID already exist try with another ID!" )
            Provide_Loan_information ( )

    Loan_information.append(loan_id)
    Loan_Details.append(loan_id)
    instalment_Date = input("Enter Instalment Date: ")
    Loan_information.append(instalment_Date)
    Loan_Details.append(instalment_Date)
    Instalment_Amount = input("Enter instalment Amount: ")
    Loan_information.append(Instalment_Amount)
    Loan_Details.append(Instalment_Amount)
    print("The information below is printed in list as: "+str(Loan_information))
    print("The list below will add more information about the customer Register")
    Customer_Register.extend(Loan_information)
    print(Loan_Details)
    f.write(str(Loan_Details)+"\n")
    f.write('\n')
    f.close()

    print("\n---------------------------------------------------------------------------------------------")
    restart = str(input("Do You Wish to Continue(Y/N): ").lower())
    if restart == 'y' :
        Provide_Loan_information()
    else:
        Admin_Menu()

# TO check loan details
def checking_Loan_details():
    print('\n******************************* CHECK LOAN DETAILS ************************************')
    Check_Loan = input("Enter ID of loan here to se the Loan details: ")
    if Check_Loan in Loan_Details:
        print(Loan_Details)
    else:
        print("ID enter does not exist in our System")

    print("\n-----------------------------------------------------------------------------------------")
    restart = str(input("Do You Wish to Continue(Y/N): ").lower())
    if restart == 'y':
        checking_Loan_details()
    else:
        Register_Customer()

# Function that will the customer to pay loan
def Pay_Loan_Instalment():
    print('\n******************************* PAY LOAN INSTALLMENT ************************************')
    Auth = input("Enter your ID here to see your loan instalment: ")
    if Auth in pay_Loan:
        print(pay_Loan)
        print("So you know how much you need to pay ")
        payLoanInstalmentAmount = input("Enter the value of the payment: ")
        print("Loan Amount Successfully Paid " + str(payLoanInstalmentAmount))
        view_Own_Transaction.append(payLoanInstalmentAmount)
        x_date = datetime.datetime.now()
        print("The Amount was paid at "+str(x_date))
        view_Own_Transaction.append(x_date)
        loan_status.append(payLoanInstalmentAmount)
        pay_Loan.append(payLoanInstalmentAmount)
        transactions_of_specific_Customer.append(payLoanInstalmentAmount)
        transaction_of_all_customer.append(payLoanInstalmentAmount)
        transaction_of_all_types_Loan.append(payLoanInstalmentAmount)
        EL_Loan_type.append(payLoanInstalmentAmount)
        CL_Loan_type.append(payLoanInstalmentAmount)
        HL_Loan_type.append(payLoanInstalmentAmount)
        PL_Loan_type.append(payLoanInstalmentAmount)


    else:
        print("Please Enter value superior than 0 to proceed : ")
    print("\n--------------------------------------------------------------------------------------------------")
    restart = str(input("Do You Wish to Continue(Y/N): ").lower())
    if restart == 'y':
        Pay_Loan_Instalment()
    else:
        Register_Customer()

# Function to display customer transaction
def view_own_Transactions():
    print('\n******************************* VIEW OWN TRANSACTION ************************************')
    print("----Showing Own Transaction-----")
    Auth = input("Enter your ID here to see  Own Transaction: ")
    if Auth in pay_Loan:
        print(view_Own_Transaction )

    else:
        print("The ID you enter has no transaction in our System")
    print("\n--------------------------------------------------------------------------------------------------")
    restart = str(input("Do You Wish to Continue(Y/N): ").lower())
    if restart == 'y':
        view_own_Transactions()
    else:
        Register_Customer()

# function to show the status of customer loan
def checking_loan_status():
    print('\n******************************* CHECK LOAN STATUS ************************************')
    print("The List below show the Instalment Amount and Instalment paid before ")
    print(loan_status)
    input("Enter the Instalment Amount as it show above")
    IA = float(input("Enter the Instalment Amount : "))
    PIA = float(input("Enter the Instalment Amount paid before: "))

    balance = IA-PIA
    print("Your Loan Status is : " + str(balance))
    print("\n-----------------------------------------------------------------------------------------")
    restart = str(input("Do You Wish to Continue(Y/N): ").lower())
    if restart == 'y':
        checking_loan_status()
    else:
        Register_Customer()


#system start
main()
