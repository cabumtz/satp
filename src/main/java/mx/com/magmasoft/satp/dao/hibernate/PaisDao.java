/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.magmasoft.satp.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import mx.com.magmasoft.satp.vo.Pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carlos
 */
@Repository
public class PaisDao extends HibernateDaoSupport implements Serializable
{
	public static final long serialVersionUID = 1L;
	
	@Autowired
	public void init(HibernateTemplate hibernateTemplate)
	{
		setHibernateTemplate(hibernateTemplate);
	}
		
	@SuppressWarnings("unchecked")
	public List<Pais> listaPaises()
	{
		return getHibernateTemplate().find("select p from Pais p");
	}
	
	public Pais buscaPaisPorId(Integer paisId)
	{
		return getHibernateTemplate().get(Pais.class, paisId);
	}
	
	public void guardarPais(Pais pais)
	{
		getHibernateTemplate().save(pais);
	}
	
	public void actualizaPais(Pais pais)
	{
		getHibernateTemplate().saveOrUpdate(pais);
	}
	
	public void eliminaPais(Pais pais)
	{
		getHibernateTemplate().delete(pais);
	}
}
