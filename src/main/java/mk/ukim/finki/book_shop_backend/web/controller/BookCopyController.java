package mk.ukim.finki.book_shop_backend.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.book_shop_backend.model.dto.CreateBookCopyDto;
import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookCopyDto;
import mk.ukim.finki.book_shop_backend.service.application.BookCopyApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookcopies")
public class BookCopyController {
    private final BookCopyApplicationService bookCopyApplicationService;

    public BookCopyController(BookCopyApplicationService bookCopyApplicationService) {
        this.bookCopyApplicationService = bookCopyApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayBookCopyDto> findById(@PathVariable Long id){
        return bookCopyApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping
    public ResponseEntity<List<DisplayBookCopyDto>> findAll() {
        return ResponseEntity.ok(bookCopyApplicationService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayBookCopyDto> create(@RequestBody @Valid CreateBookCopyDto createBookDto) {
        return ResponseEntity.ok(bookCopyApplicationService.create(createBookDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayBookCopyDto> update(
            @PathVariable Long id,
            @RequestBody CreateBookCopyDto createBookDto
    ) {
        return bookCopyApplicationService
                .update(id, createBookDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayBookCopyDto> deleteById(@PathVariable Long id) {
        return bookCopyApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
