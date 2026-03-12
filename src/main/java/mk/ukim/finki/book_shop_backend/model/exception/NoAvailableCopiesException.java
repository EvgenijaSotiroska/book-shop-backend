package mk.ukim.finki.book_shop_backend.model.exception;

public class NoAvailableCopiesException extends RuntimeException {
    public NoAvailableCopiesException(String message) {
        super(message);
    }
}
