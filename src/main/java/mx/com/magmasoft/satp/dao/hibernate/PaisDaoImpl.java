/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.magmasoft.satp.dao.hibernate;

import java.util.List;

import mx.com.magmasoft.satp.dao.PaisDao;
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
public class PaisDaoImpl extends HibernateDaoSupport implements PaisDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7300995355059215439L;

	@Autowired
	public void init(HibernateTemplate hibernateTemplate) {
		setHibernateTemplate(hibernateTemplate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.magmasoft.satp.dao.hibernate.IPaisDao#listaPaises()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Pais> listaPaises() {
		return getHibernateTemplate().find("select p from Pais p");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.magmasoft.satp.dao.hibernate.IPaisDao#buscaPaisPorId(java.lang
	 * .Integer)
	 */
	@Override
	public Pais buscaPaisPorId(Integer paisId) {
		return getHibernateTemplate().get(Pais.class, paisId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.magmasoft.satp.dao.hibernate.IPaisDao#guardarPais(mx.com.magmasoft
	 * .satp.vo.Pais)
	 */
	@Override
	public void guardarPais(Pais pais) {
		getHibernateTemplate().save(pais);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.magmasoft.satp.dao.hibernate.IPaisDao#actualizaPais(mx.com.magmasoft
	 * .satp.vo.Pais)
	 */
	@Override
	public void actualizaPais(Pais pais) {
		getHibernateTemplate().saveOrUpdate(pais);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.magmasoft.satp.dao.hibernate.IPaisDao#eliminaPais(mx.com.magmasoft
	 * .satp.vo.Pais)
	 */
	@Override
	public void eliminaPais(Pais pais) {
		getHibernateTemplate().delete(pais);
	}
}
