package mx.com.magmasoft.satp.vo;

// Generated 02-sep-2012 14:15:10 by Hibernate Tools 3.2.1.GA

/**
 * Miembrofisico generated by hbm2java
 */
public class Miembrofisico implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6196551205135929152L;
	private int idMiembroFisico;
	private String clave;

	private Agrupacionpersonas agrupacionpersonas;
	private Personafisica personafisica;
	private Chofer chofer;
	private Administadorruta administadorruta;
	private Administradormaster administradormaster;
	private Concecionario concecionario;

	public Miembrofisico() {
	}

	public int getIdMiembroFisico() {
		return this.idMiembroFisico;
	}

	public void setIdMiembroFisico(int idMiembroFisico) {
		this.idMiembroFisico = idMiembroFisico;
	}

	public Agrupacionpersonas getAgrupacionpersonas() {
		return this.agrupacionpersonas;
	}

	public void setAgrupacionpersonas(Agrupacionpersonas agrupacionpersonas) {
		this.agrupacionpersonas = agrupacionpersonas;
	}

	public Personafisica getPersonafisica() {
		return this.personafisica;
	}

	public void setPersonafisica(Personafisica personafisica) {
		this.personafisica = personafisica;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Administadorruta getAdministadorruta() {
		return administadorruta;
	}

	public void setAdministadorruta(Administadorruta administadorruta) {
		this.administadorruta = administadorruta;
	}

	public Administradormaster getAdministradormaster() {
		return administradormaster;
	}

	public void setAdministradormaster(Administradormaster administradormaster) {
		this.administradormaster = administradormaster;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public Concecionario getConcecionario() {
		return concecionario;
	}

	public void setConcecionario(Concecionario concecionario) {
		this.concecionario = concecionario;
	}
}
