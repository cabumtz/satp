/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.magmasoft.satp.dao.misc;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author Carlos
 */
public class HibernateUtil
{

	private static final SessionFactory sessionFactory;
	
	static
	{
		try
		{
			// Create the SessionFactory from standard (hibernate.cfg.xml) 
			// config file.
			Configuration conf = new Configuration();
			
			sessionFactory = conf.configure().buildSessionFactory();
		}
		catch (Throwable ex)
		{
			// Log the exception. 
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
