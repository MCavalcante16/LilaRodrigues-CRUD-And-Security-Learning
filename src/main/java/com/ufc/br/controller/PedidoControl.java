package com.ufc.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.service.PedidoService;

public class PedidoControl {
	
	@Autowired
	public PedidoService pedidoService; 
	
	
//	//TODO Carrinho de Compras
//	@PostMapping("/bolos/pedir/{codigo}")
//	public ModelAndView pedir() {
//		ModelAndView mv = new ModelAndView("bolos");
//		
//	}
}
