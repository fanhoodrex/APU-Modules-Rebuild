#include <stdio.h>
#include <stddef.h>
#include <stdbool.h>
#include <time.h>
#include <conio.h>
#include <stdlib.h>
void re();
void Login();
void syste();
void book();
void cancel();
void modidify();
void view();


struct re
{
	char *username[20];
	char *password[20];
}reg;

//booking infomation struct
struct info
{
	char *name[20];
	int roomtype;
	int phone;
	int roomnum;
	int indate, inmonth, inyear;
	int outdate, outmonth, outyear;
	char *passport[50];
	int noonkids;
	int noonads;
}in;


FILE *fp;
FILE *fp1;
FILE *fp2;
FILE *fp3;


//registration model
void re()
{
	fp = fopen("registration.txt", "a");
	printf("\n***************************************************************\nRegistration system\n");
	printf("Please Enter Your Username:");
	scanf("%s", &reg.username);
	printf("Please Enter Your PassWord:");
	scanf("%s", &reg.password);
	if (fp != NULL)
	{
		fprintf(fp, "%s\t%s\n", &reg.username, &reg.password);
		printf("You Are Successful Registration!!!\n***************************************************************\n");
	}
	fclose(fp);
	Login();
}

//Log in model
void Login()
{
	int i = 0;
	char username[20];
	char password[20];
	fp = fopen("registration.txt", "r");
	printf("***************************************************************\nUsername: ");
	scanf("%s", username);
	printf("PassWord: ");
	scanf("%s", password);
	while (!feof(fp))
	{
		fscanf(fp, "%s\t%s\n", &reg.username, &reg.password);
		if ((strcmp(username, reg.username) == 0 && (strcmp(password, reg.password) == 0)))
		{
			fclose(fp);
			printf("***************************************************************\nWelcome, %s", username);
			syste();
		}
	}
	fclose(fp);
	printf("Username or Password is error\n***************************************************************\n");
	main();
}

//main system
void syste()
{
	int choose;
	printf("\n1.Booking\n2.Cancellation\n3.Modify Booking\n4.View Status\n5.Log out\n***************************************************************\n");
	scanf("%d", &choose);
	switch (choose)
	{
	case(1):
		book();
		break;
	case(2):
		cancel();
		break;
	case(3):
		modidify();
		break;
	case(4):
		view();
		break;
	case(5):
		main();
		break;
	default:
		break;
	}
}

//booking system
void book()
{
	fp1 = fopen("book.txt", "a");
	struct info in;
	printf("***************************************************************\nPlease Enter The Detail\n\nPleace Enter Your Name: ");
	scanf("%s", &in.name);
	printf("\nPleace Enter Your passport: ");
	scanf("%s", &in.passport);
	printf("1.Single room:Each room can live 1 Adult & 1 Kid\n2.Double-bed room:Each room can live 2 Adults & 2 Kids\n\nWhich Room Type You Want?");
	scanf("%d", &in.roomtype);
	printf("\nPleace Enter Your Phone: ");
	scanf("%d", &in.phone);
	printf("\nPleace Enter Date-Month-Year of Cheak-in: \n(Tips:Date like :dd mm yyyy)");
	scanf("%d%d%d", &in.indate, &in.inmonth, &in.inyear);
	printf("\nPleace Enter Date-Month-Year of Cheak-out: \n(Tips:Date like :dd mm yyyy)");
	scanf("%d%d%d", &in.outdate, &in.outmonth, &in.outyear);
	printf("\nHow many adults do you have?\n");
	scanf("%d", &in.noonads);
	printf("\nHow many kids do you have?\n");
	scanf("%d", &in.noonkids);
	printf("\nHow many rooms do you need?\n");
	scanf("%d", &in.roomnum);
	if (fp1 != NULL)
	{
		fprintf(fp1, "%s\t%s\t%d\t%d\t\t%d %d %d\t\t%d %d %d\t%d\t%d\t%d\n", &in.name, &in.passport, in.roomtype, in.phone, in.indate, in.inmonth, in.inyear, in.outdate, in.outmonth, in.outyear, in.noonads, in.noonkids, in.roomnum);
	}
	printf("Booking successful,you will go back main menu.\n***************************************************************\n");
	fclose(fp1);
	syste();
}

