import java.util.ArrayList;
import java.util.Scanner;

public class User {
    //User should have a list of books
    //User should have a username and a password

    // Attributes
    private String username;
    private String password;
    private ArrayList<Book>rentBooks = new ArrayList<Book>();

    // Getter & Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Public Functions
    public void rentBook(Library myLibrary, Book myBook){

        if(myLibrary.doesBookExist(myBook.getIsbn())){
            if(myBook.isAvaliable()){
                this.rentBooks.add(myBook);
                myLibrary.updateBook(myBook);
                myLibrary.decreaseBook(myBook);
            }
            else
                System.out.println("This Book Is Not Available!");
        }else
            System.out.println("This Book Is Not Exist!");

    }

    public void returnBook(Library myLibrary, Book myBook){
        for(int  i = 0; i < rentBooks.size(); i++){
            if(myBook.getIsbn().equals(rentBooks.get(i).getIsbn())){
                rentBooks.remove(i);
                break;
            }
        }
        myLibrary.updateBook(myBook);
        myLibrary.increaseBook(myBook);
    }

    public void changePassword(){
        System.out.println("Enter Your Current Password: ");
        Scanner myScanner = new Scanner(System.in);
        String Pass = myScanner.nextLine();
        if(Pass.equals(this.getPassword())){
            System.out.println("Enter Your newest Password: ");
            String newPass = myScanner.nextLine();
            this.password = newPass;
        }
        else{
            System.out.println("Wrong Password! " + "\n" + "Do You Want Try Again?!(Yes/No) : ");
            String ansewr = myScanner.nextLine();
            if(ansewr.equals("Yes") || ansewr.equals("yes"))
                changePassword();
        }
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rentBooks=" + rentBooks +
                '}';
    }
}