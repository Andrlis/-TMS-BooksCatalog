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
    private String name;

    public AbstractCatalogItem(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AbstractCatalogItem(String name) {
        this.id = generateId();
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private long generateId() {
        Random random = new Random();
        return Math.abs(LocalDateTime.now().getLong(ChronoField.NANO_OF_SECOND) + random.nextLong());
    }
}
