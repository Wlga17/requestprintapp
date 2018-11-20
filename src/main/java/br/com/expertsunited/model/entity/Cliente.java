package br.com.expertsunited.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("Cliente")
@PrimaryKeyJoinColumn(name="idUsuario")
public class Cliente extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String telefone;
	private String email;
	private String cnpj;
	@OneToMany(mappedBy="cliente")
	private List<Solicitacao> solicitacao;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Solicitacao> getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(List<Solicitacao> solicitacao) {
		this.solicitacao = solicitacao;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		//se nao forem objetos da mesma classe sao objetos diferentes
        if(!(obj instanceof Cliente)) return false; 

        //se forem o mesmo objeto, retorna true
        if(obj == this) return true;

        // aqui o cast é seguro por causa do teste feito acima
        Cliente cliente = (Cliente) obj; 

        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
        return this.nome.equals(cliente.getNome());
	}
	
	@Override
	public int hashCode() {
		return this.getIdUsuario();
	}
}
