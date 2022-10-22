package co.net.parking.demosecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.net.parking.demosecurity.model.ModuloModel;
import co.net.parking.demosecurity.model.PaginaModuloModel;

public interface PaginaModuloRepository extends JpaRepository<PaginaModuloModel, Integer> {

	List<PaginaModuloModel> findByModuloModel(ModuloModel moduloModel);

}
