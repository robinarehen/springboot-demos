package co.net.parking.dad.multidatabase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.net.parking.dad.multidatabase.parking.model.Transv130;
import co.net.parking.dad.multidatabase.parking.repository.Transv130Repository;

@Service
@Transactional(transactionManager = "beparkingTransactionManager", readOnly = true)
public class Transv130Service {

	@Autowired
	private Transv130Repository repository;
	
	public List<Transv130> getFindAll(){
		return this.repository.findAll();
	}
}
