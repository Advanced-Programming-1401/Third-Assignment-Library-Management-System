import java.util.Scanner;

public class Main
{
    /*
    * make a functional library app using oop
    * run the main program in Main.java and code the oop part in other classes
    * don't forget to add at least 1 librarian to the library to make it functionable.
    * *  *** don't limit yourself to our template ***
     */
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        Book ketab = new Book();
        Library ketabkhune = new Library();
        User karbar = new User();
        Librarian ketabdar = new Librarian();
        runMenu(ketab , ketabkhune , karbar , ketabdar);
    }

    public static void runMenu(Book ketab, Library ketabkhune, User karbar, Librarian ketabdar)
    {
        //TODO:

        //Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the library!");
        System.out.println("1.Users");
        System.out.println("2.Librarians");
        System.out.println("Enter your command");
        System.out.println("command : ");
        int command = Integer.parseInt(input.nextLine());
        if (command == 1)
        {
            System.out.println("1.Sign Up");
            System.out.println("2.Sign In");
            System.out.println("Enter your command");
            System.out.println("command : ");
            command = Integer.parseInt(input.nextLine());
            if (command == 1)
            {
                signUpUser(ketabkhune , ketabdar , karbar , ketab);
            }
            else
            {
                signInUser(ketabkhune , ketabdar , karbar , ketab);
            }
            userMenu(ketabkhune, karbar, ketab , ketabdar);
        }
        else
        {
            System.out.println("1.Sign Up");
            System.out.println("2.Sign In");
            System.out.println("Enter your command");
            command = Integer.parseInt(input.nextLine());
            if (command == 1)
            {
               signUpLibrarian(ketabkhune , ketabdar , karbar , ketab);
            }
            else
            {
               signInLibrarian(ketabkhune , ketabdar , karbar , ketab);
            }
            librarianMenu(ketabkhune, karbar, ketab, ketabdar);
        }
    }

    public static void signUpUser(Library ketabkhune , Librarian ketabdar , User karbar , Book ketab)
    {
        // input = new Scanner(System.in);
        System.out.println("Enter your username");
        System.out.println("Username : ");
        String username = input.nextLine();
        karbar.setUsername(username);
        if (ketabkhune.doesUserExist(karbar))
        {
            System.out.println("You have already signed up!");
            System.out.println("Enter your password to sign in");
            System.out.println("Password : ");
            String password = input.nextLine();
            karbar.setPassword(password);
            if (ketabkhune.userPasswordCheck(karbar))
            {
                System.out.println("Welcome!");
            }
            else
            {
                System.out.println("Wrong password!");
                runMenu(ketab , ketabkhune , karbar , ketabdar);
            }
        }
        else
        {
            System.out.println("Enter your password");
            System.out.println("Password : ");
            String password = input.nextLine();
            karbar.setPassword(password);
            ketabkhune.addUser(karbar);
        }
    }

    public static void signInUser(Library ketabkhune , Librarian ketabdar , User karbar , Book ketab)
    {
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter your username");
        System.out.println("Username : ");
        String username = input.nextLine();
        karbar.setUsername(username);
        if (ketabkhune.doesUserExist(karbar))
        {
            System.out.println("Enter your password");
            System.out.println("Password : ");
            String password = input.nextLine();
            if (ketabkhune.userPasswordCheck(karbar))
            {
                System.out.println("Welcome!");
            }
            else
            {
                System.out.println("Wrong password!");
                runMenu(ketab , ketabkhune , karbar , ketabdar);
            }
        }
        else
        {
            System.out.println("You do not have an account!");
            System.out.println("You have to sign up!");
            runMenu(ketab , ketabkhune , karbar , ketabdar);
        }
    }

    public static void signUpLibrarian(Library ketabkhune , Librarian ketabdar , User karbar , Book ketab)
    {
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter your username");
        System.out.println("Username : ");
        String username = input.nextLine();
        ketabdar.setUsername(username);
        if (ketabkhune.doesLibrarianExist(ketabdar))
        {
            System.out.println("You have already signed up!");
            System.out.println("Enter your password to sign in");
            System.out.println("Password : ");
            String password = input.nextLine();
            ketabdar.setPassword(password);
            if (ketabkhune.librarianPasswordCheck(ketabdar))
            {
                System.out.println("Welcome!");
            }
            else
            {
                System.out.println("Wrong password!");
                runMenu(ketab , ketabkhune , karbar , ketabdar);
            }
        }
        else
        {
            System.out.println("Enter your password");
            System.out.println("Password : ");
            String password = input.nextLine();
            ketabdar.setPassword(password);
            ketabkhune.addLibrarian(ketabdar);
        }
    }

    public static void  signInLibrarian(Library ketabkhune , Librarian ketabdar , User karbar , Book ketab)
    {
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter your username");
        System.out.println("Username : ");
        String username = input.nextLine();
        karbar.setUsername(username);
        if (ketabkhune.doesLibrarianExist(ketabdar))
        {
            System.out.println("Enter your password");
            System.out.println("Password : ");
            String password = input.nextLine();
            if (ketabkhune.librarianPasswordCheck(ketabdar))
            {
                System.out.println("Welcome!");
            }
            else
            {
                System.out.println("Wrong password!");
                runMenu(ketab , ketabkhune , karbar , ketabdar);
            }
        }
        else
        {
            System.out.println("You do not have an account!");
            System.out.println("You have to sign up!");
            runMenu(ketab , ketabkhune , karbar , ketabdar);
        }
    }

    public static void borrowBook(Library ketabkhune , User karbar , Book ketab)
    {
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter the book's name ");
        System.out.println("Name : ");
        String name = input.nextLine();
        ketab.setName(name);
        System.out.println("Enter the author's name");
        System.out.println("Author : ");
        String author = input.nextLine();
        ketab.setAuthor(author);
        if (ketabkhune.searchBook(ketab).equals(""))
        {
            System.out.println("The library does not have this book or it is not available!");
        }
        else
        {
            String ISBN = ketabkhune.searchBook(ketab);
            ketab.setISBN(ISBN);
            karbar.rentBook(ketabkhune , ketab);
        }
    }

    public static void returnBook(Library ketabkhune , User karbar , Book ketab)
    {
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter the book's name ");
        System.out.println("Name : ");
        String name = input.nextLine();
        ketab.setName(name);
        System.out.println("Enter the author's name");
        System.out.println("Author : ");
        String author = input.nextLine();
        ketab.setAuthor(author);
        if (karbar.searchRentBook(ketab).equals(""))
        {
            System.out.println("You do not have this book!");
        }
        else
        {
            String ISBN = karbar.searchRentBook(ketab);
            ketab.setISBN(ISBN);
            karbar.returnBook(ketabkhune , ketab);
        }
    }

    public static void logOut(Book ketab , Library ketabkhune , User karbar , Librarian ketabdar)
    {
        System.out.println("You have logged out!");
        runMenu(ketab , ketabkhune , karbar , ketabdar);
    }

    public static void userMenu(Library ketabkhune, User karbar, Book ketab , Librarian ketabdar)
    {
        //Scanner input = new Scanner(System.in);
        System.out.println("1.Borrow book");
        System.out.println("2.Return book");
        System.out.println("3.Update User");
        System.out.println("4.Log out");
        System.out.println("Enter your command");
        System.out.println("command : ");
        int command = Integer.parseInt(input.nextLine());
        if (command == 1)
        {
            borrowBook(ketabkhune, karbar, ketab);
            userMenu(ketabkhune, karbar, ketab , ketabdar);
        }
        else if (command == 2)
        {
            returnBook(ketabkhune, karbar, ketab);
            userMenu(ketabkhune, karbar, ketab, ketabdar);
        }
        else  if (command == 3)
        {
            ketabkhune.updateUser(karbar);
            userMenu(ketabkhune, karbar, ketab, ketabdar);

        }
        else if (command == 4)
        {
            logOut(ketab , ketabkhune , karbar , ketabdar);
        }
    }

    public static void librarianMenu(Library ketabkhune, User karbar, Book ketab, Librarian ketabdar)
    {
        //Scanner input = new Scanner(System.in);
        // Books
        System.out.println("1.Add book");
        System.out.println("2.Remove book");
        System.out.println("3.Search book");
        // Users
        String usersUsername;
        String usersPassword;
        System.out.println("4.Add user");
        System.out.println("5.Remove user");
        System.out.println("6.Search user");
        System.out.println("7.Update user");
        // Librarian
        System.out.println("8.Update librarian");
        System.out.println("9.Search librarian");
        System.out.println("10.Log out");
        System.out.println("Enter your command");
        System.out.println("command : ");
        int command = Integer.parseInt(input.nextLine());
        if (command == 1) {
            System.out.println("Enter book's name");
            System.out.println("Name : ");
            String name = input.nextLine();
            ketab.setName(name);
            System.out.println("Enter author's name");
            System.out.println("Author : ");
            String author = input.nextLine();
            ketab.setAuthor(author);
            System.out.println("Enter the year of publish");
            System.out.println("Year of publish : ");
            int yearOfPublish = Integer.parseInt(input.nextLine());
            ketab.setYearOfPublish(yearOfPublish);
            System.out.println("Enter the book's ISBN");
            System.out.println("ISBN : ");
            String ISBN = input.nextLine();
            ketab.setISBN(ISBN);
            ketabkhune.addBook(ketab);
            librarianMenu(ketabkhune , karbar , ketab , ketabdar);
        }
        else if (command == 2) {
            System.out.println("Enter the book's ISBN");
            System.out.println("ISBN : ");
            String removeISBN = input.nextLine();
            ketab.setISBN(removeISBN);
            ketabkhune.removeBook(ketab);
            librarianMenu(ketabkhune , karbar , ketab , ketabdar);
        }
        else if (command == 3) {
            if (ketabkhune.doesBookExist(ketab)) {
                System.out.println(ketab);
            } else {
                System.out.println("This book does not exist!");
            }
            librarianMenu(ketabkhune , karbar , ketab , ketabdar);
        }
        else if (command == 4) {
            System.out.println("Enter the user's username");
            System.out.println("Username : ");
            usersUsername = input.nextLine();
            karbar.setUsername(usersUsername);
            System.out.println("Enter user's password");
            System.out.println("Password : ");
            usersPassword = input.nextLine();
            karbar.setPassword(usersPassword);
            ketabkhune.addUser(karbar);
            librarianMenu(ketabkhune , karbar , ketab , ketabdar);
        }
        else if (command == 5) {
            System.out.println("Enter the user's username");
            System.out.println("Username : ");
            usersUsername = input.nextLine();
            karbar.setUsername(usersUsername);
            if (ketabkhune.doesUserExist(karbar))
            {
                ketabkhune.removeUser(karbar);
                System.out.println("The user is removed");
            }
            else
            {
                System.out.println("The user does not exist!");
            }
            librarianMenu(ketabkhune , karbar , ketab , ketabdar);
        }
        else if (command == 6) {
            System.out.println("Enter the user's username");
            System.out.println("Username : ");
            usersUsername = input.nextLine();
            karbar.setUsername(usersUsername);
            ketabkhune.searchUser(karbar);
            librarianMenu(ketabkhune , karbar , ketab , ketabdar);
        }
        else if (command == 7) {
            System.out.println("Enter the user's username");
            System.out.println("Username : ");
            usersUsername = input.nextLine();
            karbar.setUsername(usersUsername);
            ketabkhune.updateUser(karbar);
            librarianMenu(ketabkhune , karbar , ketab , ketabdar);
        }
        else if (command == 8) {
            ketabkhune.updateLibrarian(ketabdar);
            librarianMenu(ketabkhune , karbar , ketab , ketabdar);
        }
        else if (command == 9) {
            ketabkhune.searchLibrarian(ketabdar);
            librarianMenu(ketabkhune , karbar , ketab , ketabdar);
        }
        else if (command == 10) {
            logOut(ketab , ketabkhune , karbar , ketabdar);
        }

    }
}


