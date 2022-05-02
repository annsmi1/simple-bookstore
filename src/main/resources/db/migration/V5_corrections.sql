
EXEC sp_rename 'books.author_id', 'category', 'COLUMN';
EXEC sp_rename 'books.category_id', 'author_id', 'COLUMN';
EXEC sp_rename 'books.category', 'category_id', 'COLUMN';
