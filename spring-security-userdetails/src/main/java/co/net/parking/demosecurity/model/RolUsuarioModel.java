package co.net.parking.demosecurity.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "roles_usuarios")
public class RolUsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRolUsuario;
	private String descripcion;

	@JoinColumn(name = "id_usuario")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private UsuarioModel usuarioModel;

	@JoinColumn(name = "id_rol")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private RolModel rolModel;

}
