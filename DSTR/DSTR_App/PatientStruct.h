using namespace std;

struct Patient {
	int patientId;
	string fullName;
	int patientAge;
	string gender;
	string phone;
	string address;
	string sicknessDescription;
	int isDisable;
	string medicineInformation;
	string doctorName;
	Patient();
	Patient(int patientId, string fullName, int patientAge, string gender, string phone, string address, string sicknessDescription, int isDisable, string medicineInformation);
	Patient(int patientId, string fullName, int patientAge, string gender, string phone, string address, string sicknessDescription, int isDisable, string medicineInformation, string doctorName);
	Patient* next;
	Patient* previous;
}*head, *tail, *temp, *Pat, *sortedHead, *sortedTail, *sortedTemp;

Patient::Patient(int patientId, string fullName, int patientAge, string gender, string phone, string address, string sicknessDescription, int isDisable, string medicineInformation, string doctorName) {
	this->patientId = patientId;
	this->fullName = fullName;
	this->patientAge = patientAge;
	this->gender = gender;
	this->phone = phone;
	this->address = address;
	this->sicknessDescription = sicknessDescription;
	this->isDisable = isDisable;
	this->medicineInformation = medicineInformation;
	this->doctorName = doctorName;
}

Patient::Patient(int patientId, string fullName, int patientAge, string gender, string phone, string address, string sicknessDescription, int isDisable, string medicineInformation) {
	this->patientId = patientId;
	this->fullName = fullName;
	this->patientAge = patientAge;
	this->gender = gender;
	this->phone = phone;
	this->address = address;
	this->sicknessDescription = sicknessDescription;
	this->isDisable = isDisable;
	this->medicineInformation = medicineInformation;
	this->doctorName = "-";
}

Patient::Patient() {
	
}