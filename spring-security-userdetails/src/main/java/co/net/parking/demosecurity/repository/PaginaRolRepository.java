package co.net.parking.demosecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.net.parking.demosecurity.model.PaginaRolModel;
import co.net.parking.demosecurity.model.RolModel;

public interface PaginaRolRepository extends JpaRepository<PaginaRolModel, Integer> {

	List<PaginaRolModel> findByRolModel(RolModel rolModel);

	List<PaginaRolModel> findAllByRolModelIn(List<RolModel> rolsModel);

}
