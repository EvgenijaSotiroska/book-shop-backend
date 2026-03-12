package mk.ukim.finki.book_shop_backend.repository;

import mk.ukim.finki.book_shop_backend.model.domain.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {
    Optional<BookCopy> findFirstByBookIdAndBorrowedFalse(Long bookId);
}
