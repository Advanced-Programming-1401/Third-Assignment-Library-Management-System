import java.util.ArrayList;

public class Book /*extends Library*/ {
    //Book should contain name,author,year of publish and ISBN

       private int YearPublish, ISBN ;
       private String name,author;
       public boolean borrowed;
       public Book(){
           name ="";
           author="";
           YearPublish = 0;
           ISBN = 0;

       }
       public Book(String name,String author,int ISBN,int YearPublish){

           this.name = name;
           this.author = author;
           this.ISBN = ISBN;
           this.YearPublish = YearPublish;

       }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublish() {
        return YearPublish;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearPublish(int yearPublish) {
        YearPublish = yearPublish;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
    public void setToBorrowed() { //Method will fire once a book has been checked out
        this.borrowed = true;
    }

    public void setToReturned() { //Method will fire once book has been returned to the library catalog
        this.borrowed = false;
    }

    public boolean isBorrowed() { //Determines whether the book is borrowed or not
        return this.borrowed = false;

    }


    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + ISBN +
                ", YearPublish=" + YearPublish +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
