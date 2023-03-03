import java.util.Scanner;

public class Main {
    /*
    * make a functional library app using oop
    * run the main program in Main.java and code the oop part in other classes
    * don't forget to add at least 1 librarian to the library to make it functionable.
    * *  *** don't limit yourself to our template ***
     */

    public static void main(String[] args) {

        Library library = new Library();
        library.addBook("raz bega", "mamad", 1900, 999887);
        runMenu(library);

    }

    public static void runMenu(Library library){

        System.out.println("Welcome, Please choose one option: ");
        System.out.print("1- Sign up a new user\n2- Login as user\n3- Login as librarian\n4- Exit the program");
        Scanner input = new Scanner(System.in);
        int menu_option = input.nextInt();
        input.nextLine();

        if (menu_option == 1){

            userLoggedInPage(library, userSignUp(library));
        }
        else if (menu_option == 2){

            userLogin(library);
        }
        else if (menu_option == 3){

            return;
        }
        else if (menu_option == 4){
            return;
        }
        else {
            System.out.println("am i joke to you?");
            return;
        }

    }
    public static User userSignUp(Library library){

        User new_user;
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your userName: ");
        String user_name = input.nextLine();

        if (library.doesUserExist(user_name)){

            System.out.println("Um-mm, this userName exists try again!");
            userSignUp(library);
            return null;
        }
        else{

            System.out.println("Enter your password: ");
            String password = input.nextLine();
            new_user = new User(user_name, password);
            library.addUser(new_user);
            return new_user;
        }
    }
    public static void userLogin(Library library){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your userName: ");
        String user_name = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();
        if (library.checkUserPassword(user_name, password)){

            User user = new User(user_name, password);
            userLoggedInPage(library, user);
        }
    }
    public static void userLoggedInPage(Library library, User user){

        System.out.println("USERS PAGE\n\n" + "Welcome Back " + user.getUser_name().toUpperCase() + "!\n");
        System.out.println("1- ُShow list of books\n2- Borrow a book\n3- Return a book\n4- Back to Main menu");
        Scanner input = new Scanner(System.in);
        int option_menu = input.nextInt();
        input.nextLine();
        if (option_menu == 1){

            library.searchBook();
            userLoggedInPage(library, user);
        }
        else if (option_menu == 2){

            System.out.println("this doesn't work for now");
        }
        else if (option_menu == 3){

            System.out.println("this doesn't work for now");
        }
        else if (option_menu == 4) {

            runMenu(library);
        }
        else {

            System.out.println("Am i joke to you?");
            return;
        }
    }
}
