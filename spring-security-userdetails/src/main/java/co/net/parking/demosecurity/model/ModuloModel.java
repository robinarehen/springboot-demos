package co.net.parking.demosecurity.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "modulos")
public class ModuloModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idModulo;
	@Column(nullable = false, unique = true)
	private String nombre;
	@Column(nullable = false, unique = true)
	private String label;
	private String icono;
	private String descripcion;

	@OneToMany(mappedBy = "moduloModel")
	private List<PaginaModuloModel> paginaModuloModels;

}
