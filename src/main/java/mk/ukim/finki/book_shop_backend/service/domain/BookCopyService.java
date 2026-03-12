package mk.ukim.finki.book_shop_backend.service.domain;

import mk.ukim.finki.book_shop_backend.model.domain.BookCopy;
import java.util.List;
import java.util.Optional;

public interface BookCopyService {
    Optional<BookCopy> findById(Long id);

    List<BookCopy> findAll();

    BookCopy create(BookCopy bookCopy);

    Optional<BookCopy> update(Long id, BookCopy bookCopy);

    Optional<BookCopy> deleteById(Long id);

    BookCopy borrowBook(Long id);
}
