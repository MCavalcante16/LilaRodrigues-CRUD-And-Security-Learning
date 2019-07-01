package com.ufc.br.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.ufc.br.model.*;


@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	
	private Long idcliente;
	private Long idprato;
	private String nome;
	private double preco;
	private int qtd;
	
	@ManyToMany()
	@JoinTable(name = "Pedido_Bolo",
	joinColumns = @JoinColumn(name="pedido_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "bolo_id", referencedColumnName = "id"))
	private List<Bolo> bolos;
	
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable( 
//	        name = "pedidos_bolos", 
//	        joinColumns = @JoinColumn(
//	          name = "pedido_id", referencedColumnName = "id"), 
//	        inverseJoinColumns = @JoinColumn(
//	          name = "bolo_id", referencedColumnName = "id")) 
//	private List<Bolo> bolosPedidos;
	
	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public Long getIdprato() {
		return idprato;
	}

	public void setIdprato(Long idprato) {
		this.idprato = idprato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public List<Bolo> getBolos() {
		return bolos;
	}

	public void setBolosPedidos(List<Bolo> bolos) {
		this.bolos = bolos;
	}
	
}
