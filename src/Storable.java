import edu.andrlis.bookscatalog.entity.AbstractCatalogItem;

import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 12/02/2023 - 23:54
 */
public interface Storable {

    void save(AbstractCatalogItem item);
    void save(List<AbstractCatalogItem> listOfItems);

    List<AbstractCatalogItem> getAll();

}
