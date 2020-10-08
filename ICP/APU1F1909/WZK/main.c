#define _CRT_SECURE_NO_WARNINGS  // to allow usage of fopen()
#include <stdio.h> // C standard input library
#include <string.h> // C standard library for string manipulation 
#include <stddef.h>
#include <stdbool.h>
#include <dos.h>
#include <conio.h>
#include <stdlib.h>
#define BUFFER_SIZE 1024 // ?

void menu(); // below these are function prototypes
void pricelist();
void new();
void edit();
void search();
void detail();
void balance();

struct visit {
    char date[16]; //  date is not given by user
    char name; //
    char serviceNo;
    int days,price,paid; //
};

int line, count, profit;
char buffer[BUFFER_SIZE]; // ?
char newline[BUFFER_SIZE];

FILE* fp;  // declare a pointer of type file called fp
FILE* fptmp;

void menu() {
    int choice;
    printf("\t\tRepair Store Management System\n\n\n\n");
    printf("\n(1) View price list.");
    printf("\n(2) New visit.");
    printf("\n(3) Edit existing visit.");
    printf("\n(4) Search existing visits by customer name.");
    printf("\n(5) Print visit detail.");
    printf("\n(6) Print profit et co.");
    printf("\n(7) Exit");
    printf("\n\nPlease choose : ");
    do {
        scanf("%d", &choice); // get selection value from user input
        switch (choice) {
        case 1:
            pricelist();
            break;
        case 2:
            new();
            break;
        case 3:
            edit();
            break;
        case 4:
            search();
            break;
        case 5:
            detail();
            break;
        case 6:
            balance();
            break;
        case 7:
            printf("Exiting");
            exit(0);
        default:
            printf("INVALID INPUT\nRETURN TO SELECTION");
            break;
        }
    } while (choice != NULL);
}

void pricelist() {
    printf("No   |   Service                                   | Needed days | Normal | Urgent\n");
    printf("-----+---------------------------------------------+-------------+--------+-------\n");
    printf("1    |   Remove virus, malware or spyware          |      2      | RM30   | RM50\n");
    printf("2    |   Troubleshot and fix computer running slow |      2      | RM40   | RM70\n");
    printf("3    |   Laptop screen replacement                 |      3      | RM380  | RM430\n");
    printf("4    |   Laptop keyboard replacement               |      2      | RM160  | RM200\n");
    printf("5    |   Laptop battery replacement                |      1      | RM180  | RM210\n");
    printf("6    |   Operating system Format and Installation  |      2      | RM50   | RM80\n");
    printf("7    |   Data backup and recovery                  |      2      | RM100  | RM150\n");
    printf("8    |   Internet connectivity issues              |      1      | RM50   | RM75\n\n\n\n");
    main();
}

void new(){
  fp = fopen("visit.txt", "a"); // Open for appending, data is added to the end of the file. If the file does not exist, it will be created.
  struct visit newvisit; // struct a new struture variable called newvisit
  printf("Enter customer name: ");
  scanf("%c", &newvisit.name);
  printf("Enter service number: ");
  scanf("%c", &newvisit.serviceNo);
  printf("Enter date: ");
  scanf("%c", &newvisit.date);
  printf("Enter needed days: ");
  scanf("%d", &newvisit.days);
  printf("Enter price: ");
  scanf("%d", &newvisit.price);
  printf("Enter paid: ");
  scanf("%d", &newvisit.paid);
  if (fp != NULL) { // if fp file exist then write data input from user into txt file
      fprintf(fp, "%c\t%c\t%c\t%d\t%d\t%d\n", &newvisit.name, &newvisit.serviceNo, &newvisit.date, &newvisit.days, &newvisit.price, &newvisit.paid);
  }
  else
      printf("File not found or not authorized."); 
  fclose(fp);
  main(); // back to menu function
}

