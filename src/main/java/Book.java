public class Book {
    //Book should contain name,author,year of publish and ISBN
    private String name;
    private String author;
    private int yearOfPublish;
    private String ISBN;
    private Boolean isAvailable = true;
    /* public Book(String name, String author, int yearOfPublish, String ISBN)
    {
        this.name = name;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
        this.ISBN = ISBN;
    }*/

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

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public String toString()
    {
        return "Name: " + name + " " +
                "Author: " + author + " " +
                "Year of publish: " +  yearOfPublish + "" +
                "ISBN: " + ISBN + "" +
                "Is available? " + isAvailable;
    }

    public void changeAvailableStatus(){
        this.isAvailable = !isAvailable;
    }
}
