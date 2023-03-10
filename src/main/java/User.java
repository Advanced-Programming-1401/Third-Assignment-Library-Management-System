import java.awt.*;
import java.util.Scanner;
import java.util.ArrayList;

public class User {
    //User should have a list of books
    //User should have a username and a password

    Scanner input = new Scanner(System.in);

    private String username;
    private String password;

    /* public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }*/

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

    public void changePassword(){
        System.out.println("Enter your currenct password :");
        String currentPassword = input.nextLine();
        if (currentPassword.equals(getPassword()))
        {
            System.out.println("Enter your new password :");
            String newPassword = input.nextLine();
            this.password = newPassword;
        }
        else
        {
            System.out.println("Wrong password!");
            changePassword();
        }
    }

    ArrayList<Book> rentBooks = new ArrayList<>();

    public void rentBook(Library ketabkhune , Book ketab){
        //TODO
        if (ketabkhune.doesBookExist(ketab))
        {
            if (ketab.getAvailable())
            {
                rentBooks.add(ketab);
                ketabkhune.updateBook(ketab);
                ketabkhune.decreaseBook(ketab);
            }
            else
            {
                System.out.println("This book is not available!");
            }
        }
        else
        {
            System.out.println("This book does not exist!");
        }
    }
    public String searchRentBook(Book ketab){
        //TODO
        for (int i=0; i<rentBooks.size(); i++)
        {
            if (ketab.getName().equals(rentBooks.get(i).getName()) && ketab.getAuthor().equals(rentBooks.get(i).getAuthor()))
            {
                return ketab.getISBN();
            }
        }
        return "";
    }

    public void returnBook(Library ketabkhune , Book ketab){
        //TODO
        for (int i=0; i<rentBooks.size(); i++)
        {
            if (ketab.getISBN().equals(rentBooks.get(i).getISBN()))
            {
                rentBooks.remove(i);
                break;
            }
        }
        ketabkhune.updateBook(ketab);
        ketabkhune.increaseBook(ketab);
    }

    public String toString()
    {
        return "User's username: " + username + " " +
            "User's password: " + password;
    }
}
