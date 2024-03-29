package project.com.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import project.com.model.Gener;
import project.com.utility.HibernateUtil;

public class GenerDaoImpl implements GenerDao{

	@Override
	public Gener findGenreByName(Gener generName) {
		try (Session session = HibernateUtil.getSession()) {
			//Begin Transaction
			session.beginTransaction();
			session.save(generName);
			session.getTransaction().commit();
			return  generName;
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
	public Gener addGener(Gener gener) {
		try (Session session = HibernateUtil.getSession()) {
			//Begin Transaction
			session.beginTransaction();
			session.save(gener);
			session.getTransaction().commit();
			return  gener;
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
