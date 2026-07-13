package co.net.parking.demosecurity.config;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("securityCheckUrlAccess")
public class SecurityCheckUrlAccessConfig {

	public boolean checkUrlAccess(HttpServletRequest request, Authentication authentication) {
		// Si el usuario no está autenticado, denegamos el acceso directamente
		if (Objects.isNull(authentication) || !authentication.isAuthenticated()) {
			return false;
		}

		// Obtenemos la URL que está intentando visitar (ej: "/usuarios" o "/dashboard")
		String requestUri = request.getRequestURI();

		// Recorremos las GrantedAuthority (que tú llenaste con las URLs en tu
		// UserDetailsService)
		boolean hasAccess = authentication.getAuthorities().stream()
				.anyMatch(authority -> requestUri.startsWith(authority.getAuthority()));

		if (!hasAccess) {
			request.setAttribute("errorMessage", "Acceso denegado");
		}

		return hasAccess;
	}
}
