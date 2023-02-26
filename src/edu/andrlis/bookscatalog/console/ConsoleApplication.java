package edu.andrlis.bookscatalog.console;

import com.google.gson.reflect.TypeToken;
import edu.andrlis.bookscatalog.Application;
import edu.andrlis.bookscatalog.entity.Author;
import edu.andrlis.bookscatalog.entity.Book;
import edu.andrlis.bookscatalog.entity.Publisher;
import edu.andrlis.bookscatalog.exception.InvalidInputException;
import edu.andrlis.bookscatalog.service.AuthorCatalogService;
import edu.andrlis.bookscatalog.service.BookCatalogService;
import edu.andrlis.bookscatalog.service.CatalogService;
import edu.andrlis.bookscatalog.service.PublisherCatalogService;
import edu.andrlis.bookscatalog.storage.FileStorageService;
import edu.andrlis.bookscatalog.utils.AppConstants;
import edu.andrlis.bookscatalog.utils.Reader;

import java.io.File;
import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis) - 26/02/2023 - 21:29
 */
public class ConsoleApplication implements Application {

    private List<Book> booksList;
    private List<Author> authorsList;
    private List<Publisher> publishersList;

    @Override
    public void run() {
        if (!isAppInitialized()) {

        }
        readDataFromSources();
        CatalogService<Author> authorCatalogService = new AuthorCatalogService();
        CatalogService<Book> bookCatalogService = new BookCatalogService();
        CatalogService<Publisher> publisherCatalogService = new PublisherCatalogService();

        while (true) {
            showMenu();
            int selectedMenuOption = readMenuOption();



        }
    }

    private void showMenu() {
        System.out.println("Please, select an operation:\n"
                + "\n\t1 - Show"
                + "\n\t2 - Find"
                + "\n\t3 - Add new"
                + "\n\t0 - Exit");
    }

    private void showSubMenu(int parentMenu) {
        switch (parentMenu) {
            case 1 -> System.out.println("Show:\n"
                    + "\n\t1 - Books"
                    + "\n\t2 - Authors"
                    + "\n\t3 - Publishers"
                    + "\n\t0 - Break");
            case 2 -> System.out.println("Find:\n"
                    + "\n\t1 - Find book by name"
                    + "\n\t2 - Find books by author"
                    + "\n\t3 - Find books by publisher"
                    + "\n\t4 - Find author by name"
                    + "\n\t5 - Find publisher by name"
                    + "\n\t0 - Break");
        }
    }

    private boolean isAppInitialized() {
        File bookSourceFile = new File(AppConstants.BOOK_SOURCE_FILE);
        File authorSourceFile = new File(AppConstants.AUTHOR_SOURCE_FILE);
        File publisherSourceFile = new File(AppConstants.PUBLISHER_SOURCE_FILE);

        return (bookSourceFile.exists() && authorSourceFile.exists() && publisherSourceFile.exists());
    }

    private void readDataFromSources() {
        FileStorageService<Author> authorFileStorageService = new FileStorageService<>(AppConstants.AUTHOR_SOURCE_FILE);
        FileStorageService<Book> bookFileStorageService = new FileStorageService<>(AppConstants.BOOK_SOURCE_FILE);
        FileStorageService<Publisher> publishersFileStorageService = new FileStorageService<>(AppConstants.PUBLISHER_SOURCE_FILE);

        this.booksList = bookFileStorageService.getAll(new TypeToken<List<Book>>() {
        }.getType());
        this.authorsList = authorFileStorageService.getAll(new TypeToken<List<Author>>() {
        }.getType());
        this.publishersList = publishersFileStorageService.getAll(new TypeToken<List<Publisher>>() {
        }.getType());
    }

    private int readMenuOption() {
//        try (ConsoleReader reader = new ConsoleReader()) {
//            return reader.readInt();
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
        Reader reader = new ConsoleReader();
        try {
            return reader.readInt();
        } catch (InvalidInputException e) {
            System.err.println(e.getMessage());;
        }
        return -1;
    }
}
