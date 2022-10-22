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

import co.net.parking.demosecurity.model.RolModel;
import co.net.parking.demosecurity.service.RolService;
import co.net.parking.demosecurity.utils.ConstantsUtil;

@Controller
@RequestMapping("/roles")
@PreAuthorize("hasAuthority('/roles')")
public class RolesController {

	private RolService service;
	private final RolModel rolModel;

	public RolesController(RolService service) {
		super();
		this.service = service;
		this.rolModel = new RolModel();
	}

	@GetMapping
	public String getAdminRoles(Model model) {
		model.addAttribute(ConstantsUtil.ROL_OBJ_LISTAR, this.service.getAll());
		return ConstantsUtil.ROL_HOME;
	}

	@GetMapping("/modulos/{idRol}")
	public String getModulosRol(Model model, @PathVariable Integer idRol) {
		model.addAttribute(ConstantsUtil.ROL_OBJ_DATA, this.service.getById(idRol));
		model.addAttribute(ConstantsUtil.ROL_OBJ_MODULOS, this.service.getModulosByRol(idRol));
		model.addAttribute(ConstantsUtil.TITLE_PAGE, ConstantsUtil.ROL_TIT_MODULOS);
		return ConstantsUtil.ROL_MODULOS;
	}

	@GetMapping("/paginas/{idRol}/{idModulo}")
	public String getPaginasRol(Model model, @PathVariable Integer idRol, @PathVariable Integer idModulo) {
		model.addAttribute(ConstantsUtil.ROL_OBJ_DATA, this.service.getById(idRol));
		model.addAttribute(ConstantsUtil.PAGINA_OBJ_LISTAR, this.service.getPaginasByRolAndModulo(idRol, idModulo));
		model.addAttribute(ConstantsUtil.TITLE_PAGE, ConstantsUtil.ROL_TIT_PAGINAS);
		return ConstantsUtil.ROL_PAGINAS;
	}

	@GetMapping("/crear")
	@PreAuthorize("hasAuthority('/roles/crear')")
	public String getCrearRol(Model model) {
		model.addAttribute(ConstantsUtil.ROL_OBJ_CREAR, this.rolModel);
		model.addAttribute(ConstantsUtil.TITLE_PAGE, ConstantsUtil.ROL_TIT_CREAR);
		return ConstantsUtil.ROL_CREAR;
	}

	@PostMapping("/crear")
	@PreAuthorize("hasAuthority('/roles/crear')")
	public String postCrearRol(Model model, @ModelAttribute(ConstantsUtil.ROL_OBJ_CREAR) RolModel rolModel) {

		this.service.create(rolModel);

		model.addAttribute(ConstantsUtil.RESPUESTA_CREAR, HttpStatus.CREATED.value());
		model.addAttribute(ConstantsUtil.ROL_OBJ_CREAR, this.rolModel);
		model.addAttribute(ConstantsUtil.TITLE_PAGE, ConstantsUtil.ROL_TIT_CREAR);
		return ConstantsUtil.ROL_CREAR;
	}

	@ModelAttribute
	public Model setAttribute(Model model) {
		model.addAttribute(ConstantsUtil.TITLE_PAGE, ConstantsUtil.ROL_NOMBRE);
		model.addAttribute(ConstantsUtil.ACTIVE_MODULE, ConstantsUtil.ROL_NOMBRE);
		return model;
	}
}
