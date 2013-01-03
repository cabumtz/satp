/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.magmasoft.satp.dao.hibernate;

import java.util.List;

import mx.com.magmasoft.satp.dao.ChoferDao;
import mx.com.magmasoft.satp.filtros.busqueda.FiltroChofer;
import mx.com.magmasoft.satp.vo.Chofer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Carlos
 */
@Repository
public class ChoferDaoImpl extends HibernateDaoSupport implements ChoferDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7031339299392026694L;

	@Autowired
	public void init(HibernateTemplate hibernateTemplate) {
		setHibernateTemplate(hibernateTemplate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.magmasoft.satp.dao.hibernate.IChoferDao#listaChoferes()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Chofer> listaChoferes() {
		return getHibernateTemplate().find("select c from Chofer c");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.magmasoft.satp.dao.hibernate.IChoferDao#guardar(mx.com.magmasoft
	 * .satp.vo.Chofer)
	 */
	@Override
	public Integer guardar(Chofer chofer) {
		return (Integer) getHibernateTemplate().save(chofer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.magmasoft.satp.dao.hibernate.IChoferDao#getListaChoferesPorRuta
	 * (java.lang.Integer)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Chofer> getListaChoferesPorRuta(Integer idRuta) {
		// Chofer chofer;
		// chofer.getMiembrofisico()
		return getHibernateTemplate()
				.find("select c from Chofer c, Miembrofisico mf, Agrupacionpersonas ap where ",
						idRuta);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.magmasoft.satp.dao.hibernate.IChoferDao#getListaChoferesPorFiltro
	 * (mx.com.magmasoft.satp.filtros.busqueda.FiltroChofer)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Chofer> getListaChoferesPorFiltro(FiltroChofer filtro) {
		return getHibernateTemplate().find("select c from Chofer c");
	}
}
