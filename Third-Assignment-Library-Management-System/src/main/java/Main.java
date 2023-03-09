import java.util.Scanner;

public class Main {



    public void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("**********************************************************************");
        System.out.println("		                 WELLCOME TO THE LIBRARY			 ");
        System.out.println("**********************************************************************");

        Library bookCapacity = new Library();

        bookCapacity.askingForBookCapacity();

        users usersCapacity = new users();

        usersCapacity.askingForUsersCapacity();

        Library ob = new Library();

        users obUser = new users();

        int choice;

        int searchChoice;

        do {

            dispMenu();

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    Book b = new Book();
                    ob.addBook(b);
                    break;


                case 2:
                    ob.changeBookQty();
                    break;


                case 3:

                    System.out.println(" press 1 to Search with Book ISNB.");

                    System.out.println(" Press 2 to Search with Book's Author Name.");

                    searchChoice = input.nextInt();

                    if(searchChoice==1){

                        ob.searchByISBN();
                    }

                    else {

                        ob.searchByAuthorName();
                    }


                case 4:
                    ob.showAllBooks();
                    break;


                case 5:
                    User s = new User();
                    obUser. addUsers(s);
                    break;


                case 6:
                    obUser.showAllUsers();
                    break;


                case 7:
                    obUser.rentBook(ob);
                    break;


                case 8:
                    obUser.returnBook(ob);
                    break;


                default:

                    System.out.println("Thanks for Choosing Us !");
            }

        }


        while (choice != 0);

    }


    static void dispMenu(){

        // Displaying menu
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 2 to Change Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register user.");
        System.out.println("Press 6 to Show All Registered users.");
        System.out.println("Press 7 to Borrow or Remove Book. ");
        System.out.println("Press 8 to Return Book");
        System.out.println("Press 0 to Exit");
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }

}
