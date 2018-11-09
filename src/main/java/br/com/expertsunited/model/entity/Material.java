package br.com.expertsunited.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	@ManyToOne
	@JoinColumn(name="categoria", nullable = false)
	private Categoria categoria;
	@OneToMany(mappedBy="materialSolicitacao")
	@Column(name="mat_solicitacao")
	private List<MaterialSolicitacao> materialSolicitacao;
	@ManyToMany(mappedBy="grafica")
	private List<Grafica> grafica;

	public Material() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<MaterialSolicitacao> getMaterialSolicitacao() {
		return materialSolicitacao;
	}

	public void setMaterialSolicitacao(List<MaterialSolicitacao> materialSolicitacao) {
		this.materialSolicitacao = materialSolicitacao;
	}

	public List<Grafica> getGrafica() {
		return grafica;
	}

	public void setGrafica(List<Grafica> grafica) {
		this.grafica = grafica;
	}
}
