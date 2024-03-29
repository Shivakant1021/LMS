package project.com.service;

import java.util.List;
import java.util.Scanner;

import project.com.dao.*;
import project.com.model.Books;

public class BookServiceImpl implements BookService{
	static Scanner sc = new Scanner(System.in);
	BookDao bdao = new BookDaoImpl();     //Creating BookDao Object
	@Override
	public Books addBook(Books books) {
		
		return bdao.addBook(books);
	}

	@Override
	public List<Books> getAllBooks() {
		// TODO Auto-generated method stub
		return bdao.getAllBooks();
	}

	@Override
	public Books getBook(long bookId) {
		// TODO Auto-generated method stub
		return bdao.getBook(bookId);
	}

	@Override
	public Books updateBook(long bookId, Books updateBook) {
		// TODO Auto-generated method stub
		return bdao.updateBook(bookId, updateBook);
	}

	@Override
	public String deleteBook(long bookId) {
		// TODO Auto-generated method stub
		return bdao.deleteBook(bookId);
	}
}	

