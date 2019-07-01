package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.ufc.br.model.Bolo;
import com.ufc.br.repository.BolosDataBase;
import com.ufc.br.util.BoloUtils;

public class BoloService {

	@Autowired
	private BolosDataBase bolodata; 
	
	
	public void cadastrar(Bolo bolo, MultipartFile imagem) {
		String caminho = "images/" + bolo.getNome() + ".png";
		BoloUtils.salvarImagem(caminho, imagem);  
		bolodata.save(bolo);
	}
	
	public List<Bolo> listaTodos(){
		return bolodata.findAll();
	}
	
	public void excluirBolo(Long id) {
		bolodata.deleteById(id);
	}
	
	public Bolo buscarPorId(Long id) {
		return bolodata.getOne(id);
	}
	
	
}
