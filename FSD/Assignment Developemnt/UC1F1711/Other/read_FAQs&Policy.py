

def read_holidays():
    with open("Leave Policies.txt",'r') as f:
        print(f.read())
    return None

def read_FAQs():
    with open("Public&University_Holidays.txt",'r') as f:
        content = f.read()
        print(content)
    return None