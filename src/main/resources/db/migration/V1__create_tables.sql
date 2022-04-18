CREATE TABLE categories
(
    id INT PRIMARY KEY IDENTITY(1,1),
    [name] VARCHAR(30) NOT NULL,
);

CREATE TABLE authors
(
    id INT PRIMARY KEY IDENTITY(1,1),
    [name] VARCHAR(30) NOT NULL,
    surname VARCHAR(50) NOT NULL
    );

CREATE TABLE books
(
    id INT PRIMARY KEY IDENTITY(1,1),
    title VARCHAR(50) NOT NULL,
    author_id INT NOT NULL FOREIGN KEY REFERENCES categories(id),
    purchased BIT NOT NULL DEFAULT 0,
    category_id INT NOT NULL FOREIGN KEY REFERENCES authors(id),
    [description] VARCHAR(200)
    );


CREATE TABLE users
(
    id INT PRIMARY KEY IDENTITY(1,1),
    [name] VARCHAR(30),
    surname VARCHAR(50),
    email VARCHAR(100) NOT NULL,
    [password] VARCHAR(100) NOT NULL,
    [address] VARCHAR(200)
);

CREATE TABLE transactions
(
    id INT PRIMARY KEY IDENTITY(1,1),
    [date] DATE NOT NULL,
    book_id INT NOT NULL FOREIGN KEY REFERENCES books(id),
    [user_id] INT NOT NULL FOREIGN KEY REFERENCES users(id)
);