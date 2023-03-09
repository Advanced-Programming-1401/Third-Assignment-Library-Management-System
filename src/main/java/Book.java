public class Book {
    //Book should contain name,author,year of publish and ISBN
    private String bookName;
    private String author;
    private int year;
    private int ISBN;

    public Book(String bookName, String author, int year, int ISBN) {
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.ISBN = ISBN;
    }

    public String getNameOfBook() {
        return this.bookName + "";
    }

    public int getNumberOfBook() {
        return this.ISBN;
    }
}