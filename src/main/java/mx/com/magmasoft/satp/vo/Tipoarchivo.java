package mx.com.magmasoft.satp.vo;

// Generated 02-sep-2012 14:15:10 by Hibernate Tools 3.2.1.GA

/**
 * Tipoarchivo generated by hbm2java
 */
public class Tipoarchivo implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7920752239095846639L;
	private int idTipoArchivo;
	private String nombre;

	public Tipoarchivo()
	{
	}

	public Tipoarchivo(int idTipoArchivo, String nombre)
	{
		this.idTipoArchivo = idTipoArchivo;
		this.nombre = nombre;
	}

	public int getIdTipoArchivo()
	{
		return this.idTipoArchivo;
	}

	public void setIdTipoArchivo(int idTipoArchivo)
	{
		this.idTipoArchivo = idTipoArchivo;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

}