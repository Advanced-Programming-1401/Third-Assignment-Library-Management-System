import java.util.ArrayList;
import javax.swing.*;

public class User {
    //User should have a list of books
    //User should have a username and a password

    private String username;
    private String password;
    private ArrayList<Book> userBooks;


    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.userBooks = new ArrayList<Book>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Book> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(ArrayList<Book> userBooks) {
        this.userBooks = userBooks;
    }

    public boolean areMatched(String first, String second) {
        if (first.equals(second)) {
            return true;
        }
        return false;
    }

    public boolean userIsAuthenticated(String username, String password) {
        if (areMatched(username,this.username)  && areMatched(password,this.password))
            return true;
        return false;
    }
    public void rentBook(Book book){
        if (doesRentedBookExist(book.getISBN())){
            JOptionPane.showMessageDialog(null,"The book " + book.getName() + " already exists.");

        } else {
            userBooks.add(book);
            JOptionPane.showMessageDialog(null,"The book " + book.getName() + " added to your list successfully!");
        }
    }

    public void returnBook(Book book){
        if (doesRentedBookExist(book.getISBN())) {
            userBooks.remove(book);
            JOptionPane.showMessageDialog(null,"The book " + book.getName() + " has been removed from your list.");
        } else {
            JOptionPane.showMessageDialog(null,"The book doesn't exist.");
        }
    }

    public boolean doesRentedBookExist(String ISBN) {
        for (Book book : userBooks) {
            if (book.getISBN().equals(ISBN))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Hello, it's " + this.getUsername() + "!";
    }

}
