package edu.andrlis.bookscatalog.entity;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 13/02/2023 - 00:00
 */
public abstract class AbstractCatalogItem {

    private long id;

    public AbstractCatalogItem(long id) {
        this.id = id;
    }

    public AbstractCatalogItem() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
