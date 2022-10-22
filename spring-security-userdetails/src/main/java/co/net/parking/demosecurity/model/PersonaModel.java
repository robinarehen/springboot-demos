package co.net.parking.demosecurity.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "datos_personales")
public class PersonaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;
	private String nombres;
	private String apellidos;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	private UsuarioModel usuarioModel;

}
