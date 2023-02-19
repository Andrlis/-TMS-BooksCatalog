package edu.andrlis.bookscatalog.entity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Random;

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
        this.id = generateId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long generateId() {
        Random random = new Random();
        return Math.abs(LocalDateTime.now().getLong(ChronoField.NANO_OF_SECOND) + random.nextLong());
    }
}
