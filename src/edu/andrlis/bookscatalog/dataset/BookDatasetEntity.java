package edu.andrlis.bookscatalog.dataset;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 14/02/2023 - 1:10
 */
public class BookDatasetEntity {
    private String title;
    private String author;
    private String genre;
    private float height;
    private String publisher;

    public BookDatasetEntity(String title, String author, String genre, float height, String publisher) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.height = height;
        this.publisher = publisher;
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

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "BookDatasetEntity{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", height=" + height +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
