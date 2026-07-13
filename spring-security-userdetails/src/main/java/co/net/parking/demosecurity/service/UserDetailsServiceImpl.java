package co.net.parking.demosecurity.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.net.parking.demosecurity.model.PaginaModuloModel;
import co.net.parking.demosecurity.model.PaginaRolModel;
import co.net.parking.demosecurity.model.RolModel;
import co.net.parking.demosecurity.model.RolUsuarioModel;
import co.net.parking.demosecurity.model.UsuarioModel;
import co.net.parking.demosecurity.repository.PaginaRolRepository;
import co.net.parking.demosecurity.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UsuarioRepository usuarioRepository;
	private final PaginaRolRepository paginaRolRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UsuarioModel usuarioModel = this.usuarioRepository.findByUsuario(username);

		Optional.ofNullable(usuarioModel).orElseThrow(() -> new UsernameNotFoundException("User does not exist"));

		List<RolModel> roles = usuarioModel.getRolUsuarioModels().stream().map(RolUsuarioModel::getRolModel)
				.collect(Collectors.toList());

		List<GrantedAuthority> authorities = this.paginaRolRepository.findAllByRolModel(roles).stream()
				.map(PaginaRolModel::getPaginaModuloModel)
				.map(PaginaModuloModel::getUrl)
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());

		return new User(usuarioModel.getUsuario(), usuarioModel.getContrasenia(), usuarioModel.isEnabled(), true, true,
				true, authorities);
	}

}
