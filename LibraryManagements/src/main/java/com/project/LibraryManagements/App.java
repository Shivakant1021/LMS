package com.project.LibraryManagements;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



import project.com.utility.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory=HibernateUtil.getSessionfactory();
    	//create a session(connection)
    	Session session=factory.openSession();
    	MainOperation.mainOps();
    	//Begin a Transaction
    	Transaction tx=session.beginTransaction();
    	tx.commit();
    	session.close();
    	
    	//close Session factory
    	
    	factory.close();
		
		
	}
    	
}
