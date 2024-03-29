package project.com.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import project.com.model.Auther;
import project.com.model.Books;
import project.com.utility.HibernateUtil;

public class BookDaoImpl implements BookDao{
static Scanner sc=new Scanner(System.in);
static Books book=new Books();
static Auther auther = new Auther();
	public Books addBook(Books books) {
		try (Session session = HibernateUtil.getSession()) {
			//Begin Transaction
			session.beginTransaction();
			 // Check if author name is provided in the book object
	        if (book.getAuther() != null) {
	            
	                book.getAuther().getBooks().add(books);
	            
	        } else if (book.getAutherName() != null && !book.getAutherName().isEmpty()) {
	            // Create a new Author object if author name is provided
	            Auther auther = new Auther(book.getAutherName(), new ArrayList<>());
	            auther.getBooks().add(books);
	            auther.setName(book.getAutherName());
	            book.setAuther(auther);
	            
	        } else {
	            System.out.println("Warning: No author information provided for book!");
	        }
			
			session.save(books);
			
			session.getTransaction().commit();
			session.close();
			return  books;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Books> getAllBooks() {
		try (Session session = HibernateUtil.getSession()) {
			//Begin Transaction
			//execute HQL query to retrieve all students data
			Query<Books> query=session.createQuery("FROM Books");
			List<Books> bookList=query.list();
			return bookList;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Books getBook(long bookId) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			Books book = (Books) session.get(Books.class, bookId);
	//		session.save(book);
			session.getTransaction().commit();
			session.close();
			return book;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Books updateBook(long bookId, Books updateBook) {
		try (Session session = HibernateUtil.getSession()) {
			Books book=session.get(Books.class, bookId);
			session.beginTransaction();
			book.setBookId(bookId);
			book.setTitle(updateBook.getTitle());
			book.setAutherName(updateBook.getAutherName());
			book.setPublicationYear(updateBook.getPublicationYear());
			book.setGener(updateBook.getGener());
			session.save(book);
			session.getTransaction().commit();
			session.close();
			return  book;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public String deleteBook(long bookId) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Books book=session.get(Books.class, bookId);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete? if yes type y");
				String status=sc.next();
				if(status.equalsIgnoreCase("y"))
				{
					session.delete(book);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(book);//data will remove from session Cache
					message="Object is deleted";
					
				}else
				{
					message="User wants to retain this object!!";
				}
				
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return message;
	}
}


