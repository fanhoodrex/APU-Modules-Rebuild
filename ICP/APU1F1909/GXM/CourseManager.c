#include <stdio.h>
#include <string.h>
#include <unistd.h>
#define MAX_NUM 100
#define CO_INFO_LEN 8
#define CU_INFO_LEN 6
#define ok 1
#define error -1

/**
 * Structure for storing course information
 */
struct Course{
    int no;
    char name[MAX_NUM];
    char category[MAX_NUM];
    int days;
    int admin_fee;
    int fee;
    int meal_ve;    // meal vagetarian
    int meal_nv;    // meal non-vegetarian
    int start_month;    // course start month, default = random
    int start_day;  // course start day, default = random
} ;

/**
 * Structure for storing customer information 
 */
struct Customer{
    int id;
    char *name;
    int sex;    // 0=male, 1=female
    int booked_course[MAX_NUM];
    int course_num;
    int amount_receivable;
    int amount_received;
};

/* Global variables are used to store all course information */
struct Course courses[MAX_NUM];
int course_num = 0;

/* Global variables are used to store all customer information */
struct Customer customers[MAX_NUM];
int customer_num = 0;

/**
 * Change a string to a integer
 */
int strToInt(char *str){
    int result = 0, temp;
    for(int i=0; i<strlen(str); i++){
        temp = str[i]-'0';
        result = result*10 + temp;
    }
    return result;
}

/**
 * Change a integer to a string
 */
char* itoa(int num,char* str){
	char index[]="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";    // index table
    int radix = 10;
	unsigned unum;  //Store the absolute value of the integer to be converted, which may be negative
	int i=0,j,k;
 
	if(radix==10&&num<0){
		unum=(unsigned)-num;
		str[i++]='-';
	}
	else 
        unum=(unsigned)num;
 
	do{
		str[i++]=index[unum%(unsigned)radix];
		unum/=radix;
 
	}while(unum);
	str[i]='\0';
	//Adjust the order
	if(str[0]=='-') k=1;
	else k=0;
 
	char temp;
	for(j=k;j<=(i-1)/2;j++){
		temp=str[j];
		str[j]=str[i-1+k-j];
		str[i-1+k-j]=temp;
	}
	return str;
}

/** 
 * Read course information from file 
 */
int readCourse(){
    FILE * file = NULL;
    char cwd[MAX_NUM];
    getcwd(cwd, sizeof(cwd));
    // Replace file separator in string
    for(int i=0; i<strlen(cwd); i++)
        if(cwd[i]=='\\')
            cwd[i] = '/';
    char filepath[MAX_NUM];
    strcpy(filepath, cwd);
    strcat(filepath, "/library/course_information.txt");
    file = fopen(filepath, "r");
    if(file == NULL)
        return error;
    printf("File opened successfully\n");
    char data[1024];
    // Read file information by line
    while(!feof(file)){
        fgets(data, 1024, file);
        // Separating a string from a space into an array of strings
        char *token[CO_INFO_LEN];
        token[0] = strtok(data, " ");
        for(int i=1; i<CO_INFO_LEN; i++){
            token[i] = strtok(NULL, " ");
        }
        // Assign value to each course
        courses[course_num].no = strToInt(token[0]);
        strcpy(courses[course_num].name, token[1]);
        strcpy(courses[course_num].category, token[2]);
        courses[course_num].days = strToInt(token[3]);
        courses[course_num].admin_fee = strToInt(token[4]);
        courses[course_num].fee = strToInt(token[5]);
        courses[course_num].meal_ve = strToInt(token[6]);
        courses[course_num].meal_nv = strToInt(token[7]);
        courses[course_num].start_month = course_num+1;
        courses[course_num].start_day = course_num+1;
        course_num++;
    }
    fflush(file);
    fclose(file);
    return ok;
}

/** 
 * Write course information on file 
 */
int writeCourse(){
    FILE * file = NULL;
    char cwd[MAX_NUM];
    getcwd(cwd, sizeof(cwd));
    // Replace file separator in string
    for(int i=0; i<strlen(cwd); i++)
        if(cwd[i]=='\\')
            cwd[i] = '/';
    char filepath[MAX_NUM];
    strcpy(filepath, cwd);
    strcat(filepath, "/library/course_information.txt");
    file = fopen(filepath, "w");
    if(file==NULL){
        printf("Write failed due to loss of critical files.\n");
        return error;
    }

    printf("Start writting information on file...\n");
    char data[1024];    // Used to store details of each course
    // Combine all details of every course to a string and write
    for(int i=0; i<course_num; i++){
        char str[100];
        itoa(courses[i].no, str);
        strcat(data, str);
        strcat(data, " ");
        strcat(data, courses[i].name);
        strcat(data, " ");
        strcat(data, courses[i].category);
        strcat(data, " ");
        itoa(courses[i].days, str);
        strcat(data, str);
        strcat(data, " ");
        itoa(courses[i].admin_fee, str);
        strcat(data, str);
        strcat(data, " ");
        itoa(courses[i].fee, str);
        strcat(data, str);
        strcat(data, " ");
        itoa(courses[i].meal_ve, str);
        strcat(data, str);
        strcat(data, " ");
        itoa(courses[i].meal_nv, str);
        strcat(data, str);
        if(i!=course_num-1)
            strcat(data, "\n");
        fputs(data, file);
    }
    printf("File write complete.\n");
    fflush(file);
    fclose(file);
    return ok;
}

