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
    private ArrayList <Book> BookList= new ArrayList<Book>();
     //private HashMap<User, String  > UserList = new HashMap<String, String>();
    private ArrayList <User> UserList = new ArrayList<User>();
    private ArrayList <Librarian> LibrarianList = new ArrayList<Librarian>();
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
        BookList.add(book);
    }


    public void removeBook(int ISBN){

        boolean successful = false;
        for (int i=0;i<BookList.size();i++)
        {
            if((int)BookList.get(i).getISBN()==ISBN)
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

    }

    public Book searchBook(){

        System.out.println("Which book are you searching for ?");
        booksearch = input.nextLine();
        for (Book book : BookList)
        {
            if (book.getName().contains(booksearch) || book.getAuthor().contains(booksearch))
            {
                return book;
            }
        }
        return null; //No book was found

    }

    public void updateBook(String UpdateName , String UpdateAuthor ,int UpdateYear , int UpdateISBN){

        Book book = null;
        book.setName(UpdateName);
        book.setAuthor(UpdateAuthor);
        book.setYearPublish(UpdateYear);
        book.setISBN(UpdateISBN);

    }

    public void doesBookExist(){

        System.out.println("Know about your seaerching book to exist or not = ");
        booksearch = input.nextLine();
        for (Book book : BookList)
        {
            if (book.getName().contains(booksearch) || book.getAuthor().contains(booksearch))
            {
               System.out.println("NOT EXIST");
            }
        }
        System.out.println("EXIST"); //No book was found

    }

    public void increaseBook(Book book){
        //TODO
    }

    public void decreaseBook(Book book){
        //TODO
    }

//................................................................

    //user related functions

    public void addUser(User username , User password){

         UserList.add(username);
         UserList.add(password);
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

    public User searchUser(String Usersearch){

        System.out.println("Which User are you searching for ?");
        Usersearch = input.nextLine();
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

    public void doesUserExist(String Usersearch ){
        System.out.println("Which User are you searching for ?");
        Usersearch = input.nextLine();
        for (User user : UserList)
        {
            if (user.getUsername().contains(Usersearch))
            {
               System.out.println("EXIST");
            }
        }
        System.out.println("NO User EXIST"); //No user was found
    }

    //librarian related functions

    public void addLibrarian(Librarian username , Librarian password){
        LibrarianList.add(username);
        LibrarianList.add(password);
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

    public Librarian searchLibrarian(String  Librariansearch){
        System.out.println("Which Librarian are you searching for ?");
        Librariansearch = input.nextLine();
        for (Librarian librarian : LibrarianList)
        {
            if (librarian.getUsername().contains(booksearch))
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

    public void doesLibrarianExist(String LibrarianSearch){
        System.out.println("Know about your seaerching librarian to exist or not = ");
         LibrarianSearch = input.nextLine();
        for (Librarian librarian : LibrarianList)
        {
            if (librarian.getUsername().contains(LibrarianSearch))
            {
                System.out.println("EXIST");
            }
        }
        System.out.println("NO User EXIST"); //No user was found
    }

    }

