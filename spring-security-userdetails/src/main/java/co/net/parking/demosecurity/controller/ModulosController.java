package co.net.parking.demosecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.net.parking.demosecurity.model.ModuloModel;
import co.net.parking.demosecurity.service.ModuloService;
import co.net.parking.demosecurity.service.PaginaModuloService;
import co.net.parking.demosecurity.utils.ConstantsUtil;

@Controller
@RequestMapping("/modulos")
@PreAuthorize("hasAuthority('/modulos')")
public class ModulosController {

	private ModuloService service;
	private PaginaModuloService paginaModuloService;
	private final ModuloModel moduloModel;

	public ModulosController(ModuloService service, PaginaModuloService paginaModuloService) {
		super();
		this.service = service;
		this.paginaModuloService = paginaModuloService;
		this.moduloModel = new ModuloModel();
	}

	@GetMapping
	public String getAdminModulos(Model model) {
		model.addAttribute(ConstantsUtil.MODULO_OBJ_LISTAR, this.service.getAll());
		return ConstantsUtil.MODULO_HOME;
	}

	@GetMapping("/paginas/{idModulo}")
	public String getPaginasModulo(Model model, @PathVariable Integer idModulo) {
		model.addAttribute(ConstantsUtil.PAGINA_OBJ_LISTAR, this.paginaModuloService.getByModulo(idModulo));
		model.addAttribute(ConstantsUtil.TITLE_PAGE, ConstantsUtil.MODULO_TIT_PAGINAS);
		return ConstantsUtil.MODULO_PAGINAS;
	}

	@GetMapping("/crear")
	@PreAuthorize("hasAuthority('/modulos/crear')")
	public String getCrearModulo(Model model) {
		model.addAttribute(ConstantsUtil.MODULO_OBJ_CREAR, this.moduloModel);
		model.addAttribute(ConstantsUtil.TITLE_PAGE, ConstantsUtil.MODULO_TIT_CREAR);
		return ConstantsUtil.MODULO_CREAR;
	}

	@PostMapping("/crear")
	@PreAuthorize("hasAuthority('/modulos/crear')")
	public String postCrearModulo(Model model,
			@ModelAttribute(ConstantsUtil.MODULO_OBJ_CREAR) ModuloModel moduloModel) {

		this.service.create(moduloModel);

		model.addAttribute(ConstantsUtil.RESPUESTA_CREAR, HttpStatus.CREATED.value());
		model.addAttribute(ConstantsUtil.MODULO_OBJ_CREAR, this.moduloModel);
		model.addAttribute(ConstantsUtil.TITLE_PAGE, ConstantsUtil.MODULO_TIT_CREAR);
		return ConstantsUtil.MODULO_CREAR;
	}

	@ModelAttribute
	public Model setAttribute(Model model) {
		model.addAttribute(ConstantsUtil.TITLE_PAGE, ConstantsUtil.MODULO_NOMBRE);
		model.addAttribute(ConstantsUtil.ACTIVE_MODULE, ConstantsUtil.MODULO_NOMBRE);
		return model;
	}
}
