#######Car register. While entering the parking lot 
def Vehregister():
    vehtxtinit=open('./vehtemprecord.txt', 'a+',encoding='utf-8')
    vehtxtinit.close()
    vehsum=[]
    vehno=input('Please enter the Vehicle No\n')
    vehtype=''
    typechoose=int(input('Please choose the Vehicle type\n1.Motorcycle\n2.Car\n3.Van\n'))
    if typechoose==1:
        vehtype='Motorcycle'
    if typechoose==2:
        vehtype='Car'
    if typechoose==3:
        vehtype='Van'
    date=datetime.datetime.now()
    endate=('%s-%s-%s' %(date.year,date.month,date.day))
    enhour=int(input('Please enter the current hour(24h)\n'))
    enminute=int(input('Please enter the current minute(24h)\n'))
    os.system('cls')
    entime=('%s:%s'%(enhour,enminute))
    #######Car park lot detected
    tempread=open('./vehtemprecord.txt', 'r',encoding='utf-8')
    alltemplist=[]
    parklotlist=['Lot1-1','Lot1-2','Lot1-3','Lot2-1',
    'Lot2-2','Lot2-3','Lot3-1','Lot3-2','Lot3-3',
    'Lot3-4','Lot4-1','Lot4-2','Lot5-1','Lot5-2',
    'Lot6-1','Lot6-2','Lot7-1','Lot7-2','Lot7-3',
    'Lot7-4','Lot8-1','Lot8-2','Lot8-3','Lot9-1',
    'Lot9-2','Lot9-3','Lot10-1','Lot10-2','Lot10-3',
    'Lot10-4','Noparkinglot']
    for i in tempread:
        list1=eval(i)
        alltemplist.append(list1)
    existvehnum=len(alltemplist)
    #print(alltemplist)
    for i in range(existvehnum):
        while alltemplist[i][4] in parklotlist:
            parklotlist.remove(alltemplist[i][4])
    vehparklot=parklotlist[0]
    tempread.close()
    #################Car park lot detected ended
    Vehexitdate='Nodate'
    vehexittime='Notime'
    vehprice='Noprice'
    vehsum.append(vehno)
    vehsum.append(vehtype)
    vehsum.append(endate)
    vehsum.append(entime)
    vehsum.append(vehparklot)
    vehsum.append(vehexittime)
    vehsum.append(Vehexitdate)
    vehsum.append(vehprice)
    vehtxt=open('./vehtemprecord.txt', 'a+',encoding='utf-8')
    vehtxt.writelines(str(vehsum))
    vehtxt.write('\n')
    vehtxt.close()
    print('Welcome.')
    print('Vehicle No: '+vehsum[0])
    print('Vehicle type: '+vehsum[1])
    print('Enter time: '+vehsum[2]+' '+vehsum[3])
    print('Parking lot: '+vehsum[4])
    input('Press any key back to menu')
    os.system('cls')

