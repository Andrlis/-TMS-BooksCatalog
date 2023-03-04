package edu.andrlis.bookscatalog.console;

import com.google.gson.reflect.TypeToken;
import edu.andrlis.bookscatalog.entity.Author;
import edu.andrlis.bookscatalog.entity.Book;
import edu.andrlis.bookscatalog.entity.Publisher;
import edu.andrlis.bookscatalog.service.file.AuthorCatalogService;
import edu.andrlis.bookscatalog.service.file.BookCatalogService;
import edu.andrlis.bookscatalog.service.file.FileCatalogService;
import edu.andrlis.bookscatalog.service.file.PublisherCatalogService;
import edu.andrlis.bookscatalog.storage.file.FileStorageService;
import edu.andrlis.bookscatalog.utils.AppConstants;

import java.io.File;
import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis) - 26/02/2023 - 21:29
 */
public class ConsoleApplicationWithFileStorage extends ConsoleApplication {

    private List<Book> booksList;
    private List<Author> authorsList;
    private List<Publisher> publishersList;

    @Override
    public void showAllBooks() {

    }

    @Override
    public void showAllAuthors() {

    }

    @Override
    public void showAllPublishers() {

    }

    @Override
    public void findBookByName() {

    }

    @Override
    public void findBooksByAuthor() {

    }

    @Override
    public void findBooksByPublisher() {

    }

    @Override
    public void findAuthorByName() {

    }

    @Override
    public void findPublisherByName() {

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

//    @Override
//    public void run() {
//        if (!isAppInitialized()) {
//
//        }
//        readDataFromSources();
//        FileCatalogService<Author> authorCatalogService = new AuthorCatalogService();
//        FileCatalogService<Book> bookCatalogService = new BookCatalogService();
//        FileCatalogService<Publisher> publisherCatalogService = new PublisherCatalogService();
//
//        while (true) {
//            showMenu();
//            int selectedMenuOption = readMenuOption();
//
//
//        }
//    }
//
//    private boolean isAppInitialized() {
//        File bookSourceFile = new File(AppConstants.BOOK_SOURCE_FILE);
//        File authorSourceFile = new File(AppConstants.AUTHOR_SOURCE_FILE);
//        File publisherSourceFile = new File(AppConstants.PUBLISHER_SOURCE_FILE);
//
//        return (bookSourceFile.exists() && authorSourceFile.exists() && publisherSourceFile.exists());
//    }
//
//    private void readDataFromSources() {
//        FileStorageService<Author> authorFileStorageService = new FileStorageService<>(AppConstants.AUTHOR_SOURCE_FILE);
//        FileStorageService<Book> bookFileStorageService = new FileStorageService<>(AppConstants.BOOK_SOURCE_FILE);
//        FileStorageService<Publisher> publishersFileStorageService = new FileStorageService<>(AppConstants.PUBLISHER_SOURCE_FILE);
//
//        this.booksList = bookFileStorageService.getAll(new TypeToken<List<Book>>() {
//        }.getType());
//        this.authorsList = authorFileStorageService.getAll(new TypeToken<List<Author>>() {
//        }.getType());
//        this.publishersList = publishersFileStorageService.getAll(new TypeToken<List<Publisher>>() {
//        }.getType());
//    }
}
