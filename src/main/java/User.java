import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class User  extends Library{
    //User should have a list of books
    //User should have a username and a password
    private String username;
    private String password;


    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void rentBook(String name){

        int found = 0;
        for (Book book : BookList)
        {
            if (book.getName().equals(name))
            {
                if (found == 0)
                {
                    found = 1;
                }
                if (!book.isBorrowed())
                {
                    book.borrowed=true;
                    found = 2;
                    break;
                }
            }
        }
        if (found == 0) {
            System.out.println("Sorry, this book is not in our catalog.");
        } else if (found == 1) {
            System.out.println("Sorry, this book is already borrowed.");
        } else if (found == 2) {
            System.out.println("You successfully borrowed " + name);
        }



    }

    public boolean returnBook(){ //Returns a book back to the catalog
            for(Book book : BookList) {
                if(book.isBorrowed()) {
                    book.setToReturned();
                    return true; //Book has been returned successfully
                }
                else {
                    continue;
                }
            }
            System.out.println("Cannot return book at this time, sorry!");
            return false; //Book has failed to be returned
        }


    }

}
