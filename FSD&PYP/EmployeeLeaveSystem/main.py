def display(): # 进行登陆后界面的函数定义，方便在下面的选用层级后，返回上一层时，依然可以看到选择大屏。
    print("########################################################################")
    print("\t#########Welcome to this employee leave system!#########")
    print("\t\t#################################################")
    print("\n")
    print("\t\t\t1.Search.(you can search the infomation for employee!)\n")
    print("\t\t\t2.Add.(Add a user into this employee system!)\n")
    print("\t\t\t3.Delete.(Delete a user from this employee system!)\n")
    print("\t\t\t4.Show.(Show all employ's information!)\n")
    print("\t\t\t5.Quit.(quit this employee system!)\n")
    print("\n")

def search():
    search_name = input("please enter who want to search.... ")
    search_info = employ_list.get(search_name,"not found!")
    print("%s's information is %s"% (search_name, search_info))

def add():
    add_name = input("please enter who you what to add...")
    add_info = input("please enter this one's information...")
    employ_list[add_name] = add_info
    print("%s's information has been added!"% add_name)
    with open("employ_list.txt") as f:  
        for line in f:
            lines.append(line)

    lines.insert(1,"\'%s\':\'%s\'"%(add_name, add_info))
    s = "\n".join(lines)
    with open("employ_list.txt", "w") as f:
        f.write(s)

def delete():
    delete_name = input("please enter who you what to delete...")
    delete_info = employ_list.pop(delete_name)
    print("%s'information has been deleted!")
    with open("employ_list.txt") as f:  
        for line in f:
            lines.append(line)
    if "%s:%s"%(delete_name, delete_info) in lines:
        lines.remove("\'%s\':\'%s\'"%(delete_name, delete_info))
    s = "\n".join(lines)
    with open("employ_list.txt", "w") as f:
        f.write(s)

def show():
    for employ in employ_list:
        print(str(employ+":"+str(employ_list[employ])))
        
def main():
    while True:
        display()
        option = int(input("please enter you want to select items..."))
        if option == 1:
            search()
        elif option == 2:
            add()
        elif option == 3:
            delete()
        elif option == 4:
            show()
        elif option == 5:
            print("Thank you for use this employee system, write by mzh!")
            sys.exit()

if __name__ == "__main__":
    if not (os.path.isfile("employ_list.txt")):     
        with open("employ_list.txt","w") as f:
            f.write("{\n}")
    employ_list = eval(open("employ_list.txt", "r").read())
    lines = []
    main()