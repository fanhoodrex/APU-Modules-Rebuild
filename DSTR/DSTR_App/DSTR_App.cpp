#include <cstdlib>
#include <iostream>
#include <string>
#include <iomanip>
#include <regex>
#include <sstream>
#include <vector>
#include "PatientStruct.h"

regex int_rule("(\\+|-)?[[:digit:]]+");

void init();
void returnToHome();
void sortedPatientListByPriorityOrder();
void display();
void AddPatient();

void init() {
	int choice = 0;
	bool invalid = true;
	while (choice != 14) {
		system("CLS");
		cout << "Please select your options!" << endl;
		cout << "1. Add an Patient Record" << endl;
		cout << "2. Display patient priority waiting list" << endl;
		cout << "3. Display patient original waiting list" << endl;
		cout << "10. Exit" << endl;
		cout << "Please enter the choice you wish to proceed" << endl;
		cin >> choice;
		if (!cin.good()) {
			exit(0);
		}
		switch (choice) {
		case 1:
			system("CLS");
			AddPatient();
			break;
		case 2:
			system("CLS");
			sortedPatientListByPriorityOrder();
			returnToHome();
		case 3:
			system("CLS");
			display();
			returnToHome();
			break;
		case 10:
			exit(0);
			break;
		}
	}
}

void returnToHome() {
	cout << "--------------------------------" << endl;
	cout << "If you would like to go back Homepage, simply press the 0" << endl;
	bool flag = false;
	do {
		string strSlt;
		cin >> strSlt;
		if (regex_match(strSlt, int_rule)) {
			int slt = stoi(strSlt.c_str());
			if (slt == 0) {
				flag = true;
				system("CLS");
				init();
			}
			else {
				flag = false;
				cout << "Please enter 0 to back to home page" << endl;
			}
		}
		else {
			flag = false;
			cout << "Invalid input; please re-enter." << endl;
		}
	} while (!flag);
}

void insertPatientIntoLinkedList(int patientId, string fullName, int patientAge, string gender, string phone, string address, string sicknessDescription, int isDisable, string medicineInformation) {
	Pat = new Patient(patientId, fullName, patientAge, gender, phone, address, sicknessDescription, isDisable, medicineInformation,"-");
	Pat->next = NULL;
	Pat->previous = NULL;
	if (head == NULL) {
		head = tail = Pat;
	}
	else {
		tail->next = Pat;
		Pat->previous = tail;
		tail = Pat;
	}
}

void display() {
	temp = head;
	if (temp == NULL) {
		cout << "There's no available records in the system yet!" << endl << endl;
		return;
	}
	cout << left << setw(5) << "ID" << internal << setw(25) << "Name" << internal << setw(15) << "isDisable" << internal << setw(15) << "Phone" << internal << setw(15) << "Age" << internal << setw(15) << "Gender" << internal << setw(15) << "Address" << internal << setw(15) << "Sickness" << internal << setw(15) << "Medicine" << internal << setw(15) << "Doctor" << '\n';
	while (temp != NULL) {
		cout << left << setw(5) << temp->patientId << internal << setw(25) << temp->fullName << internal << setw(15) << temp->isDisable << internal << setw(15) << temp->phone << internal << setw(15) << temp->patientAge << internal << setw(15) << temp->gender << internal << setw(15) << temp->address << internal << setw(15) << temp->sicknessDescription << internal << setw(15) << temp->medicineInformation << internal << setw(15) << temp->doctorName << '\n';
		cout << endl;
		temp = temp->next;
	}
}

void InsertintosortedPatientList(int patientId, string fullName, int patientAge, string gender, string phone, string address, string sicknessDescription, int isDisable, string medicineInformation, string doctorName) {
	Pat = new Patient;
	Pat->patientId = patientId;
	Pat->fullName = fullName;
	Pat->patientAge = patientAge;
	Pat->gender = gender;
	Pat->phone = phone;
	Pat->address = address;
	Pat->sicknessDescription = sicknessDescription;
	Pat->isDisable = isDisable;
	Pat->medicineInformation = medicineInformation;
	Pat->doctorName = doctorName;
	Pat->previous = NULL;
	Pat->next = NULL;
	if (sortedHead == NULL) {
		sortedHead = Pat;
		sortedTail = Pat;
	}
	else {
		sortedTail->next = Pat;
		Pat->previous = sortedTail;
		sortedTail = Pat;
	}
}

void disposeUsedPointer() {
	sortedTemp = sortedHead;
	while (sortedTemp != NULL) {
		sortedHead = sortedTemp->next;
		delete sortedTemp;
		sortedTemp = sortedHead;
	}
}

void displaySortedList() {
	sortedTemp = sortedHead;
	if (sortedTemp == NULL) {
		cout << "There's no available records in the system yet!" << endl << endl;
		return;
	}
	cout << left << setw(5) << "ID" << internal << setw(25) << "Name" << internal << setw(15) << "isDisable" << internal << setw(15) << "Phone" << internal << setw(15) << "Age" << internal << setw(15) << "Gender" << internal << setw(15) << "Address" << internal << setw(15) << "Sickness" << internal << setw(15) << "Medicine" << internal << setw(15) << "Doctor" << '\n';
	while (sortedTemp != NULL) {
		cout << left << setw(5) << sortedTemp->patientId << internal << setw(25) << sortedTemp->fullName << internal << setw(15) << sortedTemp->isDisable << internal << setw(15) << sortedTemp->phone << internal << setw(15) << sortedTemp->patientAge << internal << setw(15) << sortedTemp->gender << internal << setw(15) << sortedTemp->address << internal << setw(15) << sortedTemp->sicknessDescription << internal << setw(15) << sortedTemp->medicineInformation << internal << setw(15) << sortedTemp->doctorName << '\n';
		cout << endl;
		sortedTemp = sortedTemp->next;
	}
	disposeUsedPointer();
}

