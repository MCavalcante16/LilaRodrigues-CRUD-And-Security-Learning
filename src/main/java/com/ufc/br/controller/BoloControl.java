package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Bolo;
import com.ufc.br.model.Usuario;
import com.ufc.br.service.BoloService;

@Controller
public class BoloControl {
	
	@Autowired
	private BoloService boloService;
	
	
	@RequestMapping("/inicio")
	public ModelAndView pagInicial() {
		ModelAndView mv = new ModelAndView("inicio");
		return mv;
	}
	
	@RequestMapping("/sobre")
	public ModelAndView sobre() {
		ModelAndView mv = new ModelAndView("sobre");
		return mv;
	}
	
	@RequestMapping("/contato")
	public ModelAndView contato() {
		ModelAndView mv = new ModelAndView("contato");
		return mv;
	}
	
	@RequestMapping("/bolos/newForm")
	public ModelAndView retornarFormBolo() {
		ModelAndView mv = new ModelAndView("cadBolo");
		mv.addObject("bolo", new Bolo());
		return mv;
	}
	
	@PostMapping("/bolos/new")
	public ModelAndView newBolo(@Validated Bolo bolo, BindingResult result, 
			@RequestParam(value="imagem") MultipartFile imagem) {
		
		ModelAndView mv = new ModelAndView("cadBolo");
		
		if(result.hasErrors()) {
			return mv; //Se há erro, nao faz nada
		}
		
		boloService.cadastrar(bolo, imagem);
		
		mv.addObject("mensagem", "Bolo Cadastrado com Sucesso!");
		
		return mv; 
	}
	
	@RequestMapping("/bolos")
	public ModelAndView listarBolos() {
		ModelAndView mv = new ModelAndView("bolos");
		List<Bolo> bolos = boloService.listaTodos();
		mv.addObject("listaBolos", bolos);
		return mv; 
	}
	
	@RequestMapping("/bolos/excluir/{codigo}")
	public ModelAndView excluir(@PathVariable Long codigo) {
		boloService.excluirBolo(codigo);
		ModelAndView mv = new ModelAndView("redirect:/bolos");
		return mv;
	}
	
	
	@RequestMapping("/bolos/atualizar/{codigo}")
	public ModelAndView atualizar(@PathVariable Long codigo) {
		Bolo bolo = boloService.buscarPorId(codigo);
		ModelAndView mv = new ModelAndView("cadBolo");
		mv.addObject("bolo", bolo);
		return mv;
	}
	
	
	
	
	//Pensar no Controller e executar pensamento
	//Criar Tipos de Usuários
	//Harmonizar com a pagina o processo de registro
	

	
}
