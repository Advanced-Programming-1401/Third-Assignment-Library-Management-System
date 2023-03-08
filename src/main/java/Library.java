//import java.awt.print.Book;
import java.util.*;

public class Library {
    /*
    * The library should have a list of books.
    * The library should have a map of books ISBNs which is linked to the amount of book
    -> (for example: harry potter -> 4 means there are currently 4 harry potter books)
    * The library should have a list of users and a list of librarians.
     */

    static Scanner input = new Scanner(System.in);
    ArrayList<Book> BookList = new ArrayList<Book>();

    //private HashMap<User, String  > UserList = new HashMap<String, String>();
    ArrayList<User> UserList = new ArrayList<User>();
     ArrayList<Librarian> LibrarianList = new ArrayList<Librarian>();
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
    public void addBook(String name , String Author, int YearPublish , int ISBN ){
        Book book = new Book(name,Author,YearPublish,ISBN);
        BookList.add(book);

        //System.out.println("!!!!!!!!!ADD!!!!!!!!!!!");

    }


    public void removeBook(int ISBN){
        BookList.remove(ISBN);

 /*       boolean successful = false;
        for (int i = 0 ; i < BookList.size() ; i++)
        {
            if((int)BookList.get(i).getISBN() == ISBN)
            {
                BookList.remove(i);
                System.out.println("Book removal successful");
                successful=true;
            }
        }

        if (!successful)
        {
            System.out.println("Could not remove book "+ ISBN );
        }
*/
    }

    public Book searchBook(){

        System.out.println("Which book are you searching for ?");
        booksearch = input.next();
        for (Book book : BookList)
        {
            if (book.getName().contains(booksearch) || book.getAuthor().contains(booksearch))
            {
                return book;
            }
        }
        System.out.println("there is no book with this name");
        return null; //No book was found

    }

    public void updateBook(String UpdateName , String UpdateAuthor ,int UpdateYear , int UpdateISBN){

        Book book = null;
        book.setName(UpdateName);
        book.setAuthor(UpdateAuthor);
        book.setYearPublish(UpdateYear);
        book.setISBN(UpdateISBN);

    }

    public boolean doesBookExist(){

        //System.out.println("Know about your searching book to exist or not = ");
        booksearch = input.nextLine();
        for (Book book : BookList)
        {
            if (book.getName().contains(booksearch) || book.getAuthor().contains(booksearch))
            {
               //System.out.println("NOT EXIST");
                return true;
            }
        }
        //System.out.println("EXIST"); //No book was found

        return false;
    }

//................................................................

    //user related functions

    public void addUser(String username , String password){

        User user = new User(username ,password);
         UserList.add(user);
        System.out.println("Welcome!  " + username );

    }

    public void removeUser(String username ,String password){

        boolean successful = false;
        for (int i = 0 ; i < UserList.size() ; i++)
        {
            if(UserList.equals(UserList.get(i).getUsername()))
            {
                UserList.remove(username);
                UserList.remove(password);

                System.out.println("User removal successful");
                successful=true;
            }
        }

        if (!successful)
        {
            System.out.println("There is no user with "+ username +"username and "+password+" this password" );
        }
    }

    public User searchUser(){

        System.out.println("Which User are you searching for ?");
        String Usersearch = input.nextLine();
        for (User user : UserList)
        {
            if (user.getUsername().contains(booksearch))
            {
                return user;
            }
        }
        return null; //No user was found
    }

    public void updateUser(String username , String password ){
        User user = null;
        user.setUsername(username);
        user.setPassword(password);

    }

    public boolean doesUserExist(String Usersearch ){
        //Usersearch = input.nextLine();
        for (User user : UserList)
        {
            if (user.getUsername().contains(Usersearch))
            {
               //System.out.println("EXIST");
               return true;
            }
        }
        //System.out.println("NO User EXIST"); //No user was found
        return false;
    }

    //librarian related functions

    public void addLibrarian(String username , String password){
        Librarian librarian = new Librarian(username ,password);
        LibrarianList.add(librarian);
        System.out.println("Welcome!  MRS/MS " + username );

    }

    public void removeLibrarian(String username , String password){

        boolean successful = false;
        for (int i = 0 ; i < LibrarianList.size() ; i++)
        {
            if(LibrarianList.equals(LibrarianList.get(i).getUsername()))
            {
                LibrarianList.remove(username);
                LibrarianList.remove(password);

                System.out.println("Librarian removal successful");
                successful=true;
            }
        }

        if (!successful)
        {
            System.out.println("There is no librarian with "+ username +"username and "+password+" this password" );
        }
    }

    public Librarian searchLibrarian(){
        System.out.println("Which Librarian are you searching for ?");
       String Librariansearch = input.nextLine();
        for (Librarian librarian : LibrarianList)
        {
            if (librarian.getUsername().contains(Librariansearch))
            {
                return librarian;
            }
        }
        return null; //No user was found
    }

    public void updateLibrarian(String username , String password){
        User user = null;
        user.setUsername(username);
        user.setPassword(password);
    }

    public boolean doesLibrarianExist(String LibrarianSearch){
        //System.out.println("To Know about your searching librarian to exist or not plz write username again = ");
         //LibrarianSearch = input.nextLine();
        for (Librarian librarian : LibrarianList)
        {
            if (librarian.getUsername().contains(LibrarianSearch))
            {
                //System.out.println("EXIST");
                return true;
            }
        }
        //System.out.println("NO User EXIST"); //No user was found
        return false;
    }

    }

