import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    /*
     * make a functional library app using oop
     * run the main program in Main.java and code the oop part in other classes
     * don't forget to add at least 1 librarian to the library to make it functionable.
     * *  *** don't limit yourself to our template ***
     */

    private static Scanner sc = new Scanner(System.in);
    private static Library library = new Library("sun");
    //librarian
    private static Librarian firstLibrarian = new Librarian("firstLibrarian", "0000");
    private static Book firstBook = new Book("Harry Potter", "J. K. Rowling", 1997, 2);
    private static User firstUser = new User("Haleh", "0000");

    ArrayList<String> ExistedBooks = library.getExistedBooks();
    Map<String, Integer> NumberOfBooks = library.getNumberOfBooks();
    ArrayList<Librarian> Librarians = library.getLibrarians();
    Map<String, String> librarians = library.getlibrarians();
    ArrayList<User> Users = library.getUsers();
    Map<String, String> users = library.getusers();

    public static void main(String[] args){
        do
        {       System.out.println("Enter your choice from the following menu:");
                System.out.println("1.User 2.Librarian 3.Exit");
                int choice;
                choice = sc.nextInt();
            if(choice == 1){
                    System.out.println("Username: ");
                    String username = sc.next();
                    System.out.println(username);
                    System.out.println("Password: ");
                    String password = sc.next();
                    System.out.println(password);
                    User newUser = new User(username, password);
                    if(library.doesUserExist(newUser)){
                        library.loginUser(newUser);
                    } else {
                        break;
                    }
            }
            else if(choice == 2){
                    System.out.println("Username: ");
                    String username = sc.next();
                    System.out.println(username);
                    System.out.println("Password: ");
                    String password = sc.next();
                    System.out.println(password);
                    Librarian newLibrarian = new Librarian(username, password);
                    if(library.doesLibrarianExist(newLibrarian)){
                        library.loginLibrarian(newLibrarian);
                    } else {
                        break;
                    }
            }
                else {
                    break;
                }
                runMenu(choice);
        }while(true);
    }


    public static void runMenu(int choice) {
        int ex = 0;
        do {
            int option;
            if (choice == 1) {
                System.out.println("Enter your choice from the following menu:");
                System.out.println("1.Rent Book 2.Return Book 3.Exit");
                option = sc.nextInt();
                if (option == 1) {
                    //call rent function
                } else if (option == 2) {
                    //call return function
                } else {
                    break;
                }
                System.out.println("Do you want to continue? 1.Yes 2.No");
                ex = sc.nextInt();
            } else if (choice == 2) {
                System.out.println("Enter your choice from the following menu:");
                System.out.println("1.Add Book 2.Remove Book 3.Search Book");
                System.out.println("4.Add User 5.Remove User 6.Search User");
                System.out.println("7.Add Librarian 8.Remove librarian 9.Search Librarian");
                option = sc.nextInt();
                if (option == 1) {
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
                    System.out.println("Book name: ");
                    String bookName = sc.next();
                    library.removeBook(bookName);
                } else if (option == 3) {
                    System.out.println("Book name: ");
                    String bookName = sc.next();
                    library.searchBook(bookName);
                } else if (option == 4) {
                    System.out.println("Username: ");
                    String username = sc.next();
                    System.out.println("Password: ");
                    String password = sc.next();
                    User newUser = new User(username, password);
                    library.addUser(newUser);
                } else if (option == 5) {
                    System.out.println("Username: ");
                    String username = sc.next();
                    System.out.println("Password: ");
                    String password = sc.next();
                    User newUser = new User(username, password);
                    library.removeUser(newUser);
                } else if (option == 6) {
                    System.out.println("Username: ");
                    String username = sc.next();
                    System.out.println("Password: ");
                    String password = sc.next();
                    User newUser = new User(username, password);
                    library.searchUser(newUser);
                } else if (option == 7) {
                    System.out.println("Username: ");
                    String username = sc.next();
                    System.out.println("Password: ");
                    String password = sc.next();
                    Librarian newLibrarian = new Librarian(username, password);
                    library.addLibrarian(newLibrarian);
                } else if (option == 8) {
                    System.out.println("Username: ");
                    String username = sc.next();
                    System.out.println("Password: ");
                    String password = sc.next();
                    Librarian newLibrarian = new Librarian(username, password);
                    library.removeLibrarian(newLibrarian);
                } else if (option == 9) {
                    System.out.println("Username: ");
                    String username = sc.next();
                    System.out.println("Password: ");
                    String password = sc.next();
                    Librarian newLibrarian = new Librarian(username, password);
                    library.searchLibrarian(newLibrarian);
                } else {
                    break;
                }
                System.out.println("Do you want to continue? 1.Yes 2.No");
                ex = sc.nextInt();
            }
        } while (ex == 1);
    }
}
