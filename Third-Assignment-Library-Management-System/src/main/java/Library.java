import java.util.Scanner;

public class Library {

    public int BOOKcapacity;
    Book theBooks[] = new Book[BOOKcapacity];


    public static int count;

    Scanner input = new Scanner(System.in);

    public void askingForBookCapacity(){

        System.out.println("PLEASE ENTER THE CAPACITY OF YOUR LIBRARY FOR ADDING BOOKS");

        BOOKcapacity = input.nextInt();
    }


    public int compareBookObjects(Book b1, Book b2){

        if (b1.bookName.equalsIgnoreCase(b2.bookName)){

            System.out.println("Book of this Name Already Exists.");

            return 0;

        }

        if (b1.isbn == b2.isbn){

            System.out.println("Book of this Serial No Already Exists.");

            return 0;

        }

        return 1;

    }


    public void addBook(Book b) {

        for (int i = 0; i < count; i++) {

            if (this.compareBookObjects(b, this.theBooks[i]) == 0)

                return;
        }

        if (count < BOOKcapacity){

            theBooks[count] = b;

            count++;
        }

        else{

            System.out.println("No Space to Add More Books.");
        }

    }

    public void searchByISBN(){

        System.out.println("SEARCH BY SERIAL NUMBER");

         int ISBN;

        System.out.println("Enter ISBN of Book:");

        ISBN = input.nextInt();

        int flag = 0;

        System.out.println("ISBN - Name - Author - Available Qty - Total Qty - publish year");

        for (int i = 0; i < count; i++){

            if (ISBN == theBooks[i].isbn){

                System.out.println(theBooks[i].isbn + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty + "\t\t" + theBooks[i].publishYear);

                flag++;

            }
        }

        if (flag == 0){

            System.out.println("No Book for ISBN " + ISBN + " Found.");
        }

    }


    public void searchByAuthorName(){

        // Display message
        System.out.println("SEARCH BY AUTHOR'S NAME");

        System.out.println("Enter Author Name:");

        String authorName = input.nextLine();

        int flag = 0;

        System.out.println("ISBN - Name - Author - Available Qty - Total Qty - publish year");

        for (int i = 0; i < count; i++) {

            if (authorName.equalsIgnoreCase(theBooks[i].authorName)){

                System.out.println(theBooks[i].isbn + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty + "\t\t" + theBooks[i].publishYear);

                flag++;

            }

        }


        if (flag == 0){

            System.out.println("No Books of " + authorName + " Found.");
        }

    }

    public void showAllBooks(){

        System.out.println("SHOWING ALL BOOKS");

        System.out.println("ISBN - Name - Author - Available Qty - Total Qty - publish year");

        for (int i = 0; i < count; i++) {

            System.out.println(theBooks[i].isbn + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty + "\t\t" + theBooks[i].publishYear);

        }

    }


    public void changeBookQty(){

        System.out.println("CHANGE QUANTITY OF A BOOK\n");

        System.out.println("Enter ISBN of Book");

        int ISBN = input.nextInt();

        for (int i = 0; i < count; i++){

            if (ISBN == theBooks[i].isbn){

                // Display message
                System.out.println("Enter Number of Books to be Added or Removed \n ATTENTION: if you want to increase just type a positive number like \n2 and if you want to decrease write a negative number like -2 ");

                int addingQty = input.nextInt();

                theBooks[i].bookQty += addingQty;

                theBooks[i].bookQtyCopy += addingQty;

                return;
            }
        }
    }

    public int doesBookExists(int ISBN){

        for (int i = 0; i < count; i++){

            if (ISBN == theBooks[i].isbn){

                if (theBooks[i].bookQtyCopy > 0){

                    System.out.println("Book exists.");

                    return i;
                }

                System.out.println("Book does not exist");

                return -1;
            }
        }

        System.out.println("No Book of ISBN " + " Available in Library.");

        return -1;
    }


    public Book removeBook(){

        System.out.println("Enter ISBN of Book to be Checked Out.");

        int ISBN = input.nextInt();

        int bookIndex = doesBookExists(ISBN);

        if (bookIndex != -1){

            theBooks[bookIndex].bookQtyCopy--;

            return theBooks[bookIndex];

        }

        return null;

    }


    public void returnBook(Book b){

        for (int i = 0; i < count; i++){

            if (b.equals(theBooks[i])){

                theBooks[i].bookQtyCopy++;

            }
        }
    }
}

