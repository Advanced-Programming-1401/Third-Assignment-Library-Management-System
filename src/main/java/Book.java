import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class Book implements ActionListener {
    String name;
    int ISBN;
    String author;
    int year;
    int counter;
    Book(){
        name = "default name";
        ISBN = 1234;
        author = "me";
        year = 1234;
        counter = 100;
    }
    Book(String name , int ISBN , String author , int year , int counter){
        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
        this.year = year;
        this.counter = counter;
    }
    static Book book1 = new Book("PERKS OF BEING A WALLFLOWER",1234567,"STEPHEN CHOBUSKY",1991,5);
    static Book book2 = new Book("ANOTHER LIFE ",89101112,"ALBERTO MORAVIA",1990,7);
    static Book book3 = new Book("HONDA",13141516,"ROBERT EL SHOOK",1962,3);
    static Book book4 = new Book("PAINTING",17181920,"ZHOZE SARAMAGO",1989,6);
    static Book book5 = new Book("NUDGE",21222324,"RICHARD TAYLOR",2017,4);
    public Book(Book book6) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