void edit() {
    int line;
    fp = fopen("visit.txt", "r"); // open file in read mode
    fptmp = fopen("visit.tmp", "w"); // create a file object in write mode called fptmp
    struct visit newvisit; 
    printf("Enter visit ID to edit: ");
    scanf("%d", line); // 
    fflush(stdin); // ? 
    printf("Enter customer name: ");
    scanf("%c", &newvisit.name);
    printf("Enter service number: ");
    scanf("%c", &newvisit.serviceNo);
    printf("Enter date: ");
    scanf("%c", &newvisit.date);
    printf("Enter needed days: ");
    scanf("%d", &newvisit.days);
    printf("Enter price: ");
    scanf("%d", &newvisit.price);
    printf("Enter paid: ");
    scanf("%d", &newvisit.paid);
    strcpy(newline, printf("%c\t%c\t%c\t%d\t%d\t%d\n", &newvisit.name, &newvisit.serviceNo, &newvisit.date, &newvisit.days, &newvisit.price, &newvisit.paid)); // strcpy

    count = 0;
    while ((fgets(buffer, BUFFER_SIZE, fp)) != NULL) { //
        count++;
        if (count == line) {
            fputs(newline, fptmp);
        }
        else {
            fputs(buffer, fptmp);
        }
    }

    fclose(fp);
    fclose(fptmp);
    remove("visit.txt"); // remove ?
    rename("visit.tmp", "visit.txt"); // rename ？
    main();
}

void search() {
    fp = fopen("visit.txt", "r");
    struct visit existing;
    char keyword;
    int ret;
    if (fp != NULL) { // if the fp file exist
        printf("Enter name to search record: ");
        scanf("%c", keyword); // searching name from user input
        printf("No\tNeeded days\tDate\tPrice\tPaid \n"); // display the customer detail header
        while (fscanf("%c\t%c\t%c\t%d\t%d\t%d\n", &existing.name, &existing.serviceNo, &existing.date, &existing.days, &existing.price, &existing.paid) != EOF) { // ? 
            ret = strcmp(existing.name, keyword); // strcmp ?
            do {
                printf("%c\t%d\t%c\t%d\t%d", &existing.serviceNo, &existing.days, &existing.date, &existing.price, &existing.paid); // ?
            } while (ret == 0);
        }  
    else {
        printf("File not found or not authorized.");
    }
    }
    fclose(fp);
    main();
}

void detail() {
    fp = fopen("visit.txt", "r");
    struct visit existing;
    int line;
    printf("Enter visit ID: ");
    scanf("%d", line);
    count = 0;
    if (fp != NULL) {
        char lineStr[256]; /* or other suitable maximum line size */
        while (fgets(lineStr, sizeof lineStr, fp) != NULL) /* read a line */ {
            if (count == line) {
                printf("No\tNeeded days\tDate\tPrice\tPaid \n");
                printf("%c\t%d\t%c\t%d\t%d", &existing.serviceNo, &existing.days, &existing.date, &existing.price, &existing.paid);
            }
            else {
                count++;
            }
        }
        fclose("visit.txt");
    }
        else {
            printf("File not found or not authorized.");
    }
    main();
}

void balance() {
    fp = fopen("visit.txt", "r");
    struct visit existing;
    int unpaidBalance, paidBalance;
    if (fp != NULL) {
        printf("Enter name to search record: ");
        printf("No\tNeeded days\tDate\tPrice\tPaid \n");
        unpaidBalance = 0;
        paidBalance = 0;
        
        while (fscanf("%c\t%c\t%c\t%d\t%d\t%d\n", &existing.name, &existing.serviceNo, &existing.date, &existing.days, &existing.price, &existing.paid) != EOF) {
            paidBalance = paidBalance + existing.paid;
            unpaidBalance = unpaidBalance + existing.price - existing.paid;

        }
    else {
        printf("File not found or not authorized.");
    }
    printf("Paid Balance: %d"， paidBalance);
    printf("Unpaid Balance: %d", unpaidBalance);
    main();
}

int main() { // main program where execution begin
    menu();
    return 0;
}