/**
 * Print course details
 */
void printCourse(){
    printf("Course details are as follows:\n");
    for(int i=0; i<course_num; i++){
        printf("%d  ", courses[i].no);
        printf("%s  ", courses[i].name);
        printf("%s  ", courses[i].category);
        printf("%d  ", courses[i].days);
        printf("%d  ", courses[i].admin_fee);
        printf("%d  ", courses[i].fee);
        printf("%d  ", courses[i].meal_ve);
        printf("%d  ", courses[i].meal_nv);
        printf("%d.",  courses[i].start_month);
        printf("%d\n", courses[i].start_day);
    }
    printf("--------------------------------------------------\n");
}

/**
 * Read customer information from file
 */ 
int readCustomer(){
    FILE * file = NULL;
    char cwd[MAX_NUM];
    getcwd(cwd, sizeof(cwd));
    // Replace file separator in string
    for(int i=0; i<strlen(cwd); i++)
        if(cwd[i]=='\\')
            cwd[i] = '/';
    char filepath[MAX_NUM];
    strcpy(filepath, cwd);
    strcat(filepath, "/library/customer_information.txt");
    file = fopen(filepath, "r");
    if(file == NULL)
        return error;
    printf("File opened successfully\n");

    char data[1024];
    // Read file information by line
    while(!feof(file)){
        fgets(data, 1024, file);
        // If there are no customers in file, break out
        if(strlen(data)==0)
            break;
        // Separating a string from a space into an array of strings
        char *token[CU_INFO_LEN];
        token[0] = strtok(data, " ");
        for(int i=1; i<CU_INFO_LEN; i++){
            token[i] = strtok(NULL, " ");
        }
        for(int i=0; i<CU_INFO_LEN; i++){
            printf("%s ", token[i]);
        }
        printf("\n");
        // Assign value to each customer
        customers[customer_num].id = strToInt(token[0]);
        strcpy(customers[customer_num].name, token[1]);
        customers[customer_num].sex = strToInt(token[2]);
        customers[customer_num].course_num = strlen(token[3]);
        char str[MAX_NUM];
        for(int i=0; i<strlen(token[3]); i++){
            customers[customer_num].booked_course[i] = token[2][i]-'0';
        }
        customers[customer_num].amount_received = strToInt(token[4]);
        customers[customer_num].amount_receivable = strToInt(token[5]);
        customer_num++;
    }
    fflush(file);
    fclose(file);
    return ok;
}

/**
 * Write customer information on file
 */
int writeCustomer(){
    FILE * file = NULL;
    char cwd[MAX_NUM];
    // Get the work absolute address
    getcwd(cwd, sizeof(cwd));
    // Replace file separator in string
    for(int i=0; i<strlen(cwd); i++)
        if(cwd[i]=='\\')
            cwd[i] = '/';
    char filepath[MAX_NUM];
    strcpy(filepath, cwd);
    strcat(filepath, "/library/customer_information.txt");
    file = fopen(filepath, "w");
    if(file==NULL){
        printf("Write failed due to loss of critical files.\n");
        return error;
    }

    printf("Start writting information on file...\n");
    char data[1024];    // Used to store details of each course
    // Combine all details of every customer to a string and write
    for(int i=0; i<customer_num; i++){
        char str[100], temp[100];
        itoa(customers[i].id, str);
        strcat(data, str);
        strcat(data, " ");
        strcat(data, customers[i].name);
        strcat(data, " ");
        itoa(customers[i].sex, str);
        strcat(data, str);
        strcat(data, " ");
        for(int j=0; j<customers[i].course_num; j++){
            temp[j] = customers[i].booked_course[j]+'0';
        }
        strcat(data, temp);
        strcat(data, " ");
        itoa(customers[i].amount_received, str);
        strcat(data, str);
        strcat(data, " ");
        itoa(customers[i].amount_receivable, str);
        strcat(data, str);
        if(i!=customer_num-1)
            strcat(data, "\n");

        fputs(data, file);
    }
    printf("File write complete.\n");
    fflush(file);
    fclose(file);
    return ok;
}

