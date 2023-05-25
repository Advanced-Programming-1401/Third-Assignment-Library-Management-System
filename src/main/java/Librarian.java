import java.util.Scanner;

public class Librarian {
    /*
    * The librarian should have a username and a password
    * The librarian should be able to search users, librarians and books
    * The librarian should be able to add,remove,update user add,remove,update_
    _ librarian and add,remove,update book
     */

    // Attributes
    private String username;
    private String password;

    // Getter & Setter
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
        System.out.println("Enter Your Current Password: ");
        Scanner myScanner = new Scanner(System.in);
        String Pass = myScanner.nextLine();
        if(Pass.equals(this.getPassword())){
            System.out.println("Enter Your newest Password: ");
            String newPass = myScanner.nextLine();
            this.password = newPass;
        }
        else{
            System.out.println("Wrong Password! " + "\n" + "Do You Want Try Again?!(Yes/No) : ");
            String ansewr = myScanner.nextLine();
            if(ansewr.equals("Yes") || ansewr.equals("yes"))
                changePassword();
        }
    }
    @Override
    public String toString() {
        return "Librarian{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}