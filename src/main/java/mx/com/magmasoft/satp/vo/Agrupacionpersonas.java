package mx.com.magmasoft.satp.vo;

// Generated 02-sep-2012 14:15:10 by Hibernate Tools 3.2.1.GA

/**
 * Agrupacionpersonas generated by hbm2java
 */
public class Agrupacionpersonas implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6140822067747541545L;
	private Integer idAgrupacionPersonas;
	private String nombre;

	public Agrupacionpersonas()
	{
	}

	public Agrupacionpersonas(String nombre)
	{
		this.nombre = nombre;
	}

	public Integer getIdAgrupacionPersonas()
	{
		return this.idAgrupacionPersonas;
	}

	public void setIdAgrupacionPersonas(Integer idAgrupacionPersonas)
	{
		this.idAgrupacionPersonas = idAgrupacionPersonas;
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
