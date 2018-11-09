package br.com.expertsunited.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Grafica implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String cnpj;
	private String nome;
	private String email;
	private String telefone;
	private String login;
	private String senha;
	private boolean fornecedor;
	private int avaliacao;
	@OneToMany(mappedBy="grafica")
	private List<Proposta> proposta;
	@ManyToMany
	@JoinTable(name="grafica_material",
	            joinColumns={@JoinColumn(name="grafica_id")},
	            inverseJoinColumns={@JoinColumn(name="material_id")})
	private List<Material> material;

	public Grafica() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(boolean fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public int getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public List<Proposta> getProposta() {
		return proposta;
	}

	public void setProposta(List<Proposta> proposta) {
		this.proposta = proposta;
	}

	public List<Material> getMaterial() {
		return material;
	}

	public void setMaterial(List<Material> material) {
		this.material = material;
	}
}
