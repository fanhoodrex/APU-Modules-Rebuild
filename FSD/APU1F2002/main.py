# HE XIAOFENG
# TP059887
import csv,os,time
from functions import *
import time

def main():
    zone1=['A','B','C','D'] # initialize list variable zone1, group1 and tt in local scope
    group1=['ATO','ACC','AEO','SID','AHS']
    tt=['T1','T2','T3']
    print('Welcome to use COVID-19 management system Please login')
    while True:
        pwd = int(input('enter password:'))
        if pwd == 123: # password for root user is 123
            break
            time.sleep(1)
            print('welcome root')
            os.system('cls') # os module to clear the screen
        else:
            print('invalid password, pls enter password again')
            continue

    data = [] #initialize empty data list
    temp_data = []

    f = open('patient_data.txt', 'w', newline='')
    writer = csv.writer(f) # writer.writerow(['id','name', 'phone', 'mail', 'zone', 'group','testTimes', 'height','confirmed'])
    f.close()

    f = open('record_data.txt', 'w', newline='')
    writer = csv.writer(f) # writer.writerow(['id','test_period','ends','zone','group'])
    f.close()

    f = open('confirmed_data.txt', 'w', newline='')
    writer = csv.writer(f)# write.writerow([id, test, zone, group, ward, state, conid,name])
    f.close()
    
    operation = menu() # the numeric selection for menu
    
    while (operation != '0'):
        if operation == '1':
            id = get_rol()
            print('please input patient\'s  name phone mail zone group and height:')

            name = input('name')
            phone = input('phone')
            mail = input('mail')
            zone='0'
            while zone not in zone1:
                zone = input('zone for A,B,C,D:')
            group='0'
            while group not in group1:
                group = input('group for ATO ACC AEO SID AHS')
            testTimes = 'T0'
            height = input('height')
            confirmed = '0'
            insert([id, name, phone, mail, zone, group, testTimes, height, confirmed])
            operation = menu()
        elif operation == '2':
            print('please input patient\'s id test_period ends:')

            id = input('id')
            test='0'
            while test not in tt:
                test = input('test for T1 T2 T3')
            boolend=['0','1']
            end='sssss'
            while end not in boolend:
                end = input('end for 1 or 0')
            print(id, test, end)
            if search(id):
                if (findCon(id)):
                    print('Confirmed the patient should not be tested')
                    operation = menu()
                tNum = findtest(id)
                if ((tNum == "T0" and test == "T1") or (tNum == "T1" and test == "T2") or (
                        tNum == "T2" and test == "T3")):

                    zone, group = get_data(id)
                    setinsert(id, test, end)
                    record([id, test, end, zone, group])
                    get_ends(test, end, group)
                    if (end == '1'):
                        ward = input('The patient has been confirmed, please will arrange in the NM or ICU')
                        state = 'ACTIVE'
                        conid = confirmedId()
                        print('Cases of the patients with ID:', conid)
                        name=findname(id)
                        wConfirmed([id, test, zone, group, ward, state, conid,name])
                else:
                    print('Before the patient didn\'t finish the test, the order according to the patient\'s detection')
                    print('Now the patient has completed testing %s' % tNum)
                    operation = menu()
            else:
                print('Don\'t find this id,please try it again!\n')
            operation = menu()
        elif operation == '3':
            print('Please enter the patient ID and the modified state:')

            id = input('id')
            state = input('state')
            if (findConId(id)):
                setState(id, state)
            else:
                print('I\'m sorry, but we didn\'t find the patient, should be confirmed yet')
            operation = menu()
        elif operation == '4':
            printsum = menu1()
            while (printsum != '0'):
                if (printsum == '1'):
                    getTestSum()
                    printsum = menu1()
                elif (printsum == '2'):
                    getTestName()
                    printsum = menu1()
                elif (printsum == '3'):
                    getRestore()
                    printsum = menu1()
                elif (printsum == '4'):
                    getZoneNum()
                    printsum = menu1()
                elif (printsum == '5'):
                    getACZoneNum()
                    printsum = menu1()
            operation = menu()
        elif operation == '5':
            printsum = menu2()
            while (printsum != '0'):
                if (printsum == '1'):
                    name=input('check the patient record by name')
                    getname(name)
                    printsum = menu2()
                elif(printsum == '2'):
                    id=input('case ID:')
                    findcase(id)
                    printsum = menu2()
                elif(printsum == '3'):
                    getdel()
                    printsum = menu2()
                else:
                    printsum = menu2()
            operation = menu()

if __name__ == '__main__':
    main()

