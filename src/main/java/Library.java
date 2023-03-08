

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;

public class Library implements ActionListener  {

    static ArrayList<Book> books = new ArrayList<Book>();
    static ArrayList<User> rented = new ArrayList<User>();
    static ArrayList<Librarian> librarian = new ArrayList<Librarian>();


    public static void addBook () {
            books.add(Book.book1);
            books.add(Book.book2);
            books.add(Book.book3);
            books.add(Book.book4);
            books.add(Book.book5);
            Scanner newBook = new Scanner(System.in);
            String name = newBook.next();
            int ISBN = newBook.nextInt();
            String author = newBook.next();
            int year = newBook.nextInt();
            int counter = newBook.nextInt();
         Book book6 = new Book(name,ISBN,author,year,counter);
         books.add(new Book(book6));
        }

        public static void removeBook () {
            Scanner scan = new Scanner(System.in);
            String scan1 = scan.nextLine();
            for( int i = 0 ; i < books.size() ; i++){
                if(scan1.equals(books.get(i))){
                    books.remove(books.get(i));
                }
             }
        }

        public static void searchBook () {
            Scanner scan = new Scanner(System.in);
            String scan1 = scan.nextLine();
            for(int i = 0 ; i < books.size() ; i++){
                if(scan1.equals(books.get(i))){
                    System.out.println("we have");
                }else{
                    System.out.println("SORRY!");
                }
            }
        }
        public static void doesBookExist () {
            Scanner scan = new Scanner(System.in);
            String scan1 = scan.nextLine();
            for(int i = 0 ; i < books.size() ; i++){
                if(scan1.equals(books.get(i))){
                    System.out.println("the book does exist");
                }else{
                    System.out.println("SORRY!");
                }
            }
        }
        public static void increaseBook () {
            Scanner scan = new Scanner(System.in);
            String scan1 = scan.nextLine();
            int scan2 = scan.nextInt();
            for(int i = 0 ; i < books.size() ; i++){
                if(scan1.equals(books.get(i))) {
                    books.get(i).counter = books.get(i).counter + scan2;
                }
            }
        }

        public static void decreaseBook () {
            Scanner scan = new Scanner(System.in);
            String scan1 = scan.nextLine();
            int scan2 = scan.nextInt();
            for(int i = 0 ; i < books.size() ; i++){
                if(scan1.equals(books.get(i))) {
                    books.get(i).counter = books.get(i).counter - scan2;
                }
            }
        }

        //user related functions

        public static void addUser () {
            rented.add(User.user1);
            rented.add(User.user2);
            rented.add(User.user3);
            Scanner scan = new  Scanner(System.in);
            String scan1 = scan.nextLine();
            String scan2 = scan.nextLine();
            User user4 = new User(scan1,scan2,null);
            rented.add(new User(user4));
        }

        public static void removeUser () {
            Scanner scan = new Scanner(System.in);
            String scan1 = scan.nextLine();
            for(int i = 0 ; i < rented.size() ;i++){
                if(scan1.equals(rented.get(i))){
                    rented.remove(rented.get(i));
                }else{
                    System.out.println("user doesn't exist");
                }
            }
        }

        public static void searchUser () {
            Scanner scan = new Scanner(System.in);
            String scan1 = scan.nextLine();
            for(int i = 0 ; i < rented.size() ;i++){
                if(scan1.equals(rented.get(i))){
                    System.out.println(rented.get(i).name);
                }else{
                    System.out.println("user doesn't exist");
                }
            }
        }

        public static void doesUserExist () {
            Scanner scan = new Scanner(System.in);
            String scan1 = scan.nextLine();
            for(int i = 0 ; i < rented.size() ;i++){
                if(scan1.equals(rented.get(i))){
                    System.out.println(rented.get(i).name);
                    System.out.println("does exists");
                }else{
                    System.out.println("user doesn't exist");
                }
            }
        }

        //librarian related functions

        public static void addLibrarian () {
           librarian.add(Librarian.librarian1);
            Scanner scan = new Scanner(System.in);
            String scan1 = scan.nextLine();
            String scan2 = scan.nextLine();
            for(int i = 0 ; 4 > i; i++){
                if(scan1.equals(librarian.get(i))){
                    System.out.println("we already have him/her");
                }else{
                    Librarian librarian2 = new Librarian(scan1,scan2);
                    librarian.add(new Librarian(librarian2));
                }
            }
        }

        public static void removeLibrarian () {
            Scanner scan = new Scanner(System.in);
            String scan1 = scan.nextLine();
            for(int i = 0 ; 4 > i; i++){
                if(scan1.equals(librarian.get(i))){
                    librarian.remove(librarian.get(i));
                }else{
                    System.out.println("librarian doesn't exist");
                }
            }
        }

        public static void searchLibrarian () {
            Scanner scan = new Scanner(System.in);
            String scan1 = scan.nextLine();
            for(int i = 0 ; 4 > i; i++){
                if(scan1.equals(librarian.get(i))){
                    System.out.println(librarian.get(i).username);
                    System.out.println("librarian exist");
                }else{
                    System.out.println("librarian doesn't exist");
                }
            }

        }

        public static void doesLibrarianExist () {
            Scanner scan = new Scanner(System.in);
            String scan1 = scan.nextLine();
            for(int i = 0 ; 4 > i; i++){
                if(scan1.equals(librarian.get(i))){
                    System.out.println("librarian exist");
                }else{
                    System.out.println("librarian doesn't exist");
                }
            }
        }
    public static void rentBook(){
        Scanner scan = new Scanner(System.in);
        String scan1 = scan.nextLine();
        for(int i = 0 ; i < 12 ; i++){
            if(scan1.equals(books.get(i))){
                if( books.get(i).counter != 0){
                    books.get(i).counter = books.get(i).counter - 1;

                }else {
                    System.out.println("sorry the book is not available!");
                }
            }else{
                System.out.println("sorry we don't have the book!");
            }

        }
    }

    public static void returnBook(){
        Scanner scan = new Scanner(System.in);
        String scan1 = scan.nextLine();
        for(int i = 0 ; i < 12 ; i++){
            if(scan1.equals(books.get(i))){
                books.get(i).counter = books.get(i).counter + 1;
            }
            else{
                System.out.println("are you sure you got that from us?!");
            }

        }
    }


        @Override
        public void actionPerformed (ActionEvent e){

        }
    }

