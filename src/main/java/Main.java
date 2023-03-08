import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    /*
    * make a functional library app using oop
    * run the main program in Main.java and code the oop part in other classes
    * don't forget to add at least 1 librarian to the library to make it functionable.
    * *  *** don't limit yourself to our template ***
     */
    static String username; static String password; static String librarian;
    static Scanner input = new Scanner(System.in);

         public static void listBook(){
             ArrayList<Book> Booklist = new ArrayList<>();
             Book book1 = new Book("Maze Runner","James Dasher",13,2009);
             Book book2 = new Book("Hunger Games" , "Suzanne Collins" ,10,2013);
             Book book3 = new Book("Elon Musk","Ashlee Vance",8,2018);
             Book book4 = new Book("It Ends With Us", "Colleen Hoover" ,4,2018);
             Booklist.add(book1);
             Booklist.add(book2);
             Booklist.add(book3);
             Booklist.add(book4);
             System.out.println("book1 = " + book1);
             System.out.println("book2 = "+book2);
             System.out.println("book3 = "+book3);
             System.out.println("book4 = "+book4);
         }


    public static void main(String[] args) {
        Library library = new Library();
        runMenu(library);
      /*  int select = input.nextInt();
        if(select == 1) MenuForLibrarain();
        else if (select ==2) MenuForUser();
        else System.out.println("Exit Successfully");*/
    }

    public static void runMenu(Library library){

        Scanner input = new Scanner(System.in);
        System.out.println("/###########/**((Welcome! To The Online Library))**/###########/");
        System.out.println("-----Choose your access By choosing number-----");
        System.out.println("1) Librarian     OR     2) User     OR     3)Exit");
        int select = input.nextInt();
        switch (select){
            case 1:
                MenuForLibrarain(library);
            case 2:
                MenuForUser(library);
            case 3:
                System.out.println("EXIT Successfully");

        }

    }
  /*  public static void ThisIsUser(){
        User user = new User();
          user.getUsername();

        return;
    }
    public static void ThisIsLibrarian(){
        Librarian librarian = new Librarian();
        librarian.getUsername();
        librarian.getPassword();



    }*/
    public static void MenuForUser(Library library){
        System.out.print("Username  =  "); username = input.next();
         System.out.print("Password =  "); password = input.next();
        User user = new User(username, password);
        if(library.doesUserExist(username)) {System.out.println("Hi" +username+ "you had an account");}
        else{ System.out.println("new user"); library.addUser(username,password);}
        System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_WELCOME "+ username +" Select the Item that you want*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
        System.out.println("--------------|-----------|-------------|-------");
        System.out.println("1_List of book|2_Rent book|3_Return book|4_Exit ");
        System.out.println("--------------|-----------|-------------|-------");
        int option = input.nextInt();
        switch(option){
            case 1:
                listBook();
                library.searchBook();
                System.out.print("If you want to back to menu press '1'  = ");
                int select = input.nextInt();
                if(select == 1) {MenuForUser(library); break;}

            case 2:
                if(library.doesBookExist()){
                    System.out.println("which book do you want to rent please write it once again?");
                    String name = input.next();
                    user.rentBook(name);
                }
                else System.out.println("sorry this book does not exist");

                System.out.print("If you want to back to menu press '1'  = ");
                 select= input.nextInt();
                if(select == 1) {MenuForUser(library); break;}

            case 3:
                if(user.returnBook()){System.out.println("return successfully");}
                System.out.print("If you want to back to menu press '1'  = ");
                select= input.nextInt();
                if(select == 1) {MenuForUser(library); break;}
        }

    }
    public static void MenuForLibrarain(Library library){
        System.out.print("Username  =  ");username = input.next();
        System.out.print("Password =  ");password = input.next();
        Librarian librarian = new Librarian(username , password);
        if(library.doesLibrarianExist(username)) {System.out.println("Hi" +librarian+ "you had an account");}
        else{ System.out.println("new librarian"); library.addLibrarian(username,password);}
        System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_WELCOME "+ librarian +" Select the Item that you want*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
        System.out.println("--------------|------------------|-------------------|----------------|--------------|------------------|--------------");
        System.out.println("1_List of book|2_Remove User     |3_Update User      |4_Search book   |5_Search users|6_search librarian|7_update Book ");
        System.out.println("--------------|------------------|-------------------|----------------|--------------|------------------|--------------");
        System.out.println("8_add User    |9_Remove Librarian|10_Update Librarian|11_add Librarian|12_Remove book|13_add Book       |14_Exit       ");
        System.out.println("--------------|------------------|-------------------|----------------|--------------|------------------|--------------");
        int option = input.nextInt();
        switch(option){
            case 1:
                listBook();
                library.searchBook();
                System.out.print("If you want to back to menu press '1'  = ");
                int select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}
            case 2:






        }

    }
}
