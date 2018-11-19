package br.com.expertsunited.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Solicitacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String titulo;
	@Column(name="data_solicitacao")
	private String dataSolicitacao;
	@Column(name="data_entrega")
	private String dataEntrega;
	@Column(name="possui_arquivo")
	private Boolean possuiArquivo;
	@Column(name="solicita_arte")
	private Boolean solicitaArte;
	private String observacao;
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;
	@OneToMany(mappedBy="solicitacao")
	private List<Proposta> proposta;
	@OneToMany(mappedBy="solicitacao")
	private List<MaterialSolicitacao> materialSolicitacao;
	
	public Solicitacao() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDataSolicitacao() {
		return dataSolicitacao;
	}
	
	public void setDataSolicitacao(String dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	
	public String getDataEntrega() {
		return dataEntrega;
	}
	
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	public Boolean isPossuiArquivo() {
		return possuiArquivo;
	}
	
	public void setPossuiArquivo(Boolean possuiArquivo) {
		this.possuiArquivo = possuiArquivo;
	}
	
	public Boolean isSolicitaArte() {
		return solicitaArte;
	}
	
	public void setSolicitaArte(Boolean solicitaArte) {
		this.solicitaArte = solicitaArte;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Proposta> getProposta() {
		return proposta;
	}
	
	public void setProposta(List<Proposta> proposta) {
		this.proposta = proposta;
	}
	
	public List<MaterialSolicitacao> getMaterialSolicitacao() {
		return materialSolicitacao;
	}
	
	public void setMaterialSolicitacao(List<MaterialSolicitacao> materialSolicitacao) {
		this.materialSolicitacao = materialSolicitacao;
	}
	
	@Override
	public String toString() {
		return this.titulo;
	}
	
	@Override
	public boolean equals(Object obj) {
		//se nao forem objetos da mesma classe sao objetos diferentes
        if(!(obj instanceof Solicitacao)) return false; 

        //se forem o mesmo objeto, retorna true
        if(obj == this) return true;

        // aqui o cast é seguro por causa do teste feito acima
        Solicitacao solicitacao = (Solicitacao) obj; 

        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
        return this.id == solicitacao.getId() &&
                this.titulo.equals(solicitacao.getTitulo());
	}
	
	@Override
	public int hashCode() {
		return this.id;
	}
}
