public class Book {
    private String book_name;
    private String book_author;
    private int publish_year;
    private final int ISBN;
    public Book (String book_name, String book_author, int publish_year, int ISBN){

        this.book_name = book_name;
        this.book_author = book_author;
        this.publish_year = publish_year;
        this.ISBN = ISBN;
    }

    public String getBook_name() {
        return book_name;
    }
    public String getBook_author() {
        return book_author;
    }
    public int getPublish_year() {
        return publish_year;
    }
    public int getISBN() {
        return ISBN;
    }
    //Book should contain name,author,year of publish and ISBN
}
