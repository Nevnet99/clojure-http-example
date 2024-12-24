-- Create the bookstore database
CREATE DATABASE bookstore;

-- Switch to the bookstore database
\c bookstore

-- Create the users table
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    hash VARCHAR(255) NOT NULL,
    permissions TEXT[] NOT NULL DEFAULT ARRAY['USER']
);

-- Create the books table
CREATE TABLE IF NOT EXISTS books (
    book_id SERIAL PRIMARY KEY, 
    title VARCHAR(255) NOT NULL, 
    author VARCHAR(255) NOT NULL, 
    publisher VARCHAR(255),
    publication_date DATE, 
    isbn VARCHAR(13) UNIQUE,
    genre VARCHAR(100),
    language VARCHAR(50) DEFAULT 'English', 
    pages INT CHECK (pages > 0), 
    summary TEXT, 
    cover_image_url TEXT
);

-- Insert users with more realistic examples and hashed passwords
INSERT INTO users (username, email, hash, permissions) VALUES
    ('johndoe', 'john.doe@example.com', 'hashed_password_1', ARRAY['USER']),
    ('janedoe', 'jane.doe@example.com', 'hashed_password_2', ARRAY['ADMIN']),
    ('adminuser', 'admin@example.com', 'hashed_password_3', ARRAY['ADMIN', 'OWNER']),
    ('guest', 'guest@example.com', 'hashed_password_4', ARRAY['USER']),
    -- A really cool password
    ('example', 'main-email@email.com', 'bcrypt+sha512$74f45e5a470fd31302ff01a037a8d34b$12$80ccc50ac20ec8824e35f410c625e3682108d473ed21ee6e', ARRAY['ADMIN', "OWNER", "USER"])
ON CONFLICT (email) DO NOTHING;

-- Insert books with meaningful examples
INSERT INTO books (title, author, publisher, publication_date, isbn, genre, language, pages, summary, cover_image_url) VALUES
    ('To Kill a Mockingbird', 'Harper Lee', 'J.B. Lippincott & Co.', '1960-07-11', '9780060935467', 'Fiction', 'English', 281, 
     'A gripping, heart-wrenching, and wholly remarkable tale of coming-of-age in a South poisoned by virulent prejudice.', 
     'https://example.com/covers/to-kill-a-mockingbird.jpg'),
    ('1984', 'George Orwell', 'Secker & Warburg', '1949-06-08', '9780451524935', 'Dystopian', 'English', 328, 
     'A dystopian social science fiction novel and cautionary tale about the dangers of totalitarianism.', 
     'https://example.com/covers/1984.jpg'),
    ('Pride and Prejudice', 'Jane Austen', 'T. Egerton', '1813-01-28', '9780141439518', 'Romance', 'English', 279, 
     'A classic novel of manners that explores the issues of marriage, morality, and misunderstandings.', 
     'https://example.com/covers/pride-and-prejudice.jpg'),
    ('The Great Gatsby', 'F. Scott Fitzgerald', 'Charles Scribners Sons', '1925-04-10', '9780743273565', 'Tragedy', 'English', 180, 
     'A story of the mysterious Jay Gatsby and his unrelenting passion and obsession with Daisy Buchanan.', 
     'https://example.com/covers/the-great-gatsby.jpg');
