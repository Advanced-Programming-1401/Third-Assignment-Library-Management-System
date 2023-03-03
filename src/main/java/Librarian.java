import java.util.Scanner;

public class Librarian {
    private final String user_name;
    private final String password;
    public Librarian(String user_name, String password){

        this.user_name = user_name;
        this.password = password;
    }
    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }
}
