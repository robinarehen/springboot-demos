package co.net.parking.demosecurity.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	@JsonManagedReference
	private List<RolUsuarioModel> rolUsuarioModels;

	@OneToMany(mappedBy = "rolModel")
	@JsonManagedReference
	private List<PaginaRolModel> paginaRolModels;

}
