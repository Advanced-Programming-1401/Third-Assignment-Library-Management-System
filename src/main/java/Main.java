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

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("Maze Runner", "James Dasher", 2009, 13);
        library.addBook("Hunger Games", "Suzanne Collins", 2008, 1043521);
        library.addBook("Elon Musk", "Ashlee Vance", 2017,97814 );
        library.addBook("It Ends With Us", "Colleen Hoover", 2016, 10);
        library.addLibrarian("Cole_Sp","LibraryGZ2004");

        runMenu(library);
    }

    public static void runMenu(Library library){

        Scanner input = new Scanner(System.in);
        System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*((Welcome! To The Online Library))*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
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

    public static void MenuForUser(Library library){
        System.out.print("Username  =  "); username = input.next();
         System.out.print("Password =  "); password = input.next();
        User user = new User(username, password);
        if(library.doesUserExist(username)) {System.out.println("Hi There you had an account");}
        else{ System.out.println("Hi there --> new user"); library.addUser(username,password);}
        System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_WELCOME! Select the Item that you want*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
        System.out.println("--------------|-----------|-------------|----------------|------------------|-------");
        System.out.println("1_search book|2_Rent book|3_Return book |4_show book list|5-show Borrow book|6-EXIT ");
        System.out.println("--------------|-----------|-------------|----------------|------------------|-------");
        int option = input.nextInt();
        switch(option){
            case 1:
                //Search book
                System.out.println(library.searchBook());
                System.out.print("If you want to back to menu press '1'  = ");
                int select = input.nextInt();
                if(select == 1) {MenuForUser(library); break;}

            case 2:
                //Rent book
                if(library.doesBookExist()){
                    System.out.println("which book do you want to rent please write the information once again?");
                    System.out.println("NAME = ");String name = input.next();
                    System.out.println("AUTHOR = ");String author = input.next();
                    System.out.println("YEAR OF PUBLISH = ");int YearPublish = input.nextInt();
                    System.out.println("ISBN = ");int ISBN = input.nextInt();

                    user.rentBook(name,author,YearPublish,ISBN);
                }
                else System.out.println("sorry this book does not exist");

                System.out.print("If you want to back to menu press '1'  = ");
                 int selecte= input.nextInt();
                if(selecte == 1) {MenuForUser(library); break;}

            case 3:
                //Return book
                System.out.println("NAME = ");String name = input.next();
                System.out.println("AUTHOR = ");String author = input.next();
                System.out.println("YEAR OF PUBLISH = ");int YearPublish = input.nextInt();
                System.out.println("ISBN = ");int ISBN = input.nextInt();
                user.returnBook(name,author,YearPublish,ISBN);
                System.out.println("return successfully");
                System.out.print("If you want to back to menu press '1'  = ");
                  select= input.nextInt();
                if(select == 1) {MenuForUser(library); break;}

            case 4:
                //show list books
                System.out.println(library.BookList);
                System.out.print("If you want to back to menu press '1'  = ");
                select= input.nextInt();
                if(select == 1) {MenuForUser(library); break;}


            case 5:
                //show list borrow books
                System.out.println(user.rentBooks);
                System.out.print("If you want to back to menu press '1'  = ");
                select= input.nextInt();
                if(select == 1) {MenuForUser(library); break;}

            case 6:
                //EXIT part
                runMenu(library);
        }

    }
    public static void MenuForLibrarain(Library library){
        System.out.print("Username  =  ");username = input.next();
        System.out.print("Password =  ");password = input.next();
        Librarian librarian = new Librarian(username , password);
        if(library.doesLibrarianExist(username)) {System.out.println("Hi Ther you had an account");}
        else{ System.out.println("new librarian"); library.addLibrarian(username,password);}
        System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_WELCOME! Select the Item that you want*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
        System.out.println("--------------------------------|------------------|-------------------|----------------|-------------------|------------------|------------------");
        System.out.println("1_Search of book                |2_Add Book        |3_Remove book      |4_Update book   |5_Search librarian |6_Add Librarian   |7_Remove Librarian");
        System.out.println("--------------------------------|------------------|-------------------|----------------|-------------------|------------------|------------------");
        System.out.println("8_Update Librarian              |9_Search users    |10_add User        |11_Remove User  |12_Update User     |13_show book list |14_show user list ");
        System.out.println("--------------------------------|------------------|-------------------|----------------|-------------------|------------------|------------------");
        System.out.println("15_show librarian list          |16_Exit ");
        int option = input.nextInt();
        switch(option){
            case 1:
                //Search of book
                //Book.listBook();
                library.searchBook();
                System.out.print("If you want to back to menu press '1'  = ");
                int select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}

            case 2:
                //ADD book
                System.out.println("If you want to add book plz write the name of the book, and it's Author and it's Year of publish and it's ISBN");
                System.out.print("NAME = ");String name = input.next();
                System.out.print("AUTHOR = ");String author = input.next();
                System.out.print("YEAR OF PUBLISH = ");int YearPublish = input.nextInt();
                System.out.print("ISBN = ");int ISBN = input.nextInt();
                Book book = new Book(name,author,YearPublish,ISBN);
                System.out.print("Name the book again = ");
                if(library.doesBookExist()) System.out.println("we have this book in library");
                else library.addBook(book.getName(),book.getAuthor(),book.getYearPublish(),book.getISBN());System.out.println("!!ADD!!");
                System.out.print("If you want to back to menu press '1'  = ");
                 select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}


            case 3:
                //Remove book
                System.out.println("If you want to remove book plz write the name of the book, and it's Author and it's Year of publish and it's ISBN");
                System.out.print("NAME = "); name = input.next();
                System.out.print("AUTHOR = "); author = input.next();
                System.out.print("YEAR OF PUBLISH = "); YearPublish = input.nextInt();
                System.out.print("ISBN = "); ISBN = input.nextInt();
                System.out.print("Write the name of the book again = ");
                //String yearPublish = String.valueOf(YearPublish);
               // String isbn = String.valueOf(ISBN);
                if(library.doesBookExist()){ library.removeBook(name,author,YearPublish,ISBN);System.out.println("!!REMOVE!!");}
                else {System.out.println("THis book does not EXIST!!");}
                System.out.print("If you want to back to menu press '1'  = ");
                select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}

            case 4:
                //Update book
                System.out.println("If you want to update the book plz write the name of the book, and it's Author and it's Year of publish and it's ISBN");
                System.out.print("NAME = "); name = input.next();
                System.out.print("AUTHOR = "); author = input.next();
                System.out.print("YEAR OF PUBLISH = "); YearPublish = input.nextInt();
                System.out.print("ISBN = "); ISBN = input.nextInt();
                library.updateBook(name,author,YearPublish,ISBN);
                System.out.print("If you want to back to menu press '1'  = ");
                select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}

            case 5:
                //Search librarian
                library.searchLibrarian();
                System.out.print("If you want to back to menu press '1'  = ");
                select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}

            case 6:
                //Add Librarian
                System.out.println("If you want to add librarian plz write the username and password");
                System.out.print("Username = "); String username = input.next();
                System.out.print("Password = "); String password = input.next();
                Librarian librarian1 = new Librarian(username , password);
                //System.out.println("Name the book again = ");
                if(library.doesLibrarianExist(username)) System.out.println("we have this Username");
                else library.addLibrarian(librarian1.getUsername(),librarian1.getPassword()); System.out.println("!!!!!!ADD!!!!!!");
                System.out.print("If you want to back to menu press '1'  = ");
                select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}

            case 7:
                //Remove Librarian
                System.out.println("If you want to remove librarian plz write his/her username and password");
                System.out.print("Username = ");  username = input.next();
                System.out.print("Password = ");  password = input.next();
                //System.out.println("Name the book again = ");
                if(library.doesLibrarianExist(username)) library.removeLibrarian(username , password);
                else System.out.println("No account with this username");
                System.out.print("If you want to back to menu press '1'  = ");
                select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}

            case 8:
                //Update Librarian
                System.out.println("If you want to update the librarian plz write username and password");
                System.out.print("Username = ");  username = input.next();
                System.out.print("Password = ");  password = input.next();
                library.updateLibrarian(username , password);
                System.out.print("If you want to back to menu press '1'  = ");
                select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}

            case 9:
                //Search User
                library.searchUser();
                System.out.print("If you want to back to menu press '1'  = ");
                select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}

            case 10:
                //Add User
                System.out.println("If you want to add user plz write the username and password");
                System.out.print("Username = "); username = input.next();
                System.out.print("Password = "); password = input.next();
                User user = new User(username , password);
                if(library.doesUserExist(username)) System.out.println("we have this Username");
                else library.addUser(user.getUsername(),user.getPassword()); System.out.println("!!!!!!ADD!!!!!!");
                System.out.print("If you want to back to menu press '1'  = ");
                select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}

            case 11:
                //Remove User
                System.out.println("If you want to remove User plz write his/her username and password");
                System.out.print("Username = ");  username = input.next();
                System.out.print("Password = ");  password = input.next();
                //System.out.println("Write the name of the book again = ");
                if(library.doesUserExist(username)) library.removeUser(username , password);
                else System.out.println("No account with this username");
                System.out.print("If you want to back to menu press '1'  = ");
                select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}

            case 12:
                //Update User
                System.out.println("If you want to update the user plz write username and password");
                System.out.print("Username = ");  username = input.next();
                System.out.print("Password = ");  password = input.next();
                library.updateUser(username , password);
                System.out.print("If you want to back to menu press '1'  = ");
                select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}

            case 13:
                //Book list
                System.out.print(library.BookList);
                System.out.print("If you want to back to menu press '1'  = ");
                select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}

            case 14:
                //user list
                System.out.print(library.UserList);
                System.out.print("If you want to back to menu press '1'  = ");
                select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}

            case 15:
                //librarian list
                System.out.print(library.LibrarianList);
                System.out.print("If you want to back to menu press '1'  = ");
                select = input.nextInt();
                if(select == 1) {MenuForLibrarain(library); break;}

        }

    }

}
