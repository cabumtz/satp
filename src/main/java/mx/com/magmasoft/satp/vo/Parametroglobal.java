package mx.com.magmasoft.satp.vo;

// Generated 02-sep-2012 14:15:10 by Hibernate Tools 3.2.1.GA

/**
 * Parametroglobal generated by hbm2java
 */
public class Parametroglobal implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5700556623119984315L;
	private int idParametroGlobal;
	private String nombre;
	private String valor;

	public Parametroglobal()
	{
	}

	public Parametroglobal(int idParametroGlobal)
	{
		this.idParametroGlobal = idParametroGlobal;
	}

	public Parametroglobal(int idParametroGlobal, String nombre, String valor)
	{
		this.idParametroGlobal = idParametroGlobal;
		this.nombre = nombre;
		this.valor = valor;
	}

	public int getIdParametroGlobal()
	{
		return this.idParametroGlobal;
	}

	public void setIdParametroGlobal(int idParametroGlobal)
	{
		this.idParametroGlobal = idParametroGlobal;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getValor()
	{
		return this.valor;
	}

	public void setValor(String valor)
	{
		this.valor = valor;
	}

}
