#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>
#define N 1024
#define AdminPassWord "root"

typedef struct Customer { // typedef create an alias name for data types and simplify the syntax of declaring variables
	char name[16]; // string type of name variable which has maximum 16 characters, principle applied following declaration
	char address[32];
	char phoneNumber[16];
	char gender[10];
	char accountNumber[20];
	char password[7];
	char accountType[10];
	double balance;
}Customer;

typedef struct Transaction {
	char accountNumber[20];
	char time[20];
	double amount;
}Transaction;

void inputCustomer(Customer* ct) {
	printf("name:");
	scanf("%s", ct->name);
	printf("address:");
	scanf("%s", ct->address);
	printf("phoneNumber:");
	scanf("%s", ct->phoneNumber);
	printf("gender(man|woman):");
	scanf("%s", ct->gender);
	printf("accountType(Saving|Current):");
	scanf("%s", ct->accountType);
	printf("accountNumber:");
	scanf("%s", ct->accountNumber);
	printf("password:");
	scanf("%s", ct->password);
	ct->balance = 0;
}

void customerRegist(Customer* customers, int* customersSize) { // Pass structs to function, structure alias name is Customer
	int i;
	inputCustomer(&customers[*customersSize]);
	for (i = 0; i < *customersSize; i++) { // loop through the size of customers
		if (!strcmp(customers[*customersSize].accountNumber, customers[i].accountNumber)) { // Compare accountNumber of customerSize with each customer's accountNumber 
			printf("%s already exist!\n", customers[*customersSize].accountNumber);
			return;
		}
	}
	(*customersSize)++; // increase customerSize by 1
	printf("Regist Success!\n");
}

void readFile(Customer** customers, int * customersSize, Transaction** transactions,int * transactionsSize) {
	FILE* fp; 
	int i;
	Customer* pc = NULL;
	Transaction* pt = NULL;
	fp = fopen("customers.txt", "r");
	*customers = (Customer*)malloc(sizeof(Customer) * N);
	*transactions = (Transaction*)malloc(sizeof(Transaction) * N);
	pc = *customers;
	pt = *transactions;
	if (fp) {
		i = 0;
		while (fscanf(fp, "%s%s%s%s%s%s%s%lf", pc[i].name, pc[i].address, pc[i].phoneNumber,
			pc[i].gender, pc[i].accountNumber, pc[i].password, pc[i].accountType, &pc[i].balance) != EOF) {
			i++;
		}
		fclose(fp);
		*customersSize = i;
	}
	else {
		*customersSize = 0;
	}

	fp = fopen("transactions.txt", "r");
	if (fp) {
		i = 0;
		while (fscanf(fp, "%s%s%lf", pt[i].accountNumber, pt[i].time, &pt[i].amount) != EOF) {
			i++;
		}
		fclose(fp);
		*transactionsSize = i;
	}
	else {
		*transactionsSize = 0;
	}
}

void saveFile(Customer* customers, int customersSize, Transaction* transactions, int transactionsSize) { 
	FILE* fp;
	int i;
	fp = fopen("customers.txt", "w");
	for (i = 0; i < customersSize; i++) {
		fprintf(fp, "%s %s %s %s %s %s %s %lf\n", customers[i].name, customers[i].address, 
			customers[i].phoneNumber, customers[i].gender, 
			customers[i].accountNumber, customers[i].password,
			customers[i].accountType, customers[i].balance);
	}
	fclose(fp);

	fp = fopen("transactions.txt", "w");
	for (i = 0; i < transactionsSize; i++) {
		fprintf(fp, "%s %s %lf\n", transactions[i].accountNumber, transactions[i].time, transactions[i].amount);
	}
	fclose(fp);
}

void viewCustomsList(Customer* customers, int customersSize) {
	int i;
	printf("Customs List:\n");
	printf("%-10s%-20s%-20s%-10s%-20s%-20s%-10s\n", "Name", "Address", "PhoneNumber", 
		"Gender", "AccountNumber", "AccountType", "Balance");
	for (i = 0; i < customersSize; i++) {
		printf("%-10s%-20s%-20s%-10s%-20s%-20s%-10.2lf\n", customers[i].name,
			customers[i].address, customers[i].phoneNumber, customers[i].gender, 
			customers[i].accountNumber, customers[i].accountType, customers[i].balance);
	}
	printf("Total: %d record(s)\n\n", customersSize);
}

