package co.net.parking.demosecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import co.net.parking.demosecurity.service.PaginaModuloService;
import co.net.parking.demosecurity.utils.ConstantsUtil;

@Controller
@RequestMapping("/paginas")
@PreAuthorize("hasAuthority('/paginas')")
public class PaginasController {

	private PaginaModuloService service;

	public PaginasController(PaginaModuloService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public String getPaginas(Model model) {
		model.addAttribute(ConstantsUtil.PAGINA_OBJ_LISTAR, this.service.getAll());
		return ConstantsUtil.PAGINA_HOME;
	}

	@ModelAttribute
	public Model setAttribute(Model model) {
		model.addAttribute(ConstantsUtil.TITLE_PAGE, ConstantsUtil.PAGINA_NOMBRE);
		model.addAttribute(ConstantsUtil.ACTIVE_MODULE, ConstantsUtil.PAGINA_NOMBRE);
		return model;
	}
}