############################
def Vehexit():
    alllist=[]
    vehno=input('Please enter Vehicle No to do action\n')
    vehtxt=open('./vehtemprecord.txt', 'r',encoding='utf-8')
    for i in vehtxt:  #######load txt data to list
        list1=eval(i)
        alllist.append(list1)
    existvehnum=len(alllist)
    for i in range(existvehnum):
        if alllist[i][0]==vehno:
            locatedata=i
            #print(locatedata)      
    vehtxt.close()
    date=datetime.datetime.now()
    exdate=('%s-%s-%s' %(date.year,date.month,date.day))
    exhour=int(input('Please enter the current hour(24h.exit)\n'))
    exminute=int(input('Please enter the current minute(24h.exit)\n'))
    extime=('%s:%s'%(exhour,exminute))
    alllist[locatedata][5]=extime
    alllist[locatedata][6]=exdate
    t1 = datetime.datetime.strptime(alllist[locatedata][3], '%H:%M')
    t2 = datetime.datetime.strptime(alllist[locatedata][5], '%H:%M')
    finalhour = t2-t1 ######float type
    exithour=finalhour.seconds/3600
    exithour=round(exithour,2) ###last hour count tag
    d1 = datetime.datetime.strptime(alllist[locatedata][2], '%Y-%m-%d')
    d2 = datetime.datetime.strptime(alllist[locatedata][6], '%Y-%m-%d')
    finalday=d2-d1
    exitday=finalday.days  ##last day count tag
    if alllist[locatedata][1]=='Motorcycle':  ######judge car type to pay
        if exitday>0:
            sumforday=3*1+2*3+20*1
            intexithour=int(exithour)
            decimalpart=exithour-float(intexithour)
            if decimalpart<0.10:  #judge the decimalpart whether more than 0.10
                sumforhour=intexithour*1
                sumpay=sumforday+sumforhour
            else:
                sumforhour=(1+intexithour)*1
                sumpay=sumforday+sumforhour
        if exitday==0:
            intexithour=int(exithour)
            decimalpart=exithour-float(intexithour)
            if 1.10>exithour>=0.00:
                sumpay=3
            if 4.10>exithour>=1.10:
                if decimalpart<0.10:
                    sumpay=3+(intexithour-1)*2
                else:
                    sumpay=3+intexithour*2
            if exithour>=4.10:
                if decimalpart<0.10:
                    sumpay=1*3+3*2+(intexithour-4)*1
                else:
                    sumpay=1*3+3*2+(intexithour-4+1)*1
    if alllist[locatedata][1]=='Car':  ######judge car type to pay
        if exitday>0:
            sumforday=5*1+3*3+2*20
            intexithour=int(exithour)
            decimalpart=exithour-float(intexithour)
            if decimalpart<0.10:  #judge the decimalpart whether more than 0.10
                sumforhour=intexithour*2
                sumpay=sumforday+sumforhour
            else:
                sumforhour=(1+intexithour)*2
                sumpay=sumforday+sumforhour
        if exitday==0:
            intexithour=int(exithour)
            decimalpart=exithour-float(intexithour)
            if 1.10>exithour>=0.00:
                sumpay=5
            if 4.10>exithour>=1.10:
                if decimalpart<0.10:
                    sumpay=5+(intexithour-1)*3
                else:
                    sumpay=5+intexithour*3
            if exithour>=4.10:
                if decimalpart<0.10:
                    sumpay=1*5+3*3+(intexithour-4)*2
                else:
                    sumpay=1*5+3*3+(intexithour-4+1)*2
    if alllist[locatedata][1]=='Van':  ######judge car type to pay
        if exitday>0:
            sumforday=8*1+4*3+3*20
            intexithour=int(exithour)
            decimalpart=exithour-float(intexithour)
            if decimalpart<0.10:  #judge the decimalpart whether more than 0.10
                sumforhour=intexithour*3
                sumpay=sumforday+sumforhour
            else:
                sumforhour=(1+intexithour)*3
                sumpay=sumforday+sumforhour
        if exitday==0:
            intexithour=int(exithour)
            decimalpart=exithour-float(intexithour)
            if 1.10>exithour>=0.00:
                sumpay=8
            if 4.10>exithour>=1.10:
                if decimalpart<0.10:
                    sumpay=8+(intexithour-1)*4
                else:
                    sumpay=8+intexithour*4
            if exithour>=4.10:
                if decimalpart<0.10:
                    sumpay=1*8+3*4+(intexithour-4)*3
                else:
                    sumpay=1*8+3*4+(intexithour-4+1)*3
    alllist[locatedata][7]=sumpay
    os.system('cls')
    print('Vehicle No: '+alllist[locatedata][0])
    print('Vehicle type: '+alllist[locatedata][1])
    print('Enter time: '+alllist[locatedata][2]+' '+alllist[locatedata][3])
    print('Parking lot: '+alllist[locatedata][4])
    print('Exit time: '+alllist[locatedata][6]+' '+alllist[locatedata][5])
    print('Fee: '+str(alllist[locatedata][7]))
    vehprtxt=open('./vehprrecord.txt', 'a+',encoding='utf-8')######Permanent record file
    vehprtxt.writelines(str(alllist[locatedata]))
    vehprtxt.write('\n')
    vehprtxt.close()
    del alllist[locatedata]
    os.remove('./vehtemprecord.txt') #####keep exist parking car information
    for i in alllist:
        tempw=open('./vehtemprecord.txt', 'a+',encoding='utf-8')
        tempw.writelines(str(i))
        tempw.write('\n')
        tempw.close()
    input('Press any key back to menu')
    time.sleep(2)
    os.system('cls')
