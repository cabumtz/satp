package mx.com.magmasoft.satp.vo;

// Generated 02-sep-2012 14:15:10 by Hibernate Tools 3.2.1.GA

/**
 * Colonia generated by hbm2java
 */
public class Colonia implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9126153070819698121L;
	private int idColonia;
	private Ciudad ciudad;
	private String clave;
	private String nombre;

	public Colonia()
	{
	}

	public Colonia(int idColonia, Ciudad ciudad)
	{
		this.idColonia = idColonia;
		this.ciudad = ciudad;
	}

	public Colonia(int idColonia, Ciudad ciudad, String clave, String nombre)
	{
		this.idColonia = idColonia;
		this.ciudad = ciudad;
		this.clave = clave;
		this.nombre = nombre;
	}

	public int getIdColonia()
	{
		return this.idColonia;
	}

	public void setIdColonia(int idColonia)
	{
		this.idColonia = idColonia;
	}

	public Ciudad getCiudad()
	{
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad)
	{
		this.ciudad = ciudad;
	}

	public String getClave()
	{
		return this.clave;
	}

	public void setClave(String clave)
	{
		this.clave = clave;
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