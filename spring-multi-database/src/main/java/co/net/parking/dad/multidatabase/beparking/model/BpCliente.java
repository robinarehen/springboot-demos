package co.net.parking.dad.multidatabase.beparking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BpCliente")
public class BpCliente {

	@Id
	@Column(name = "Cedula")
	private String Cedula;

	@Column(name = "Nombres")
	private String Nombres;

	public BpCliente() {
		super();
	}

	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

}
