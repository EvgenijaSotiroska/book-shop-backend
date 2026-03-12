package mk.ukim.finki.book_shop_backend.model.dto;

import jakarta.validation.constraints.NotBlank;
import mk.ukim.finki.book_shop_backend.model.domain.Author;
import mk.ukim.finki.book_shop_backend.model.domain.Book;

public record CreateBookDto(
        @NotBlank(message = "Book name is required")
        String name,
        Long authorId
) {
    public Book toBook(Author author){
        return new Book(author, name);
    }
}