void sortedPatientListByPriorityOrder() {
	if (head == NULL) {
		cout << "There's no available patient in the system!" << endl;
		return;
	}
	sortedHead = NULL;
	sortedTail = NULL;
	temp = head;
	int swapped;
	Patient* firstPtr;
	Patient* lastPtr = NULL;
	while (temp != NULL) {
		InsertintosortedPatientList(temp->patientId, temp->fullName, temp->patientAge, temp->gender, temp->phone, temp->address, temp->sicknessDescription, temp->isDisable, temp->medicineInformation, temp->doctorName);
		temp = temp->next;
	}
	do {
		swapped = 0;
		firstPtr = sortedHead;
		while (firstPtr->next != lastPtr) {
			if (firstPtr->isDisable < firstPtr->next->isDisable) {
				swap(firstPtr->patientId, firstPtr->next->patientId);
				swap(firstPtr->fullName, firstPtr->next->fullName);
				swap(firstPtr->patientAge, firstPtr->next->patientAge);
				swap(firstPtr->gender, firstPtr->next->gender);
				swap(firstPtr->phone, firstPtr->next->phone);
				swap(firstPtr->address, firstPtr->next->address);
				swap(firstPtr->sicknessDescription, firstPtr->next->sicknessDescription);
				swap(firstPtr->isDisable, firstPtr->next->isDisable);
				swap(firstPtr->medicineInformation, firstPtr->next->medicineInformation);
				swap(firstPtr->doctorName, firstPtr->next->doctorName);
				swapped = 1;
			}
			firstPtr = firstPtr->next;
		}
		lastPtr = firstPtr;
	} while (swapped);
	displaySortedList();
}

bool validatePatientId(int id) {
	temp = head;
	while (temp != NULL) {
		if (temp->patientId == id) {
			return false;
		}
		temp = temp->next;
	}
	return true;
}

void AddPatient() {
	string fullName, gender, phone, address, sicknessDescription ,id;
	int patientId, patientAge, isDisable;
	bool match = true;
	cout << "Please enter patient ID" << endl;
	do {
		cin >> id;
		if (!regex_match(id, int_rule)) {
			match = false;
			cout << "The patient ID only accept integer input!" << endl;
		}
		else {
			match = true;
			patientId = stoi(id.c_str());
			if (validatePatientId(patientId) == false) {
				match = false;
				cout << "This entered patient ID has been registered in the system before." << endl;
			}
			else {
				match = true;
			}
		}
	} while (!match);

	cin.ignore();
	cout << endl;
	cout << "Please enter Patient Name" << endl;
	getline(cin, fullName);

	cout << endl;
	cout << "Please enter Patient Phone Number" << endl;
	match = true;
	do {
		cin >> phone;
		regex rule("^[0-9]*$");
		if (!regex_match(phone, rule)) {
			match = false;
			cout << "The phone number only accept number! Please re-enter the input!" << endl;
		}
		else {
			match = true;
		}
	} while (!match);

	cin.ignore();
	cout << endl;
	cout << "Please enter patient Gender" << endl;
	getline(cin, gender);

	cout << endl;
	cout << "Please enter patient Address" << endl;
	getline(cin, address);

	cout << endl;
	cout << "Please enter patient sickness description" << endl;
	getline(cin, sicknessDescription);

	cout << endl;
	match = true;
	string age;
	cout << "Please enter patient age in numerical form" << endl;
	do {
		cin >> age;
		if (regex_match(age, int_rule)) {
			patientAge = stoi(age.c_str());
				match = true;
		}
		else {
			cout << "The patient age only allow integer input!" << endl;
			match = false;
		}
	} while (!match);

	cout << endl;
	string dis;
	cout << "Is thie patient is a disable?" << endl;
	cout << "Enter 1 for disable, otherwise, enter 0" << endl;
	do {
		cin >> dis;
		if (regex_match(dis, int_rule)) {
			isDisable = stoi(dis.c_str());
			if (isDisable == 1 || isDisable == 0) {
				match = true;
			}
			else {
				cout << "Please only enter 1 or 0 value; Enter 1 for disable, otherwise, enter 0" << endl;
				match = false;
			}
		}
		else {
			cout << "The disability only allow integer input!" << endl;
			match = false;
		}
	} while (!match);

	insertPatientIntoLinkedList(patientId, fullName, patientAge, gender, phone, address, sicknessDescription, isDisable, "-");
	cout << endl << "Patient Id, " << id << " has been successfully created!" << endl;
	returnToHome();
}

int main()
{
	tail = NULL;
	head = NULL;
	insertPatientIntoLinkedList(222, "Louis Vuitton", 22, "F", "123", "China", "Fever", 0, "Mec");
	insertPatientIntoLinkedList(11, "John Smith", 20, "M", "239", "China", "Fever", 1, "Mec");
	init();
	return 0;
}