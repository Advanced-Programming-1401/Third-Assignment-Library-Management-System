import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;


public class User extends Library {
    String name;
    String password;
    String booksName;

    User(){
        name = "alex";
        password = "hi!";
        booksName = "hi";
    }
    User(String name , String password , String booksName){
        this.name = name;
        this.password = password;
        this.booksName= booksName;
    }
    static User user1 = new User("ALEX","0935",null);
    static User user2 = new User("DAVE","093541",null);
    static User user3 = new User("TED","09354146",null);
    public User(User user4) {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
