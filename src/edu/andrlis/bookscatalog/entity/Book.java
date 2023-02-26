package edu.andrlis.bookscatalog.entity;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 12/02/2023 - 23:13
 */
public class Book extends AbstractCatalogItem {
    private Author author;
    private String genre;
    private int rating;
    private Publisher publisher;

    public Book(long id, String name, Author author, String genre, int rating, Publisher publisher) {
        super(id, name);
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.publisher = publisher;
    }

    public Book(String name, Author author, String genre, int rating, Publisher publisher) {
        super(name);
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.publisher = publisher;
    }

    public Book() {
        super();
    }

    public Book(Book book) {
        super(book.getId(), book.getName());
        this.author = book.getAuthor();
        this.genre = book.getGenre();
        this.rating = book.getRating();
        this.publisher = book.getPublisher();
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
                ", name='" + this.getName() + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
