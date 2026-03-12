package mk.ukim.finki.book_shop_backend.service.domain.impl;

import mk.ukim.finki.book_shop_backend.model.domain.BookCopy;
import mk.ukim.finki.book_shop_backend.model.exception.NoAvailableCopiesException;
import mk.ukim.finki.book_shop_backend.repository.BookCopyRepository;
import mk.ukim.finki.book_shop_backend.service.domain.BookCopyService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookCopyServiceImpl implements BookCopyService {
    private final BookCopyRepository bookCopyRepository;

    public BookCopyServiceImpl(BookCopyRepository bookCopyRepository) {
        this.bookCopyRepository = bookCopyRepository;
    }

    @Override
    public Optional<BookCopy> findById(Long id) {
        return bookCopyRepository.findById(id);
    }

    @Override
    public List<BookCopy> findAll() {
        return bookCopyRepository.findAll();
    }

    @Override
    public BookCopy create(BookCopy book) {
        return bookCopyRepository.save(book);
    }

    @Override
    public Optional<BookCopy> update(Long id, BookCopy book) {
        return bookCopyRepository
                .findById(id)
                .map((existingBook) -> {
                    existingBook.setState(book.getState());
                    existingBook.setCategory(book.getCategory());
                    return bookCopyRepository.save(existingBook);
                });
    }

    @Override
    public Optional<BookCopy> deleteById(Long id) {
        Optional<BookCopy> book = bookCopyRepository.findById(id);
        book.ifPresent(bookCopyRepository::delete);
        return book;
    }

    @Override
    public BookCopy borrowBook(Long id) {
        BookCopy copy = bookCopyRepository
                .findFirstByBookIdAndBorrowedFalse(id)
                .orElseThrow(() -> new NoAvailableCopiesException("No available copies"));

        copy.setBorrowed(true);

        return bookCopyRepository.save(copy);
    }
}
