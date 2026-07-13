package co.net.parking.demosecurity.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roles_usuarios")
public class RolUsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRolUsuario;
	private String descripcion;

	@JoinColumn(name = "id_usuario")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private UsuarioModel usuarioModel;

	@JoinColumn(name = "id_rol")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private RolModel rolModel;

}
