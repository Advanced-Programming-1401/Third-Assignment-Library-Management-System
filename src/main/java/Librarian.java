import java.util.Scanner;

public class Librarian {

    String libName;
    String libPass;
    Scanner input = new Scanner(System.in);

    public Librarian()
    {
        System.out.println("Enter librarian name:");

        this.libName = input.nextLine();

        System.out.println("Enter librarian password:");

        this.libPass = input.nextLine();
    }

}