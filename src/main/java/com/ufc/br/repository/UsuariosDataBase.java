package com.ufc.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufc.br.model.Usuario;

@Repository
public interface UsuariosDataBase extends JpaRepository<Usuario,Long>{
	public Usuario findByLogin(String login);

}
