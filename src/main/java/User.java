import java.util.ArrayList;

public class User {
//    private ArrayList<String> book_list;
    private final String user_name;
    private final String user_password;
    private ArrayList<Book> borrowed_books;
    //User should have a list of books
    //User should have a username and a password
    public User(String user_name, String user_password){

        this.user_name = user_name;
        this.user_password = user_password;
        borrowed_books = new ArrayList<Book>();
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public ArrayList<Book> getBorrowed_books() {
        return borrowed_books;
    }
    public void addToBorrowedBooks(Book borrowed_book){
        borrowed_books.add(borrowed_book);
    }
    public void removeFromBorrowedBooks(String returned_book_name){
        for (int i = 0; i < borrowed_books.size(); i++){
            if (borrowed_books.get(i).getBook_name().equals(returned_book_name)){

                borrowed_books.remove(i);
            }
        }
    }
    public void searchBorrowedBooks(){

        System.out.println("List of borrowed books:\n");
        if (borrowed_books.size() == 0){

            System.out.println("List is empty!");
        }
        else{

            for (int i = 0; i < borrowed_books.size(); i++){

                System.out.print(borrowed_books.get(i).getBook_name());
                if (i != borrowed_books.size() - 1){
                    System.out.print(", ");
                }
            }
        }
        System.out.print("\n\n");
    }
}
