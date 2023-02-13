package edu.andrlis.bookscatalog.entity;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 13/02/2023 - 02:01
 */
public class Publisher extends AbstractCatalogItem {
    private String name;

    public Publisher(long id, String name) {
        super(id);
        this.name = name;
    }

    public Publisher() {
        super();
    }

    public Publisher(Publisher publisher) {
        super(publisher.getId());
        this.name = publisher.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "edu.andrlis.bookscatalog.entities.Publisher{" +
                "id=" + this.getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
