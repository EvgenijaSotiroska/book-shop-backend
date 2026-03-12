package mk.ukim.finki.book_shop_backend.web.controller;

import jakarta.validation.Valid;

import mk.ukim.finki.book_shop_backend.model.dto.CreateBookDto;
import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookCopyDto;
import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookDto;
import mk.ukim.finki.book_shop_backend.service.application.BookApplicationService;
import mk.ukim.finki.book_shop_backend.service.application.BookCopyApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookApplicationService bookApplicationService;
    private final BookCopyApplicationService bookCopyApplicationService;

    public BookController(BookApplicationService bookApplicationService, BookCopyApplicationService bookCopyApplicationService) {
        this.bookApplicationService = bookApplicationService;
        this.bookCopyApplicationService = bookCopyApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayBookDto> findById(@PathVariable Long id){
        return bookApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping
    public ResponseEntity<List<DisplayBookDto>> findAll() {
        return ResponseEntity.ok(bookApplicationService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayBookDto> create(@RequestBody @Valid CreateBookDto createBookDto) {
        return ResponseEntity.ok(bookApplicationService.create(createBookDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayBookDto> update(
            @PathVariable Long id,
            @RequestBody CreateBookDto createBookDto
    ) {
        return bookApplicationService
                .update(id, createBookDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayBookDto> deleteById(@PathVariable Long id) {
        return bookApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}/borrow")
    public ResponseEntity<DisplayBookCopyDto> borrowBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookCopyApplicationService.borrowBook(id));
    }
}


