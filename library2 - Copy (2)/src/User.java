import java.util.Scanner;

public class User {

    String userName;
    String passWord;

    Book borrowedBooks[] = new Book[3];
    public int booksCount = 0;

    Scanner input = new Scanner(System.in);

    public User()
    {
        System.out.println("Enter username:");

        this.userName = input.nextLine();

        System.out.println("Enter password:");

        this.passWord = input.nextLine();
    }
}
