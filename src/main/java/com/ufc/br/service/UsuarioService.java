package com.ufc.br.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ufc.br.model.Role;
import com.ufc.br.model.RoleNum;
import com.ufc.br.model.Usuario;
import com.ufc.br.repository.UsuariosDataBase;

@Service
public class UsuarioService {

	@Autowired
	public UsuariosDataBase usersData; 
	
	
	public void cadastrar(Usuario usuario) {
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		
		
		Role role = new Role();
		role.setPapel(RoleNum.ROLE_USER);
		List<Role> rolesC = new ArrayList<Role>();
		rolesC.add(role);
 		usuario.setRoles(rolesC);
		usersData.save(usuario);
	}
	
	public void atualizar(Usuario usuario) {
		if (usuario.getId() != null) {
			usersData.save(usuario);
		}
	}
	
	public List<Usuario> listaTodos(){
		return usersData.findAll();
	}
	
	public void excluir(Long id) {
		usersData.deleteById(id);
	}
	
	public Usuario buscarPorId(Long id) {
		return usersData.getOne(id);
	}
	
	public Usuario buscarPorLogin(String login) {
		return usersData.findByLogin(login);
	}
}
