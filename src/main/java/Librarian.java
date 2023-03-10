import java.util.Scanner;

public class Librarian
{
    /*
    * The librarian should have a username and a password
    * The librarian should be able to search users, librarians and books
    * The librarian should be able to add\remove\ update user add\remove\ update_
    _ librarian and add\remove\ update book
     */
    Scanner input = new Scanner(System.in);

    private String username;
    private String password;
    /* public Librarian(String username, String password)
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


    public String toString()
    {
        return "Librarian's username: " + username + " " +
                "Librarian's password: " + password;
    }
}
