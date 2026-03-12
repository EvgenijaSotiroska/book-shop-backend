package mk.ukim.finki.book_shop_backend.model.dto;

import mk.ukim.finki.book_shop_backend.model.domain.BookCopy;
import mk.ukim.finki.book_shop_backend.model.enumeration.Category;
import mk.ukim.finki.book_shop_backend.model.enumeration.State;

import java.util.List;

public record DisplayBookCopyDto(
        Long id,
        Category category,
        State state,
        boolean isBorrowed,
        Long bookId
) {

    public static DisplayBookCopyDto from(BookCopy book){
        return new DisplayBookCopyDto(
                book.getId(),
                book.getCategory(),
                book.getState(),
                book.isBorrowed(),
                book.getBook().getId()
        );
    }

    public static List<DisplayBookCopyDto> from(List<BookCopy> books){
        return books.stream()
                .map(DisplayBookCopyDto::from)
                .toList();
    }
}
