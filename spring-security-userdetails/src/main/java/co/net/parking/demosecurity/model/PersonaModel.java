package co.net.parking.demosecurity.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	@JoinColumn(name = "id_usuario")
	@OneToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private UsuarioModel usuarioModel;

}
