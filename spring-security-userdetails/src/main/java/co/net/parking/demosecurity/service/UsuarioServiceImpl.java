package co.net.parking.demosecurity.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.net.parking.demosecurity.model.PaginaModuloModel;
import co.net.parking.demosecurity.model.UsuarioModel;
import co.net.parking.demosecurity.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository repository;

	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public UsuarioModel getByUserName(String userName) {
		return this.repository.findByUsuario(userName);
	}

	@Override
	public Map<String, List<PaginaModuloModel>> listMenu(String userName) {

		List<PaginaModuloModel> paginasModulo = new ArrayList<>();

		Map<String, List<PaginaModuloModel>> menuPaginas = new HashMap<>();

		this.repository.findByUsuario(userName).getRolUsuarioModels().forEach(rol -> {
			rol.getRolModel().getPaginaRolModels().forEach(paginas -> {
				String key = paginas.getPaginaModuloModel().getModuloModel().getLabel();
				if (!menuPaginas.containsKey(key)) {
					menuPaginas.put(key, null);
				}
				paginasModulo.add(paginas.getPaginaModuloModel());
			});
		});

		menuPaginas.entrySet().forEach(data -> {
			Predicate<PaginaModuloModel> predicate = (pagina) -> {
				return pagina.getModuloModel().getLabel().equals(data.getKey());
			};
			data.setValue(paginasModulo.stream().filter(predicate).collect(Collectors.toList()));
		});

		return menuPaginas;
	}

	@Override
	public List<UsuarioModel> getAll() {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(0, 10);
		return this.repository.findAll(pageable).getContent();
	}
}