//cancel system
void cancel()
{
	struct info in;
	int phone1;
	fp1 = fopen("book.txt", "r");
	fp3 = fopen("reason.txt", "a");
	char rea[5000];
	printf("***************************************************************\nEnter The Phone Number:\n");
	scanf("%d", &phone1);
	fp2 = fopen("book1.txt", "w");
	while (!feof(fp1))
	{
		fscanf(fp1, "%s\t%s\t%d\t%d\t\t%d %d %d\t\t%d %d %d\t%d\t%d\t%d\n", &in.name, &in.passport, &in.roomtype, &in.phone, &in.indate, &in.inmonth, &in.inyear, &in.outdate, &in.outmonth, &in.outyear, &in.noonads, &in.noonkids, &in.roomnum);
		if (phone1 == in.phone)
		{
			printf("Successful remove scheduled record\n***************************************************************\n");
		}
		else
		{
			fprintf(fp2, "%s\t%s\t%d\t%d\t\t%d %d %d\t\t%d %d %d\t%d\t%d\t%d\n", &in.name, &in.passport, in.roomtype, in.phone, in.indate, in.inmonth, in.inyear, in.outdate, in.outmonth, in.outyear, in.noonads, in.noonkids, in.roomnum);
		}
	}
	fclose(fp1);
	fclose(fp2);
	system("del book.txt");
//	remove("book.txt");
	rename("book1.txt", "book.txt");
	syste();
}

//modidify system
void modidify()
{
	struct info in;
	int phone;
	fp1 = fopen("book.txt", "r");
	fp2 = fopen("book1.txt", "w");
	printf("***************************************************************\nEnter The Phone number:\n");
	scanf("%d", &phone);
	while (!feof(fp1))
	{
		fscanf(fp1, "%s\t%s\t%d\t%d\t\t%d %d %d\t\t%d %d %d\t%d\t%d\t%d\n", &in.name, &in.passport, &in.roomtype, &in.phone, &in.indate, &in.inmonth, &in.inyear, &in.outdate, &in.outmonth, &in.outyear, &in.noonads, &in.noonkids, &in.roomnum);
		if (phone == in.phone)
		{
			continue;
		}
		else
		{
			fprintf(fp2, "%s\t%s\t%d\t%d\t\t%d %d %d\t\t%d %d %d\t%d\t%d\t%d\n", &in.name, &in.passport, in.roomtype, in.phone, in.indate, in.inmonth, in.inyear, in.outdate, in.outmonth, in.outyear, in.noonads, in.noonkids, in.roomnum);
		}
	}
	fclose(fp1);
	fclose(fp2);
	remove("book.txt");
	rename("book1.txt", "book.txt");
	printf("Please update the data");
	fp1 = fopen("book.txt", "a");
	printf("\nPlease Enter New Detail\n\nPleace Enter Your Name: ");
	scanf("%s", &in.name);
	printf("\nPleace Enter Your passport: ");
	scanf("%s", &in.passport);
	printf("1.Single room:Each room can live 1 Adult & 1 Kid\n2.Double-bed room:Each room can live 2 Adults & 2 Kids\n\nWhich Room Type You Want?");
	scanf("%d", &in.roomtype);
	printf("\nPleace Enter Your Phone: ");
	scanf("%d", &in.phone);
	printf("\nPleace Enter Date-Month-Year of Cheak-in: \n(Tips:Date like :dd mm yyyy)");
	scanf("%d%d%d", &in.indate, &in.inmonth, &in.inyear);
	printf("\nPleace Enter Date-Month-Year of Cheak-out: \n(Tips:Date like :dd mm yyyy)");
	scanf("%d%d%d", &in.outdate, &in.outmonth, &in.outyear);
	printf("\nHow many adults do you have?\n");
	scanf("%d", &in.noonads);
	printf("\nHow many kids do you have?\n");
	scanf("%d", &in.noonkids);
	printf("\nHow many rooms do you need?\n");
	scanf("%d", &in.roomnum);
	if (fp1 != NULL)
	{
		fprintf(fp1, "%s\t%s\t%d\t%d\t\t%d %d %d\t\t%d %d %d\t%d\t%d\t%d\n", &in.name, &in.passport, in.roomtype, in.phone, in.indate, in.inmonth, in.inyear, in.outdate, in.outmonth, in.outyear, in.noonads, in.noonkids, in.roomnum);
	}
	printf("Update successful,you will go back main menu.\n***************************************************************\n");
	fclose(fp1);
	syste();
}


