import java.awt.print.Book;
import java.util.*;
import java.util.HashMap;

public class Library {
    /*
    * The library should have a list of books.
    * The library should have a map of books ISBNs which is linked to the amount of book
    -> (for example: harry potter -> 4 means there are currently 4 harry potter books)
    * The library should have a list of users and a list of librarians.
     */
    private ArrayList collection;
    //ArrayList<String> collection= new ArrayList<Book>();

    public Library(){
        collection = new ArrayList<Book>();
    }

/*
    HashMap<String, Book> directory = new HashMap<>();
      directory.put(book1.getName(), book1);
      directory.put(book2.getName(), book2);
*/

    //book related functions
    public void addBook(Book book){
        //TODO
        collection.add(book);
    }


    public void removeBook(Book book){
        //TODO
        collection.remove(book);
    }

    public void searchBook(Book book){
        //TODO


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
