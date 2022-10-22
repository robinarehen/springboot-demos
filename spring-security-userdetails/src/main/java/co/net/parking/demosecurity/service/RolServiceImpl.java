package co.net.parking.demosecurity.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.net.parking.demosecurity.model.ModuloModel;
import co.net.parking.demosecurity.model.PaginaModuloModel;
import co.net.parking.demosecurity.model.PaginaRolModel;
import co.net.parking.demosecurity.model.RolModel;
import co.net.parking.demosecurity.repository.RolRepository;
import co.net.parking.demosecurity.utils.ConstantsUtil;

@Service
public class RolServiceImpl implements RolService {

	private RolRepository repository;

	public RolServiceImpl(RolRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public RolModel create(RolModel rolModel) {
		// TODO Auto-generated method stub
		this.validateExist(rolModel);
		return this.repository.save(rolModel);
	}

	private void validateExist(RolModel rolModel) {
		// TODO Auto-generated method stub
		Predicate<RolModel> predicate = (rol) -> {
			String nuevoRol = rolModel.getNombre().toLowerCase();
			return rol.getNombre().toLowerCase().equals(nuevoRol);
		};
		this.getAll().stream().filter(predicate).findFirst().ifPresent(value -> {
			String mensaje = String.format("%s %s", ConstantsUtil.ERROR_DUPLICADO, ConstantsUtil.ROL_NOMBRE);
			throw new IllegalArgumentException(mensaje);
		});
	}

	@Override
	public List<RolModel> getAll() {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(0, 10);
		return this.repository.findAll(pageable).getContent();
	}

	@Override
	public RolModel getById(Integer idRol) {
		// TODO Auto-generated method stub
		return this.repository.findById(idRol).orElseThrow(() -> new IllegalArgumentException(ConstantsUtil.ERROR_ID));
	}

	@Override
	public Map<String, ModuloModel> getModulosByRol(Integer idRol) {
		// TODO Auto-generated method stub
		Map<String, ModuloModel> modulosRol = new HashMap<>();

		this.getById(idRol).getPaginaRolModels().stream().forEach(paginas -> {
			String key = paginas.getPaginaModuloModel().getModuloModel().getLabel();
			if (!modulosRol.containsKey(key)) {
				modulosRol.put(key, paginas.getPaginaModuloModel().getModuloModel());
			}
		});

		return modulosRol;
	}

	@Override
	public List<PaginaModuloModel> getPaginasByRolAndModulo(Integer idRol, Integer idModulo) {
		// TODO Auto-generated method stub
		Predicate<PaginaRolModel> predicate = (paginas) -> {
			return paginas.getPaginaModuloModel().getModuloModel().getIdModulo() == idModulo;
		};

		return this.getById(idRol).getPaginaRolModels().stream().filter(predicate).map(paginas -> {
			return paginas.getPaginaModuloModel();
		}).collect(Collectors.toList());

	}

}
