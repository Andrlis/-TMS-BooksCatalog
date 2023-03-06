package edu.andrlis.bookscatalog.entity;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 13/02/2023 - 01:46
 */
public class Author extends AbstractCatalogItem {

    public Author(int id, String name) {
        super(id, name);
    }

    public Author(String name) {
        super(name);
    }

    public Author() {
        super();
    }

    public Author(Author author) {
        super(author.getId(), author.getName());
    }

    @Override
    public String toString() {
        return "edu.andrlis.bookscatalog.entities.Author{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                '}';
    }
}
