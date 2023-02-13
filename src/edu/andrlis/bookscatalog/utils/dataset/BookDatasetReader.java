package edu.andrlis.bookscatalog.utils.dataset;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 13/02/2023 - 02:35
 */
public class BookDatasetReader {

    private File datasetFile = new File("resources/books.csv");

    public List<DatasetEntity> readDataset() {
        List<DatasetEntity> datasetEntities = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.datasetFile))) {
            String line = reader.readLine(); //Skip first line from file
            while ((line = reader.readLine()) != null) {
                datasetEntities.add(convertStringToDatasetEntity(line));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return datasetEntities;
    }

    private DatasetEntity convertStringToDatasetEntity(String inputString) {
        System.out.println(inputString);
        String[] entityParameters = inputString.split(","); //Should be split by regexp because author is a combination of name and surname that split by comma
        String title = entityParameters[0];
        String author = entityParameters[1];
        String genre = entityParameters[2];
        float height = Float.parseFloat(entityParameters[3]);
        String publisher = entityParameters[4];
        return new DatasetEntity(title, author, genre, height, publisher);
    }
}
