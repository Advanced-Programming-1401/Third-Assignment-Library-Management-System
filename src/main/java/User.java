import java.util.ArrayList;

public class User {
    //User should have a list of books
    //User should have a username and a password

    ArrayList<Book> rentedBooks = new ArrayList<Book>();
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void rentBook(){
        //TODO
    }

    public void returnBook(){
        //TODO
    }
}