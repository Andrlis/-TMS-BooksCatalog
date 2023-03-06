package edu.andrlis.bookscatalog.dataset;

import edu.andrlis.bookscatalog.entity.Author;
import edu.andrlis.bookscatalog.entity.Book;
import edu.andrlis.bookscatalog.entity.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andrei Lisouski (Andrlis) - 19/02/2023 - 14:25
 */
public class BookDatasetService {
    public List<Author> getAuthors(List<BookDatasetEntity> dataset) {
        return dataset.stream().map(BookDatasetEntity::getAuthor).distinct()
                .map(i -> new Author(i)).collect(Collectors.toList());
    }

    public List<Publisher> getPublishers(List<BookDatasetEntity> dataset) {
        return dataset.stream().map(BookDatasetEntity::getPublisher).distinct()
                .map(i -> new Publisher(i)).collect(Collectors.toList());
    }

    public List<Book> getBooks(List<BookDatasetEntity> dataset, List<Author> authors, List<Publisher> publishers) {
        List<Book> bookList = new ArrayList<>();

        for (BookDatasetEntity datasetEntity : dataset) {
            Book book = new Book();
            book.setName(datasetEntity.getTitle());
            book.setGenre(datasetEntity.getGenre());

            Author author = findAuthorByName(authors, datasetEntity.getAuthor());
            book.setAuthor(author);

            Publisher publisher = findPublisherByName(publishers, datasetEntity.getPublisher());
            book.setPublisher(publisher);

            bookList.add(book);
        }

        return bookList;
    }

    private Author findAuthorByName(List<Author> authors, String authorName) {
        for (Author author : authors) {
            if (author.getName().equals(authorName)) {
                return new Author(author);
            }
        }
        return null;
    }

    private Publisher findPublisherByName(List<Publisher> publishers, String publisherName) {
        for (Publisher publisher : publishers) {
            if (publisher.getName().equals(publisherName)) {
                return new Publisher(publisher);
            }
        }
        return null;
    }
}