/**
 * Print the course table
 */
void printCourseTable(){
    printf("Customer list:\n");
    for(int i=0; i<customer_num; i++){
        printf("%s", customers[i].id);
        printf(" ");
        printf("%s", customers[i].name);
        printf("\n");
    }
    printf(0);
    printf(" ");
    printf("Print all customers' course table\n");
    printf("------------------------------------\n");
    printf("Please enter the id you want to print:");
    int choice;
    scanf("%d", &choice);
    while (choice<0 || choice>customer_num){
        printf("The option you entered is invalid. Please re-enter:");
        scanf("%d", &choice);
    }
    if(choice!=0){
        choice--;
        printf("%s's courses table are as follows:\n", customers[choice].name);
        int index;
        for(int i=0; i<customers[choice].course_num; i++){
            index = customers[choice].booked_course[i]-1;
            printf("%s", courses[index].name);
            printf(" ");
            printf("%s", courses[index].start_month);
            printf(".");
            printf("%s", courses[index].start_day);
            printf(" during %d days.\n", courses[index].days);
        }
    }else{
        for(int j=1; j<=customer_num; j++){
            choice = j;
            choice--;
            printf("%s's courses table are as follows:\n", customers[choice].name);
            int index;
            for(int i=0; i<customers[choice].course_num; i++){
                index = customers[choice].booked_course[i]-1;
                printf("%s", courses[index].name);
                printf(" ");
                printf("%s", courses[index].start_month);
                printf(".");
                printf("%s", courses[index].start_day);
                printf(" during %d days.\n", courses[index].days);
            }
        }
    }
}

int colculateFee(int index){
    int fee = courses[index].admin_fee;
    fee += courses[index].days * courses[index].fee;
    fee += courses[index].days * courses[index].meal_ve;
    return fee;
}

/**
 * 
 */
int bookCourse(){
    printf("1.Exist customer\n");
    printf("2.New customer\n");
    printf("-----------------------------------\n");
    int choice, cu_id, co_id;
    printf("Please enter the option:");
    scanf("%d", &choice);
    if(choice==1){
        printf("Customer list:\n");
        for(int i=0; i<customer_num; i++){
            printf("%s", customers[i].id);
            printf(" ");
            printf("%s", customers[i].name);
            printf("\n");
        }
        printf("-----------------------------------\n");
        printf("Please choose which customer want to book:");
        scanf("%d", &cu_id);
        printCourse();
        printf("Please choose which course he/she want to book:");
        scanf("%d", &co_id);
        // If the chosen course has been booked before, return error
        for(int i=0; i<customers[cu_id-1].course_num; i++){
            if(customers[cu_id-1].booked_course[i]==co_id)
                return error;
        }
        // Else add the chosen course to list
        customers[cu_id-1].booked_course[customers[cu_id-1].course_num] = co_id;
        customers[cu_id-1].course_num++;
        // Concern he/she pay the bill immediately
        customers[cu_id-1].amount_received += colculateFee(co_id-1);
    }else{
        int n;
        char str[MAX_NUM];
        customers[customer_num].id = customer_num;
        printf("Please enter the name of customer:");
        scanf("%s", &str);
        strcpy(customers[customer_num].name, str);
        printf("Please enter the gender of customer:");
        scanf("%d", &n);
        customers[customer_num].sex = n;
        printCourse();
        printf("Please enter the course he/she want to book:");
        scanf("%d", &n);
        customers[customer_num].booked_course[customers[customer_num].course_num] = n;
        customers[customer_num].course_num++;
        customers[customer_num].amount_received = colculateFee(n-1);
        customers[customer_num].amount_receivable = 0;
        customer_num++;
    }
    printf("Booked successfully.\n");
    return ok;
}

/**
 * 
 */
void cancelCourse(){
    printf("Customer list:\n");
    for(int i=0; i<customer_num; i++){
        printf("%s", customers[i].id);
        printf(" ");
        printf("%s", customers[i].name);
        printf(" booked courses:");
        for(int j=0; j<customers[i].course_num; j++){
            printf("%s", customers[i].booked_course[j]);
            printf(" ");
        }
        printf("\n");
    }
    printf("-------------------------------------");
    int cu_id, co_id;
    printf("Please enter the customer id:");
    scanf("%d", &cu_id);
    printf("Please enter the course id:");
    scanf("%d", &co_id);
    for(int i=co_id-1; i<customers[cu_id-1].course_num-1; i++){
        customers[cu_id-1].booked_course[i] = customers[cu_id-1].booked_course[i+1];
    }
    customers[cu_id].amount_received -= colculateFee(co_id);
    printf("Cancel complete.");
}

