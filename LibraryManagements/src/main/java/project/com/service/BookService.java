package project.com.service;

import java.util.List;

import project.com.model.Books;

public interface BookService {
	Books addBook(Books books);
	List<Books> getAllBooks();
	Books getBook(long bId);
	Books updateBook(long bookId,Books books);
	String deleteBook(long bookId);

}
