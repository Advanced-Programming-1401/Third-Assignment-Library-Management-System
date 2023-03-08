import java.util.ArrayList;

public class User {
    //User should have a list of books
    //User should have a username and a password
    private String username;
    private String password;
    ArrayList<Book> rentBooks = new ArrayList<Book>();
    public User(String username , String password){
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void rentBook(String name , String Author , int YearPublish , int ISBN) {
        Book book = new Book(name,Author,YearPublish,ISBN);
        rentBooks.add(book);

    }


    public void returnBook(String name , String Author , int YearPublish , int ISBN){
        //Returns a book back to the catalog
        Book book = new Book(name,Author,YearPublish,ISBN);
        rentBooks.remove(book);
    }

    @Override
    public String toString() {

        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rentBooks=" + rentBooks +
                '}';

    }
}
