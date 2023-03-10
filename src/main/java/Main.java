import java.util.Scanner;
import javax.swing.*;

public class Main {
    static Library library = new Library();
    static User user = new User();
    static Librarian librarian = new Librarian();

    //static User user = new User();

    /*
    * make a functional library app using oop
    * run the main program in Main.java and code the oop part in other classes
    * don't forget to add at least 1 librarian to the library to make it functionable.
    * *  *** don't limit yourself to our template ***
     */

    public static void main(String[] args) {
        //System.out.println(displayLibrarianMenu_Book());
        runMenu();
    }

    public static void runMenu(){
        while (true) {
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Hello! Please enter your name.");
        String firstName = JOptionPane.showInputDialog(null,"Hello! Please enter your name.");
        String firstChosenOption = JOptionPane.showInputDialog(null,"Welcome to the library, dear " + firstName + "!\n" + printChooseAnOption() + "\n" + displayFirstOption());
        switch (firstChosenOption) {
            case "1": // Sign Up as a New User
                String signUpChosenOption = JOptionPane.showInputDialog(null, printChooseAnOption() + "\n" + displaySignUpMenu());
                switch (signUpChosenOption) {
                    case "1": // Sign Up as a User
                        newUserSignUp();
                        LoginAsAUser();
                        break;
                    case "2": // Sign Up as a Librarian
                        newLibrarianSignUp();
                        LoginAsALibrarian();
                        break;
                
                    default:
                        runMenu();
                        break;
                }

                break;

            case "2": // Already Have an Account? Let's Login.
                String loginChosenOption = JOptionPane.showInputDialog(null, printChooseAnOption() + "\n" + displayLoginMenu());
                switch (loginChosenOption) {
                    case "1": // Login as a user
                        LoginAsAUser();
                        break;

                    case "2": // Login as a Librarian
                        LoginAsALibrarian();
                        break;
                
                    default:
                        runMenu();
                        break;
                }
                break;
            default:
                runMenu();
                break;
        }

        //String firstName = sc.nextLine();
        //System.out.println("Welcome to the library, dear " + firstName + "!\n" + printChooseAnOption() + "\n" + displayLoginMenu());
        // if (loginChosenOption.equals("1")) {
        //     newUserSignUp();
        // }
        //JOptionPane.showMessageDialog(null, "meow");
        //System.out.println(loginChosenOption);
        for (int i = 0; i < library.getUsers().size(); i++) {
            System.out.println(library.getUsers().get(i));
        }
        //sc.close();
        }
    }

    public static String printChooseAnOption() {
        return "Please Choose One Option: ";
    }
    public static String displayFirstOption() {
        return "1: Sign Up as a New User\n2: Already Have an Account? Let's Login.";
    }
    public static String displaySignUpMenu() {
        return "1: Sign Up as a User\n2: Sign Up as a Librarian";
    }
    public static String displayLoginMenu() {
        return "1: Login as a User\n2: Login as a Librarian";
    }
    public static String displayUserMenu() {
        return "1: Borrow a Book\n2: Return a Book";
    }
    public static String displayLibrarianMenu_Book() {
        //System.out.println(displayUserMenu());
        return displayUserMenu() + "3: Add a Book\n4: Remove a Book\n5: Search a Book\n6: Update a Book";
    }
    public static String displayLibrarianMenu_User() {
        return "1: Add a User\n2: Remove a User\n3: Search a User\n4: Update a User";
    }
    public static String displayLibrarianMenu_Librarian() {
        return "1: Add a Librarian\n2: Remove a Librarian\n3: Search a Librarian\n4: Update a Librarian";
    }
    public static void newUserSignUp() {
        String username = JOptionPane.showInputDialog(null, "Please enter a username: ");
        String password = JOptionPane.showInputDialog(null, "Let's create a password: ");
        User newUser =new User(username,password);
        library.addUser(newUser);

    }

    public static void newLibrarianSignUp() {
        String username = JOptionPane.showInputDialog(null, "Please enter a username: ");
        String password = JOptionPane.showInputDialog(null, "Let's create a password: ");
        Librarian newUser =new Librarian(username,password);
        library.addLibrarian(newUser);

    }

