import java.util.ArrayList;

public class User<username> {
    //User should have a list of books
    //User should have a username and a password

    String book = "0";
    ArrayList<String> rentedBooks;
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        rentedBooks = new ArrayList<String>();
        rentedBooks.add(book);
    }

    public ArrayList<String> getRentedBooks() {
        return rentedBooks;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void rentBook(String book){
        rentedBooks.add(book);
        System.out.println("You've rented " + book);
    }

    public void returnBook(String book){
        rentedBooks.remove(book);
        System.out.println("You've returned " + book);
    }
}