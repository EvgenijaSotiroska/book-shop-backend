package mk.ukim.finki.book_shop_backend.model.dto;

import mk.ukim.finki.book_shop_backend.model.domain.Book;
import mk.ukim.finki.book_shop_backend.model.domain.BookCopy;
import mk.ukim.finki.book_shop_backend.model.enumeration.Category;
import mk.ukim.finki.book_shop_backend.model.enumeration.State;

public record CreateBookCopyDto (
        Category category,
        State state,
        Long bookId
) {
    public BookCopy toBookCopy(Book book){
        return new BookCopy(book, category, state);
    }
}
