package co.net.parking.dad.multidatabase.beparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.net.parking.dad.multidatabase.beparking.model.BpCliente;

public interface BpClienteRepository extends JpaRepository<BpCliente, String> {

}
