public class Book {
    //Book should contain name,author,year of publish and ISBN
       private int ISBN , YearPublish;
       private String name,author;
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
