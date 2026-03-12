package mk.ukim.finki.book_shop_backend.model.dto;

import mk.ukim.finki.book_shop_backend.model.domain.Book;
import java.util.List;

public record DisplayBookDto(
        Long id,
        String name,
        Long authorId
) {

    public static DisplayBookDto from(Book book){
        return new DisplayBookDto(
                book.getId(),
                book.getName(),
                book.getAuthor().getId()
        );
    }

    public static List<DisplayBookDto> from(List<Book> books){
        return books.stream()
                .map(DisplayBookDto::from)
                .toList();
    }
}
