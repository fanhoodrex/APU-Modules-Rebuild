import time,os,datetime # import standard library in python
from functions import # import function written by programmer  

# Main
keep=True
print('Welcome to use car park system')
time.sleep(2)
os.system('cls')
while keep:
    print('1.New Vehicle entering register')
    print('2.Vehicle exit bill')
    print('3.Accounts Information')
    print('4.Searching')
    print('5.Shutdown')
    sec=int(input())
    if sec==1:
        os.system('cls')
        Vehregister()
        continue
    if sec==2:
        os.system('cls')
        Vehexit()
        continue
    if sec==3:
        seckeep3=True
        os.system('cls')
        while seckeep3:
            print('1.Show total amount collected from each vehicle type')
            print('2.Show total number of vehicles that has paid more than RM10.')
            print('3.Back')
            insec=int(input())
            if insec==1:
                os.system('cls')
                Vehamount()
                continue
            if insec==2:
                os.system('cls')
                Vehbillmore10()
                continue
            if insec==3:
                seckeep3=False
                os.system('cls')
        continue
    if sec==4:
        seckeep4=True
        os.system('cls')
        while seckeep4:
            print('1.Show Parking lot details')
            print('2.Show Vehicle registration number of vehicles parked for more than 4 hours.')
            print('3.Back')
            insec=int(input())
            if insec==1:
                os.system('cls')
                Searchveh()
                continue
            if insec==2:
                os.system('cls')
                Vehmorethan4h()
                continue
            if insec==3:
                seckeep4=False
                os.system('cls')
        continue
    if sec==5:
        keep=False