    public static void LoginAsALibrarian() {
        String username = JOptionPane.showInputDialog(null, "Please enter your username: ");
        String password = JOptionPane.showInputDialog(null, "Please enter your password: ");
        if (library.doesLibrarianExist(username)) {
            if (library.librarianIsAuthenticated(username, password)) {
                String librarianFirstMenuOption = JOptionPane.showInputDialog(null, "Welcome to your page dear " + username + "!\n" + printChooseAnOption() + "\n1: User Menu Options\n2: Librarian Menu Options\n3: Book Menu Options");
                switch (librarianFirstMenuOption) {
                    case "1": // User Menu Options
                        String librarianUserMenuOption = JOptionPane.showInputDialog(null, "*USER MENU OPTIONS*\n" + displayLibrarianMenu_User());
                        switch (librarianUserMenuOption) {
                            case "1": // Add a User
                                //library.addUser(user);
                                newUserSignUp();
                                break;
                            case "2": // Remove a User
                                String remove_searchUserViaUsername = JOptionPane.showInputDialog(null, "Enter the username you want to remove: ");
                                User removedUser = library.searchUser(remove_searchUserViaUsername);
                                library.removeUser(removedUser);
                                break;
                            case "3": // Search a User
                                String searchUserViaUsername = JOptionPane.showInputDialog(null, "Enter the username you want to search: ");
                                User searchedUser = library.searchUser(searchUserViaUsername);
                                JOptionPane.showMessageDialog(null, searchedUser);
                                break;
                            case "4": // Update a Book
                                String update_searchUserViaUsername = JOptionPane.showInputDialog(null, "Enter the username you want to update: ");
                                User updatedUser = library.searchUser(update_searchUserViaUsername);
                                String newPassword = JOptionPane.showInputDialog(null, "Enter the new password: ");
                                library.updateUser(updatedUser.getUsername(), updatedUser.getPassword(), newPassword); //////////////////////////////////////////////////////////////////////////
                                break;
                            default:
                                runMenu();
                                break;
                        }
                        break;
                    case "2": // Librarian Menu Options
                        String librarianLibrarianMenuOption = JOptionPane.showInputDialog(null, "*LIBRARIAN MENU OPTIONS*\n" + displayLibrarianMenu_Librarian());
                        //String librarianUserMenuOption = JOptionPane.showInputDialog(null, "*USER MENU OPTIONS*\n" + displayLibrarianMenu_User());
                        switch (librarianLibrarianMenuOption) {
                            case "1": // Add a Librarian
                                //library.addUser(user);
                                //newUserSignUp();
                                newLibrarianSignUp();
                                break;
                            case "2": // Remove a Librarian
                                String remove_searchLibrarianViaUsername = JOptionPane.showInputDialog(null, "Enter the username you want to remove: ");
                                User removedUser = library.searchUser(remove_searchLibrarianViaUsername);
                                library.removeUser(removedUser);
                                break;
                            case "3": // Search a Librarian
                                String searchLibrarianViaUsername = JOptionPane.showInputDialog(null, "Enter the username you want to search: ");
                                User searchedUser = library.searchUser(searchLibrarianViaUsername);
                                JOptionPane.showMessageDialog(null, searchedUser);
                                break;
                            case "4": // Update a Librarian
                                String update_searchLibrarianViaUsername = JOptionPane.showInputDialog(null, "Enter the username you want to update: ");
                                User updatedUser = library.searchUser(update_searchLibrarianViaUsername);
                                String newPassword = JOptionPane.showInputDialog(null, "Enter the new password: ");
                                library.updateUser(updatedUser.getUsername(), updatedUser.getPassword(), newPassword);
                                break;
                            default:
                                runMenu();
                                break;
                        }
                        break;

                    case "3": // Book Menu Options
                        String librarianBookMenuOption = JOptionPane.showInputDialog(null, "*BOOK MENU OPTIONS*\n" + displayLibrarianMenu_Book());
                        switch (librarianBookMenuOption) {
                            case "1": // Borrow a Book
                                String rent_searchViaISBN = JOptionPane.showInputDialog(null, "Enter the ISBN of the book you want to rent: ");
                                Book rentBook = library.searchBook(rent_searchViaISBN);
                                //user.rentBook(rentBook);
                                librarian.rentBook(rentBook);
                                break;
                            case "2": // Return a Book
                                String return_searchViaISBN = JOptionPane.showInputDialog(null, "Enter the ISBN of the book you want to return: ");
                                Book returnBook = library.searchBook(return_searchViaISBN);
                                //user.returnBook(returnBook);
                                librarian.rentBook(returnBook);
                                break;
                            case "3": // Add a Book
                                String add_searchViaISBN = JOptionPane.showInputDialog(null, "Enter the ISBN of the book you want to add: ");
                                Book addBook = library.searchBook(add_searchViaISBN);
                                library.addBook(addBook);
                                break;
                            case "4": // Remove a Book
                                String remove_searchViaISBN = JOptionPane.showInputDialog(null, "Enter the ISBN of the book you want to remove: ");
                                Book removeBook = library.searchBook(remove_searchViaISBN);
                                library.removeBook(removeBook);
                                break;
                            case "5": // Search a Book
                                String searchBookViaISBN = JOptionPane.showInputDialog(null, "Enter the ISBN of the book you want to search: ");
                                Book searchedBook = library.searchBook(searchBookViaISBN);
                                JOptionPane.showMessageDialog(null, searchedBook);
                                break;
                            case "6": // Update a Book
                                String update_searchViaISBN = JOptionPane.showInputDialog(null, "Enter the ISBN of the book you want to update: ");
                                //String update_searchViaISBN = JOptionPane.showInputDialog(null, "Enter the ISBN of the book you want to update: ");
                                //////////////////////////////////////
                                // Book addBook = library.searchBook(add_searchViaISBN);
                                // library.addBook(addBook);
                                break;
                            default:
                                break;
                        
                        
                        }
                        break;
                
                    default:
                        runMenu();
                        break;
                }

                String librarianMenuOption = JOptionPane.showInputDialog(null, "Welcome to your page dear " + username + "!" + "\nWhat would you like to do?\n" + displayUserMenu());
                switch (librarianMenuOption) {    //////////////////////////////////////////////////////// user/book/librarian field //////////////////////////////////////////////////////////////////////////////////////////
                    case "1": // Borrow a Book
                        String rent_searchViaISBN = JOptionPane.showInputDialog(null, "Enter the ISBN of the book you want to rent: ");
                        Book rentBook = library.searchBook(rent_searchViaISBN);
                        user.rentBook(rentBook);

                        break;
                    case "2": // Return a Book
                        String return_searchViaISBN = JOptionPane.showInputDialog(null, "Enter the ISBN of the book you want to return: ");
                        Book returnBook = library.searchBook(return_searchViaISBN);
                        user.returnBook(returnBook);
                        break;
                
                    default:
                        runMenu();
                        break;
                }

            } else {
                JOptionPane.showMessageDialog(null, "The username & password you entered do not match. Please try again: ");
                LoginAsAUser();
                
            }
        } else {
            String wrongUsername = JOptionPane.showInputDialog(null, "This username doesn't exist. Do you want to Sign up as a new user?\n1: Yes, let's create a new account\n2: No, let's try again.");
            switch (wrongUsername) {
                case "1":
                    newUserSignUp();
                    break;
                case "2":
                    LoginAsAUser();
                    break;
            
                default:
                    runMenu();
                    break;
            }

        }

    }