void viewTransactions(char* accountNumber, Transaction* transactions, int transactionsSize) {
	int i, t = 0;
	printf("%s's transactions:\n", accountNumber);
	printf("%-30s%s\n", "Time", "Amount");
	for (i = 0; i < transactionsSize; i++) {
		if (!strcmp(transactions[i].accountNumber, accountNumber)) {
			t++;
			printf("%-30s%.2lf\n", transactions[i].time, transactions[i].amount);
		}
	}
	printf("Total %d record(s)\n\n", t);
}

void viewCustomTransactions(Transaction* transactions, int transactionsSize) {
	char accountNumber[20] = { 0 };
	printf("Please input Customer accountNumber:\n");
	scanf("%s", &accountNumber);
	viewTransactions(accountNumber, transactions, transactionsSize);
}

void removeCustomer(Customer* customers, int *customersSize) {
	char accountNumber[20] = { 0 }, ans[10] = {0};
	int i, j;
	printf("Please input Customer accountNumber:\n");
	scanf("%s", &accountNumber);
	for (i = 0; i < *customersSize; i++) {
		if (!strcmp(customers[i].accountNumber, accountNumber)) {
			printf("remove %s(y/n)?", accountNumber);
			scanf("%s", ans);
			if (!strcmp(ans, "y")) {
				for (j = i; j < *customersSize - 1; j++) {
					customers[j] = customers[j + 1];
				}
				(*customersSize)--;
				printf("Remove %s successfully.\n", accountNumber);
				return;
			}
		}
	}
	printf("%s not exist!\n", accountNumber);
}

int adminLoginSuccess(Customer* customers, int customersSize) {
	char pwd[20] = {0};
	printf("Please input Administrator password:\n");
	scanf("%s", pwd);
	if (!strcmp(pwd, AdminPassWord)) {
		printf("Welcome! Administrator\n");
		return 1;
	}
	else {
		printf("Permission Denied!\n");
		return 0;
	}
}

void adminSystem(Customer* customers, int *customersSize, Transaction* transactions, int *transactionsSize) {
	int op, running=1;
	if (!adminLoginSuccess(customers, *customersSize)) {
		return;
	}
	while (running) {
		do {
			printf("Admin System\n");
			printf("1.View Customers' list\n");
			printf("2.View Customers' transaction\n");
			printf("3.Remove existing Customer\n");
			printf("0.Exit\n");
			printf("\tPlease enter number:\n");
			scanf("%d", &op);
		} while (op<0 || op>3);

		switch (op) {
		case 1:
			viewCustomsList(customers, *customersSize);
			break;
		case 2:
			viewCustomTransactions(transactions, *transactionsSize);
			break;
		case 3:
			removeCustomer(customers, customersSize);
			saveFile(customers, *customersSize, transactions, *transactionsSize);
			break;
		case 0:
			running = 0;
		}
	}
}

void viewPersonalInfo(Customer* ct) {
	printf("Name: %s\n", ct->name);
	printf("Gender: %s\n", ct->gender);
	printf("Addres: %s\n", ct->address);
	printf("Phone: %s\n\n", ct->phoneNumber);
}

void viewAccountInfo(Customer* ct) {
	printf("AccountNumber: %s\n", ct->accountNumber);
	printf("AcountType: %s\n", ct->accountType);
	printf("Balance: %.2lf\n\n", ct->balance);
}

void updatePersonalInfo(Customer* ct) {
	printf("Name: %s ->", ct->name);
	scanf("%s", ct->name);
	printf("Gender: %s ->", ct->gender);
	scanf("%s", ct->gender);
	printf("Addres: %s ->", ct->address);
	scanf("%s", ct->address);
	printf("Phone: %s ->", ct->phoneNumber);
	scanf("%s", ct->phoneNumber);

	printf("Personal infomation update success!\n");
}

void currentTime(char* timestr) {
	time_t timep;
	struct tm* p;
	time(&timep);
	p = localtime(&timep);
	sprintf(timestr, "%02d-%02d-%02d_%02d:%02d:%02d", 1900 + p->tm_year,
		1 + p->tm_mon, p->tm_mday, p->tm_hour, p->tm_min, p->tm_sec);
}

