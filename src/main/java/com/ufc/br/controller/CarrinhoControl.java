package com.ufc.br.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Bolo;
import com.ufc.br.model.Usuario;
import com.ufc.br.service.BoloService;
import com.ufc.br.service.UsuarioService;

@Controller
public class CarrinhoControl {
	
	@Autowired
	public UsuarioService usuarioServ;
	
	@Autowired
	public BoloService boloServ;
	
	@RequestMapping("/carrinho/add/{boloId}")
	public ModelAndView adicionarAoCarrinho(@PathVariable Long boloId, Principal principal) {
		ModelAndView mv = new ModelAndView("carrinho");
		
		Bolo boro = boloServ.buscarPorId(boloId);
		
		Usuario us = usuarioServ.buscarPorLogin(principal.getName());
		
		us.getCarrinho().add(boro);
		
		usuarioServ.atualizar(us);
		mv.addObject("carrinho", us.getCarrinho());
		
		return mv;
	}
	
	@RequestMapping("/carrinho")
	public ModelAndView getCarrinho(Principal principal) {
		ModelAndView mv = new ModelAndView("carrinho");
		
		Usuario us = usuarioServ.buscarPorLogin(principal.getName());
		
		mv.addObject("carrinho", us.getCarrinho());
		return mv;
	}
	
	@RequestMapping("/carrinho/excluir/{codigo}")
	public ModelAndView excluir(@PathVariable Long codigo) {
		boloServ.excluirBolo(codigo);
		ModelAndView mv = new ModelAndView("redirect:/carrinho");
		return mv;
	}
	
	@PostMapping("/carrinho/pedir")
	public ModelAndView pedir(@PathVariable Long codigo) {
		boloServ.excluirBolo(codigo);
		ModelAndView mv = new ModelAndView("redirect:/carrinho");
		return mv;
	}
}
