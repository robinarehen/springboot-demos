package co.net.parking.demosecurity.service;

import java.util.List;

import co.net.parking.demosecurity.model.ModuloModel;

public interface ModuloService {

	public ModuloModel create(ModuloModel modulo);
	
	public List<ModuloModel> getAll();
	
	public ModuloModel getById(Integer idModulo);
}
