#include <stdio.h> // header file for standard input and output
#include <string.h>
#include <stdlib.h>
#include <time.h>

struct customer { //define structures of visitor
	char visit_id, customer_name, visit_date, service_needed;
};

struct service_fee {
	char type;
	int normal_price, urgent_price;
};

struct payment {
	float payment_made;
	char date;
};

void user_input() {
	char visit_id, customer_name, visit_date, service_needed;
	int age;
	printf("visit_id:");
	scanf("%c",&visit_id); // assign the input value from user to the address of variable name ,same as below
	printf("customer_name:");
	scanf("%s", &customer_name);
	printf("visit_date:");
	scanf("%s",&visit_date);
	printf("service_needed:");
	scanf("%s",&service_needed);
}

char id; // initialize integer value
printf("Pls enter user id:");
scanf("%s", id);// prompt for user input for ID

int main(){
	int option;
do
{
	printf("1.User Registeration\n"); 
	printf("2.User Login\n");
	printf("3.User Booking\n");
	printf("4..Cancellation:\n");
	printf("5.Modify Booking:");
	printf("6. View Status:");
	printf("0.Exit\n");
	scanf("%d", &option);
} while (option < 1 || option >7); // if option entered by user is not within the range

switch (option)
{
	case 1:

	case 2;

	case 3;

	case 4;

	case 5;

	case 6;

	case 0;
		printf("Exit successfully");
		running = 1;
}

}

