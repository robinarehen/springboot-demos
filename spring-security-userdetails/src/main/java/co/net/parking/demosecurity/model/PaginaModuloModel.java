package co.net.parking.demosecurity.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "paginas_modulo")
@JsonInclude(Include.NON_NULL)
public class PaginaModuloModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaginaModulo;
	private String label;
	private String url;
	private String icono;
	private String descripcion;

	@JoinColumn(name = "id_modulo")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private ModuloModel moduloModel;

	@OneToMany(mappedBy = "paginaModuloModel")
	@JsonManagedReference
	private List<PaginaRolModel> paginaRolModels;

}
