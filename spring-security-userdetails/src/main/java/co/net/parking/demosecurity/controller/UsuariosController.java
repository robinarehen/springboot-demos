package co.net.parking.demosecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.net.parking.demosecurity.model.UsuarioModel;
import co.net.parking.demosecurity.service.UsuarioService;
import co.net.parking.demosecurity.utils.ConstantsUtil;

@Controller
@RequestMapping("/usuarios")
@PreAuthorize("hasAuthority('/usuarios')")
public class UsuariosController {

	private UsuarioService service;
	private final UsuarioModel usuarioModel;

	public UsuariosController(UsuarioService service) {
		super();
		this.service = service;
		this.usuarioModel = new UsuarioModel();
	}

	@GetMapping
	public String getAdminUsuarios(Model model) {
		model.addAttribute(ConstantsUtil.USUARIO_OBJ_LISTAR, this.service.getAll());
		return ConstantsUtil.USUARIO_HOME;
	}

	@GetMapping("/crear")
	@PreAuthorize("hasAuthority('/usuarios/crear')")
	public String getCrearUsuario(Model model) {
		model.addAttribute(ConstantsUtil.USUARIO_OBJ_CREAR, this.usuarioModel);
		return ConstantsUtil.USUARIO_CREAR;
	}

	@PostMapping("/crear")
	@PreAuthorize("hasAuthority('/usuarios/crear')")
	public String postCrearUsuario(Model model, @ModelAttribute(ConstantsUtil.USUARIO_OBJ_CREAR) UsuarioModel usuarioModel) {
		model.addAttribute(ConstantsUtil.USUARIO_OBJ_CREAR, usuarioModel);
		return ConstantsUtil.USUARIO_CREAR;
	}

	@ModelAttribute
	public Model setAttribute(Model model) {
		model.addAttribute(ConstantsUtil.TITLE_PAGE, ConstantsUtil.USUARIO_NOMBRE);
		model.addAttribute(ConstantsUtil.ACTIVE_MODULE, ConstantsUtil.USUARIO_NOMBRE);
		return model;
	}
}
