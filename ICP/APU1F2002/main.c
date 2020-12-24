#include <stdio.h> /*header files*/
#include <string.h>
#include <stdlib.h>
#pragma warning (disable: 4996)/*disable string error*/

struct Hospital {
    char HID[5];
    char HName[20];
    char Haddress[20];
    char Hphone[20];
    int Hage;
    char HChosenPlan[10];
    char HChosenClaim[25];
    int Hblance;
    int Roomfee;
    int ICUFee;
    int Totalfee;
    int HSSFee;
    int SFee;
    int OthersFee;
}h;

struct Patient {
    char ID[5];
    char Name[20];
    char address[20];
    char phone[20];
    int age;
    char ChosenPlan[10];
    char ChosenClaim[25];
    int balance;

}p;
/*declare the functions*/
char plan, plantype;
void Register();
void DisplayAllRecord();
void updateBalance(char id[5], int balance);
void Hospitlization();
void SearchByAge(int age);
void SearchByID(char id[5]);
void SearchByPlan(char plan[10]);
void SearchByPlanType(char planType[25]);
void TotalLifeTime();
void TotalAnnual();

/*system functions*/
int main(void) {
    char MenuOption, search, ID[5], planOption, planType, displayOption;
    int Page;
    FILE* FP = fopen("patient.txt","a");
    fclose(FP);
    FILE* FP2 = fopen("Hospital.txt", "a");
    fclose(FP2);
    do
    {
        printf("\n<><><><><><  MEDILIFE HELATH INSURANCE SCHEME ><><><><><>");
        printf("\n1) Register new patient");
        printf("\n2) Patient Claim Options");
        printf("\n3) Search for Patients");
        printf("\n4) View Hospital Records");
        printf("\n0) Quit");
        printf("\nChoose your option: "); scanf("%s", &MenuOption);
        switch (MenuOption)
        {
            case '1'://register new patient
                Register();
                break;
            case '2'://patient claim option
                Hospitlization();
                break;
            case '3'://search for patient
                printf("\n1. Search based on Patient ID\n2. Search based on Patient Age\n3. Search based on Plan\n4. Search based on Plan Type");
                printf("\nEnter option: "); scanf("%s", &search);
                switch (search)
                {
                    case '1':
                        printf("\nEnter patient ID: "); scanf("%s", &ID);
                        SearchByID(ID);
                        break;
                    case '2':
                        printf("\nEnter patient age: "); scanf("%d", &Page);
                        SearchByAge(Page);
                        break;
                    case '3':
                        printf("\n1. Plan120\t2. Plan150\t3. Plan200\nEnter one choice: "); scanf("%s", &planOption);
                        if (planOption == '1')
                            SearchByPlan("Plan120");
                        else if (planOption == '2')
                            SearchByPlan("Plan150");
                        else if (planOption == '3')
                            SearchByPlan("Plan200");
                        else
                            printf("\nWrong input Try again (Click Enter)\n");
                        break;
                    case '4':
                        printf("\n1.Annual Claim Limit\t2. Lifetime Claim Limit\nEnter one choice: "); scanf("%s", &planType);
                        if (planType == '1')
                            SearchByPlanType("Annual Claim Limit");
                        else if (planType == '2')
                            SearchByPlanType("Lifetime Claim Limit");
                        else
                            printf("\nWrong input Try again (Click Enter)\n");
                        break;
                    default:
                        printf("\nWrong input Try again (Click Enter)\n");
                        break;
                }
                break;
            case '4'://view hospital
                printf("\n1) Total amount claimed by Lifetime Claim Limit subscribers");
                printf("\n2) Total number of Annual Claim Limit subscribers who have exhausted Their Balance");
                printf("\n3) Print all Hospital records");
                printf("\nEnter option: "); scanf("%s", &displayOption);
                if (displayOption == '1')
                    TotalLifeTime();
                else if (displayOption == '2')
                    TotalAnnual();
                else if (displayOption == '3')
                    DisplayAllRecord();
                else
                    printf("\nWrong input Try again (Click Enter)\n");
                break;
            case '0'://exit
                exit(1);
                break;
            default:
                printf("\nWrong input Try again (Click Enter)\n");
                break;
        }

    } while (MenuOption != '0');
    return 0;
}
void Hospitlization() {
    FILE* FP2 = fopen("patient.txt", "r");/*open the patient txt for reading*/
    FILE* FP = fopen("Hospital.txt", "a");
    char Id[20];
    int room, ICU, conf;
    int roomDays, ICUDays, ICUFee =0, planf=0;

    printf("\n-*********************************************************************************************-");
    printf("\nEZMediLife Health Insurance Plan ");
    printf("\n-*********************************************************************************************-");
    printf("\nPlans>                                      |            Plan120         Plan150        Plan200");
    printf("\nHospitalisation and Surgical Benefits ");
    printf("\n_______________________________________________________________________________________________");
    printf("\nRoom Charges >                                         120/Day          150/Day         200/Day");
    printf("\n_______________________________________________________________________________________________");
    printf("\nIntensive Care Unit (ICU) Charges >                    250/Day          400/Day         700/Day");
    printf("\n_______________________________________________________________________________________________");
    printf("\nHospital Supplies and Services                                                                 ");
    printf("\nSurgical Fees                         As charged. Subject to approval by EZMediLife            ");
    printf("\nOther Fees                                                                                     ");
    printf("\n_______________________________________________________________________________________________");
    printf("\n-*********************************************************************************************-");
    printf("\nEnter patient ID: "); scanf("%s", &Id);
    while (fread(&p, sizeof(p), 1, FP2)) {
        if (strcmp(p.ID,Id) == 0) {
            printf("\nID       : %s", p.ID);
            printf("\nname     : %s", p.Name);
            printf("\naddress  : %s", p.address);
            printf("\nphone    : %s", p.phone);
            printf("\nAge      : %d", p.age);
            printf("\nPlan     : %s", p.ChosenPlan);
            printf("\nPlan type: %s", p.ChosenClaim);
            printf("\nBalance  : %d\n", p.balance);
        }
    }
    fclose(FP2);
    strcpy(h.HID, p.ID);
    strcpy(h.HName, p.Name);
    strcpy(h.Hphone, p.phone);
    h.Hage = p.age;
    strcpy(h.Haddress, p.address);
    strcpy(h.HChosenClaim, p.ChosenClaim);
    strcpy(h.HChosenPlan, p.ChosenPlan);
    if (strcmp(p.ChosenPlan, "Plan120") == 0)
        planf = 120;
    else if (strcmp(p.ChosenPlan, "Plan150") == 0)
        planf = 150;
    else if (strcmp(p.ChosenPlan, "Plan200") == 0)
        planf = 200;
    printf("\n---------------------------------------------------------------------");
    h.Roomfee = 0;
    h.ICUFee = 0;
    printf("\nWould you like to have a room?(1.Yes/2.No): "); scanf("%d", &room);
    if (room == 1) {
        printf("\nFor how many days would like to claim? "); scanf("%d", &roomDays);
        h.Roomfee = roomDays* planf;
    }
    printf("\nWould you like to have a Intensive Care Unit (ICU)?(1.Yes/2.No):"); scanf("%d", &ICU);
    if (ICU == 1) {
        printf("\nFor how many days would like to claim? "); scanf("%d", &ICUDays);
        h.ICUFee = planf* ICUDays;
    }
    printf("\nHospital Supplies and Services Fees (RM):"); scanf("%d", &h.HSSFee);
    printf("\nSurgical Fees  (RM): "); scanf("%d", &h.SFee);
    printf("\nOthers(RM): "); scanf("%d", &h.OthersFee);
    h.Totalfee = h.OthersFee + h.HSSFee + h.SFee + h.Roomfee + h.ICUFee;
    printf("\n-*********************************************************************************************-");
    printf("\nRoom Charges: %d", h.Roomfee);
    printf("\nIntensive Care Unit (ICU) Charges: %d", h.ICUFee);
    printf("\nSurgical Fees  (RM): %d", h.SFee);
    printf("\nOthers (RM): %d", h.OthersFee);
    printf("\nTotal Charged RM: %d", h.Totalfee);
    printf("\nYour current balance: %d ", p.balance);
    printf("\nWould you like to confirm your claim?(1.Yes/2.No):"); scanf("%d", &conf);
    if (conf == 2) {
        printf("\n The process canceled\n");
        return;
    }
    if (p.balance < h.Totalfee) {
        printf("\nYou do not have enough money !!");
        return;
    }
    h.Hblance =p.balance- h.Totalfee;
    printf("\nBalance after claim RM: %d\n", h.Hblance);
    fwrite(&h, sizeof(h), 1,FP);
    fclose(FP);
    updateBalance(p.ID, h.Hblance);
    printf("\nThe process done successfully\n");
    return;
}
void updateBalance(char id[5], int balance)
{
    FILE* fp;
    FILE* FtempFile;
    fp = fopen("patient.txt", "r");
    FtempFile = fopen("TempF.txt", "w");
    while (fread(&p, sizeof(p), 1, fp)){
        if (strcmp(p.ID, id) != 0)/*copying the data into the tempfile*/
            fwrite(&p, sizeof(p), 1, FtempFile);
        else {
            p.balance = balance;
            fwrite(&p, sizeof(p), 1, FtempFile);
            //update the new data//
        }
    }
    fclose(FtempFile);/*close both files and save changes made*/
    fclose(fp);
    fp = fopen("patient.txt", "w");
    FtempFile = fopen("TempF.txt", "r");
    while (fread(&p, sizeof(p), 1, FtempFile)) {
        fwrite(&p, sizeof(p), 1, fp);
    }
    fclose(FtempFile);/*close both files and save the changes*/
    fclose(fp);
    return;
}
void SearchByID(char id[5]) {
    FILE* FP = fopen("patient.txt", "r");
    while (fread(&p, sizeof(p), 1, FP)) {
        if (strcmp(id,p.ID) == 0) {
            printf("\nID       : %s", p.ID);
            printf("\nname     : %s", p.Name);
            printf("\naddress  : %s", p.address);
            printf("\nphone    : %s", p.phone);
            printf("\nAge      : %d", p.age);
            printf("\nPlan     : %s", p.ChosenPlan);
            printf("\nPlan type: %s", p.ChosenClaim);
            printf("\nBalance  : %d\n", p.balance);
        }
    }
    fclose(FP);
}
void SearchByAge(int age) {
    FILE* FP = fopen("patient.txt", "r");
    while (fread(&p, sizeof(p), 1, FP)) {
        if (age== p.age) {
            printf("\nID       : %s", p.ID);
            printf("\nname     : %s", p.Name);
            printf("\naddress  : %s", p.address);
            printf("\nphone    : %s", p.phone);
            printf("\nAge      : %d", p.age);
            printf("\nPlan     : %s", p.ChosenPlan);
            printf("\nPlan type: %s", p.ChosenClaim);
            printf("\nBalance  : %d\n", p.balance);
        }
    }
    fclose(FP);
}
void SearchByPlan(char plan[10]) {
    FILE* FP = fopen("patient.txt", "r");
    while (fread(&p, sizeof(p), 1, FP)) {
        if (strcmp(plan, p.ChosenPlan) == 0) {
            printf("\nID       : %s", p.ID);
            printf("\nname     : %s", p.Name);
            printf("\naddress  : %s", p.address);
            printf("\nphone    : %s", p.phone);
            printf("\nAge      : %d", p.age);
            printf("\nPlan     : %s", p.ChosenPlan);
            printf("\nPlan type: %s", p.ChosenClaim);
            printf("\nBalance  : %d\n", p.balance);
        }
    }
    fclose(FP);
}
void SearchByPlanType(char planType[25]) {
    FILE* FP = fopen("patient.txt", "r");
    while (fread(&p, sizeof(p), 1, FP)) {
        if (strcmp(planType, p.ChosenClaim) == 0) {
            printf("\nID       : %s", p.ID);
            printf("\nname     : %s", p.Name);
            printf("\naddress  : %s", p.address);
            printf("\nphone    : %s", p.phone);
            printf("\nAge      : %d", p.age);
            printf("\nPlan     : %s", p.ChosenPlan);
            printf("\nPlan type: %s", p.ChosenClaim);
            printf("\nBalance  : %d\n", p.balance);
        }
    }
    fclose(FP);
}
void DisplayAllRecord() {
    FILE* filep = fopen("Hospital.txt", "r");
    while (fread(&h, sizeof(h), 1, filep)) {
        printf("\nID       : %s", h.HID);
        printf("\nname     : %s", h.HName);
        printf("\naddress  : %s", h.Haddress);
        printf("\nphone    : %s", h.Hphone);
        printf("\nAge      : %d", h.Hage);
        printf("\nPlan     : %s", h.HChosenPlan);
        printf("\nPlan type: %s", h.HChosenClaim);
        printf("\nRoom Fee : %d", h.Roomfee);
        printf("\nIntensive Care Unit (ICU) Charges: %d", h.ICUFee);
        printf("\nSurgical Fees(RM): %d", h.SFee);
        printf("\nOthers(RM)       : %d", h.OthersFee);
        printf("\nTotal Charged RM : %d", h.Totalfee);
        printf("\nCurrent Balance  : %d\n", h.Hblance);
        printf("\n-----------------------------------------------\n");
    }
    fclose(filep);
}
void TotalLifeTime() {
    int total = 0;
    FILE* FP = fopen("Hospital.txt", "r");
    while (fread(&h, sizeof(h), 1, FP)) {
        total += h.Totalfee;
    }
    fclose(FP);
    printf("\nTotal Amount Claim by Lifetime Claim Limit: %d\n", total);
}
void TotalAnnual() {
    int num = 0;
    FILE* FP = fopen("patient.txt", "r");
    while (fread(&p, sizeof(p), 1, FP)) {
        if ((strcmp(p.ChosenClaim, "Annual Claim Limit")==0)&& p.balance == 0)
            num++;
    }
    fclose(FP);
    printf("\nTotal number of Annual Claim Limit subscribers \nwho have exhausted all their eligible amount.: %d\n", num);
}
void Register() {
    FILE* FP = fopen("patient.txt", "a");
    double ageDay=0;
    printf("\n<><><><><><  Register new patient ><><><><><>");
    printf("\nEnter patient ID: "); scanf("%s", &p.ID);
    printf("\nEnter patient name: "); scanf("%s", &p.Name);
    printf("\nEnter patient Address: "); scanf("%s", &p.address);
    printf("\nEnter patient Phone: "); scanf("%s", &p.phone);
    do
    {
        printf("\n<>NOTE: The age must be less than 54");
        printf("\nEnter patient age: "); scanf("%d", &p.age);
        ageDay = p.age * 12 * 30;
    } while (ageDay >19440 || ageDay <15);

    //choosing the plan
    if (ageDay <= 7200 && ageDay > 15) {
        printf("\n-*********************************************************************************************-");
        printf("\nEZMediLife Health Insurance Plan ");
        printf("\n-*********************************************************************************************-");
        printf("\nPlans>                                      |            Plan120         Plan150        Plan200");
        printf("\n_______________________________________________________________________________________________");
        printf("\n15 days old – 20 Years Old Avaialbalilty >  |	           Allowed         Allowed        Allowed");
        printf("\n_______________________________________________________________________________________________");
        printf("\nAnnual Claim Limit Amount > 	              |            120,000 	       150,000 	     200,000 ");
        printf("\n_______________________________________________________________________________________________");
        printf("\nLifetime Claim Limit Amount > 	          |            600,000 	       750,000      1,000,000");
        printf("\n-*********************************************************************************************-");
        printf("\nHospitalisation and Surgical Benefits ");
        printf("\n_______________________________________________________________________________________________");
        printf("\nRoom Charges >                                         120/Day          150/Day         200/Day");
        printf("\n_______________________________________________________________________________________________");
        printf("\nIntensive Care Unit (ICU) Charges >                    250/Day          400/Day         700/Day");
        printf("\n_______________________________________________________________________________________________");
        printf("\nHospital Supplies and Services                                                                 ");
        printf("\nSurgical Fees                         As charged. Subject to approval by EZMediLife            ");
        printf("\nOther Fees                                                                                     ");
        printf("\n_______________________________________________________________________________________________");
        printf("\n-*********************************************************************************************-");
        printf("\n Your age is: %d", p.age);
        printf("\nChoose any plan from these");
        top:
        printf("\n1. Plan120\t2. Plan150\t3. Plan200\nEnter one choice: "); scanf("%s", &plan);
        if (plan == '1') {
            strcpy(p.ChosenPlan, "Plan120");
        }
        else if(plan == '2')
        {
            strcpy(p.ChosenPlan, "Plan150");
        }
        else if (plan == '3')
        {
            strcpy(p.ChosenPlan, "Plan200");
        }
        else {
            printf("\nWrong input, retry again");
            goto top;
        }
    }
    else if (ageDay <= 14400 && ageDay > 7200) {
        printf("\n-*********************************************************************************************-");
        printf("\nEZMediLife Health Insurance Plan ");
        printf("\n-*********************************************************************************************-");
        printf("\nPlans>                                      |            Plan120         Plan150        Plan200");
        printf("\n_______________________________________________________________________________________________");
        printf("\n21 – 40 Years Old Avaialbalilty >           |	           Not Allowed     Allowed        Allowed");
        printf("\n_______________________________________________________________________________________________");
        printf("\nAnnual Claim Limit Amount > 	              |            120,000 	       150,000 	     200,000 ");
        printf("\n_______________________________________________________________________________________________");
        printf("\nLifetime Claim Limit Amount > 	          |            600,000 	       750,000      1,000,000");
        printf("\n-*********************************************************************************************-");
        printf("\nHospitalisation and Surgical Benefits ");
        printf("\n_______________________________________________________________________________________________");
        printf("\nRoom Charges >                                         120/Day          150/Day         200/Day");
        printf("\n_______________________________________________________________________________________________");
        printf("\nIntensive Care Unit (ICU) Charges >                    250/Day          400/Day         700/Day");
        printf("\n_______________________________________________________________________________________________");
        printf("\nHospital Supplies and Services                                                                 ");
        printf("\nSurgical Fees                         As charged. Subject to approval by EZMediLife            ");
        printf("\nOther Fees                                                                                     ");
        printf("\n_______________________________________________________________________________________________");
        printf("\n-*********************************************************************************************-");
        printf("\n Your age is: %d", p.age);
        printf("\nChoose any plan from these");
        top3:
        printf("\n1. Plan150\t2. Plan200\nEnter one choice: "); scanf("%s", &plan);
        if (plan == '1') {
            strcpy(p.ChosenPlan, "Plan150");
        }
        else if (plan == '2')
        {
            strcpy(p.ChosenPlan, "Plan200");
        }
        else {
            printf("\nWrong input, retry again");
            goto top3;
        }
    }
    else if (ageDay <= 19440 && ageDay > 14400) {
        printf("\n-*********************************************************************************************-");
        printf("\nEZMediLife Health Insurance Plan ");
        printf("\n-*********************************************************************************************-");
        printf("\nPlans>                                      |            Plan120         Plan150        Plan200");
        printf("\n_______________________________________________________________________________________________");
        printf("\n41 – 54 Years Old Avaialbalilty >           |	           Not Allowed     Not Allowed    Allowed ");
        printf("\n_______________________________________________________________________________________________");
        printf("\nAnnual Claim Limit Amount > 	              |            120,000 	       150,000 	     200,000 ");
        printf("\n_______________________________________________________________________________________________");
        printf("\nLifetime Claim Limit Amount > 	          |            600,000 	       750,000      1,000,000");
        printf("\n-*********************************************************************************************-");
        printf("\nHospitalisation and Surgical Benefits ");
        printf("\n_______________________________________________________________________________________________");
        printf("\nRoom Charges >                                         120/Day          150/Day         200/Day");
        printf("\n_______________________________________________________________________________________________");
        printf("\nIntensive Care Unit (ICU) Charges >                    250/Day          400/Day         700/Day");
        printf("\n_______________________________________________________________________________________________");
        printf("\nHospital Supplies and Services                                                                 ");
        printf("\nSurgical Fees                         As charged. Subject to approval by EZMediLife            ");
        printf("\nOther Fees                                                                                     ");
        printf("\n_______________________________________________________________________________________________");
        printf("\n-*********************************************************************************************-");
        printf("\n Your age is: %d", p.age);
        strcpy(p.ChosenPlan, "Plan200");
    }
    top2:
    printf("\nChoose any plan type from these");
    printf("\n1.Annual Claim Limit\t2. Lifetime Claim Limit\nEnter one choice: "); scanf("%s", &plantype);
    switch (plantype)
    {
        case '1':
            strcpy(p.ChosenClaim, "Annual Claim Limit");
            if (plan == '1')
                p.balance = 120000;
            else if (plan == '2')
                p.balance = 150000;
            else
                p.balance = 200000;
            break;

        case '2':
            strcpy(p.ChosenClaim, "Lifetime Claim Limit");
            if (plan == '1')
                p.balance = 600000;
            else if (plan == '2')
                p.balance = 750000;
            else
                p.balance = 1000000;
            break;
        default:
            printf("\nWrong input, retry again");
            goto top2;
            break;
    }
    fwrite(&p, sizeof(p), 1,FP);//write to the file
    fclose(FP);
    printf("\n            <> RECORD CREATED SUCCESSFULLY <>\n");
    return;
}