import edu.andrlis.bookscatalog.entity.AbstractCatalogItem;

import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 13/02/2023 - 00:44
 */
public class FileStorage implements Storable{

    @Override
    public void save(AbstractCatalogItem item) {

    }

    @Override
    public void save(List<AbstractCatalogItem> listOfItems) {

    }

    @Override
    public List<AbstractCatalogItem> getAll() {
        return null;
    }
}
