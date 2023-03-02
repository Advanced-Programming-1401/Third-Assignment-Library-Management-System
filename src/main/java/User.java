import java.util.ArrayList;

public class User {
//    private ArrayList<String> book_list;
    private final String user_name;
    private final String user_password;
    //User should have a list of books
    //User should have a username and a password
    public User(String user_name, String user_password){

        this.user_name = user_name;
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void rentBook(){
        //TODO
    }

    public void returnBook(){
        //TODO
    }
}
