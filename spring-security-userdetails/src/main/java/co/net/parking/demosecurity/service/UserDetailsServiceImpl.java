package co.net.parking.demosecurity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.net.parking.demosecurity.model.UsuarioModel;
import co.net.parking.demosecurity.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UsuarioModel usuarioModel = this.usuarioRepository.findByUsuario(username);
		
		Optional.ofNullable(usuarioModel).orElseThrow(() -> new UsernameNotFoundException("User does not exist"));

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		usuarioModel.getRolUsuarioModels().stream().forEach((rolUsuario) -> {

			rolUsuario.getRolModel().getPaginaRolModels().stream().forEach((paginaRol) -> {

				authorities.add(new SimpleGrantedAuthority(paginaRol.getPaginaModuloModel().getUrl()));
			});
		});

		return new User(usuarioModel.getUsuario(), usuarioModel.getContrasenia(), usuarioModel.isEnabled(), true, true, true, authorities);
	}

}
