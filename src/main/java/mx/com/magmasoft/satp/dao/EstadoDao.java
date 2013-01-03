package mx.com.magmasoft.satp.dao;

import java.io.Serializable;
import java.util.List;

import mx.com.magmasoft.satp.vo.Estado;

public interface EstadoDao extends Serializable{

	public abstract List<Estado> listaEstadosPorIdPais(Integer idPais);

}