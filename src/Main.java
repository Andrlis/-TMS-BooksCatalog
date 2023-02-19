import edu.andrlis.bookscatalog.entity.Author;
import edu.andrlis.bookscatalog.utils.dataset.BookDatasetReader;
import edu.andrlis.bookscatalog.utils.dataset.DatasetEntity;

import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created ${DAY}/${MONTH}/${YEAR} - ${TIME}
 */
public class Main {
    public static void main(String[] args) {
        BookDatasetReader datasetReader = new BookDatasetReader();
        List<DatasetEntity> dataset = datasetReader.readDataset();
        List<Author> authors = datasetReader.getAuthors(dataset);

        authors.stream().forEach(System.out::println);

//        for(DatasetEntity entity: dataset) {
//            System.out.println(entity.toString());
//        }

    }
}