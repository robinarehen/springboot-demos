package co.net.parking.dad.multidatabase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.net.parking.dad.multidatabase.beparking.model.BpCliente;
import co.net.parking.dad.multidatabase.parking.model.Transv130;
import co.net.parking.dad.multidatabase.service.BpClienteService;
import co.net.parking.dad.multidatabase.service.Transv130Service;

@Controller
public class WebController {

	private BpClienteService service;
	private Transv130Service transv130Service;

	public WebController(BpClienteService service, Transv130Service transv130Service) {
		super();
		this.service = service;
		this.transv130Service = transv130Service;
	}

	@RequestMapping("/")
	public String index() {

		for (BpCliente bpcliente : this.service.getFindAll()) {

			System.out.println(bpcliente.getCedula());

			break;
		}
		
		for(Transv130 transv: transv130Service.getFindAll()) {
			
			System.out.println(transv.getNum_factura());
			
			break;
		}

		return "index";
	}
}
