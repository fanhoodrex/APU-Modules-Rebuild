import json
#1.
#open the file called Hello world.json
def import_file():
    try:
        with open('Hello world.json') as f:
            return json.load(f)
    #seats with 10 for business and 40 for economy
    except FileNotFoundError:
        data = []
        for i in range(16):
            data.append([[[0]*10, [0]*40],[[0]*10, [0]*40],[[0]*10, [0]*40],[[0]*10, [0]*40]])
        return data
    
#save data as Hello world.json
def export_file(data):
    with open('Hello world.json','w') as f:
        json.dump(data,f)

data=import_file()
#2
#define M
def M():
    print('''FERRY TICKETING SYSTEM 
P – to Purchase Ticket
V – to View Seating Arrangement
Q – to Quit the system
''')
    x=input()
    return x

#define P
def P():
    print('''PURCHASING MODULE 
    B – to purchase ticket for Business class 
    E – to purchase ticket for Economy class
    M – to return to Main Menu''')
    y=input()
    return y


#define V
def V():
    while True:
        print('''
            Please select your schedule！
                Enter M to go back!
                
****************************************************
*   FERRY ID         ROUTE       SCHEDULE    TIME  *
****************************************************
* Ferry 1,2,3,4 Penang->Langkawi    0      10:00 AM*
* Ferry 5,6,7,8 Penang->Langkawi    1      11:00 AM*
* Ferry 1,2,3,4 Penang->Langkawi    2      12:00 AM*
* Ferry 5,6,7,8 Penang->Langkawi    3      01:00 PM*
* Ferry 1,2,3,4 Penang->Langkawi    4      02:00 PM*
* Ferry 5,6,7,8 Penang->Langkawi    5      03:00 PM*
* Ferry 1,2,3,4 Penang->Langkawi    6      04:00 PM*
* Ferry 5,6,7,8 Penang->Langkawi    7      05:00 PM*
* Ferry 5,6,7,8 Langkawi->Penang    8      10:00 AM*
* Ferry 1,2,3,4 Langkawi->Penang    9      11:00 AM*
* Ferry 5,6,7,8 Langkawi->Penang    10     12:00 AM*
* Ferry 1,2,3,4 Langkawi->Penang    11     01:00 PM*
* Ferry 5,6,7,8 Langkawi->Penang    12     02:00 PM*
* Ferry 1,2,3,4 Langkawi->Penang    13     03:00 PM*
* Ferry 5,6,7,8 Langkawi->Penang    14     04:00 PM*
* Ferry 1,2,3,4 Langkawi->Penang    15     05:00 PM*
****************************************************
''')
        t=input()
        if t == 'M':
            return t
        t = int(t)
        if t < 0 or t > 15:
            continue
        return t


#3
#find empty seat
def find_empty_seat(schedule,Class):

    for i in range(4):
        if Class == 'B':
            seats=schedule[i][0]
        else:# 'E'
            seats=schedule[i][1]

        for j in range(len(seats)):
            if seats [j]==0:
                return i,j
    return -1,-1

#4
#VEIW TICKET---V
from datetime import date

def print_seats(data,schedule_id,ferry_id, add = False):
    if add:
        n = 4
    else:
        n = 0
        
    b,e=data[schedule_id][ferry_id]
    stars='*'*41
    s=''
    s=s+stars+'\n'
    s=s+'*Ferry ID:'+str(ferry_id+n)+'             Date:'+date.today().strftime('%d %b %Y')+'*\n'
    s=s+stars+'\n'
    s=s+'*          Business class               *\n'
    s=s+stars+'\n'
    for j in range(2):
        for i in range(5):
            s=s+'*   '+str(b[j*5+i])+'   '
        s=s+'*      \n'
        s=s+stars+'\n'
    s=s+'*          Economy class                *\n'
    s=s+stars+'\n'
    for J in range(8):
        for I in range(5):
            s=s+'*   '+str(e[J*5+I])+'   '
        s=s+'*\n'
        s=s+stars+'\n'
    print(s)


#5    
#PRINT TICKET
def print_ticket(c, i,schedule_id,ferry_id):
    name = input('''
Please enter your name: ''')
    passport_no = input('Please enter your passport NO:')

    if schedule_id <= 7 and schedule_id % 2 or schedule_id > 7 and schedule_id % 2 == 0:
        ferry_id += 4
    
    print('********************************')
    print('*  You have purchase a ticket! *')
    print('*     Here is your ticket!     *')
    print('********************************')
    print('*     WELCOME TO THE TRIP!     *')
    print('********************************')
    print('*Schedule NO: {: <17}*'.format(schedule_id))
    print('*Ferry ID:    {: <17}*'.format(ferry_id+1))
    print('*Name:        {: <17}*'.format(name))
    print('*Passport NO: {: <17}*'.format(passport_no))
    print('*Seat Number: {: <17}*'.format(c + str(i+1)))
    print('********************************')
#6    
#purchase ticket
while True:
    userinput=M()
    
    if userinput=='P':
        while True:
            schedule_id = V()
            if schedule_id =='M':
                break
            

            print('Please select which kinds of class you want to purchase!')
        
            userinput=P()
            
            if userinput=='B':
                ferry_id,n=find_empty_seat(data[schedule_id], 'B')
                if n == -1:
                    print('''Business Class is full！                  
Press E to select an Economy seat！
Press M to return to the previous menu！
''')

                    
                    userinput=input()
                    if userinput=='E':
                        ferry_id,m=find_empty_seat(data[schedule_id], 'E')
                        if m==-1:
                            print('''            Ticket sold out for this hour!
               Next trip leaves in 1hour!
            Please select another schedule!''')
                        else:
                            print_ticket(userinput, m,schedule_id,ferry_id)
                            data[schedule_id][ferry_id][1][m]=1
                            export_file(data)
                    
                    else:
                        print('Sorry！Next trip leaves in 1 hour！')
                else:
                    print_ticket(userinput, n,schedule_id,ferry_id)
                    data[schedule_id][ferry_id][0][n]=1
                    export_file(data)
                
                
            elif userinput=='E':
                ferry_id,m=find_empty_seat(data[schedule_id], 'E')

                if m == -1:
                    print('''Economy Class is full！
                    Press B to select a Business seat！
                    Press M to return to the previous menu！
                    ''')
                    userinput=input()
                    if userinput=='B':
                        
                        ferry_id,n=find_empty_seat(data[schedule_id], 'B')
                        if n==-1:
                            print('''          Ticket sold out for this hour!
            Next trip leaves in 1hour!
            Please select another schedule!''')
                        else:
                            print_ticket(userinput, n,schedule_id,ferry_id)
                            data[schedule_id][ferry_id][0][n]=1
                            export_file(data)
                    else:
                        print('Sorry！Next trip leaves in 1 hour！')
                else:
                    print_ticket(userinput, m,schedule_id,ferry_id)
                    data[schedule_id][ferry_id][1][m]=1
                    export_file(data)
                
                
            elif userinput=='M':
                break
    elif userinput=='V':
        print('Please select your Schedule: ')
        schedule_id=V()
        if schedule_id=='M':
            continue
        ferry_id = int(input('Enter ferry ID: ')) 
        if ferry_id >4:
            ferry_id-=4
            add = True
        else:
            add = False
        print_seats(data,schedule_id,ferry_id,add)
                       
    elif userinput=='Q':
        print('Thank you for visiting! ')
        break
    else:
        print('Error')
print('Have a nice trip！')
