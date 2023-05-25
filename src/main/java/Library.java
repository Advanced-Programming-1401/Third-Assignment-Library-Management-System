
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Library {
    /*
    * The library should have a list of books.
    * The library should have a map of books ISBNs which is linked to the amount of book
    -> (for example: harry potter -> 4 means there are currently 4 harry potter books)
    * The library should have a list of users and a list of librarians.
     */

    //book related functions

    // ArrayLists
    private HashMap<String, Integer>numberOfBooks = new HashMap<String, Integer>();
    private ArrayList<Book>Books  = new ArrayList<Book>();
    private ArrayList<Librarian>Librarians = new ArrayList<Librarian>();
    private ArrayList<User>Users = new ArrayList<User>();

    // Public Functions

    // Book Related Functions
    public void addBook(String name, String author, String year, String isbn){
        if(!this.doesBookExist(isbn)){
            Book myBook = new Book();
            myBook.setName(name);
            myBook.setAuthor(author);
            myBook.setYear(year);
            myBook.setIsbn(isbn);
            this.Books.add(myBook);
            this.increaseBook(myBook);
        }
    }

    public void removeBook(String isbn){
        if(this.doesBookExist(isbn)){
            this.Books.remove(this.searchBook(isbn));
        }
    }

    public Book searchBook(String isbn){
        Book myTargetBook = new Book();
        if(this.doesBookExist(isbn)){
            for(Book value : this.Books){
                if(isbn.equals(value.getIsbn())){
                    myTargetBook = value;
                    break;
                }
            }
        }
        return myTargetBook;
    }

    public Book searchBook(String name, String author){
        Book myTargetBook = new Book();
        if(this.doesBookExist(name, author)){
            for(Book value : Books){
                if(name.equals(value.getName()) && author.equals(value.getAuthor())){
                    myTargetBook = value;
                    break;
                }
            }
        }

        return myTargetBook;
    }

    public void updateBook(Book myBook){
        if(doesBookExist(myBook.getIsbn())){
            for (Book book : Books) {
                if (myBook.getIsbn().equals(book.getIsbn())) {
                    book.changeStatus();
                    break;
                }
            }
        }
        else
            System.out.println("This Book Is Not Exist!");
    }

    public boolean doesBookExist(String isbn){
        boolean flag = false;
        for(Book value : this.Books){
            if(isbn.equals(value.getIsbn())){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean doesBookExist(String name, String author){
        boolean flag = false;
        for(Book value : this.Books){
            if(name.equals(value.getName()) && author.equals(value.getAuthor())){
                flag = true;
                break;
            }
        }
        return flag;
    }
    public void increaseBook(Book ibook){
        int number = numberOfBooks.get(ibook.getName()) + 1;
        numberOfBooks.put(ibook.getName(), number);
    }

    public void decreaseBook(Book ibook){
        int number = numberOfBooks.get(ibook.getName()) - 1;
        if(number >= 0)
            numberOfBooks.put(ibook.getName(), number);
    }

    //User Related Functions

    public void addUser(String username, String password){
        User myUser = new User();
        if(!this.doesUserExist(username, password)){
            myUser.setUsername(username);
            myUser.setPassword(password);
            this.Users.add(myUser);
        }
    }

    public void removeUser(String username, String password){
        if(this.doesUserExist(username, password)){
            this.Users.remove(this.searchUser(username, password));
        }
    }

    public User searchUser(String username, String password){
        User myTargetUser = new User();
        if(this.doesUserExist(username, password)){
            for(User value : this.Users){
                if(username.equals(value.getUsername()) && password.equals(value.getPassword())){
                    myTargetUser = value;
                    break;
                }
            }
        }
        return myTargetUser;
    }

    public void updateUser(User myuser){
        if(this.doesUserExist(myuser.getUsername(), myuser.getPassword())){
            myuser.changePassword();
        }
        else
            System.out.println("This User Is Not Exist!");
    }

    public boolean doesUserExist(String username, String password){
        boolean flag = false;
        for(User value : this.Users){
            if(username.equals(value.getUsername()) && password.equals(value.getPassword())){
                flag = true;
                break;
            }
        }
        return flag;
    }

    //Librarian Related Functions

    public void addLibrarian(String username, String password){
        if(!this.doesLibrarianExist(username, password)){
            Librarian myLibrarian = new Librarian();
            myLibrarian.setUsername(username);
            myLibrarian.setPassword(password);
            this.Librarians.add(myLibrarian);
        }
    }

    public void removeLibrarian(String username, String password){
        if(this.doesLibrarianExist(username, password)){
            this.Librarians.remove(this.searchLibrarian(username, password));
        }
    }

    public Librarian searchLibrarian(String username, String password){
        Librarian myTargetLibrarian = new Librarian();
        if(this.doesLibrarianExist(username, password)){
            for(Librarian value : this.Librarians){
                if(username.equals(value.getUsername()) && password.equals(value.getPassword())){
                    myTargetLibrarian = value;
                    break;
                }
            }
        }
        return myTargetLibrarian;
    }

    public void updateLibrarian(Librarian myLibrarian){
        if(doesLibrarianExist(myLibrarian.getUsername(), myLibrarian.getPassword())){
            myLibrarian.changePassword();
        }
        else
            System.out.println("This Librarian IS Not Exist!");
    }

    public boolean doesLibrarianExist(String username, String password){
        boolean flag = false;
        for(Librarian value : this.Librarians){
            if(username.equals(value.getUsername()) && password.equals(value.getPassword())){
                flag = true;
                break;
            }
        }
        return flag;
    }
}