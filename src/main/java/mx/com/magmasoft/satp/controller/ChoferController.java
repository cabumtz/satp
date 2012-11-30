package mx.com.magmasoft.satp.controller;

import java.io.Serializable;
import java.util.List;

import mx.com.magmasoft.satp.filtros.busqueda.FiltroChofer;
import mx.com.magmasoft.satp.service.ChoferService;
import mx.com.magmasoft.satp.vo.Chofer;

import org.apache.log4j.Logger;

public class ChoferController implements Serializable{
	
	public static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(ChoferController.class);
	
	private ChoferService choferService;
	
	/*
	private Entidad entidad;
	
	private Personafisica personafisica = new Personafisica(3, null, "Carlos Alberto", "Bañuelos", "Moro", new Date(), null);
	
	private Miembrofisico miembrofisico;
	
	private String datoPrueba = " HOLA A TODOS ";
	*/
	
	public ChoferService getChoferService()
	{
		return choferService;
	}

	public void setChoferService(ChoferService choferService)
	{
		this.choferService = choferService;
	}
	
	public List<Chofer> getListaChoferes() {
		return this.choferService.getListaChoferesPorFiltro(null);
	}
	
}
