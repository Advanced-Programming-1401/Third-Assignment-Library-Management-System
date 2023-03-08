import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {
    /*
    * The library should have a list of books.
    * The library should have a map of books ISBNs which is linked to the amount of book
    -> (for example: harry potter -> 4 means there are currently 4 harry potter books)
    * The library should have a list of users and a list of librarians.
     */

    private String libraryName;

    //book
    ArrayList<String> ExistedBooks = new ArrayList<String>();
    Map<String, Integer> NumberOfBooks = new HashMap<String, Integer>();

    //librarian  user
    ArrayList<User> Users = new ArrayList<User>();
    ArrayList<Librarian> Librarians = new ArrayList<Librarian>();
    Map<String, String> users = new HashMap<String, String>();
    Map<String, String> librarians = new HashMap<String, String>();

    public Library(String libraryName) {
        this.libraryName = libraryName;
    }

    //book related functions

    public void addBook(Book book){
        ExistedBooks.add(book.getNameOfBook());
        NumberOfBooks.put(book.getNameOfBook(), book.getNumberOfBook());
    }

    public void removeBook(Book book){

    }

    public boolean doesBookExist(String bookName) {
        for (String element : ExistedBooks) {
            if (element.contains(bookName)) {
                return true;
            } else {
                System.out.println("This book doesn't exist!");
            }
        }
        return false;
    }

    public void searchBook(){
        //TODO
    }

    public void updateBook(){
        //TODO
    }

    public void increaseBook(){
        //TODO
    }

    public void decreaseBook(){
        //TODO
    }

    //user related functions

    public void addUser(){
        //TODO
    }

    public void removeUser(){
        //TODO
    }

    public void doesUserExist(){
        //TODO
    }

    public void searchUser(){
        //TODO
    }

    public void updateUser(){
        //TODO
    }

    //librarian related functions

    public void addLibrarian(){
        //TODO
    }

    public void removeLibrarian(){
        //TODO
    }

    public void doesLibrarianExist(){
        //TODO
    }

    public void searchLibrarian(){
        //TODO
    }

    public void updateLibrarian(){
        //TODO
    }
}
