CREATE TABLE livros (
    id serial PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    pages INTEGER,
    publisher VARCHAR(255),
    genre VARCHAR(100)
);
