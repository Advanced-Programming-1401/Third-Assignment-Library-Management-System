import java.util.ArrayList;
import java.util.HashMap;
public class Library {

    private ArrayList<Book> books;
    private HashMap<Integer, Integer> map;   //map ISBNs along with it's amount
    private ArrayList<User> users;
    private ArrayList<Librarian> librarians;
    private Librarian default_librarian;
    public Library(){

        books = new ArrayList<Book>();
        map = new HashMap<Integer, Integer>();
        users = new ArrayList<User>();
        librarians = new ArrayList<Librarian>();
        default_librarian = new Librarian("mmd", "2385");
        librarians.add(default_librarian);
    }
    /*
    * The library should have a list of books.
    * The library should have a map of books ISBNs which is linked to the amount of book
    -> (for example: harry potter -> 4 means there are currently 4 harry potter books)
    * The library should have a list of users and a list of librarians.
     */

    //book related functions

    public void addBook(String book_name, String book_author, int publish_year, int ISBN){

        Book new_book = new Book(book_name, book_author, publish_year, ISBN);
        books.add(new_book);
        increaseBook(ISBN);
    }

    public void removeBook(int ISBN){

        for (int i = 0; i < books.size(); i++){

            if (books.get(i).getISBN() == ISBN){

                books.remove(i);
                map.remove(ISBN);
            }
        }
    }

    public void searchBook(){

        System.out.println("List Of Books: ");
        for (int i = 0; i < books.size(); i++){

            System.out.println("Name: " + books.get(i).getBook_name() + ", "  + " amount: " + map.get(books.get(i).getISBN()) + ", "  + " author: " + books.get(i).getBook_author() + ", "  + " publish year: " + books.get(i).getPublish_year() + "\n");
        }
    }

    public void updateBook(){
        //TODO
    }

    public boolean doesBookExist(int ISBN){

        if (map.containsKey(ISBN)) {

            if (map.get(ISBN) != 0) {

                return true;
            }
        }
        return false;
    }

    public void increaseBook(int ISBN){

        if (!map.containsKey(ISBN)){

            map.put(ISBN, 1);
        }
        else
        {
            map.replace(ISBN, map.get(ISBN));
        }
    }

    public void decreaseBook(int ISBN){

        map.replace(ISBN, map.get(ISBN) - 1);
    }

    //user related functions

    public void addUser(String user_name, String password){

        User new_user = new User(user_name, password);
        users.add(new_user);
    }
    public void addUser(User new_user){


        users.add(new_user);
    }

    public void removeUser(String user_name){

        for (int i = 0; i < users.size(); i++){

            if (users.get(i).getUser_name().equals(user_name)){

                users.remove(i);
            }
        }
    }

    public void searchUser(){

        System.out.print("A list of users: ");
        for (int i = 0; i < users.size(); i++){

            System.out.print(users.get(i).getUser_name() + "  ");
        }
        System.out.print("\n\n");
    }

    public void updateUser(){
        //TODO
    }

    public boolean doesUserExist(String user_name){

        for (int i = 0; i < users.size(); i++){

            if (users.get(i).getUser_name().equals(user_name)){

                return true;
            }
        }
        return false;
    }
    public boolean checkUserPassword(String user_name, String password){

        for (int i = 0; i < users.size(); i++){

            if (users.get(i).getUser_name().equals(user_name)){
                if (users.get(i).getUser_password().equals(password)){

                    return true;
                }
            }
        }
        return false;
    }

    //librarian related functions

    public void addLibrarian(String user_name, String password){

        Librarian new_librarian = new Librarian(user_name, password);
        librarians.add(new_librarian);
    }

    public void removeLibrarian(String user_name){

        for (int i = 0; i < librarians.size(); i++){

            if (librarians.get(i).getUser_name().equals(user_name)){

                librarians.remove(i);
            }
        }
    }

    public void searchLibrarian(){

        System.out.println("List Of Librarians: " + librarians);
    }

    public void updateLibrarian(){
        //TODO
    }

    public boolean doesLibrarianExist(String user_name){

        for (int i = 0; i < librarians.size(); i++){

            if (librarians.get(i).getUser_name().equals(user_name)){

                return true;
            }
        }
        return false;
    }
    public boolean checkLibrarianPassword(String user_name, String password){

        for (int i = 0; i < librarians.size(); i++){

            if (librarians.get(i).getUser_name().equals(user_name)){
                if (librarians.get(i).getPassword().equals(password)){

                    return true;
                }
            }
        }
        return false;
    }
}
