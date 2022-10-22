package co.net.parking.demosecurity.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import co.net.parking.demosecurity.service.UsuarioService;
import co.net.parking.demosecurity.service.UsuarioServiceImpl;
import co.net.parking.demosecurity.utils.ConstantsUtil;

@Controller
public class HomeController {

	private UsuarioService usuarioService;

	public HomeController(UsuarioServiceImpl usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	@RequestMapping({ "/", "/index", "/login" })
	public String login(Model model) {
		return ConstantsUtil.HOME_LOGIN;
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {

		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();

		logoutHandler.logout(request, null, null);

		return ConstantsUtil.HOME_LOGOUT;
	}

	@RequestMapping("/dashboard")
	public String dashboard(Principal principal, Model model, HttpSession session) {

		if (session != null && session.getAttribute(ConstantsUtil.HOME_MENU) != null) {
			return ConstantsUtil.HOME_PAGE;
		}

		session.setAttribute(ConstantsUtil.HOME_MENU, this.usuarioService.listMenu(principal.getName()));

		return ConstantsUtil.HOME_PAGE;
	}

	@ModelAttribute
	public Model setAttribute(Model model) {
		model.addAttribute(ConstantsUtil.TITLE_PAGE, ConstantsUtil.HOME_NOMBRE);
		return model;
	}
}
