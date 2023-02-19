package edu.andrlis.bookscatalog.entity;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 13/02/2023 - 01:46
 */
public class Author extends AbstractCatalogItem {
    private String name;

    public Author(long id, String name) {
        super(id);
        this.name = name;
    }

    public Author(String name) {
        super();
        this.name = name;
    }

    public Author() {
        super();
    }

    public Author(Author author) {
        super(author.getId());
        this.name = author.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "edu.andrlis.bookscatalog.entities.Author{" +
                "id=" + this.getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
