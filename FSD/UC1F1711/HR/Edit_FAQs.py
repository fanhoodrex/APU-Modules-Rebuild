import time

def Upload_FAQs():
    """HR's Function that used for Uploading University's FAQs, and store the policy in dictionary
    then write it to plain text file """

    FAQs = {} # initialize the empty FAQs dictionary 
    n = 1 # Declare the policy counting number 

    while True:
        policy = input(f"Pls Enter {n} University's Policies and integer [-1] for exit:") # string type user input
        
        if policy == str(-1): #Exit the Uploading
            print("Upload the policy and exit successfully!!! ")
            time.sleep(1)
            break

        else: # Enter the Leave policy rule 
            FAQs[n] = policy # add the policy value to the dictionary
            print(f"Add the {n} policy successfully and the current FAQs shown as below")
            time.sleep(1) # pause 1 second
            print(FAQs) # display current FAQs enter
            n += 1
            continue
    
    with open("Leave Policies.txt","w") as f: # write the policies to plain txt file
        for k,v in FAQs.items(): # iterate the policy dictionary 
            f.write(f"{k}:{v}\n")

    return FAQs

FAQs = Upload_FAQs()

def Update_FAQs():
    """Update the current FAQs by altering the FAQs dictionary then rewite to the plain txt file"""

    while True:
        choice = int(input("1.Add new policy OR 2.Change the current policy rule 3. Finished and Exit:"))

        if choice == 1: # Add new policy
            FAQs[len(FAQs)] = input("Enter new policy:")
            print("Successfully add the new policy !")
            time.sleep(1)
            print(FAQs)

        elif choice == 2: # Change the current policy rule
            print(FAQs) # display the FAQs first
            print("\n") # print one new line
            num = int(input("Which number of policy you wanna change?:")) # ask user input for the number of policy
            FAQs[num] = input("Enter the changed policy:") #ask user input for the policy content after changing
            print(f"Successfully change the content of {num} policy !")
            time.sleep(1)
            print(FAQs)

        else:
            print("Pls enter correct number within range [1,2,3]....")
            time.sleep(1)
            continue
    return None
