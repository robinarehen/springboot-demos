package co.net.parking.demosecurity.service;

import java.util.List;
import java.util.Map;

import co.net.parking.demosecurity.model.PaginaModuloModel;
import co.net.parking.demosecurity.model.UsuarioModel;

public interface UsuarioService {

	public UsuarioModel getByUserName(String userName);

	public Map<String, List<PaginaModuloModel>> listMenu(String userName);
	
	public List<UsuarioModel> getAll();
}
