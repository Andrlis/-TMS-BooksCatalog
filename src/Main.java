import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.andrlis.bookscatalog.dataset.BookDatasetEntity;
import edu.andrlis.bookscatalog.dataset.BookDatasetService;
import edu.andrlis.bookscatalog.entity.Author;
import edu.andrlis.bookscatalog.dataset.BookDatasetReader;
import edu.andrlis.bookscatalog.entity.Book;
import edu.andrlis.bookscatalog.entity.Publisher;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created ${DAY}/${MONTH}/${YEAR} - ${TIME}
 */
public class Main {
    public static void main(String[] args) {
        BookDatasetReader datasetReader = new BookDatasetReader();
        BookDatasetService bookDatasetService = new BookDatasetService();

        List<BookDatasetEntity> dataset = datasetReader.readDataset();
        List<Author> authors = bookDatasetService.getAuthors(dataset);
        List<Publisher> publishers = bookDatasetService.getPublisher(dataset);
        List<Book> books = bookDatasetService.getBooks(dataset, authors, publishers);

        System.out.println("Authors:");
        authors.forEach(System.out::println);
        System.out.println("Publishers:");
        publishers.forEach(System.out::println);
        System.out.println("Books:");
        books.forEach(System.out::println);

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        String authorsJson = gson.toJson(authors);
        String publishersJson = gson.toJson(publishers);
        String booksJson = gson.toJson(books);

        FileOutputStream fileOutputStream =
                null;
        try {
            fileOutputStream = new FileOutputStream("resources/authors.json", true);
            fileOutputStream.write(authorsJson.getBytes());
            fileOutputStream.write(10);
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fileOutputStream = new FileOutputStream("resources/publishers.json", true);
            fileOutputStream.write(publishersJson.getBytes());
            fileOutputStream.write(10);
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fileOutputStream = new FileOutputStream("resources/books.json", true);
            fileOutputStream.write(booksJson.getBytes());
            fileOutputStream.write(10);
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}