/**
 * Change the information of course
 */
void changeCourse(){
    printCourse();
    int choice, course_id, m, d;
    printf("Please enter the course number you want to change:");
    scanf("%d", &course_id);
    while(course_id<=0 || course_id>course_num+1){
        printf("The option you entered is invalid. Please re-enter:");
        scanf("%d", &course_id);
    }
    printf("-------------------------------------\n");
    printf("1.Name\n");
    printf("2.Category\n");
    printf("3.Days\n");
    printf("4.Admin fee\n");
    printf("5.Fee\n");
    printf("6.Meal(vegetarian)\n");
    printf("7.Meal(non-vegetarian)\n");
    printf("Which attribute do you want to change:");
    scanf("%d", &choice);
    while(choice<=0 || choice>7){
        printf("The option you entered is invalid. Please re-enter:");
        scanf("%d", &choice);
    }
    int new_am;
    char new_str[MAX_NUM];
    course_id--;
    if(choice==1){
        printf("Please enter a new name:");
        scanf("%s", &new_str);
        strcpy(courses[course_id].name, new_str);
    }else if(choice==2){
        printf("Please enter a new category:");
        scanf("%s", &new_str);
        strcpy(courses[course_id].category, new_str);
    }else if(choice==3){
        printf("Please enter a new days:");
        scanf("%d", new_am);
        courses[course_id].days = new_am;
    }else if(choice==4){
        printf("Please enter a new admin fee:");
        scanf("%d", new_am);
        courses[course_id].admin_fee = new_am;
    }else if(choice==5){
        printf("Please enter a new fee:");
        scanf("%d", new_am);
        courses[course_id].fee = new_am;
    }else if(choice==6){
        printf("Please enter a new meal(vegetarian):");
        scanf("%d", new_am);
        courses[course_id].meal_ve = new_am;
    }else if(choice==7){
        printf("Please enter a new meal(non-vegetarian):");
        scanf("%d", new_am);
        courses[course_id].meal_nv = new_am;
    }
    printf("Change successfully.\n");
} 

/**
 * Make the date schedule
 */
void dateSchedule(){
    printCourse();
    int choice, m, d;
    printf("Please enter the course number you want to set:");
    scanf("%d", &choice);
    while(choice<=0 || choice>course_num+1){
        printf("The option you entered is invalid. Please re-enter:");
        scanf("%d", &choice);
    }
    printf("Set the start time of this %s course\n", courses[choice-1].name);
    printf("Please enter start month:");
    scanf("%d", &m);
    while(m<1 || m>12){
        printf("The option you entered is invalid. Please re-enter:");
        scanf("%d", &m);
    }
    printf("Please enter start day:");
    while(d<1 || d>31){
        printf("The option you entered is invalid. Please re-enter:");
        scanf("%d", &d);
    }
    courses[choice-1].start_month = m;
    courses[choice-1].start_day = d;
    printf("Set successfully\n");
    return;
}

/**
 * The menu function 
 */
int menu(){
    // print the menu.
    printf("-------------------------------------\n");
    printf("Welecome to Course Manager!\n");
    printf("1.Book Course\n");
    printf("2.Cancel Course\n");
    printf("3.Change Course\n");
    printf("4.Set Schedule\n");
    printf("5.Print All Amount Receivable\n");
    printf("6.Print Receivable and Received\n");
    printf("7.Exit\n");
    printf("-------------------------------------\n");
    printf("Please enter the function you need to perform:");
    int choice;
    scanf("%d", &choice);
    while(choice<1 || choice>7){
        printf("The option you entered is invalid. Please re-enter:");
        scanf("%d", &choice);
    }
    return choice;
}

int main(){
    readCourse();
    // readCustomer();
    while (1){
        int choice = menu();
        if(choice == 1)
            bookCourse();
        else if(choice==2)
            cancelCourse();
        else if(choice==3)
            changeCourse();
        else if(choice==4)
            dateSchedule();
        // Print total amount receivable and total payment received.
        else if(choice==5){
            int sum1 = 0, sum2 = 0;
            for(int i=0; i<customer_num; i++){
                sum1 += customers[i].amount_receivable;
                sum2 += customers[i].amount_received;
            }
            printf("All amount receivable:%d\n", sum1);
            printf("All amount received:%d\n", sum2);
        // Print amount receivable from each participant.
        }else if(choice==6){
            for(int i=0; i<customer_num; i++){
                printf("%s's amount received:", customers[i].name);
                printf("%s", customers[i].amount_received);
                printf(" amount receivable:%s\n", customers[i].amount_receivable);
            }
        }else
            break;
    }
    writeCourse();
    writeCustomer();
    return 0;
}