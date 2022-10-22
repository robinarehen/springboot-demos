package co.net.parking.demosecurity.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class RolModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRol;
	@Column(length = 20, nullable = false)
	private String nombre;
	private String descripcion;

	@OneToMany(mappedBy = "rolModel")
	private List<RolUsuarioModel> rolUsuarioModels;

	@OneToMany(mappedBy = "rolModel", fetch = FetchType.EAGER)
	private List<PaginaRolModel> paginaRolModels;

}
