package mk.ukim.finki.book_shop_backend.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book extends BaseAuditableEntity{

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;


    public Book(Author author,String name) {
        this.author = author;
        this.name = name;
    }

    public Book() {
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }
}
