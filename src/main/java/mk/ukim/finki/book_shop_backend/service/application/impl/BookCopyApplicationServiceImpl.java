package mk.ukim.finki.book_shop_backend.service.application.impl;

import mk.ukim.finki.book_shop_backend.model.domain.Book;
import mk.ukim.finki.book_shop_backend.model.dto.CreateBookCopyDto;
import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookCopyDto;
import mk.ukim.finki.book_shop_backend.model.exception.BookNotFoundException;
import mk.ukim.finki.book_shop_backend.service.application.BookCopyApplicationService;
import mk.ukim.finki.book_shop_backend.service.domain.BookCopyService;
import mk.ukim.finki.book_shop_backend.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCopyApplicationServiceImpl implements BookCopyApplicationService {

    private final BookCopyService bookCopyService;
    private final BookService bookService;

    public BookCopyApplicationServiceImpl(BookCopyService bookCopyService, BookService bookService) {
        this.bookCopyService = bookCopyService;
        this.bookService = bookService;
    }

    @Override
    public Optional<DisplayBookCopyDto> findById(Long id) {
        return bookCopyService.findById(id).map(DisplayBookCopyDto::from);
    }

    @Override
    public List<DisplayBookCopyDto> findAll() {
        return DisplayBookCopyDto.from(bookCopyService.findAll());
    }

    @Override
    public DisplayBookCopyDto create(CreateBookCopyDto createBookDto) {
        Book book = bookService
                .findById(createBookDto.bookId())
                .orElseThrow(() -> new BookNotFoundException(createBookDto.bookId()));
        return DisplayBookCopyDto.from(bookCopyService.create(createBookDto.toBookCopy(book)));
    }

    @Override
    public Optional<DisplayBookCopyDto> update(Long id, CreateBookCopyDto createBookDto) {
        Book book = bookService
                .findById(createBookDto.bookId())
                .orElseThrow(() -> new BookNotFoundException(createBookDto.bookId()));
        return bookCopyService
                .update(id, createBookDto.toBookCopy(book))
                .map(DisplayBookCopyDto::from);
    }

    @Override
    public Optional<DisplayBookCopyDto> deleteById(Long id) {
        return bookCopyService.deleteById(id).map(DisplayBookCopyDto::from);
    }

    @Override
    public DisplayBookCopyDto borrowBook(Long id){
        return DisplayBookCopyDto.from(bookCopyService.borrowBook(id));
    }
}
