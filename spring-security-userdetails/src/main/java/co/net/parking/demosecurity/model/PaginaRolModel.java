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
@Table(name = "paginas_rol")
public class PaginaRolModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaginaRol;

	@JoinColumn(name = "id_pagina_modulo")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private PaginaModuloModel paginaModuloModel;

	@JoinColumn(name = "id_rol")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private RolModel rolModel;

}
