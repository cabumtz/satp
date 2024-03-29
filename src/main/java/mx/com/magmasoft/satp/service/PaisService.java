/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.magmasoft.satp.service;

import java.io.Serializable;
import java.util.List;

import mx.com.magmasoft.satp.dao.PaisDao;
import mx.com.magmasoft.satp.vo.Pais;

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
public class PaisService implements Serializable
{
	public static final long serialVersionUID = 1L;
	
	private PaisDao paisDao;

	
	public PaisDao getPaisDao()
	{
		return paisDao;
	}

	@Autowired
	public void setPaisDao(PaisDao paisDao)
	{
		this.paisDao = paisDao;
	}
	
	@Transactional(propagation= Propagation.REQUIRED,  isolation= Isolation.DEFAULT , readOnly=true)
	public List<Pais> listaPaises()
	{
		return this.paisDao.listaPaises();
	}
	
	

}
