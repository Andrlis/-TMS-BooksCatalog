package edu.andrlis.bookscatalog.entity;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 12/02/2023 - 23:13
 */
public class Book extends AbstractCatalogItem {

    private String title;
    private Author author;
    private String genre;
    private int rating;
    private Publisher publisher;

    public Book(long id, String title, Author author, String genre, int rating, Publisher publisher) {
        super(id);
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.publisher = publisher;
    }

    public Book(String title, Author author, String genre, int rating, Publisher publisher) {
        super();
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
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

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "edu.andrlis.bookscatalog.entities.Book{" +
                "id=" + this.getId() +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
