package br.com.expertsunited.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Proposta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descricao;
	@Column(name="data_proposta")
	private String dataProposta;
	@ManyToOne
	@JoinColumn(name="solicitacao", nullable = false )
	private Solicitacao solicitacao;
	@ManyToOne
	@JoinColumn(name="grafica", nullable = false)
	private Grafica grafica;
	
	public Proposta() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDataProposta() {
		return dataProposta;
	}
	
	public void setDataProposta(String dataProposta) {
		this.dataProposta = dataProposta;
	}
	
	public Solicitacao getSolicitacao() {
		return solicitacao;
	}
	
	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}
	
	public Grafica getGrafica() {
		return grafica;
	}
	
	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
	}
}
