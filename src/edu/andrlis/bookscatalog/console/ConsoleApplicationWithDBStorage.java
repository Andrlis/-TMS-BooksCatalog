package edu.andrlis.bookscatalog.console;

import edu.andrlis.bookscatalog.entity.Author;
import edu.andrlis.bookscatalog.entity.Book;
import edu.andrlis.bookscatalog.entity.Publisher;
import edu.andrlis.bookscatalog.storage.db.JDBCAuthorStorageService;
import edu.andrlis.bookscatalog.storage.db.JDBCBookStorageService;
import edu.andrlis.bookscatalog.storage.db.JDBCPublisherStorageService;

import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis) 04/03/2023 - 17:29
 */
public class ConsoleApplicationWithDBStorage extends ConsoleApplication {

    private JDBCBookStorageService bookStorageService = new JDBCBookStorageService();
    private JDBCAuthorStorageService authorStorageService = new JDBCAuthorStorageService();
    private JDBCPublisherStorageService publisherStorageService = new JDBCPublisherStorageService();

    @Override
    public void showAllBooks() {
        List<Book> allBooks = bookStorageService.getAll();
        for (Book book : allBooks) {
            writer.write(book.toString());
        }
    }

    @Override
    public void showAllAuthors() {
        List<Author> allAuthors = authorStorageService.getAll();
        for (Author author : allAuthors) {
            writer.write(author.toString());
        }
    }

    @Override
    public void showAllPublishers() {
        List<Publisher> allPublisher = publisherStorageService.getAll();
        for (Publisher publisher : allPublisher) {
            writer.write(publisher.toString());
        }
    }

    @Override
    public void findBookByName() {
        writer.write("Please, enter book's name:");
        String bookName = reader.readString();
        List<Book> bookSearchResult = bookStorageService.getByName(bookName);
        for (Book book : bookSearchResult) {
            writer.write(book.toString());
        }
    }

    @Override
    public void findBooksByAuthor() {
        writer.write("Please, enter author's name:");
        String authorName = reader.readString();
        List<Book> bookSearchResult = bookStorageService.getByAuthor(authorName);
        for (Book book : bookSearchResult) {
            writer.write(book.toString());
        }
    }

    @Override
    public void findBooksByPublisher() {
        writer.write("Please, enter publisher's name:");
        String publisherName = reader.readString();
        List<Book> bookSearchResult = bookStorageService.getByAuthor(publisherName);
        for (Book book : bookSearchResult) {
            writer.write(book.toString());
        }
    }

    @Override
    public void findAuthorByName() {
        writer.write("Please, enter author's name:");
        String authorName = reader.readString();
        List<Author> authorSearchResult = authorStorageService.getByName(authorName);
        for (Author author : authorSearchResult) {
            writer.write(author.toString());
        }
    }

    @Override
    public void findPublisherByName() {
        writer.write("Please, enter publisher's name:");
        String publisherName = reader.readString();
        List<Publisher> publisherSearchResult = publisherStorageService.getByName(publisherName);
        for (Publisher publisher : publisherSearchResult) {
            writer.write(publisher.toString());
        }
    }

    @Override
    public void addNewBook() {

    }

    @Override
    public void addNewAuthor() {

    }

    @Override
    public void addNewPublisher() {

    }
}