    public static void LoginAsAUser() {
        String username = JOptionPane.showInputDialog(null, "Please enter your username: ");
        String password = JOptionPane.showInputDialog(null, "Please enter your password: ");
        if (library.doesUserExist(username)) {
            if (library.userIsAuthenticated(username, password)) {
                String userMenuOption = JOptionPane.showInputDialog(null, "Welcome to your page dear " + username + "!" + "\nWhat would you like to do?\n" + displayUserMenu());
                switch (userMenuOption) {
                    case "1": // Borrow a Book
                        String rent_searchViaISBN = JOptionPane.showInputDialog(null, "Enter the ISBN of the book you want to rent: ");
                        Book rentBook = library.searchBook(rent_searchViaISBN);
                        user.rentBook(rentBook);

                        break;
                    case "2": // Return a Book
                        String return_searchViaISBN = JOptionPane.showInputDialog(null, "Enter the ISBN of the book you want to return: ");
                        Book returnBook = library.searchBook(return_searchViaISBN);
                        user.returnBook(returnBook);
                        break;
                
                    default:
                        runMenu();
                        break;
                }

            } else {
                JOptionPane.showMessageDialog(null, "The username & password you entered do not match. Please try again: ");
                LoginAsAUser();
                
            }
        } else {
            String wrongUsername = JOptionPane.showInputDialog(null, "This username doesn't exist. Do you want to Sign up as a new user?\n1: Yes, let's create a new account\n2: No, let's try again.");
            switch (wrongUsername) {
                case "1":
                    newUserSignUp();
                    break;
                case "2":
                    LoginAsAUser();
                    break;
            
                default:
                    runMenu();
                    break;
            }

        }

    }
    
}
