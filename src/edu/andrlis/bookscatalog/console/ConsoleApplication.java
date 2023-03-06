package edu.andrlis.bookscatalog.console;

import edu.andrlis.bookscatalog.Application;
import edu.andrlis.bookscatalog.dataset.BookDatasetEntity;
import edu.andrlis.bookscatalog.dataset.BookDatasetReader;
import edu.andrlis.bookscatalog.dataset.BookDatasetService;
import edu.andrlis.bookscatalog.entity.Author;
import edu.andrlis.bookscatalog.entity.Book;
import edu.andrlis.bookscatalog.entity.Publisher;
import edu.andrlis.bookscatalog.exception.InvalidInputException;
import edu.andrlis.bookscatalog.utils.Reader;
import edu.andrlis.bookscatalog.utils.Writer;

import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis) 04/03/2023 - 17:30
 */
public abstract class ConsoleApplication implements Application {

    public Writer writer = new ConsoleWriter();
    public Reader reader = new ConsoleReader();

    private BookDatasetService bookDatasetService = new BookDatasetService();

    BookDatasetReader bookDatasetReader = new BookDatasetReader();

    public void showMenu() {
        writer.write("Please, select an operation:\n"
                + "\n\t1 - Show"
                + "\n\t2 - Find"
                + "\n\t3 - Add new"
                + "\n\t0 - Exit");
    }

    public void showSubMenu(int parentMenu) {
        switch (parentMenu) {
            case 1:
                writer.write("Show:\n"
                        + "\n\t1 - Books"
                        + "\n\t2 - Authors"
                        + "\n\t3 - Publishers"
                        + "\n\t0 - Break");
                break;
            case 2:
                writer.write("Find:\n"
                        + "\n\t1 - Find book by name"
                        + "\n\t2 - Find books by author"
                        + "\n\t3 - Find books by publisher"
                        + "\n\t4 - Find author by name"
                        + "\n\t5 - Find publisher by name"
                        + "\n\t0 - Break");
                break;
            case 3:
                writer.write("Add new:\n"
                        + "\n\t1 - Book"
                        + "\n\t2 - Author"
                        + "\n\t3 - Publisher");
                break;
            default:
                writer.write("default");
        }
    }

    public int readMenuOption() {
//        try (ConsoleReader reader = new ConsoleReader()) {
//            return reader.readInt();
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
        try {
            return reader.readInt();
        } catch (InvalidInputException e) {
            System.err.println(e.getMessage());
            ;
        }
        return -1;
    }

    @Override
    public void run() {
        if (!isAppInitialized()) {
            List<BookDatasetEntity> dataset = bookDatasetReader.readDataset();
            List<Author> authorList = bookDatasetService.getAuthors(dataset);
            List<Publisher> publisherList = bookDatasetService.getPublishers(dataset);
            List<Book> bookList = bookDatasetService.getBooks(dataset, authorList, publisherList);

            saveAuthorsFromDataset(authorList);
            savePublishersFromDataset(publisherList);
            saveBooksFromDataset(bookList);
        }

        while (true) {
            showMenu();
            int selectedMenuOption = readMenuOption();

            if (selectedMenuOption == 0) {
                break;
            }

            showSubMenu(selectedMenuOption);
            int selectedSubMenuOption = readMenuOption();

            switch (selectedMenuOption * 10 + selectedSubMenuOption) {
                case 11:
                    //Show all books
                    showAllBooks();
                    break;
                case 12:
                    //Show all authors
                    showAllAuthors();
                    break;
                case 13:
                    //Show all publishers
                    showAllPublishers();
                    break;
                case 21:
                    //Find book by name
                    findBookByName();
                    break;
                case 22:
                    //Find books by author
                    findBooksByAuthor();
                    break;
                case 23:
                    //Find books by publisher
                    findBooksByPublisher();
                    break;
                case 24:
                    //Find author by name
                    findAuthorByName();
                    break;
                case 25:
                    //Find publisher by name
                    findPublisherByName();
                    break;
                case 31:
                    //Add new book
                    addNewBook();
                    break;
                case 32:
                    //Add new author
                    addNewAuthor();
                    break;
                case 33:
                    //Add new publisher
                    addNewPublisher();
                    break;
                default:
                    break;
            }
        }
    }

    public abstract void showAllBooks();

    public abstract void showAllAuthors();

    public abstract void showAllPublishers();

    public abstract void findBookByName();

    public abstract void findBooksByAuthor();

    public abstract void findBooksByPublisher();

    public abstract void findAuthorByName();

    public abstract void findPublisherByName();

    public abstract void addNewBook();

    public abstract void addNewAuthor();

    public abstract void addNewPublisher();

    public abstract boolean isAppInitialized();

    public abstract void saveBooksFromDataset(List<Book> bookList);

    public abstract void saveAuthorsFromDataset(List<Author> authorList);

    public abstract void savePublishersFromDataset(List<Publisher> publisherList);
}
