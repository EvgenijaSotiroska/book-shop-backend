DROP TABLE books;
CREATE TABLE books (
                       id BIGSERIAL PRIMARY KEY,
                       created_at TIMESTAMP NOT NULL,
                       updated_at TIMESTAMP NOT NULL,
                       name VARCHAR(255) NOT NULL,
                       author_id BIGINT NOT NULL,
                       CONSTRAINT fk_book_author
                           FOREIGN KEY (author_id)
                               REFERENCES authors(id)
                               ON DELETE CASCADE
);

CREATE TABLE book_copies (
                             id BIGSERIAL PRIMARY KEY,
                             category VARCHAR(50),
                             state VARCHAR(50),
                             is_borrowed VARCHAR(6),
                             book_id BIGINT NOT NULL,
                             CONSTRAINT fk_book
                                 FOREIGN KEY (book_id)
                                     REFERENCES books(id)
                                     ON DELETE CASCADE

);

INSERT INTO books (name, author_id, created_at, updated_at) VALUES
                                                                                                   ('Harry Potter and the Philosopher''s Stone', 1, NOW(), NOW()),
                                                                                                   ('A Game of Thrones', 2, NOW(), NOW()),
                                                                                                   ('Les Miserables', 3, NOW(), NOW());

INSERT INTO book_copies (category, state, is_borrowed, book_id) VALUES
                                                                ('FANTASY', 'GOOD', 'false', 1),
                                                                ('FANTASY', 'BAD', 'false', 2),
                                                                ('FANTASY', 'GOOD', 'false', 1);