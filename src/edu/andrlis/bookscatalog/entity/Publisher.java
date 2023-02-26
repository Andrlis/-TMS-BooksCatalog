package edu.andrlis.bookscatalog.entity;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 13/02/2023 - 02:01
 */
public class Publisher extends AbstractCatalogItem {
    public Publisher(long id, String name) {
        super(id, name);
    }

    public Publisher(String name) {
        super(name);
    }

    public Publisher() {
        super();
    }

    public Publisher(Publisher publisher) {
        super(publisher.getId(), publisher.getName());
    }

    @Override
    public String toString() {
        return "edu.andrlis.bookscatalog.entities.Publisher{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                '}';
    }
}
