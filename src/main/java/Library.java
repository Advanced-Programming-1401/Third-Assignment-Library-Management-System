import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Library {
    /*
    * The library should have a list of books.
    * The library should have a map of books ISBNs which is linked to the amount of book
    -> (for example: harry potter -> 4 means there are currently 4 harry potter books)
    * The library should have a list of users and a list of librarians.
     */

    //book related functions
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Librarian> librarians = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    HashMap<String , Integer> numberOfBooks = new HashMap<String , Integer>();

    public void addBook(Book ketab){
        if (!doesBookExist(ketab))
        {
            books.add(ketab);
            increaseBook(ketab);
        }
        else
        {
            System.out.println("We have already had this book!");
        }
    }

    public void removeBook(Book ketab){
        if (doesBookExist(ketab))
        {
            for (int i=0; i<books.size(); i++)
            {
                if (ketab.getISBN().equals(books.get(i).getISBN()))
                {
                    books.remove(i);
                    decreaseBook(ketab);
                    break;
                }
            }
        }
        else
        {
            System.out.println("This book does not exist!");
        }
    }

    public String searchBook(Book ketab){
        //TODO
        for (int i=0; i<books.size(); i++)
        {
            if (ketab.getName().equals(books.get(i).getName()) && ketab.getAuthor().equals(books.get(i).getAuthor()) && ketab.getAvailable()==true)
            {
                return ketab.getISBN();
            }
        }
        return "";
    }

    public void updateBook(Book ketab){
        //TODO
        if (doesBookExist(ketab))
        {
            for (int i=0; i<books.size(); i++)
            {
                if (ketab.getISBN().equals(books.get(i).getISBN()))
                {
                    books.get(i).changeAvailableStatus();
                    break;
                }
            }
        }
        else
        {
            System.out.println("This book does not exist!");
        }
    }

    public Boolean doesBookExist(Book ketab){
        //TODO
        Boolean existence = false;
        for (int i=0; i<books.size(); i++)
        {
            if (ketab.getISBN().equals(books.get(i).getISBN()))
            {
                existence = true;
                break;
            }
        }
        return existence;
    }

    public void increaseBook(Book ketab){
        //TODO
        int number = numberOfBooks.get(ketab.getName()) + 1;
        numberOfBooks.put(ketab.getName(), number);
    }

    public void decreaseBook(Book ketab){
        //TODO
        int number = numberOfBooks.get(ketab.getName()) - 1;
        numberOfBooks.put(ketab.getName(), number);
    }

    //user related functions

    public void addUser(User karbar){
        //TODO
        if (!doesUserExist(karbar))
        {
            users.add(karbar);
        }
    }

    public void removeUser(User karbar){
        //TODO
        if (doesUserExist(karbar))
        {
            for (int i=0; i<users.size(); i++)
            {
                if (karbar.getUsername().equals(users.get(i).getUsername()))
                {
                    users.remove(i);
                    break;
                }
            }
        }
    }

    public void searchUser(User karbar){
        //TODO
        if (doesUserExist(karbar))
        {
            System.out.println(karbar);
        }
        else
        {
            System.out.println("This user does not exist!");
        }
    }

    public void updateUser(User karbar){
        //TODO
        Scanner input = new Scanner(System.in);
        if (doesUserExist(karbar))
        {
            karbar.changePassword();
        }
        else
        {
            System.out.println("This user does not exist!");
        }
    }

    public Boolean doesUserExist(User karbar){
        //TODO
        Boolean existence = false;
        for (int i=0; i<users.size(); i++)
        {
            if (karbar.getUsername().equals(users.get(i).getUsername()))
            {
                existence = true;
                break;
            }
        }
        return existence;
    }

    public Boolean userPasswordCheck(User karbar)
    {
        Boolean passCheck = false;
        for (int i=0; i<users.size(); i++)
        {
            if (karbar.getUsername().equals(users.get(i).getUsername()))
            {
                if (karbar.getPassword().equals(users.get(i).getPassword()))
                {
                    passCheck = true;
                    break;
                }
                else
                {
                    passCheck = false;
                    break;
                }
            }
        }
        return passCheck;
    }

    //librarian related functions

    public void addLibrarian(Librarian ketabdar){
        //TODO
        if (!doesLibrarianExist(ketabdar))
        {
            librarians.add(ketabdar);
        }

    }

    public void removeLibrarian(Librarian ketabdar){
        //TODO
        if (doesLibrarianExist(ketabdar))
        {
            for (int i=0; i<librarians.size(); i++)
            {
                if (ketabdar.getUsername().equals(librarians.get(i).getUsername()))
                {
                    librarians.remove(i);
                    break;
                }
            }
        }
    }

    public void searchLibrarian(Librarian ketabdar){
        //TODO
        if (doesLibrarianExist(ketabdar))
        {
            System.out.println(ketabdar);
        }
        else
        {
            System.out.println("This librarian does not exist!");
        }
    }

    public void updateLibrarian(Librarian ketabdar){
        //TODO
        if (doesLibrarianExist(ketabdar))
        {
            ketabdar.changePassword();
        }
        else
        {
            System.out.println("This librarian does not exist!");
        }
    }

    public Boolean doesLibrarianExist(Librarian ketabdar){
        //TODO
        Boolean existence = false;
        for (int i=0; i<librarians.size(); i++)
        {
            if (ketabdar.getUsername().equals(librarians.get(i).getUsername()))
            {
                existence = true;
                break;
            }
        }
        return existence;
    }
    public Boolean librarianPasswordCheck(Librarian ketabdar)
    {
        Boolean passCheck = false;
        for (int i=0; i<librarians.size(); i++)
        {
            if (ketabdar.getUsername().equals(librarians.get(i).getUsername()))
            {
                if (ketabdar.getPassword().equals(librarians.get(i).getPassword()))
                {
                    passCheck = true;
                    break;
                }
                else
                {
                    passCheck = false;
                    break;
                }
            }
        }
        return passCheck;
    }

}
