import time # we need the time module for program pause

def get_books():
    """prompt the user to enter the book title, quantity, read them as one text
    one by one and stop reading the titles when user enters -1. 
    Save all the titles, quantity into a text file named books.txt"""

    print("Getting Books Infor")
    while True: # loop of user input
        title_quantity = input("Enter your book titles and quantity[-1 to end]:")
        if title_quantity != str(-1):
            with open('books.txt','a') as f: # open the txt file for writing
                f.write(title_quantity)
                f.write("\n")
        else:
            break
    print("\n")
    return None

def show_books():
    """Read all contents of the file books.txt and display them on screen"""
    
    print("Display Books Info as in File")
    with open('books.txt ','r') as f: # open the txt file for writing
        print(f.read())
    return None

def show_books_by_title():
    """read all the book titles,quantity from file books.txt and
    add them to a list named books.Sort them alphabetically by book title
    and display them on the screen"""

    print("Display Books Info alphabetically")
    with open('books.txt','r') as f:# open the txt file for writing
        books = sorted(f.readlines()) # returns a list of remaining lines as element alphabetically.
        for ele in books: # iterate the list and print it out
            print(ele,end='') # eliminate the \n new line
            time.sleep(0.5)
    print("\n")
    return None

def compute_book_stock():
    """read all the book titles, quantity from the file books.txt and
    compute the total number of books. Display the book stock on screen"""
  
    print("Display Books Stock")
    total = 0 # initialize the total value as zero
    with open('books.txt','r') as f: #open in read mode
        book_list = f.readlines() # return every line in that file as list
        for ele in book_list: # iterate through the book_list
            total += int(ele[-2]) # access the book quantity from each element of the book_list
    print(f"Total number of books = {total}")

get_books()
time.sleep(2)
show_books()
time.sleep(2)
show_books_by_title()
time.sleep(2)
compute_book_stock()