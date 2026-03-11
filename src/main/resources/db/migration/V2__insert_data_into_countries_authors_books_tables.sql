INSERT INTO countries (name, continent) VALUES
                                            ('United Kingdom', 'Europe'),
                                            ('United States', 'North America'),
                                            ('France', 'Europe');

INSERT INTO authors (name, surname, country_id, created_at, updated_at) VALUES
                                                                            ('J.K.', 'Rowling', 1, NOW(), NOW()),
                                                                            ('George', 'Martin', 2, NOW(), NOW()),
                                                                            ('Victor', 'Hugo', 3, NOW(), NOW());
INSERT INTO books (name, category, author_id, state, available_copies, created_at, updated_at) VALUES
                                                                                                   ('Harry Potter and the Philosopher''s Stone', 'FANTASY', 1, 'GOOD', 10, NOW(), NOW()),
                                                                                                   ('A Game of Thrones', 'FANTASY', 2, 'BAD', 5, NOW(), NOW()),
                                                                                                   ('Les Miserables', 'CLASSICS', 3, 'GOOD', 3, NOW(), NOW());
