package br.com.expertsunited.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_juridico")
public class ClienteJuridico extends Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	
	public ClienteJuridico() {
		// TODO Auto-generated constructor stub
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
