#include <stdio.h>
#include <string.h>
#include <conio.h>

char name[30];
char address[30];
int  phone;
int amountPaid;

void input();
void modify();
void writeFile();
void Search();
void output();

int main()
{
    int option;
    char username[15];
    char password[12];

  do{

      printf("\nTo login to the system, press the number of your rule:\n\t");

            printf("\n\t 1. Admin");
            printf("\n\t 2. Staff");
            printf("\n\t 3. Customer");
            printf("\n\t 4. Exit \n\n\t");
            printf("\n\t Enter  your rule: ");

        scanf("%d",&option);

        switch(option){

            case 1:
                printf("\n\t Enter your username: ");
                scanf("%s",&username);

                printf("\n\t Enter your password: ");
                scanf("%s",&password);



                if(strcmp(username,"admin")==0){
                    if(strcmp(password,"1234")==0){
                    printf("\n\n Welcome %s, you successfully logged-in MBBS System!\n\n",username);


                    int adminOption;

                    do{
                    printf("\n Press the task you would like to perform:\n\t");
                    printf("\n\t 1. Create New Customer Profile");
                    printf("\n\t 2. Modify Existing Customer Records");
                    printf("\n\t 3. Delete redundant customer information");
                    printf("\n\t 4. View and Search Customer Profile");
                    printf("\n\t 5. Log out from the admin menu \n\n\t");
                    printf("\n\t Which task to perform?: ");

                    scanf("%d",&adminOption);
                    switch(adminOption){

                    case 1:

                        input();
                        writeFile();

                        break;

                    case 2:

                        modify();

                        break;

                    case 3:

                        break;

                    case 4:

                        output();

                        break;



                    }
                    }
                        while(adminOption!=5);





                    }else{
                printf("\n\t wrong password");
                  }
                }else{
                printf("\n\t User doesn't exist");
            }

            break;

            case 2:
                printf("\n\t Enter your username: ");
                scanf("%s",&username);

                printf("\n\t Enter your password: ");
                scanf("%s",&password);



                if(strcmp(username,"staff")==0){
                    if(strcmp(password,"1234")==0){
                    printf("\n\n\Welcome %s, you successfully logged-in MBBS System!",username);


                    int staffOption;

                    do{

                            printf("\n\n\n Press the task you would like to perform:\n\t");
                            printf("\n\t 1. Create New Customer Profile");
                            printf("\n\t 2. View Customers accordingly");
                            printf("\n\t 3. Log out from staff menu");
                            printf("\n\n\n\t Which task to perform?: ");

                            scanf("%d",&staffOption);
                            switch(staffOption){

                    case 1:

                            input();
                            writeFile();
                        break;

                    case 2:
                            search();
                        break;

                    }
                        } while(staffOption!=3);
                }else{
                printf("\n\t wrong password");
                  }
                }else{
                printf("\n\t User doesn't exist");
            }

            break;
            case 3:
                printf("\n\t Enter your username: ");
                scanf("%s",&username);

                printf("\n\t Enter your password: ");
                scanf("%s",&password);



                if(strcmp(username,"customer")==0){
                    if(strcmp(password,"1234")==0){
                    printf("\n\nWelcome %s, you successfully logged-in MBBS System!\n\n",username);

                    search();

                    }else{
                printf("\n\t wrong password");
                  }
                }else{
                printf("\n\t User doesn't exist");
            }

            break;
            default:
                printf("\n\t System to exit...");


        }

  }

   while(option!=4);

            printf("\t System Exiting...\n\n\n\n\n");


    return 0;

}


    void input(){

    int i,n;

    int customer;

    printf("\n\n How many customers to input? enter customers total number: ");
    scanf("%d",&n);
    for(i=0;i<n;i++){

       printf("\n\tEnter the name of customer%d : ",i+1);
       scanf("%s",&name);
       printf("\n\tEnter the address of customer%d : ", i+1);
       scanf("%s",&address);
       printf("\n\tEnter the phone number of customer%d : ",i+1);
       scanf("%d",&phone);
       printf("\n\tEnter the amount paid of customer%d : ",i+1);
       scanf("%d",&amountPaid);


    }


    }

    void writeFile(){


            FILE *fptr;

            fptr = fopen("C://c//program.txt","a+");

             if(fptr == '\0'){

             fptr = fopen("C://c//program.txt","a+");
             }

             if(fptr == '\0'){

                  printf("Error!");
                  exit(1);
             }


              fprintf(fptr, "\n\nCustomer Name: %s" ,&name);
              fprintf(fptr,"\n");
              fprintf(fptr,"Customer Address: %s",&address);
              fprintf(fptr,"\n");
              fprintf(fptr,"Customer Phone: %d",phone);
              fprintf(fptr,"\n");
              fprintf(fptr,"Customer Amount Paid: %d",amountPaid);

                fclose(fptr);

}

   void modify(){

   char modifyingName[30];
   int res;
   FILE *fptr;

     fptr = fopen("C://c//program.txt","r");

   printf("Enter name to modify");
   scanf("%s",modifyingName);

   printf("the name you're modifying is: %s ", modifyingName);

   fscanf(fptr,"%s %s %d %d",&name,&address,&phone,&amountPaid);
   if(strcmp(modifyingName,name)){

        printf("Enter new name for the customer");
        scanf("%s",&name);
        printf("Enter new address for the customer");
        scanf("%s",&address);
        printf("Enter new phone number for the customer");
        scanf("%d",&phone);
        printf("Enter new amount paid for the customer");
        scanf("%d",&amountPaid);

              fprintf(fptr, "\n\nCustomer Name: %s" ,&name);
              fprintf(fptr,"\n");
              fprintf(fptr,"Customer Address: %s",&address);
              fprintf(fptr,"\n");
              fprintf(fptr,"Customer Phone: %d",phone);
              fprintf(fptr,"\n");
              fprintf(fptr,"Customer Amount Paid: %d",amountPaid);
    }

    else {

        printf("\n\n not the same");
    }



   fclose(fptr);

   return 0;
}


void output(){




    char file_to_open[] = "C://c//program.txt", ch;
    FILE *file_ptr;

    if((file_ptr = fopen(file_to_open, "r")) != NULL)
    {
        while((ch = fgetc(file_ptr)) != EOF)
        {
            putchar(ch);
        }
    }
    else
    {
        printf("Could not open %s\n", file_to_open);

return 1;
    }
    return(0);


}


void search(){

//struct records customer;
FILE *fp2;
 int r, s, avl;
 printf("\nEnter the name you want to search  :");
 scanf("%s", &r);

 if (avl == 0)
  printf("This \" %s \" name is not available in the file\n",r);
 else
 {
  fp2 = fopen("C://c//program.txt", "r");
  while (fread(&name, (name), 1, fp2))
  {
   s = name;
   if (s == r)
   {
    printf("\nName: = %s", name);
    printf("\nAddress    = %s", address);
    printf("\nPhone Number    = %d\n", phone);
    printf("\nAmount Paid    = %d\n", amountPaid);
   }
  }
  fclose(fp2);
 }



}