void withdraw(Customer* ct, Transaction* transactions, int *transactionsSize) {
	double amount;
	char time[20] = { 0 };
	printf("Please enter the amount of withdrawal:\n");
	scanf("%lf", &amount);
	if (amount <= 0) {
		printf("Please enter a positive integer!\n");
		return;
	}
	if (ct->balance < amount) {
		printf("You have not enough balance!\n");
		return;
	}
	ct->balance -= amount;
	strcpy(transactions[*transactionsSize].accountNumber, ct->accountNumber);
	currentTime(time);
	strcpy(transactions[*transactionsSize].time, time);
	transactions[*transactionsSize].amount = -amount;
	(*transactionsSize)++;
	printf("Operation success!\n");
}

void deposit(Customer* ct, Transaction* transactions, int* transactionsSize) {
	double amount;
	char time[20] = { 0 };
	printf("Please enter the amount of deposit:\n");
	scanf("%lf", &amount);
	if (amount <= 0) {
		printf("Please enter a positive integer!\n");
		return;
	}
	ct->balance += amount;
	strcpy(transactions[*transactionsSize].accountNumber, ct->accountNumber);
	currentTime(time);
	strcpy(transactions[*transactionsSize].time, time);
	transactions[*transactionsSize].amount = amount;
	(*transactionsSize)++;
	printf("Operation success!\n");
}

void customerSystem(Customer* customer, Transaction* transactions, int* transactionsSize) {
	int op, running = 1;
	while (running) {
		do {
			printf("Customer System\n");
			printf("1.View personal information\n");
			printf("2.View Account detail\n");
			printf("3.View Transactions\n");
			printf("4.Update personal information\n");
			printf("5.Withdraw\n");
			printf("6.Deposit\n");
			printf("0.Exit and Save\n");
			printf("\tPlease enter number:\n");
			scanf("%d", &op);
		} while (op < 0 || op>6);

		switch (op) {
		case 1:
			viewPersonalInfo(customer);
			break;
		case 2:
			viewAccountInfo(customer);
			break;
		case 3:
			viewTransactions(customer->accountNumber, transactions, *transactionsSize);
			break;
		case 4:
			updatePersonalInfo(customer);
			break;
		case 5:
			withdraw(customer, transactions, transactionsSize);
			break; 
		case 6:
			deposit(customer, transactions, transactionsSize);
			break;
		case 0:
			running = 0;
		}
	}
}

int customerLogin(Customer* customers, int size) {
	int i;
	char account[20] = { 0 }, password[7] = {0};
	int k = 3;
	printf("Please input AccountNumber:\n");
	scanf("%s", account);
	for (i = 0; i < size; i++) {
		if (!strcmp(account, customers[i].accountNumber)) {
			while (k--) {
				printf("Please input Password:\n");
				scanf("%s", password);
				if (!strcmp(password, customers[i].password)) {
					printf("Welcome! %s!\n", customers[i].name);
					return i;
				}
				else {
					if (k) {
						printf("Password not correct, %d chance(s) left!\n", k);
					}
				}
			}
			printf("Password not correct!\n");
			return -1;
		}
	}
	printf("Account not exist!\n");
	return -1;
}

int main() {
	Customer *customers = NULL; //  ? 
	Transaction *transactions = NULL; // ?
	int customersSize, transactionsSize;
	int op, running = 1;
	int index;
	readFile(&customers, &customersSize , &transactions, &transactionsSize);
	while (running) { // running value is equal to 1 as initialized above
		do {
			printf("1.Admin System\n");
			printf("2.Customer Login\n");
			printf("3.Customer Regist\n");
			printf("0.Exit\n");
			scanf("%d", &op);
		} while (op < 0 || op>3);

		switch (op)
		{
		case 1:
			adminSystem(customers, &customersSize, transactions, &transactionsSize);
			break;
		case 2:
			index = customerLogin(customers, customersSize);
			if (index >= 0) {
				customerSystem(&customers[index], transactions, &transactionsSize);
				saveFile(customers, customersSize, transactions, transactionsSize);
			}
			break;
		case 3:
			customerRegist(customers, &customersSize);
			saveFile(customers, customersSize, transactions, transactionsSize);
			break;
		case 0:
			running = 0;
			break;
		}
	}
	free(customers); // ? 
	free(transactions); // ?
	return 0;
}