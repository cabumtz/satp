package mx.com.magmasoft.satp.vo;

// Generated 02-sep-2012 14:15:10 by Hibernate Tools 3.2.1.GA


/**
 * Estatuslicenciaconducir generated by hbm2java
 */
public class Estatuslicenciaconducir implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7891272799981960969L;
	private int idEstatusLicenciaConducir;
	private String nombre;

	public Estatuslicenciaconducir()
	{
	}

	public Estatuslicenciaconducir(int idEstatusLicenciaConducir)
	{
		this.idEstatusLicenciaConducir = idEstatusLicenciaConducir;
	}

	public Estatuslicenciaconducir(int idEstatusLicenciaConducir, String nombre)
	{
		this.idEstatusLicenciaConducir = idEstatusLicenciaConducir;
		this.nombre = nombre;

	}

	public int getIdEstatusLicenciaConducir()
	{
		return this.idEstatusLicenciaConducir;
	}

	public void setIdEstatusLicenciaConducir(int idEstatusLicenciaConducir)
	{
		this.idEstatusLicenciaConducir = idEstatusLicenciaConducir;
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