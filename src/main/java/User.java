import java.util.ArrayList;

public class User {
//    private ArrayList<String> book_list;
    private final String user_name;
    private final String user_password;
    private ArrayList<String> borrowed_books;
    //User should have a list of books
    //User should have a username and a password
    public User(String user_name, String user_password){

        this.user_name = user_name;
        this.user_password = user_password;
        borrowed_books = new ArrayList<String>();
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public ArrayList<String> getBorrowed_books() {
        return borrowed_books;
    }

    public void rentBook(String book_name){


    }

    public void returnBook(){
        //TODO
    }
}
