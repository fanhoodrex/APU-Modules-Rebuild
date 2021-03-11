import pickle

import os

import pathlib

Menu = 0
admin_menu = 0


def Admin_Login():
    print("Admin Login")


def Admin_Menu():
    print("\n"
          "                          1: Login \n"
          "                          2: Viewing the new customer’s registration request\n"
          "                          3: Give approval to new customer \n"
          "                          4: Provide unique Loan ID to registered customer \n"
          "                          5: Viewing all transactions of specific customer \n"
          "                          6: Viewing all transactions of specific Loan type (EL/CL/HL/PL). \n"
          "                          7: Viewing all transaction of all customer \n"
          "                          8: Viewing all transaction of all types Loan \n"
          "                          9: Exit  \n ")

    int(input('Select Your Optional to enjoy the feature: '))


if admin_menu == 1:
    Admin_Login()


def New_Customer_Menu():
    print("\n"
          "                          1: Checking Loan detail. \n"
          "                          2: Calculate to check Loan Amount\n"
          "                          3: Information Registration \n"
          "                          4: Exit \n")

    int(input('Select Your Optional to enjoy the feature: '))


def Register_Customer():
    print("\n"
          "                          1: Login . \n"
          "                          3: Paying Loan Instalment \n"
          "                          4: Viewing  own transactions \n"
          "                          5: Checking the status of Loan. \n"
          "                          6: Exit \n")

    int(input('Select Your Optional to enjoy the feature: '))


while Menu < 4:
    print("\n"
          "@@@@@@@@@@@@@@@@@@@@  [1] Admin @@@@@@@@@@@@@@@@@@@@@@@\n"
          "@@@@@@@@@@@@@@@@@@@@  [2] Customer @@@@@@@@@@@@@@@@@@@@\n"
          "@@@@@@@@@@@@@@@@@@@@  [3] Register Customer @@@@@@@@@@@\n ")

    Menu = int(input('Select Your Optional to enjoy the feature: '))
    if Menu == 1:
        Admin_Menu()
    elif Menu == 2:
        New_Customer_Menu()
    elif Menu == 3:
        New_Customer_Menu()
    else:
        print('Thank You for using our System\nGood Bye!')
