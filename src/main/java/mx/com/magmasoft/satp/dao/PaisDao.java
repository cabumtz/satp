package mx.com.magmasoft.satp.dao;

import java.io.Serializable;
import java.util.List;

import mx.com.magmasoft.satp.vo.Pais;

public interface PaisDao extends Serializable{

	public abstract List<Pais> listaPaises();

	public abstract Pais buscaPaisPorId(Integer paisId);

	public abstract void guardarPais(Pais pais);

	public abstract void actualizaPais(Pais pais);

	public abstract void eliminaPais(Pais pais);

}