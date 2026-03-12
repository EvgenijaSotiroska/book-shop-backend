package mk.ukim.finki.book_shop_backend.service.application;

import mk.ukim.finki.book_shop_backend.model.dto.CreateBookCopyDto;
import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookCopyDto;
import java.util.List;
import java.util.Optional;

public interface BookCopyApplicationService {
    Optional<DisplayBookCopyDto> findById(Long id);

    List<DisplayBookCopyDto> findAll();

    DisplayBookCopyDto create(CreateBookCopyDto createBookDto);

    Optional<DisplayBookCopyDto> update(Long id, CreateBookCopyDto createBookDto);

    Optional<DisplayBookCopyDto> deleteById(Long id);

    DisplayBookCopyDto borrowBook(Long id);
}
