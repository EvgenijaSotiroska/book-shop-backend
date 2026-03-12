DROP TABLE IF EXISTS book_copies;
CREATE TABLE book_copies (
                             id BIGSERIAL PRIMARY KEY,
                             category VARCHAR(50),
                             state VARCHAR(50),
                             is_borrowed BOOLEAN DEFAULT FALSE,
                             book_id BIGINT NOT NULL,
                             CONSTRAINT fk_book
                                 FOREIGN KEY (book_id)
                                     REFERENCES books(id)
                                     ON DELETE CASCADE

);

INSERT INTO book_copies (category, state, book_id) VALUES
                                                       ('FANTASY', 'GOOD', 1),
                                                       ('FANTASY', 'GOOD', 1),
                                                       ('NOVEL', 'GOOD', 2),
                                                       ('CLASSICS', 'GOOD', 3);