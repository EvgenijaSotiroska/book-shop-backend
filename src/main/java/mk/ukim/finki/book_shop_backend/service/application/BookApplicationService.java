package mk.ukim.finki.book_shop_backend.service.application;

import mk.ukim.finki.book_shop_backend.model.dto.CreateBookDto;
import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookDto;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {
    Optional<DisplayBookDto> findById(Long id);

    List<DisplayBookDto> findAll();

    DisplayBookDto create(CreateBookDto createBookDto);

    Optional<DisplayBookDto> update(Long id, CreateBookDto createBookDto);

    Optional<DisplayBookDto> deleteById(Long id);

    DisplayBookDto borrowBook(Long id);

}