//cheak system
void view()
{
	struct info in;
	int phone3 = 0;
	int ch = 10;
	fp1 = fopen("book.txt", "r");
	printf("Do you want cheak your info?(Yes = 1/No = 0)\n");
	scanf("%d", &ch);
	if (ch == 0)
	{
		syste();
	}
	else if (ch == 123654789)
	{
		printf("The Booking Details : \n");
		while (!feof(fp1))
		{
			fscanf(fp1, "%s\t%s\t%d\t%d\t\t%d %d %d\t\t%d %d %d\t%d\t%d\t%d\n\n", &in.name, &in.passport, &in.roomtype, &in.phone, &in.indate, &in.inmonth, &in.inyear, &in.outdate, &in.outmonth, &in.outyear, &in.noonads, &in.noonkids, &in.roomnum);
			printf("******\nName : %s\nPassport Number : %s\nRoom Type : %d\n(1.Single room 2.Double - bed room)\nPhone Number : %d\nDate Of Cheak - in :%d / %d / %d.\nDate Of Cheak - out:%d / %d / %d.\nThe Number of Adults : %d\nThe Number of Kids : %d\n The Number of Rooms : %d\n", &in.name, &in.passport, in.roomtype, in.phone, in.indate, in.inmonth, in.inyear, in.outdate, in.outmonth, in.outyear, in.noonads, in.noonkids, in.roomnum);             
		}
		fclose(fp1);
		syste();
	}
	printf("Enter The Phone Number:\n");
	scanf("%d", &phone3);
	while (!feof(fp1))
	{
		fscanf(fp1, "%s\t%s\t%d\t%d\t\t%d %d %d\t\t%d %d %d\t%d\t%d\t%d\n", &in.name, &in.passport, &in.roomtype, &in.phone, &in.indate, &in.inmonth, &in.inyear, &in.outdate, &in.outmonth, &in.outyear, &in.noonads, &in.noonkids, &in.roomnum);
		if (in.phone == phone3)
		{
			printf("***************************************************************\nHere Is The Booking Details:\nName: %s\nPassport Number:%s\nRoom Type:%d\n(1.Single room 2.Double-bed room)\nPhone Number:%d\nDate Of Cheak-in :%d/%d/%d.\nDate Of Cheak-out:%d/%d/%d.\nThe Number of Adults:%d\nThe Number of Kids:%d\n The Number of Rooms:%d\n***************************************************************\n", &in.name, &in.passport, in.roomtype, in.phone, in.indate, in.inmonth, in.inyear, in.outdate, in.outmonth, in.outyear, in.noonads, in.noonkids, in.roomnum);                                         
			fclose(fp1);
			syste();
		}
		else
		{
			continue;
		}
	}

	fclose(fp1);
	printf("Sorry,We Can't Find This Recording :(. Please Check And Enter Again!!!\n");
	syste();
}

//mainmenu
main()
{
	int fch = 0;
	while (fch == 0)
	{
		printf("\n***************************************************************\nWelcome to LLB Hotel\n1.Log in\n2.Register\n3.Exit\n***************************************************************\n");
		scanf("%d", &fch);
		if (fch == 1)
		{
			fch = 0;
			Login();

		}
		if (fch == 2)
		{
			fch = 0;
			re();
		}
		if (fch == 3)
		{
			fch = 0;
			printf("Thank for use\n");
			system("PAUSE");
			exit(0);
		}
	}
}