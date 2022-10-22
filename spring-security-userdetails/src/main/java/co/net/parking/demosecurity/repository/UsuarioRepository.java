package co.net.parking.demosecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.net.parking.demosecurity.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

	UsuarioModel findByUsuario(String usuario);
}
