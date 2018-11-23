package br.com.expertsunited.controler.managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.expertsunited.facade.ClienteFachada;
import br.com.expertsunited.model.entity.Cliente;

@ManagedBean
@SessionScoped
public class ClienteMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	public boolean campo = true;
	@ManagedProperty(value="#{loginMB.cliente}")
	private Cliente cli;
	
	public Cliente getCli() {
		return cli;
	}
	
	public void setCli(Cliente cli) {
		this.cli = cli;
	}
	
	public boolean isCampo() {
		return campo;
	}

	public void setCampo(boolean campo) {
		this.campo = campo;
	}

	public ClienteMB() {
		cliente = new Cliente();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	public void inserir() {
		getCliente().setIsGrafica(0);
		if(this.cliente != null) {
			ClienteFachada fachada = new ClienteFachada();
			try {
				fachada.createCF(cliente);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void editarCliente() {
		ClienteFachada fachada = new ClienteFachada();
		try {
			fachada.updateCliente(cli);
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void desbloquearCampo() {
		this.campo = false;
	}
}
