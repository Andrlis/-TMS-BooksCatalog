/**
 * @author Andrei Lisouski (Andrlis)
 * @created 12/02/2023 - 23:13
 */
public class Book extends CatalogItem{

    private String title;
    private String author;
    private String genre;
    private int rating;
    private String publisher;

    public Book(long id, String title, String author, String genre, int rating, String publisher) {
        super(id);
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.publisher = publisher;
    }

    public Book() {
        super();
    }

    public Book(Book book) {
        super(book.getId());
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.genre = book.getGenre();
        this.rating = book.getRating();
        this.publisher = book.getPublisher();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + this.getId() +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
