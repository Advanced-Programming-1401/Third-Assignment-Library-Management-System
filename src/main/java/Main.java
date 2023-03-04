import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        Library library = new Library();
        library.addBook("bigjava", "kherad", 1900, 8);
        library.addUser("reza", "mosavi");
        runMenu(library);
    }
    public static void runMenu(Library library){

        System.out.println("Welcome, Please choose one option: ");
        System.out.print("1- Sign up a new user\n2- Login as user\n3- Login as librarian\n4- Exit the program\n");
        int menu_option = input.nextInt();
        input.nextLine();

        if (menu_option == 1){
            //Sign up a new user
            //first sign up and then go to LoggedIn page
            User new_user = userSignUp(library);
            System.out.println("------------------------------------------USERs PAGE------------------------------------------");
            System.out.println("\n\n" + "Welcome Back " + new_user.getUser_name().toUpperCase() + "!\n");
            userPage(library, new_user);
        }
        else if (menu_option == 2){
            //Login as user
            userSignIn(library);
        }
        else if (menu_option == 3){
            //Login as librarian
            //first login as librarian and then go to LoggedIn page
            Librarian librarian = librarianSignIn(library);
            System.out.println("--------------------------------------------------LIBRARIANs PAGE--------------------------------------------------");
            System.out.println("Welcome back " + librarian.getUser_name());
            librarianPage(library, librarian);
        }
        else if (menu_option == 4){
            //Exit the program
            return;
        }
    }
    public static User userSignUp(Library library){
        //entering the signup page
        User new_user;
        System.out.println("Enter desired information: 1-user_name, 2-password\n");
        new_user = new User(input.nextLine(), input.nextLine());

        if (library.doesUserExist(new_user.getUser_name())){
            //if this user_name doesn't exist, try again
            System.out.println("Um-mm, this username already exists. please try again!");
            userSignUp(library);
            return null;
        }
        else{
            //else create new user
            library.addUser(new_user);
            System.out.println("You have successfully signedUp " + new_user.getUser_name());
            return new_user;
        }
    }
    public static void userSignIn(Library library){
        //entering userSignIn page
        System.out.println("Enter desired information: 1-user_name 2-password\n");
        User user = new User(input.nextLine(), input.nextLine());

        if (library.checkUserPassword(user.getUser_name(), user.getUser_password())){
            //if user and password is valid, user shall go to the userPage.
            System.out.println("------------------------------------------USERs PAGE------------------------------------------");
            System.out.println("\n\n" + "Welcome Back " + user.getUser_name().toUpperCase() + "!\n");
            userPage(library, user);
        }
        else {
            //if user or password is wrong, user has to try again.
            System.out.println("user_name or password is wrong try again!");
            userSignIn(library);
        }
    }
    public static void userPage(Library library, User user){

//        System.out.println("USERS PAGE\n\n" + "Welcome Back " + user.getUser_name().toUpperCase() + "!\n");
        System.out.println("1- ُShow list of books\n2- Borrow a book\n3- Return a book\n4- Show a list of borrowed books\n5- Back to Main menu\n");
        int option_menu = input.nextInt();
        input.nextLine();

        if (option_menu == 1){
            //Show a list of books
            library.searchBook();
            userPage(library, user);
        }
        else if (option_menu == 2){
            //Borrow a book from library
            System.out.println("Search the book by: \n1-name of the book\n2-ISBN of the book");
            option_menu = input.nextInt();
            input.nextLine();

            if (option_menu == 1){
                //search by name of the book
                System.out.println("Enter the name of the book\n");
                String book_name = input.nextLine();

                if (library.doesBookExist(book_name)){
                    //if book already exists we have the permission to book it
                    library.decreaseBook(book_name);
                    user.addToBorrowedBooks(library.getBook(book_name));
                    System.out.println("You added a Book named " + book_name + "to your borrowed books\n");
                }
            }
            else if (option_menu == 2) {
                //search by ISBN of the book
                System.out.println("Enter the ISBN of the book\n");
                int ISBN = input.nextInt();
                input.nextLine();

                if (library.doesBookExist(ISBN)){
                    //if book already exists we have the permission to book it
                    library.decreaseBook(ISBN);
                    user.addToBorrowedBooks(library.getBook(ISBN));
                }
            }
            userPage(library, user);
        }
        else if (option_menu == 3){
            //Return a book to library
            if (user.getBorrowed_books().size() == 0){

                System.out.println("You haven't borrowed a book yet!");
            }
            else{

                System.out.println("Look " + user.getUser_name() + " you have already borrowed this books:\n");
                user.searchBorrowedBooks();
                System.out.println("Now, which one you want to return back?");
                String book_name = input.nextLine();
                library.increaseBook(book_name);
                user.removeFromBorrowedBooks(book_name);
                System.out.println("you have successfully returned " + book_name + " to the library\n");
            }
            userPage(library, user);
        }
        else if (option_menu == 4){
            //Show a list of borrowed books
            user.searchBorrowedBooks();
            userPage(library, user);
        }
        else if (option_menu == 5) {
            //Back to main menu
            runMenu(library);
        }
    }
    public static Librarian librarianSignIn(Library library){
        //entering the librarian login page
        System.out.println("Enter desired information: 1-user_name, 2-password\n");
        Librarian librarian = new Librarian(input.nextLine(), input.nextLine());

        if (library.checkLibrarianPassword(librarian.getUser_name(), librarian.getPassword())){
            //if user_name and password is valid, librarian shall enter the librarianPage
            return librarian;
        }
        else {
            //if user_name or password is wrong, user has to try again.
            System.out.println("user_name or password is wrong, Try again!");
            librarianSignIn(library);
        }
        return null;
    }
    public static void librarianPage(Library library, Librarian librarian){
        //entering librarian page
//        System.out.println("LIBRARIAN PAGE\n\n" + "Welcome Back " + librarian.getUser_name().toUpperCase() + "!\n");
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
                if (library.doesBookExist(book_name)){
                    library.increaseBook(ISBN);
                }
                else {

                    library.addBook(book_name, author, publish_year, ISBN);
                    System.out.println("You have successfully added " + book_name + " to the library\n");
                }

            }
            else if (option_menu == 3){
                //Remove a book from library
                System.out.println("Enter ISBN: \n");
                library.removeBook(input.nextInt());
                input.nextLine();
                System.out.println("You have successfully removed a book from library\n");
            }
            else if (option_menu == 4){
                //Update a book
                System.out.println("Enter desired information: 1-previous name of the book, 2-new name of the book, 3-new author of the book, 4-new year of publication\n");
                library.updateBook(input.nextLine(), input.nextLine(), input.nextLine(), input.nextInt());
                input.nextLine();
                System.out.println("You have successfully updated a book\n");
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
                System.out.println("An user was successfully added\n");
            }
            else if (option_menu == 3){
                //Remove a user
                System.out.println("Enter the name of the user: \n");
                library.removeUser(input.nextLine());
                System.out.println("An user was successfully removed\n");
            }
            else if (option_menu == 4){
                //Update a user
                System.out.println("Enter desired information: 1-previous user_name, 2-new user_name, 3-new password");
                library.updateUser(input.nextLine(), input.nextLine(), input.nextLine());
                System.out.println("An user was successfully removed\n");
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
                library.addLibrarian(input.nextLine(), input.nextLine());
                System.out.println("A librarian was successfully added\n");
            }
            else if (option_menu == 3){
                //Remove a librarian
                System.out.println("Enter the name of the librarian you want to remove: \n");
                library.removeLibrarian(input.nextLine());
                System.out.println("A librarian was successfully removed\n");
            }
            else if (option_menu == 4){
                //Update a librarian
                System.out.println("Enter desired information: 1-previous user_name, 2-new user_name, 3-new password");
                library.updateLibrarian(input.nextLine(), input.nextLine(), input.nextLine());
                System.out.println("A librarian was successfully updated\n");
                runMenu(library);

            }
        }
        else if (option_menu == 4) {
            //Back to main menu
            runMenu(library);
            return;
        }
        librarianPage(library, librarian);  //get back to the LoggedIn page
    }
}