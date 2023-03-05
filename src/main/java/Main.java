import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Library library = new Library();
        library.addBook("bigjava", "kheradpisheh", "2000", "hash00");
        library.addUser("reza", "mosavi");
        runMenu(library);
    }

    public static void runMenu(Library library){

        System.out.println("------------------WELCOME TO THE LIBRARY------------------\nPLEASE CHOOSE ONE OPTION:");
        System.out.println("1-Signing up a new user\n2-Login as a user\n3-Login as a librarian\n4-Exit the program\n");
        int menu_option = input.nextInt();
        input.nextLine();   //bug handling

        switch (menu_option) {
            case 1 -> {
                //Signing up a new user
                userSignUp(library);
                runMenu(library);
                break;
            }
            case 2 -> {
                //Login as a user
                userLogin(library);
                break;
            }
            case 3 -> {
                //Login as a librarian
                librarianLogin(library);
                break;
            }
        }
    }

    public static void userSignUp (Library library){
        //sign up a new user
        System.out.println("Enter the requested information --> 1-Username,  2-Password");
        String username = input.nextLine();
        String password = input.nextLine();

        if (!library.doesUserExist(username)){

            library.addUser(username, password);
        }
        else {

            System.out.println("This user is already exist.");
            runMenu(library);
        }
    }

    public static void userLogin (Library library){
        //Login as user
        System.out.println("Enter requested information --> 1-Username, 2-Password");
        String username = input.nextLine();
        String password = input.nextLine();

        if (library.isUserValid(username, password)){

            System.out.println("User " + username + " has been successfully Login");
            userPage(library, library.getSpecifiedUser(username));
        }
        else {

            System.out.println("Username or password is wrong.");
            runMenu(library);
        }
    }

    public static void userPage(Library library, User user){

        System.out.println("------------------------------------------USER PAGE------------------------------------------");
        System.out.println("Welcome back " + user.getUsername().toUpperCase());
        System.out.println("1- ُShow a list of books\n2- Borrow a book\n3- Show a list of borrowed books\n4- Return a book\n5- Back to Main menu\n");
        int option_menu = input.nextInt();
        input.nextLine();

        switch (option_menu) {
            case 1 -> {
                //Show a list of books
                library.searchBook();
                userPage(library, user);
                break;
            }
            case 2 -> {
                //Borrow a book from library
                System.out.println("Enter name of the book:\n");
                String book_name = input.nextLine();

                if (library.doesBookExist(book_name) && !user.hasRentedBook(book_name)) {
                    //if book exists in library and user didn't borrow that yet:
                    library.decreaseBook(library.getSpecifiedBook(book_name).getISBN());
                    user.rentBook(library.getSpecifiedBook(book_name));
                } else {

                    System.out.println("Book doesn't exist in library or you have borrowed that before.");
                }
                userPage(library, user);

                break;
            }
            case 3 -> {
                //Show a list of borrowed books
                user.showBorrowedBooks();
                userPage(library, user);

                break;
            }
            case 4 -> {
                //Return a book
                if (user.getRented_books().size() == 0) {

                    System.out.println("User " + user.getUsername() + " has not borrowed any books yet!");
                } else {

                    System.out.println("Until now you have borrowed this list of books : ");
                    user.showBorrowedBooks();
                    System.out.println("Which one do you want to return?");
                    String book_name = input.nextLine();

                    if (user.hasRentedBook(book_name)) {

                        user.returnBook(library.getSpecifiedBook(book_name));
                        library.increaseBook(library.getSpecifiedBook(book_name).getISBN());
                    } else {

                        System.out.println("You haven't rent this book yet, so you cannot return it!");
                    }
                }
                userPage(library, user);
                break;
            }
            case 5 -> {
                //Back to main menu
                runMenu(library);
                break;
            }
        }
    }

    public static void librarianLogin (Library library){

        System.out.println("Enter requested information: 1-username, 2-password");
        String username = input.nextLine();
        String password = input.nextLine();

        if (library.isLibrarianValid(username, password)){
            //if username and password is valid we have the permission to login
            System.out.println("Librarian " + username + " has been successfully login");
            librarianPage(library, library.getSpecifiedLibrarian(username));
        }
        else {

            System.out.println("Username or Password is invalid.");
            runMenu(library);
        }
    }

    public static void librarianPage (Library library, Librarian librarian) {

        System.out.println("--------------------------------------------------LIBRARIAN PAGE--------------------------------------------------");
        System.out.println("Welcome back " + librarian.getUsername());
        System.out.println("1- ُShow a list of book related commands\n2- Show a list of user related commands\n3- Show a list of librarian related commands\n4- Back to main menu\n");
        int option_menu = input.nextInt();
        input.nextLine();

        switch (option_menu) {
            case 1 -> {
                //Show a list of book - related commands
                System.out.println("1- Show a list of books\n2- Add a book\n3- Remove a book\n4- Update a book\n");
                option_menu = input.nextInt();
                input.nextLine();

                switch (option_menu) {
                    case 1 -> {
                        //show a list of books
                        library.searchBook();
                        librarianPage(library, librarian);
                        break;
                    }
                    case 2 -> {
                        //Add a book to library
                        System.out.println("Enter requested information --> 1-Name of the book,  2-Author,  3-Year of publish,  4-ISBN");
                        String book_name = input.nextLine();
                        String author = input.nextLine();
                        String publish_year = input.nextLine();
                        String ISBN = input.nextLine();

                        if (library.doesBookExist(book_name)) {
                            library.increaseBook(ISBN);
                        } else {

                            library.addBook(book_name, author, publish_year, ISBN);
                        }
                        librarianPage(library, librarian);

                        break;
                    }
                    case 3 -> {
                        //remove a book from library
                        System.out.println("Enter name of the book:");
                        library.removeBook(input.nextLine());
                        librarianPage(library, librarian);

                        break;
                    }
                    case 4 -> {
                        //Update a book
                        System.out.println("Enter required information --> 1-ISBN of the book, 2-New name of the book, 3-New author of the book,  3-New year of publish");
                        String ISBN = input.nextLine();
                        String new_book_name = input.nextLine();
                        String new_author = input.nextLine();
                        String new_publish_year = input.nextLine();

                        library.updateBook(ISBN, new_book_name, new_author, new_publish_year);
                        librarianPage(library, librarian);

                        break;
                    }
                }

                break;
            }
            case 2 -> {
                //Show a list of user - related commands

                System.out.println("1- Show a list of users\n2- Add a user\n3- Remove a user\n4- Update a user\n");
                option_menu = input.nextInt();
                input.nextLine();

                switch (option_menu) {
                    case 1 -> {
                        //show a list of users
                        library.searchUser();
                        librarianPage(library, librarian);
                        break;
                    }
                    case 2 -> {
                        //Add a user
                        System.out.println("Enter required information --> 1-Username,  2-Password");
                        User new_user = new User(input.nextLine(), input.nextLine());
                        if (library.doesUserExist(new_user.getUsername())) {

                            System.out.println("This username exist already!");
                        } else {

                            library.addUser(new_user.getUsername(), new_user.getPassword());
                        }
                        librarianPage(library, librarian);

                        break;
                    }
                    case 3 -> {
                        //Remove a user
                        System.out.println("Enter name of the user you want to remove: ");
                        String username = input.nextLine();
                        if (!library.doesUserExist(username)){

                            System.out.println("This user doesn't exist, so you cannot remove him/her!");
                        }
                        else {

                            library.removeUser(username);
                        }
                        librarianPage(library, librarian);

                        break;
                    }
                    case 4 -> {
                        //Update a user
                        System.out.println("Enter required information --> 1-Old username 2-New username 3-New password");
                        library.updateUser(input.nextLine(), input.nextLine(), input.nextLine());
                        librarianPage(library, librarian);

                        break;
                    }
                }
                break;
            }
            case 3 -> {
                //Show a list of librarian - related commands
                System.out.println("1- Show a list of librarians\n2- Add a librarian\n3- Remove a librarian\n4- Update a librarian\n");
                option_menu = input.nextInt();
                input.nextLine();

                switch (option_menu) {
                    case 1 -> {
                        //Show a list of librarians
                        library.searchLibrarian();
                        librarianPage(library, librarian);

                        break;
                    }
                    case 2 -> {
                        //Add a librarian
                        System.out.println("Enter required information --> 1-Username,  2-Password");
                        Librarian librarian1 = new Librarian(input.nextLine(), input.nextLine());

                        if (library.doesUserExist(librarian1.getUsername()) || library.doesLibrarianExist(librarian1.getUsername())) {

                            System.out.println("This username has already registered!");
                        } else {

                            library.addLibrarian(librarian1.getUsername(), librarian1.getPassword());
                        }
                        librarianPage(library, librarian);

                        break;
                    }
                    case 3 -> {
                        //Remove a librarian
                        System.out.println("Enter name of the librarian you want to remove: ");
                        String username = input.nextLine();
                        if (!library.doesLibrarianExist(username)){

                            System.out.println("This librarian doesn't exist, so you cannot remove him/her!");
                        }
                        else {

                            library.removeLibrarian(username);
                        }
                        librarianPage(library, librarian);

                        break;
                    }
                    case 4 -> {
                        //Update a librarian
                        System.out.println("Enter required information --> 1-Old username,  2-New username,  3-New password");
                        library.updateLibrarian(input.nextLine(), input.nextLine(), input.nextLine());
                        librarianPage(library, librarian);

                        break;
                    }
                }
            }
            case 4 -> {
                //Back to main menu
                runMenu(library);
            }
        }
    }
}