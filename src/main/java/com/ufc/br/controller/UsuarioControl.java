package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Usuario;
import com.ufc.br.service.UsuarioService;

@Controller
public class UsuarioControl {

	@Autowired
	public UsuarioService usuarioServ;
	
	@RequestMapping("/cadastro")
	public ModelAndView cadastroUsuario() {
		ModelAndView mv = new ModelAndView("cadastro");
		mv.addObject(new Usuario());
		return mv;
	}
	
	
	@PostMapping("/cadastro/new")
	public ModelAndView newUsuario(@Validated Usuario usuario, BindingResult result) {
		ModelAndView mv = new ModelAndView("cadastro");
		
		if(result.hasErrors()) {
			return mv; //Se há erro, nao faz nada
		} 
		
		usuarioServ.cadastrar(usuario);
		
		mv.addObject("mensagem", "Usuário Cadastrado com Sucesso!");
		
		return mv; 
	}
	
	@RequestMapping("/cadastro/excluir/{codigo}")
	public ModelAndView excluir(@PathVariable Long codigo) {
		usuarioServ.excluir(codigo);
		ModelAndView mv = new ModelAndView("redirect:/cadastro");
		return mv;
	}
	
	
	@RequestMapping("/cadastro/atualizar/{codigo}")
	public ModelAndView atualizar(@PathVariable Long codigo) {
		Usuario usuario = usuarioServ.buscarPorId(codigo);
		ModelAndView mv = new ModelAndView("redirect:/cadastro");
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@RequestMapping("/cadastro/listar")
	public ModelAndView listarBolos() {
		ModelAndView mv = new ModelAndView("listaCadastrados");
		List<Usuario> usuarios = usuarioServ.listaTodos();
		mv.addObject("listaCads", usuarios);
		return mv; 
	}
	
	@RequestMapping("/login")
	public ModelAndView loginView() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
}
