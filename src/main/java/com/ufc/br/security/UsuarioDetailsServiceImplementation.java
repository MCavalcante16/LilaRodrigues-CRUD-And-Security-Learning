package com.ufc.br.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.ufc.br.model.Usuario;
import com.ufc.br.repository.UsuariosDataBase;


@Repository
@Transactional
public class UsuarioDetailsServiceImplementation implements UserDetailsService{

	@Autowired
	private UsuariosDataBase usuarioData;
	
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioData.findByLogin(login);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Não existe usuário com esse login");
		}
		
		return new User(usuario.getUsername(),usuario.getPassword(),true,true,true,true,usuario.getAuthorities());
		
	}
}
