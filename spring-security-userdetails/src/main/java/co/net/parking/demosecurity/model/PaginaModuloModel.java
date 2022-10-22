package co.net.parking.demosecurity.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "paginas_modulo")
public class PaginaModuloModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaginaModulo;
	private String label;
	private String url;
	private String icono;
	private String descripcion;

	@JoinColumn(name = "id_modulo")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ModuloModel moduloModel;

	@OneToMany(mappedBy = "paginaModuloModel")
	private List<PaginaRolModel> paginaRolModels;

}
