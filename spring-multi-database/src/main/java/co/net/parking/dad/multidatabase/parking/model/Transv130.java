package co.net.parking.dad.multidatabase.parking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "trans_v130")
@IdClass(value = Transv130.class)
public class Transv130 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "num_factura", insertable = false, updatable = false)
	private Integer num_factura;

	@Id
	@Column(name = "cod_terminal", insertable = false, updatable = false)
	private String cod_terminal;

	@Column(name = "tipo_trans", length = 5)
	private Integer tipo_trans;

	public Transv130() {
		super();
	}

	public Integer getNum_factura() {
		return num_factura;
	}

	public void setNum_factura(Integer num_factura) {
		this.num_factura = num_factura;
	}

	public String getCod_terminal() {
		return cod_terminal;
	}

	public void setCod_terminal(String cod_terminal) {
		this.cod_terminal = cod_terminal;
	}

	public Integer getTipo_trans() {
		return tipo_trans;
	}

	public void setTipo_trans(Integer tipo_trans) {
		this.tipo_trans = tipo_trans;
	}


}
