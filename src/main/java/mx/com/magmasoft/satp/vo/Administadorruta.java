package mx.com.magmasoft.satp.vo;

// Generated 02-sep-2012 14:15:10 by Hibernate Tools 3.2.1.GA

/**
 * Administadorruta generated by hbm2java
 */
public class Administadorruta implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -322351203852985549L;
	private Integer idAdministadorRuta;
	private Miembrofisico miembrofisico;

	public Administadorruta()
	{
	}

	public Administadorruta(Miembrofisico miembrofisico)
	{
		this.miembrofisico = miembrofisico;
	}

	public Integer getIdAdministadorRuta()
	{
		return this.idAdministadorRuta;
	}

	public void setIdAdministadorRuta(Integer idAdministadorRuta)
	{
		this.idAdministadorRuta = idAdministadorRuta;
	}

	public Miembrofisico getMiembrofisico()
	{
		return this.miembrofisico;
	}

	public void setMiembrofisico(Miembrofisico miembrofisico)
	{
		this.miembrofisico = miembrofisico;
	}

}
