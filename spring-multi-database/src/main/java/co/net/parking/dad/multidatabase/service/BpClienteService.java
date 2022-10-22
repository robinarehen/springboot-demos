package co.net.parking.dad.multidatabase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.net.parking.dad.multidatabase.beparking.model.BpCliente;
import co.net.parking.dad.multidatabase.beparking.repository.BpClienteRepository;

@Service
@Transactional(transactionManager = "beparkingTransactionManager", readOnly = true)
public class BpClienteService {

	@Autowired
	private BpClienteRepository repository;
	
	public List<BpCliente> getFindAll(){
		return this.repository.findAll();
	}
}
