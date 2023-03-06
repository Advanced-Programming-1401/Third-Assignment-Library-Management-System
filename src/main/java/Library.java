//import java.awt.print.Book;
import java.util.*;
import java.util.HashMap;

public class Library  extends Book{
    /*
    * The library should have a list of books.
    * The library should have a map of books ISBNs which is linked to the amount of book
    -> (for example: harry potter -> 4 means there are currently 4 harry potter books)
    * The library should have a list of users and a list of librarians.
     */
    static Scanner input = new Scanner(System.in);
    private ArrayList<Book> BookList= new ArrayList<Book>();
    private ArrayList<User> UserList = new ArrayList<User>();
    private ArrayList<Librarian> LibrarianList = new ArrayList<Librarian>();
    String booksearch;
    public Library(){

        this.BookList = new ArrayList<Book>();
        this.UserList = new ArrayList<User>();
        this.LibrarianList = new ArrayList<Librarian>();

    }

/*
    HashMap<String, Book> directory = new HashMap<>();
      directory.put(book1.getName(), book1);
      directory.put(book2.getName(), book2);
*/

    //book related functions
    public void addBook(Book book){
        //TODO
        BookList.add(book);
    }


    public void removeBook(Book book){
        //TODO
        BookList.remove(book);
    }

    public Book searchBook(){
        //TODO

        System.out.println("Which book are you searching for ?");
        booksearch = input.nextLine();
        for (Book book : BookList)
        {
            if (book.getName().contains(booksearch) || book.getAuthor().contains(booksearch)
            {
                return book;
            }
        }
        return null; //No book was found

    }

    public void updateBook(Book book){
        //TODO
    }

    public void doesBookExist(Book book){
        //TODO
    }

    public void increaseBook(Book book){
        //TODO
    }

    public void decreaseBook(Book book){
        //TODO
    }

    //user related functions

    public void addUser(User add){
        //TODO
    }

    public void removeUser(User remove){
        //TODO
    }

    public void searchUser(User search){
        //TODO
    }

    public void updateUser(User update){
        //TODO
    }

    public void doesUserExist(User exist ){
        //TODO
    }

    //librarian related functions

    public void addLibrarian(Librarian add){
        //TODO
    }

    public void removeLibrarian(Librarian remove){
        //TODO
    }

    public void searchLibrarian(Librarian search){
        //TODO
    }

    public void updateLibrarian(Librarian update){
        //TODO
    }

    public void doesLibrarianExist(Librarian exist){
        //TODO
    }


}
