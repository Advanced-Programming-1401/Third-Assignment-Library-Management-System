import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
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
        System.out.print("1- Sign up a new user\n2- Login as user\n3- Login as librarian\n4- Exit the program\n");
        int menu_option = input.nextInt();
        input.nextLine();

        if (menu_option == 1){

            userLoggedInPage(library, userSignUp(library));
        }
        else if (menu_option == 2){

            userLogin(library);
        }
        else if (menu_option == 3){

            librarianLoggedInPage(library, librarianLogin(library));
        }
        else if (menu_option == 4){
            return;
        }
    }
    public static User userSignUp(Library library){
        //entering the signup page
        User new_user;
        System.out.println("Enter desired information: 1-user_name, 2-password\n");
        new_user = new User(input.nextLine(), input.nextLine());

        if (library.doesUserExist(new_user.getUser_name())){
            //if this user_name doesn't exist try again
            System.out.println("Um-mm, this userName exists try again!");
            userSignUp(library);
            return null;
        }
        else{
            //else create new user
            library.addUser(new_user);
            return new_user;
        }
    }
    public static void userLogin(Library library){
        //entering userLogin page
        System.out.println("Enter desired information: 1-user_name 2-password\n");
        User user = new User(input.nextLine(), input.nextLine());

        if (library.checkUserPassword(user.getUser_name(), user.getUser_password())){

            userLoggedInPage(library, user);
        }
    }
    public static void userLoggedInPage(Library library, User user){

        System.out.println("USERS PAGE\n\n" + "Welcome Back " + user.getUser_name().toUpperCase() + "!\n");
        System.out.println("1- ُShow list of books\n2- Borrow a book\n3- Return a book\n4- Back to Main menu");
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
    }
    public static Librarian librarianLogin(Library library){
        //entering the librarian login page
        System.out.println("Enter desired information: 1-user_name, 2-password\n");
        Librarian librarian = new Librarian(input.nextLine(), input.nextLine());

        if (library.checkLibrarianPassword(librarian.getUser_name(), librarian.getPassword())){

            return librarian;
        }
        return null;
    }
    public static void librarianLoggedInPage(Library library, Librarian librarian){

        System.out.println("LIBRARIAN PAGE\n\n" + "Welcome Back " + librarian.getUser_name().toUpperCase() + "!\n");
        System.out.println("1- ُShow a list of book related commands\n2- Show a list of user related commands\n3- Show a list of librarian related commands\n4- Back to main menu\n");
        int option_menu = input.nextInt();
        input.nextLine();

        if (option_menu == 1){
            //show a list of book related commands
            System.out.println("1- Show a list of books\n2- Add a book\n3- Remove a book\n4- Update a book\n");
            option_menu = input.nextInt();
            input.nextLine();

            if (option_menu == 1){
                //show a list of books
                library.searchBook();
            }
            else if (option_menu == 2){
                //Add a book to library
                System.out.println("Enter desired information: 1-name of the book, 2-author, 3-publish year, 4-ISBN\n");
                String book_name = input.next();
                String author = input.next();
                int publish_year = input.nextInt();
                input.nextLine();
                int ISBN = input.nextInt();
                input.nextLine();

                library.addBook(book_name, author, publish_year, ISBN);
            }
            else if (option_menu == 3){
                //Remove a book from library
                System.out.println("Enter ISBN: \n");
                library.removeBook(input.nextInt());
                input.nextLine();
            }
            else if (option_menu == 4){
                //Update a book
                System.out.println("this still needs a little bit work");
            }
        }
        else if (option_menu == 2){
            //Show a list of user related commands
            System.out.println("1- Show a list of users\n2- Add a user\n3- Remove a user\n4- Update a user\n");
            option_menu = input.nextInt();
            input.nextLine();

            if (option_menu == 1){
                //Show a list of users
                library.searchUser();
            }
            else if (option_menu == 2){
                //Add a user
                System.out.println("Enter desired information: 1- user_name, 2- password\n");
                library.addUser(input.nextLine(), input.nextLine());
            }
            else if (option_menu == 3){
                //Remove a user
                System.out.println("Enter the name of the user: \n");
                library.removeUser(input.nextLine());
            }
        }
        else if (option_menu == 3){
            //Show a list of librarian related commands
            System.out.println("1- Show a list of librarians\n2- Add a librarian\n3- Remove a librarian\n4- Update a librarian\n");
            option_menu = input.nextInt();
            input.nextLine();

            if (option_menu == 1){
                //Show a list of librarians
                library.searchLibrarian();
            }
            else if (option_menu == 2){
                //Add a librarian
                System.out.println("Enter desired information: 1-user_name, 2-password\n");
                library.addUser(input.nextLine(), input.nextLine());
            }
            else if (option_menu == 3){
                //Remove a librarian
                System.out.println("Enter the name of the librarian you want to remove: \n");
                library.removeLibrarian(input.nextLine());
            }
            else if (option_menu == 4){
                //Update a librarian
                //this needs a little work
            }
        }
        else if (option_menu == 4) {

            runMenu(library);
            return;
        }
        librarianLoggedInPage(library, librarian);
    }
}
