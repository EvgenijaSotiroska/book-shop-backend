package mk.ukim.finki.book_shop_backend.model.domain;

import jakarta.persistence.*;
import mk.ukim.finki.book_shop_backend.model.enumeration.Category;
import mk.ukim.finki.book_shop_backend.model.enumeration.State;

@Entity
@Table(name = "book_copies")
public class BookCopy extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "is_borrowed")
    private boolean borrowed;

    public BookCopy(Book book, Category category, State state) {
        this.book = book;
        this.category = category;
        this.state = state;
        this.borrowed = false;
    }

    public BookCopy() {
    }

    public Book getBook() {
        return book;
    }

    public Category getCategory() {
        return category;
    }

    public State getState() {
        return state;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void setState(State state) {
        this.state = state;
    }
}
