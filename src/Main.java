import edu.andrlis.bookscatalog.Application;
import edu.andrlis.bookscatalog.console.ConsoleApplicationWithDBStorage;
import edu.andrlis.bookscatalog.entity.Author;
import edu.andrlis.bookscatalog.storage.db.JDBCAuthorStorage;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created ${DAY}/${MONTH}/${YEAR} - ${TIME}
 */
public class Main {
    public static void main(String[] args) {
//        BookDatasetReader datasetReader = new BookDatasetReader();
//        BookDatasetService bookDatasetService = new BookDatasetService();
//
//        List<BookDatasetEntity> dataset = datasetReader.readDataset();
//        List<Author> authors = bookDatasetService.getAuthors(dataset);
//        List<Publisher> publishers = bookDatasetService.getPublisher(dataset);
//        List<Book> books = bookDatasetService.getBooks(dataset, authors, publishers);
//
//        System.out.println("Authors:");
//        authors.forEach(System.out::println);
//        System.out.println("Publishers:");
//        publishers.forEach(System.out::println);
//        System.out.println("Books:");
//        books.forEach(System.out::println);
//
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        Gson gson = gsonBuilder.create();

//        String authorsJson = gson.toJson(authors);
//        String publishersJson = gson.toJson(publishers);
//        String booksJson = gson.toJson(books);
//
//        FileOutputStream fileOutputStream =
//                null;
//        try {
//            fileOutputStream = new FileOutputStream("resources/authors.json", true);
//            fileOutputStream.write(authorsJson.getBytes());
//            fileOutputStream.write(10);
//            fileOutputStream.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            fileOutputStream = new FileOutputStream("resources/publishers.json", true);
//            fileOutputStream.write(publishersJson.getBytes());
//            fileOutputStream.write(10);
//            fileOutputStream.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            fileOutputStream = new FileOutputStream("resources/books.json", true);
//            fileOutputStream.write(booksJson.getBytes());
//            fileOutputStream.write(10);
//            fileOutputStream.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        FileStorageService<Author> authorFileStorageService = new FileStorageService<>("resources/authors.json");
//        CatalogService authorCatalogService = new AuthorCatalogService();
//        List<Author> authorsList = authorFileStorageService.getAll(new TypeToken<List<Author>>() {
//        }.getType());
////        Optional<Author> searchResult = authorCatalogService.searchById(4406006010904375003l, authorsList);
//        Optional<Author> searchResult = authorCatalogService.searchById(1, authorsList);
//
//        Author author = searchResult.orElse(new Author());
//        System.out.println(author.toString());
//
//        for (Author a : authorsList) {
//            System.out.println(a.toString());
//        }
////        if(searchResult.isPresent()){
////            Author author = searchResult.get();
////            System.out.println(author.toString());
////        }

        Application application = new ConsoleApplicationWithDBStorage();
        application.run();

//        Author author = new Author("Test");
//        JDBCAuthorStorage authorStorageService = new JDBCAuthorStorage();
//
//        authorStorageService.add(author);
    }
}