package co.net.parking.demosecurity.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	@Column(length = 20, nullable = false)
	private String usuario;
	@Column(nullable = false)
	private String contrasenia;
	private boolean enabled;

	@OneToMany(mappedBy = "usuarioModel", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)//solution to MultipleBagFetchException in H2
	private List<RolUsuarioModel> rolUsuarioModels;

	@OneToOne(mappedBy = "usuarioModel")
	private PersonaModel personaModel;

}
