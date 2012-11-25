/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.magmasoft.satp.service;

import java.io.Serializable;
import java.util.List;
import mx.com.magmasoft.satp.dao.hibernate.ChoferDao;
import mx.com.magmasoft.satp.filtros.busqueda.FiltroChofer;
import mx.com.magmasoft.satp.vo.Chofer;
import mx.com.magmasoft.satp.vo.Empresaruta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Carlos
 */
@Service
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS)
public class ChoferService implements Serializable
{
	public static final long serialVersionUID = 1L;
	
	private ChoferDao choferDao;

	public ChoferDao getChoferDao()
	{
		return choferDao;
	}

	@Autowired
	public void setChoferDao(ChoferDao choferDao)
	{
		this.choferDao = choferDao;
	}
	
	@Transactional(propagation= Propagation.REQUIRED,  isolation= Isolation.DEFAULT , readOnly=true)
	public List<Chofer> listaChoferes()
	{
		return this.choferDao.listaChoferes();
	}
	
	@Transactional(propagation= Propagation.REQUIRED,  isolation= Isolation.DEFAULT , readOnly=false)
	public Integer guardar(Chofer chofer)
	{
		return this.choferDao.guardar(chofer);
	}
	
	
	public List<Chofer> getListaChoferesPorRuta(Empresaruta ruta) {
		//return this.choferDao.g
		return null;
	}
	
	@Transactional(propagation= Propagation.REQUIRED,  isolation= Isolation.DEFAULT , readOnly=false)
	public List<Chofer> getListaChoferesPorFiltro(FiltroChofer filtro)
	{
		return this.choferDao.getListaChoferesPorFiltro(filtro);
	}
}
