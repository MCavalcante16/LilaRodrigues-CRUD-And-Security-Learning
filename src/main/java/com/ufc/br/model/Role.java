package com.ufc.br.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
	
	@Id
	private RoleNum papel;
	
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuarios;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.papel.toString();
	}

	public RoleNum getPapel() {
		return papel;
	}

	public void setPapel(RoleNum papel) {
		this.papel = papel;
	}
	
	
	
	
	
	

}
