package mx.com.magmasoft.satp.vo;

// Generated 02-sep-2012 14:15:10 by Hibernate Tools 3.2.1.GA

/**
 * Telefono generated by hbm2java
 */
public class Telefono implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 321759452517705918L;
	private Integer idTelefono;
	private Entidad entidad;
	private Tipotelefono tipotelefono;
	private String numero;
	private String comentario;

	public Telefono()
	{
	}

	public Telefono(Entidad entidad, Tipotelefono tipotelefono, String numero)
	{
		this.entidad = entidad;
		this.tipotelefono = tipotelefono;
		this.numero = numero;
	}

	public Telefono(Entidad entidad, Tipotelefono tipotelefono, String numero,
			String comentario)
	{
		this.entidad = entidad;
		this.tipotelefono = tipotelefono;
		this.numero = numero;
		this.comentario = comentario;
	}

	public Integer getIdTelefono()
	{
		return this.idTelefono;
	}

	public void setIdTelefono(Integer idTelefono)
	{
		this.idTelefono = idTelefono;
	}

	public Entidad getEntidad()
	{
		return this.entidad;
	}

	public void setEntidad(Entidad entidad)
	{
		this.entidad = entidad;
	}

	public Tipotelefono getTipotelefono()
	{
		return this.tipotelefono;
	}

	public void setTipotelefono(Tipotelefono tipotelefono)
	{
		this.tipotelefono = tipotelefono;
	}

	public String getNumero()
	{
		return this.numero;
	}

	public void setNumero(String numero)
	{
		this.numero = numero;
	}

	public String getComentario()
	{
		return this.comentario;
	}

	public void setComentario(String comentario)
	{
		this.comentario = comentario;
	}

}
