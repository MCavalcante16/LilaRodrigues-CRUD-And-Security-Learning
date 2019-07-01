package com.ufc.br.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.ufc.br.model.Pedido;
import com.ufc.br.repository.pedidoDataBase;

public class PedidoService {
	@Autowired
	public pedidoDataBase pedidoData; 
	
	
	public void cadastrar(Pedido pedido) {
		pedidoData.save(pedido);
	}
	
	public List<Pedido> listarPedidos(){
		List<Pedido> aux = new ArrayList<Pedido>();
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails) auth;
		
		for (int i = 0; i < pedidoData.findAll().size(); i++) {
			if (pedidoData.findAll().get(i).getIdcliente().equals(user.getUsername())) {
				aux.add(pedidoData.findAll().get(i));
			}
		}
		return aux;
	}
	
	public void excluir(Long id) {
		pedidoData.deleteById(id);
	}
	
	public Pedido buscarPorId(Long id) {
		return pedidoData.getOne(id);
	}


}
