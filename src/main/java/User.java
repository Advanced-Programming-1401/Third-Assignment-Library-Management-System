import java.util.ArrayList;
import java.util.HashMap;

public class User  extends Library{
    //User should have a list of books
    //User should have a username and a password
    private String username;
    private String password;


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

    public void rentBook(String title){
       //TODO
        /*int found = 0;
        for (Book b : collection)
        {
            if (b.getName().equals(title))
            {
                if (found == 0)
                {
                    found = 1;
                }
                if (!b.does())
                {
                    b.borrowed=true;
                    found = 2;
                    break;
                }
            }
        }
        if (found == 0) {
            System.out.println("Sorry, this book is not in our catalog.");
        } else if (found == 1) {
            System.out.println("Sorry, this book is already borrowed.");
        } else if (found == 2) {
            System.out.println("You successfully borrowed " + title);
        }

*/

    }

    public void returnBook(){
        //TODO

    }

}
