package co.net.parking.demosecurity.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.net.parking.demosecurity.model.ModuloModel;
import co.net.parking.demosecurity.repository.ModuloRepository;
import co.net.parking.demosecurity.utils.ConstantsUtil;

@Service
public class ModuloServiceImpl implements ModuloService {

	private ModuloRepository repository;

	public ModuloServiceImpl(ModuloRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public ModuloModel create(ModuloModel modulo) {
		// TODO Auto-generated method stub
		this.validateExist(modulo);
		return this.repository.save(modulo);
	}

	private void validateExist(ModuloModel modulo) {
		// TODO Auto-generated method stub
		Predicate<ModuloModel> predicate = (value) -> {
			boolean validate = value.getNombre().toLowerCase().equals(modulo.getNombre().toLowerCase()) ||
			 value.getLabel().toLowerCase().equals(modulo.getLabel().toLowerCase());
			return validate;
		};
		this.getAll().stream().filter(predicate).findFirst().ifPresent( value -> {
			String mensaje = String.format("%s %s", ConstantsUtil.ERROR_DUPLICADO, ConstantsUtil.MODULO_NOMBRE);
			throw new IllegalArgumentException(mensaje);
		});
	}

	@Override
	public List<ModuloModel> getAll() {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(0, 10);
		return this.repository.findAll(pageable).getContent();
	}

	@Override
	public ModuloModel getById(Integer idModulo) {
		// TODO Auto-generated method stub
		return this.repository.findById(idModulo).orElseThrow(() -> new IllegalArgumentException(ConstantsUtil.ERROR_ID));
	}

}
