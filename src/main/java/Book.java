import java.util.Scanner;

public class Book {

    public int isbn;
    public String bookName;
    public String authorName;
    public String publishYear;
    public int bookQty;
    public int bookQtyCopy;

    Scanner input = new Scanner(System.in);

    public Book(){

        System.out.println("Enter ISBN of Book:");
        this.isbn = input.nextInt();
        input.nextLine();

        System.out.println("Enter Book Name:");
        this.bookName = input.nextLine();

        System.out.println("Enter Author Name:");
        this.authorName = input.nextLine();

        System.out.println("Enter publish year:");
        this.publishYear = input.nextLine();

        System.out.println("Enter Quantity of Books:");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;

    }

}