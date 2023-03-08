import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

public class Library {
    /*
    * The library should have a list of books.
    * The library should have a map of books ISBNs which is linked to the amount of book
    -> (for example: harry potter -> 4 means there are currently 4 harry potter books)
    * The library should have a list of users and a list of librarians.
     */

    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Librarian> librarians;
    private HashMap<String, Integer> amountOfTheBook;


    public Library() {
        this.books = new ArrayList<Book>();
        this.librarians = new ArrayList<Librarian>();
        this.users = new ArrayList<User>();
        this.amountOfTheBook = new HashMap<String,Integer>();

    }

    public Library(Book books, Librarian librarians, User users) {
        this.books = new ArrayList<Book>();
        this.librarians = new ArrayList<Librarian>();
        this.users = new ArrayList<User>();
        this.amountOfTheBook = new HashMap<String,Integer>();
    }


    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Librarian> getLibrarians() {
        return librarians;
    }

    public void setLibrarians(ArrayList<Librarian> librarians) {
        this.librarians = librarians;
    }

    public HashMap<String, Integer> getAmountOfTheBook() {
        return amountOfTheBook;
    }

    public void setAmountOfTheBook(HashMap<String, Integer> amountOfTheBook) {
        this.amountOfTheBook = amountOfTheBook;
    }





    
    //book related functions

    public void addBook(Book book){
        //Book addedBook = new Book(name, author, yearOfPublish, ISBN);
        // books.add(book);
        // increaseBook(book.getISBN());
        if (doesBookExist(book.getISBN())) {
            increaseBook(book.getISBN());
            JOptionPane.showMessageDialog(null,"The book " + book.getName() + " added successfully!");

        } else {
            books.add(book);
            increaseBook(book.getISBN());
            JOptionPane.showMessageDialog(null,"The book " + book.getName() + " added successfully!");
        }
        
    }

    public void removeBook(Book book){
        if (doesBookExist(book.getISBN())) {
            books.remove(book);
            decreaseBook(book.getISBN());
            JOptionPane.showMessageDialog(null,"The book " + book.getName() + " has been removed.");

        } else {
            JOptionPane.showMessageDialog(null,"The book doesn't exist.");
        }
    }

    public Book searchBook( String ISBN ){
        if (doesBookExist(ISBN)) {
            for (Book book : books) {
                if (book.getISBN().equals(ISBN)) {
                    //System.out.println(book);
                    JOptionPane.showMessageDialog(null,book);
                    return book;
                }
            } 
        }
        JOptionPane.showMessageDialog(null,"The book doesn't exist.");
        return null;
        
    }

    public void updateBook(String ISBN, String newName, String newAuthor, int newYearOfPublish){
        if ( doesBookExist(ISBN)){
            for (Book book : books) {
                if (book.getISBN().equals(ISBN)) {
                    book.setName(newName);
                    book.setAuthor(newAuthor);
                    book.setYearOfPublish(newYearOfPublish);
                }    
            }
        JOptionPane.showMessageDialog(null,"Updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null,"The book doesn't exist.");
        }
    }

    public boolean doesBookExist( String ISBN ){
        for (Book book : books) {
            if (book.getISBN().equals(ISBN))
                return true;
                
        }
        return false;
        
    }

    public void increaseBook(String ISBN){
        if (doesBookExist(ISBN)) {
            amountOfTheBook.replace(ISBN, amountOfTheBook.get(ISBN) + 1);
        } else {
            amountOfTheBook.put(ISBN, 1);

        }
        
    }

    public void decreaseBook(String ISBN){
        if (doesBookExist(ISBN)) {
            amountOfTheBook.replace(ISBN, amountOfTheBook.get(ISBN) - 1);

        } else {
            JOptionPane.showMessageDialog(null,"The book doesn't exist.");
        }
    }

    //user related functions


    public void addUser(User user){
        if (doesUserExist(user.getUsername())) {
            JOptionPane.showMessageDialog(null,"The user " + user.getUsername() + " already exists.");

        } else {
            users.add(user);
            JOptionPane.showMessageDialog(null,"The user " + user.getUsername() + " added successfully!");
        }

    }

    public void removeUser(User user){
        if (doesUserExist(user.getUsername())) {
            users.remove(user);
            JOptionPane.showMessageDialog(null,"The user " + user.getUsername() + " has been removed.");

        } else {
            JOptionPane.showMessageDialog(null,"The username doesn't exist.");
        }
    }

    public User searchUser(String username){
        if (doesUserExist(username)) {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    //System.out.println(user);
                    JOptionPane.showMessageDialog(null,user);
                    return user;
                }
            }
        }
        JOptionPane.showMessageDialog(null,"The username doesn't exist.");
        return null;
    }

    public void updateUser(String username, String newUsername, String newPassword){
        if ( doesUserExist(username) ) {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    user.setUsername(newUsername);
                    user.setPassword(newPassword);
                }
            } 
        JOptionPane.showMessageDialog(null,"Updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null,"The username doesn't exist.");

        }
    }

    public boolean doesUserExist(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) 
                return true;
        }
        return false;
    }

    //librarian related functions

    public void addLibrarian(Librarian librarian){
        if (doesLibrarianExist(librarian.getUsername())) {
            JOptionPane.showMessageDialog(null,"The librarian " + librarian.getUsername() + " already exists.");

        } else {
            librarians.add(librarian);
            JOptionPane.showMessageDialog(null,"The librarian " + librarian.getUsername() + " added successfully!");
        }
    }

    public void removeLibrarian(Librarian librarian){
        if (doesLibrarianExist(librarian.getUsername())) {
            librarians.remove(librarian);
            JOptionPane.showMessageDialog(null,"The librarian " + librarian.getUsername() + " has been removed.");

        } else {
            JOptionPane.showMessageDialog(null,"The librarian doesn't exist.");
        }
    }

    public Librarian searchLibrarian(String username){
        if (doesLibrarianExist(username)) {
            for (Librarian librarian : librarians) {
                if (librarian.getUsername().equals(username)) {
                    JOptionPane.showMessageDialog(null,librarian);
                    return librarian;
                }
            }
        }
        JOptionPane.showMessageDialog(null,"The librarian doesn't exist.");
        return null;
    }

    public void updateLibrarian(String username, String newUsername, String newPassword){
        if ( doesLibrarianExist(username) ) {
            for (Librarian librarian : librarians) {
                if (librarian.getUsername().equals(username)) {
                    librarian.setUsername(newUsername);
                    librarian.setPassword(newPassword);
                }
            } 
        JOptionPane.showMessageDialog(null,"Updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null,"The librarian doesn't exist.");

        }
    }

    public boolean doesLibrarianExist(String username){
        for (Librarian librarian : librarians) {
            if (librarian.getUsername().equals(username)) 
                return true;
        }
        return false;
    }

}
