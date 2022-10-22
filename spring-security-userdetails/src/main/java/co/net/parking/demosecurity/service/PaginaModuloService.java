package co.net.parking.demosecurity.service;

import java.util.List;

import co.net.parking.demosecurity.model.PaginaModuloModel;

public interface PaginaModuloService {

	public PaginaModuloModel create(PaginaModuloModel paginaModulo);
	
	public List<PaginaModuloModel> getAll();
	
	public List<PaginaModuloModel> getByModulo(Integer idModulo);
}
