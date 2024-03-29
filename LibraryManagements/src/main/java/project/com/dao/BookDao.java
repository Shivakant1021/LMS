package project.com.dao;

import java.util.List;

import project.com.model.Books;

public interface BookDao {
	Books addBook(Books books);
	List<Books> getAllBooks();
	Books getBook(long bookId);
	Books updateBook(long bookId,Books books);
	String deleteBook(long bookId);

}
