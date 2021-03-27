#LUO WENHAO
#TP054781
class Room:
    def __init__(self, type, monthly_rental, has_kitchen, has_laundry, internet_monthly_fee, apartment) -> None:
        super().__init__()
        self.type = type
        self.monthly_rental = monthly_rental
        self.has_kitchen = has_kitchen
        self.has_laundry = has_laundry
        self.internet_monthly_fee = internet_monthly_fee
        self.apartment = apartment
        self.student_tp = None

    def __str__(self) -> str:
        s = '\t({}){} ${:.2f}/Month  Internet ${:.2f}'.format('*' if self.student_tp == '' else 'x', self.type,
                                                              self.monthly_rental, self.internet_monthly_fee)
        if self.has_kitchen:
            s += ' has kitchen'
        if self.has_laundry:
            s += ' has laundry'
        return s


class Apartment:
    def __init__(self, apartment_type, rooms) -> None:
        super().__init__()
        self.apartment_type = apartment_type
        self.rooms = rooms

    def __str__(self) -> str:
        s = f'Apartment Type {self.apartment_type}, Rooms: {len(self.rooms)}\n'
        for room in self.rooms:
            s += '{}\n'.format(room)
        return s

class Student:
    def __init__(self, tp, name) -> None:
        super().__init__()
        self.tp = tp
        self.name = name
        self.checkin = False
        self.internet = False
        self.actualpayed = 0
        self.shouldpay = 0

    def __str__(self) -> str:
        return '{} {}'.format(self.tp, self.name)


class ManagementSystem:
    def __init__(self) -> None:
        super().__init__()
        self.students = []
        self.checkout_students = []
        self.apartments = []
        self.total_amount = 0
        self.total_deposit = 0

    def read_students(self, filename='students.txt'):
        self.students.clear()
        with open(filename) as fp:
            for line in fp:
                line = line.strip()
                if ',' not in line:
                    break
                parts = line.split(',')
                tp, name = parts
                stu = Student(tp, name)
                self.students.append(stu)

    def read_apartments(self, filename='apartments.txt'):
        self.apartments.clear()
        with open(filename) as fp:
            lines = fp.readlines()
            i = 0
            apartment = None
            while i < len(lines):
                line = lines[i].strip()
                if line == '':
                    break
                i += 1
                if apartment is None:
                    parts = line.split(',')
                    apartmenttype, roomcount = parts
                    roomcount = int(roomcount)

                    apartment = Apartment(apartmenttype, [])
                    self.apartments.append(apartment)
                    for r in range(roomcount):
                        line = lines[i + r].strip()
                        parts = line.split(',')
                        room_type, price, kitchen, laundry, internetfee, tp = parts
                        kitchen = bool(kitchen)
                        laundry = bool(laundry)
                        price = float(price)
                        internetfee = float(internetfee)

                        room = Room(room_type, price, kitchen, laundry, internetfee, apartment)
                        room.student_tp = tp
                        apartment.rooms.append(room)
                    i += roomcount
                    apartment = None

                pass
        pass

    def find_student(self, tp):
        for stu in self.students:
            if stu.tp == tp:
                return stu
        return None

    def find_available_room(self, apartment_type, room_type):
        for apartment in self.apartments:
            if apartment.apartment_type == apartment_type:
                for room in apartment.rooms:
                    if room.type == room_type and room.student_tp == '':
                        return room

    def check_in(self, tp, apartment_type, room_type, internet):
        stu = self.find_student(tp)
        room = self.find_available_room(apartment_type, room_type)
        if stu is None or stu.checkin:
            return False
        if room is None:
            return False

        stu.checkin = True
        stu.internet = internet
        room.student_tp = stu.tp

        c = input('pay full rental? (y/n) ').lower()
        if c == 'y':
            payed = (room.monthly_rental + (room.internet_monthly_fee if stu.internet else 0)) * 5
            stu.shouldpay = payed
            stu.actualpayed = payed
            self.total_amount += payed + 100 + 100
            self.total_deposit += payed + 100
            print('Payed full rental, RM{:.2f}, RM100.00 for first installation, RM100.00 for key'.format(payed))
        else:
            payed = (room.monthly_rental + (room.internet_monthly_fee if stu.internet else 0)) * 5 / 2
            stu.shouldpay = (room.monthly_rental + (room.internet_monthly_fee if stu.internet else 0)) * 5
            stu.actualpayed = payed
            self.total_amount += payed + 100 + 100
            self.total_deposit += payed + 100
            print('Payed half rental, RM{:.2f}, RM100.00 for first installation, RM100.00 for key'.format(payed))
        return True

    def check_out(self, tp, month):
        for apartment in self.apartments:
            for room in apartment.rooms:
                if room.student_tp == tp:
                    self.total_amount -= 100
                    stu = self.find_student(tp)
                    if stu.checkin:
                        stu.checkin = False
                        c = month * (room.monthly_rental + (room.internet_monthly_fee if stu.internet else 0))
                        if c < stu.actualpayed:
                            print('Return RM{:.2f}(rental) to student {}'.format(stu.actualpayed-c, tp))
                        elif c > stu.actualpayed:
                            print('Student {} payed RM{:.2f}(rental)'.format(tp, c-stu.actualpayed ))
                        print('Return RM100.00(deposit) to student {}'.format(tp))
                        return True

        return False

    def main_menu(self):
        while True:
            print('==========================')
            print('1. Show all rooms')
            print('2. Show all students')
            print('3. Check in student')
            print('4. Check out student')
            print('5. Exit')
            c = input('Choice: ')
            if c == '1':
                for apartment in self.apartments:
                    print(apartment)
            elif c == '2':
                for stu in self.students:
                    print(stu)
            elif c == '3':
                tp = input('Student tp: ')
                apartmentType = input('Apartment type: ')
                roomType = input('Room type: ')
                internet = input('Internet (y/n)? ').lower() == 'y'
                r = self.check_in(tp, apartmentType, roomType, internet)
                if r:
                    print('Check in success')
                else:
                    print('No suitable rooms found!')
            elif c == '4':
                tp = input('Student tp: ')
                m = int(input('Month: '))
                r = self.check_out(tp, m)
                if r:
                    stu = self.find_student(tp)
                    self.checkout_students.append(stu)
                    print('Check out success')
                else:
                    print('Check out failed!')
            elif c == '5':
                with open('checkout.txt', 'w') as fp:
                    for stu in self.checkout_students:
                        fp.write('{}\n'.format(stu))
                print('Total: {:.2f}, Total Withou Deposit: {:.2f}'.format(self.total_amount, self.total_deposit))
                break


if __name__ == '__main__':
    managesys = ManagementSystem()
    managesys.read_students()
    managesys.read_apartments()

    managesys.main_menu()