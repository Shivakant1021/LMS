package project.com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import project.com.service.*;
import project.com.model.Auther;
import project.com.model.Books;
import project.com.utility.HibernateUtil;

public class AutherDaoImpl implements AutherDao{
Auther auther = new Auther();
static AutherService autherservice = new AutherServiceImpl();
Books book = new Books();
	@Override
	public Auther addAuther(Auther auther) {
		try (Session session = HibernateUtil.getSession()) {
			//Begin Transaction
			session.beginTransaction();
			List<Books>book = new ArrayList();
			auther.setBooks(book);
			session.save(auther);
			session.getTransaction().commit();
			session.close();
			return  auther;
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
	public Auther getAutherById(int autherId) {
		Auther author = null;
		try (Session session = HibernateUtil.getSession()) {
			//Begin Transaction
			session.beginTransaction();
			author = (Auther) session.get(Auther.class, autherId);
			session.save(autherId);
			session.getTransaction().commit();
			session.close();
			return  author;
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
	public Auther getAutherByName(String autherName) {
		Auther author = null;
		try (Session session = HibernateUtil.getSession()) {
			//Begin Transaction
			session.beginTransaction();
			author = (Auther) session.get(Auther.class, autherName);
			session.save(autherName);
			session.getTransaction().commit();
			session.close();
			return  author;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