########################Total amount from each type of vehicle
def Vehamount():
    vehtxt=open('./vehprrecord.txt', 'r',encoding='utf-8')
    carsum=0
    motosum=0
    vansum=0
    alllist=[]
    for i in vehtxt:  #######load txt data to list
        list1=eval(i)
        alllist.append(list1)
    existvehnum=len(alllist)
    for i in range(existvehnum):
        if alllist[i][1]=='Car':
            carsum=carsum+alllist[i][7]
        if alllist[i][1]=='Motorcycle':
            motosum=motosum+alllist[i][7]
        if alllist[i][1]=='Van':
            vansum=vansum+alllist[i][7]
    print('Total amount for Car: RM'+str(carsum))
    print('Total amount for Motorcycle: RM'+str(motosum))
    print('Total amount for Van: RM'+str(vansum))
    input('Press enter back to menu')
    os.system('cls')
######################
def Vehbillmore10():
    vehtxt=open('./vehprrecord.txt', 'r',encoding='utf-8')
    carcount=0
    alllist=[]
    for i in vehtxt:  #######load txt data to list
        list1=eval(i)
        alllist.append(list1)
    existvehnum=len(alllist)
    for i in range(existvehnum):
        if alllist[i][7]>10:
            carcount=carcount+1
    print('Total number of vehicles that has paid more than RM10: '+str(carcount))
    input('Press enter back to menu')
    os.system('cls')

####################
def Searchveh():
    alllist=[]
    vehno=input('Please enter Vehicle to search parking lot\n')
    vehtxt=open('./vehtemprecord.txt', 'r',encoding='utf-8')
    for i in vehtxt:  #######load txt data to list
        list1=eval(i)
        alllist.append(list1)
    existvehnum=len(alllist)
    for i in range(existvehnum):
        if alllist[i][0]==vehno:
            locatedata=i
            #print(locatedata)      
    vehtxt.close()
    os.system('cls')
    print('Vehicle No: '+alllist[locatedata][0])
    print('Vehicle type: '+alllist[locatedata][1])
    print('Enter time: '+alllist[locatedata][2]+' '+alllist[locatedata][3])
    print('Parking lot: '+alllist[locatedata][4])
    input('Press enter back to menu')
    os.system('cls')
##################3
def Vehmorethan4h():
    alllist=[]
    sumhour=0
    vehtxt=open('./vehtemprecord.txt', 'r',encoding='utf-8')
    for i in vehtxt:  #######load txt data to list
        list1=eval(i)
        alllist.append(list1)
    existvehnum=len(alllist)
    for i in range(existvehnum):
        locatedata=i
        #print(locatedata)      
        date=datetime.datetime.now()
        nowdate=('%s-%s-%s' %(date.year,date.month,date.day))
        nowtime=('%s:%s'%(date.hour,date.minute))
        alllist[locatedata][5]=nowtime
        alllist[locatedata][6]=nowdate
        t1 = datetime.datetime.strptime(alllist[locatedata][3], '%H:%M')
        t2 = datetime.datetime.strptime(alllist[locatedata][5], '%H:%M')
        finalhour = t2-t1 ######float type
        flhour=finalhour.seconds/3600
        flhour=round(flhour,2) ###last hour count tag
       #print(flhour)
        d1 = datetime.datetime.strptime(alllist[locatedata][2], '%Y-%m-%d')
        d2 = datetime.datetime.strptime(alllist[locatedata][6], '%Y-%m-%d')
        finalday=d2-d1
        flday=finalday.days  ##last day count tag
        #print(flday)
        sumhour=flday*24+int(flhour)
        if sumhour>4:
            print(alllist[locatedata][0])
    vehtxt.close()
    input('Press enter back to menu')
    os.system('cls')
