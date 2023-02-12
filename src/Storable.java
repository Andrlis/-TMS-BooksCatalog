import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 12/02/2023 - 23:54
 */
public interface Storable {

    void save(CatalogItem item);
    void save(List<CatalogItem> listOfItems);

    List<CatalogItem> getAll();

}
