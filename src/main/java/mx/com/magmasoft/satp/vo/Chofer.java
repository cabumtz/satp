package mx.com.magmasoft.satp.vo;

// Generated 02-sep-2012 14:15:10 by Hibernate Tools 3.2.1.GA

/**
 * Chofer generated by hbm2java
 */
public class Chofer implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6572740962092349477L;
	private int idChofer;
	private Miembrofisico miembrofisico;

	public Chofer()
	{
	}

	public Chofer(int idChofer, Miembrofisico miembrofisico)
	{
		this.idChofer = idChofer;
		this.miembrofisico = miembrofisico;
	}

	public int getIdChofer()
	{
		return this.idChofer;
	}

	public void setIdChofer(int idChofer)
	{
		this.idChofer = idChofer;
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