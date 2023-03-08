import java.util.Scanner;

public class users {

    public int USERcapacity;
    Scanner input = new Scanner(System.in);
    User theUsers[] = new User[USERcapacity];



    public static int count = 0;

    public void askingForUsersCapacity(){

        System.out.println("PLEASE ENTER THE CAPACITY OF YOUR LIBRARY FOR USERS");

        USERcapacity = input.nextInt();
    }


    public void addUsers(User u){

        for (int i = 0; i < count; i++) {

            if (u.passWord.equalsIgnoreCase(theUsers[i].passWord)){

                System.out.println("user of password " + u.passWord + " is Already Registered.");

            }

        }

        if (count <= USERcapacity){

            theUsers[count] = u;

            count++;
        }

    }


    public void showAllUsers(){

        System.out.println("username --- password");

        for (int i = 0; i < count; i++){

            System.out.println(theUsers[i].userName + " --- " + theUsers[i].passWord);

        }

    }

    public int doesUserExist(){

        System.out.println("Enter password:");

        String password = input.nextLine();

        for (int i = 0; i < count; i++){

            if (theUsers[i].passWord.equalsIgnoreCase(password)){

                return i;

            }

        }


        System.out.println("user is not Registered.");

        System.out.println("Get Registered First.");

        return -1;

    }

    public void rentBook(Library book){

        int userIndex = this.doesUserExist();

        if (userIndex != -1){

            System.out.println("renting ...");

            book.showAllBooks();

            Book b = book.removeBook();

            System.out.println("renting ...");

            if (b != null){

                if (theUsers[userIndex].booksCount <= 3){

                    System.out.println("adding book");

                    theUsers[userIndex].borrowedBooks[theUsers[userIndex].booksCount] = b;

                    theUsers[userIndex].booksCount++;

                    return;

                }

                else{

                    System.out.println("User Can not Borrow more than 3 Books.");

                    return;

                }

            }

            System.out.println("Book is not Available.");
        }


    }

    public void returnBook(Library book){

        int userIndex = this.doesUserExist();

        if (userIndex != -1){

            System.out.println("ISBN --- Book Name --- Author Name");

            User u = theUsers[userIndex];

            for (int i = 0; i < u.booksCount; i++){

                System.out.println(u.borrowedBooks[i].isbn + " --- " + u.borrowedBooks[i].bookName + " --- " + u.borrowedBooks[i].authorName);

            }

            System.out.println("Enter ISBN of Book to be returned:");

            int ISBN = input.nextInt();

            for (int i = 0; i < u.booksCount; i++){

                if (ISBN == u.borrowedBooks[i].isbn){

                    book.returnBook(u.borrowedBooks[i]);

                    u.borrowedBooks[i] = null;

                }

            }

            System.out.println("Book of ISBN " + ISBN + "not Found");

        }

    }

}
