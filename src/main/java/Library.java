import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {
    /*
    * The library should have a list of books.
    * The library should have a map of books ISBNs which is linked to the amount of book
    -> (for example: harry potter -> 4 means there are currently 4 harry potter books)
    * The library should have a list of users and a list of librarians.
     */

    private String libraryName;
    private String book = "Harry Potter";
    private int num = 2;
    private String librarian = "firstLibrarian";
    private String User = "Haleh";
    private String pass = "0000";

    private static Librarian firstLibrarian = new Librarian("firstLibrarian", "0000");
    private static Book firstBook = new Book("Harry Potter", "J. K. Rowling", 1997, 2);
    private static User firstUser = new User("Haleh", "0000");

    //book
    private ArrayList<String> ExistedBooks;
    private static Map<String, Integer> NumberOfBooks;

    //librarian  user
    private static ArrayList<User> Users = new ArrayList<User>();
    private static ArrayList<Librarian> Librarians = new ArrayList<Librarian>();
    private static Map<String, String> users = new HashMap<String, String>();
    private static Map<String, String> librarians;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        ExistedBooks = new ArrayList<String>();
        ExistedBooks.add(book);
        NumberOfBooks = new HashMap<String, Integer>();
        NumberOfBooks.put(book, num);

        Librarians = new ArrayList<Librarian>();
        Librarians.add(firstLibrarian);
        librarians = new HashMap<String, String>();
        librarians.put(librarian, pass);

        Users = new ArrayList<User>();
        Users.add(firstUser);
        users = new HashMap<String, String>();
        users.put(User, pass);
    }

    public ArrayList<String> getExistedBooks() {
        return ExistedBooks;
    }

    public Map<String, Integer> getNumberOfBooks() {
        return NumberOfBooks;
    }

    public ArrayList<Librarian> getLibrarians() {
        return Librarians;
    }

    public Map<String, String> getlibrarians() {
        return librarians;
    }

    public ArrayList<User> getUsers() {
        return Users;
    }

    public Map<String, String> getusers() {
        return users;
    }
    //book related functions

    public void addBook(Book book){
        ExistedBooks.add(book.getNameOfBook());
        NumberOfBooks.put(book.getNameOfBook(), book.getNumberOfBook());
    }

    public void removeBook(String bookName){
        if(doesBookExist(bookName)) {
            ExistedBooks.remove(bookName);
            NumberOfBooks.remove(bookName);
            System.out.println(bookName + " is removed!");
        } else {
            System.out.println("This book doesn't exist!");
        }
    }

    public boolean doesBookExist(String bookName) {
        for (String element : ExistedBooks) {
            if (element.contains(bookName)) {
                return true;
            } else {
                System.out.println("This book doesn't exist!");
            }
        }
        return false;
    }

    public void searchBook(String bookName){
        if(doesBookExist(bookName)) {
            System.out.println("We have " + bookName);
        } else {
            System.out.println("No book with name " + bookName);
        }
    }

    //user related functions

    public void addUser(User user){
        Users.add(user);
        users.put(user.getUsername(), user.getPassword());
    }

    public void removeUser(User user){
        if(doesUserExist(user)) {
            Users.remove(user);
            users.remove(user.getUsername());
            System.out.println(user.getUsername() + " is removed!");
        } else {
            System.out.println("This book doesn't exist!");
        }
    }

    public boolean doesUserExist(User user){
        if(users.containsKey(user.getUsername()) && users.containsValue(user.getPassword())){
            return true;
        } else {
            System.out.println("No member in the list!");
        }
        return false;
    }

    public void searchUser(User user){
        if(doesUserExist(user)) {
            System.out.println(user.getUsername() + " exists");
        } else {
            System.out.println("No member with username " + user.getUsername());
        }
    }

    public void loginUser(User user){
        if(doesUserExist(user)) {
            System.out.println("Hello " + user.getUsername());
        } else {
            System.out.println("No member with username " + user.getUsername());
        }
    }

    //librarian related functions

    public void addLibrarian(Librarian librarian){
        Librarians.add(librarian);
        librarians.put(librarian.getUsername(), librarian.getPassword());
    }

    public void removeLibrarian(Librarian librarian){
        if(doesLibrarianExist(librarian)) {
            Librarians.remove(librarian);
            librarians.remove(librarian.getUsername());
            System.out.println(librarian.getUsername() + " is removed!");
        } else {
            System.out.println("This librarian doesn't exist!");
        }
    }

    public boolean doesLibrarianExist(Librarian librarian){
        if(librarians.containsKey(librarian.getUsername()) && librarians.containsValue(librarian.getPassword())){
            return true;
        } else {
            System.out.println("No librarian in the list!");
        }
        return false;
    }

    public void searchLibrarian(Librarian librarian){
        if(doesLibrarianExist(librarian)) {
            System.out.println(librarian.getUsername() + " exists");
        } else {
            System.out.println("No member with username " + librarian.getUsername());
        }
    }

    public void loginLibrarian(Librarian librarian){
        if(doesLibrarianExist(librarian)) {
            System.out.println("Hello " + librarian.getUsername());
        } else {
            System.out.println("No member with username " + librarian.getUsername());
        }
    }
}
