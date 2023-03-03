import java.util.ArrayList;
import java.util.HashMap;
public class Library {

    private ArrayList<Book> books;           //list of our books
    private HashMap<Integer, Integer> map;   //map ISBNs along with it's amount
    private ArrayList<User> users;           //list of users
    private ArrayList<Librarian> librarians; //list of librarians
    private Librarian default_librarian;
    public Library() {

        books = new ArrayList<Book>();
        map = new HashMap<Integer, Integer>();
        users = new ArrayList<User>();
        librarians = new ArrayList<Librarian>();
        default_librarian = new Librarian("Mobin", "Elite20");
        librarians.add(default_librarian);
    }

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

    public void updateBook(String previous_book_name,String new_book_name, String new_author, int new_publish_year){
        //because ISBN of a book is constant we don't touch it and there is also need to make any changes in map
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).getBook_name().equals(previous_book_name)){

                Book updated_book = new Book(new_book_name, new_author, new_publish_year, books.get(i).getISBN());
                books.set(i, updated_book);
            }
        }

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
            map.replace(ISBN, map.get(ISBN) + 1);
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

            System.out.print(users.get(i).getUser_name());
            if (i != (users.size() - 1)){

                System.out.print(",  ");
            }
        }
        System.out.print("\n\n");
    }
    public void updateUser(String previous_user_name, String new_user_name, String new_password){

        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getUser_name().equals(previous_user_name)){

                User updated_user = new User(new_user_name, new_password);
                users.set(i, updated_user);
            }
        }
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

        System.out.print("List of librarians: ");
        for (int i = 0; i < librarians.size(); i++){

            System.out.print(librarians.get(i).getUser_name());
            if (i != (librarians.size() - 1)){

                System.out.print(",  ");
            }
        }
        System.out.print("\n");
    }
    public void updateLibrarian(String previous_user_name, String new_user_name, String new_password){

        for (int i = 0; i < librarians.size(); i++){
            if (librarians.get(i).getUser_name().equals(previous_user_name)){

                Librarian updated_librarian = new Librarian(new_user_name, new_password);
                librarians.set(i, updated_librarian);
            }
        }
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
