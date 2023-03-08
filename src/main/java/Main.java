import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
import java.util.Iterator;


public class Main extends Library {
    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        System.out.println("hi welcome to third assignment library");
        System.out.println("if you are a librarian type 1 and if you are a user type 2");
        Scanner scan = new Scanner(System.in);
        int scan1 = scan.nextInt();
        if (scan1 == 1) {
            System.out.println("first we need some information to make sure you are a librarian");
            System.out.println("what is your username?");
            String UserName = scan.nextLine();
            for (int i = 0; i < 4; i++) {
                if (UserName.equals(librarian.get(i).username)) {
                    System.out.println("enter your password");
                    String Password = scan.nextLine();
                    if (Password.equals(librarian.get(i).password)) {
                        System.out.println("welcome back");
                        System.out.println("as a librerian you can choose the number between 1 to 14, go ahead ");
                        System.out.println("addBook1,removeBook2,searchBook3 ,doesBookExist4,increaseBook5,decreaseBook6,addUser7 " +
                                "removeUser8,searchUser9,doesUserExist10,addLibrarian11,removeLibrarian12,searchLibrarian13" +
                                ",doesLibrarianExist14");
                        int number = scan.nextInt();
                        switch (number) {
                            case 1:
                                addBook();
                                break;
                            case 2:
                                removeBook();
                                break;
                            case 3:
                                searchBook();
                                break;
                            case 4:
                                doesBookExist();
                                break;
                            case 5:
                                increaseBook();
                                break;
                            case 6:
                                decreaseBook();
                                break;
                            case 7:
                                addUser();
                                break;
                            case 8:
                                removeUser();
                                break;
                            case 9:
                                searchUser();
                                break;
                            case 10:
                                doesUserExist();
                                break;
                            case 11:
                                addLibrarian();
                                break;
                            case 12:
                                removeLibrarian();
                                break;
                            case 13:
                                searchLibrarian();
                                break;
                            case 14:
                                doesLibrarianExist();
                                break;
                        }
                    } else {
                        System.out.println("password is invalid");
                    }
                } else {
                    System.out.println("username is invalid");
                }
            }
        } else {
            System.out.println("plz enter you name");
            String Name = scan.nextLine();
            String password = scan.nextLine();
            for (int i = 0; i < 4; i++) {
                if (Name.equals(rented.get(i).name)) {
                    if(password.equals(rented.get(i).password)){
                        System.out.println("hi! as a user you have four options , plz go ahead and pick one ");
                        System.out.println("searchBook1,doesBookExist2,rentBook3,returnBook4");
                        int number1 = scan.nextInt();
                        switch(number1){
                            case 1:
                                searchBook();
                                break;
                            case 2:
                                doesBookExist();
                                break;
                            case 3:
                                rentBook();
                                rented.get(i).booksName= books.get(i).name;
                                break;
                            case 4:
                                returnBook();
                                rented.get(i).booksName = null;
                                break;
                        }


                    }else{
                        System.out.println("invalid password");
                    }
                }else{
                    System.out.println("invalid name for a user");
                }


            }
        }

    }
}