package edu.andrlis.bookscatalog.entity;

import java.util.Date;
import java.util.Random;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 13/02/2023 - 00:00
 */
public abstract class AbstractCatalogItem {

    private int id;
    private String name;

    public AbstractCatalogItem(int id, String name) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int generateId() {
        Random random = new Random();
        return Math.abs((int)(new Date().getTime()/1000) + random.nextInt());
    }
}
