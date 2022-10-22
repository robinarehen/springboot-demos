package co.net.parking.demosecurity.service;

import java.util.List;
import java.util.Map;

import co.net.parking.demosecurity.model.ModuloModel;
import co.net.parking.demosecurity.model.PaginaModuloModel;
import co.net.parking.demosecurity.model.RolModel;

public interface RolService {

	public RolModel create(RolModel rolModel);

	public List<RolModel> getAll();

	public RolModel getById(Integer idRol);
	
	public Map<String, ModuloModel> getModulosByRol(Integer idRol);
	
	public List<PaginaModuloModel> getPaginasByRolAndModulo(Integer idRol, Integer idModulo);
}
