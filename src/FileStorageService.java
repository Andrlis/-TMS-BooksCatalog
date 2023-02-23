import com.google.gson.Gson;
import edu.andrlis.bookscatalog.entity.AbstractCatalogItem;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 13/02/2023 - 00:44
 */
public class FileStorageService<T> implements Storable<T> {

    private String filePath;

    public FileStorageService(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(T item) {
        Gson gson = new Gson();
        try (FileOutputStream fileOutputStream =
                     new FileOutputStream(filePath, true)) {
            fileOutputStream.write(gson.toJson(item).getBytes());
            fileOutputStream.write(10);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public void save(List<T> listOfItems) {
        Gson gson = new Gson();
        try (FileOutputStream fileOutputStream =
                     new FileOutputStream(filePath, false)) {
            fileOutputStream.write(gson.toJson(listOfItems).getBytes());
            fileOutputStream.write(10);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public List<T> getAll(Type type) {
        Gson gson = new Gson();
        List<T> result = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filePath))) {
            result = gson.fromJson(bufferedReader, type);
        } catch (IOException e) {
            System.err.println(e);
        }
        return result;
    }

}
