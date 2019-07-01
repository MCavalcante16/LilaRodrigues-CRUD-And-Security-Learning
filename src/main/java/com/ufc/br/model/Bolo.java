package com.ufc.br.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Bolo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id; 
	
	@NotBlank(message = "O campo 'nome' não foi preenchido")
	private String nome;
	
	@NotNull(message = "O campo 'preco' não foi preenchido")
	private float preco;
	
	@ManyToMany(mappedBy = "bolos")
	private List<Pedido> pedidos;
	
	@ManyToMany(mappedBy = "carrinho")
	private List<Usuario> usuarios;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	} 
	
	
}
