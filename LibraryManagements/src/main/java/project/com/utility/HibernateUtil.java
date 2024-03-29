package project.com.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import project.com.model.Auther;
import project.com.model.Books;
import project.com.model.Gener;
import project.com.model.Member;

public class HibernateUtil {
	private final static SessionFactory sessionfactory=buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
		return new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Books.class)
				.addAnnotatedClass(Auther.class)
				.addAnnotatedClass(Gener.class)
				.addAnnotatedClass(Member.class)
				.buildSessionFactory();
		}catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionfactory;
	}
	
	public static Session getSession() {
		return getSessionfactory().openSession();
	}

}
