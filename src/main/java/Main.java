import java.util.Scanner;

public class Main {
    /*
     * make a functional library app using oop
     * run the main program in Main.java and code the oop part in other classes
     * don't forget to add at least 1 librarian to the library to make it functionable.
     * *  *** don't limit yourself to our template ***
     */

    private static Library library = new Library("sun");
    private static Librarian firstLibrarian = new Librarian("firstLibrarian", "0000");
    private static Book firstBook = new Book("Harry Potter", "J. K. Rowling", 1997, 2);

    public static void main(String[] args){
        int option, ex;
        do
        {
            try (Scanner sc = new Scanner(System.in);) {
                System.out.println("Enter your choice from the following menu:");
                System.out.println("1.User 2.Librarian 3.Exit");
                option = sc.nextInt();
                if(option != 3){
                    System.out.println("Username: ");
                    String username = sc.next();
                    System.out.println(username);
                    System.out.println("Password: ");
                    String password = sc.next();
                    System.out.println(password);
                    //check username and password
                }
                else
                    break;
                runMenu(option);
            }
        }while(true);
    }


    public static void runMenu(int choice){
        if (choice == 1) {
            int option, ex;
            do
            {
                try (Scanner sc = new Scanner(System.in)) {
                    System.out.println("Enter your choice from the following menu:");
                    System.out.println("1.Rent Book 2.Return Book 3.Exit");
                    option = sc.nextInt();
                    if(option == 1){
                        //call rent function
                    } else if (option == 2) {
                        //call return function
                    } else {
                        break;
                    }
                    System.out.println("Do you want to continue? 1.Yes 2.No");
                    ex=sc.nextInt();
                }
            }while(ex==1);
        } else if (choice == 2) {
            int option, ex;
            do
            {
                try (Scanner sc = new Scanner(System.in)) {
                    System.out.println("Enter your choice from the following menu:");
                    System.out.println("1.Add Book 2.Remove Book 3.Search Book");
                    System.out.println("4.Add User 5.Remove User 6.Search User");
                    System.out.println("7.Add Librarian 8.Remove librarian 9.Search Librarian");
                    option = sc.nextInt();
                    if(option == 1){
                        System.out.println("Book name: ");
                        String bookName = sc.next();
                        System.out.println("Author name: ");
                        String authorName = sc.next();
                        System.out.println("Year of publish: ");
                        int Year = sc.nextInt();
                        System.out.println("ISBN: ");
                        int ISBN = sc.nextInt();
                        Book newBook = new Book(bookName, authorName, Year, ISBN);
                        library.addBook(newBook);
                    } else if (option == 2) {
                        //call remove book
                    } else if (option == 3) {
                        //call search book
                    } else if (option == 4) {
                        //call add user
                    } else if (option == 5) {
                        //call remove user
                    } else if (option == 6) {
                        //call search user
                    } else if (option == 7) {
                        //call add librarian
                    } else if (option == 8) {
                        //call remove librarian
                    } else if (option == 9) {
                        //call search librarian
                    }
                    else {
                        break;
                    }
                    System.out.println("Do you want to continue? 1.Yes 2.No");
                    ex=sc.nextInt();
                }
            }while(ex==1);
        }
    }
}
