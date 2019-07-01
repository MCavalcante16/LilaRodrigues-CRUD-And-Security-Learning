package com.ufc.br.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity	
public class Usuario implements UserDetails{
	
	//Id para indicar que id é chave, e generated para dar um valor aleatorio para id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//Notblanks para quando o user for criado sem a informacao, retornar a informacao
	@NotBlank(message = "O campo 'nome' não foi preenchido")
	private String nome;
	
	@NotBlank(message = "O campo 'cpf' não foi preenchido")
	private String cpf;
	
	@NotNull(message = "O campo 'data de nascimento' não foi preenchido")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataNasc;
	

	@NotBlank(message = "O campo 'endereco' não foi preenchido")
	private String endereco;
	
	@NotBlank(message = "O campo 'login' não foi preenchido")
	private String login;
	
	@NotBlank(message = "O campo 'senha' não foi preenchido")
	private String senha;
	
	@NotBlank(message = "O campo 'email' não foi preenchido")
	private String email;
	
	
	//ManyToMany pois a relacao entre roles e users é muitos pra muitos
	//jointable cria a tabela que diz a relacao de cada user com cada role
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( 
	        name = "usuario_roles", 
	        joinColumns = @JoinColumn(
	          name = "usuario_id", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "role_codigo", referencedColumnName = "papel")) 
	private List<Role> roles; 
	
	@ManyToMany()
	@JoinTable(name = "Usuario_Bolo",
	joinColumns = @JoinColumn(name="usuario_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "bolo_id", referencedColumnName = "id"))
	private List<Bolo> carrinho;
	
	public Usuario() {
		carrinho = new ArrayList<>();
		roles = new ArrayList<>();
		dataNasc = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//Funcao pra obter qual a autoridade do usuario
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) this.roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}
	
	public List<Bolo> getCarrinho() {
		return carrinho;
	}
	
	public void setCarrinho(List<Bolo> carrinho) {
		this.carrinho = carrinho;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;	
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
}
