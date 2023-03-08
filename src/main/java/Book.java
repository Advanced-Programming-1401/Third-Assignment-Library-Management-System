public class Book {
    //Book should contain name,author,year of publish and ISBN
    private String name;
    private String author;
    private int yearOfPublish;
    private String ISBN;

    private int amountOfBook = 0;

    public int getAmountOfBook() {
        return amountOfBook;
    }

    public void setAmountOfBook(int amountOfBook) {
        this.amountOfBook = amountOfBook;
    }

    public Book(String name, String author, int yearOfPublish, String ISBN) {
        this.name = name;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
        this.ISBN = ISBN;

        this.amountOfBook++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Here is the information of " + this.getName() + "book:\nThe Book's Name: " + getName() + "\nThe Author's Name: " + getAuthor() + "\nThe Book's Year of Publish: " + getYearOfPublish() + "\nThe Book's ISBN: " + getISBN();
    }


}
