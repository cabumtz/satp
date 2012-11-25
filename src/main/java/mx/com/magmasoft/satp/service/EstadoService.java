/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.magmasoft.satp.service;

import java.io.Serializable;
import java.util.List;
import mx.com.magmasoft.satp.dao.hibernate.EstadoDao;
import mx.com.magmasoft.satp.vo.Estado;

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
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EstadoService implements Serializable
{

	public static final long serialVersionUID = 1L;
	private EstadoDao estadoDao;

	public EstadoDao getEstadoDao()
	{
		return estadoDao;
	}

	@Autowired
	public void setEstadoDao(EstadoDao estadoDao)
	{
		this.estadoDao = estadoDao;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	public List<Estado> listaEstadosPorIdPais(Integer idPais)
	{
		return estadoDao.listaEstadosPorIdPais(idPais);
	}
}
