/**
 * @author Andrei Lisouski (Andrlis)
 * @created 13/02/2023 - 00:00
 */
public abstract class CatalogItem {

    private long id;

    public CatalogItem(long id) {
        this.id = id;
    }

    public CatalogItem() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
