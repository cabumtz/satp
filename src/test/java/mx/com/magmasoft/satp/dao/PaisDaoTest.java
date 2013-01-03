/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.magmasoft.satp.dao;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import mx.com.magmasoft.satp.dao.hibernate.PaisDaoImpl;
import mx.com.magmasoft.satp.dao.misc.HibernateUtil;
import mx.com.magmasoft.satp.vo.Pais;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Carlos
 */
public class PaisDaoTest
{
	private static final Logger logger = Logger.getLogger(PaisDaoTest.class);
	
	private static PaisDaoImpl instance;
	private static Transaction tx;
	private static SessionFactory sessionFactory;
	
	public PaisDaoTest()
	{
	}

	@BeforeClass
	public static void setUpClass() throws Exception
	{
		
		instance = new PaisDaoImpl();
		sessionFactory = HibernateUtil.getSessionFactory();
		instance.setSessionFactory(sessionFactory);
		
		for(Pais p : instance.listaPaises()) 
		{
			instance.eliminaPais(p);
		}
		
		//sessionFactory.getCurrentSession().close();
		
	}

	@AfterClass
	public static void tearDownClass() throws Exception
	{
		logger.info("tearDownClass");
		instance.getSessionFactory().close();
	}
	
	@Before
	public void setUp()
	{
		logger.debug("setUp");
		//logger.debug("session: " + sessionFactory.getCurrentSession().hashCode());
		//tx = sessionFactory.getCurrentSession().beginTransaction();
	}
	
	@After
	public void tearDown()
	{
		logger.info("tearDown");
	}

	/**
	 * Test of listaPaises method, of class PaisDao.
	 */
	//@Test
	public void testListaPaises()
	{
		System.out.println("listaPaises");
		List<Pais> expResult = Arrays.asList(  );
		List<Pais> result = instance.listaPaises();
		
		assertEquals(expResult, result);
	}
	
	//@Test
	public void testBuscaPaisPorId()
	{
		System.out.println("testBuscaPaisPorId");
		Pais expResult = null;
		Pais result = instance.buscaPaisPorId(Integer.valueOf(5));
		assertEquals(expResult, result);
	}

	/**
	 * Test of guardarPais method, of class PaisDao.
	 */
	//@Test
	public void testGuardarPais()
	{
		System.out.println("guardarPais");
		Pais pais = new Pais(5, "CA2231", "Canada", "CA");
		instance.guardarPais(pais);
	}

	/**
	 * Test of actualizaPais method, of class PaisDao.
	 */
	//@Test
	public void testActualizaPais()
	{
		System.out.println("actualizaPais");
		Pais pais = new Pais(5, "CA444", "Canada", "CAN");
		instance.actualizaPais(pais);
	}

	/**
	 * Test of eliminaPais method, of class PaisDao.
	 */
	//@Test
	public void testEliminaPais()
	{
		System.out.println("eliminaPais");
		Pais pais = new Pais(50, "OCO", "OCOTEPEC", "OCO");
		instance.guardarPais(pais);
		Pais pais2 = instance.buscaPaisPorId(Integer.valueOf(50));
		instance.eliminaPais(pais);
	}
}
