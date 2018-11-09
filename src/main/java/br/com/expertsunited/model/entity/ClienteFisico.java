package br.com.expertsunited.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cliente_fisico")
public class ClienteFisico extends Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	
	public ClienteFisico() {
		// TODO Auto-generated constructor stub
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
