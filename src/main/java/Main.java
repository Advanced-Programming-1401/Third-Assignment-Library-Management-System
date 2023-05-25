import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class Main {
    /*
     * make a functional library app using oop
     * run the main program in Main.java and code the oop part in other classes
     * don't forget to add at least 1 librarian to the library to make it functionable.
     * *  *** don't limit yourself to our template ***
     */

    public static void main(String[] args) {
        Book book = new Book();
        Library library = new Library();
        User user = new User();
        Librarian librarian = new Librarian();
        runMenu(book, library, user, librarian);
    }

    public static void runMenu(Book myBook, Library myLibrary, User myUser, Librarian myLibrarian){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Welcome To Our Library");
        System.out.println("Enter Number Of Your Position : \n1: User\n2: Librarian");
        int pos = myScanner.nextInt();
        if(pos == 1){
            System.out.println("Enter Your Command: " + "1: Login" + "\n" + "2: SignUp");
            int command = myScanner.nextInt();
            if(command == 1)
                loginUser(myBook, myLibrary, myUser, myLibrarian);
            else
                signUpUser(myBook, myLibrary, myUser, myLibrarian);
        }
        //else{







        //}
    }
    public static void signUpUser(Book myBook, Library myLibrary, User myUser, Librarian myLibrarian){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your Username: ");
        String username = input.nextLine();
        System.out.println("Enter Your Password: ");
        String password = input.nextLine();
        myUser.setUsername(username);
        myUser.setPassword(password);
        if(!myLibrary.doesUserExist(myUser.getUsername(), myUser.getPassword())){
            System.out.println("Ok, You Successfully SignUp!");
            myLibrary.addUser(myUser.getUsername(), myUser.getPassword());
        }
        else
            System.out.println("This Username Is Already Exist!");
    }

    public static void loginUser(Book myBook, Library myLibrary, User myUser, Librarian myLibrarian){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your Username: ");
        String username = input.nextLine();
        System.out.println("Enter Your Password: ");
        String password = input.nextLine();
        myUser.setUsername(username);
        myUser.setPassword(password);
        if(myLibrary.doesUserExist(myUser.getUsername(), myUser.getPassword())){
            System.out.println("Ok, You Successfully Login!");
        }
        else
            System.out.println("Your Username or Password Went Wrong!");
    }
    public static void logOut(){
        System.out.println("You Logged Out!");
    }
}
