package br.com.expertsunited.controler.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.expertsunited.facade.ClienteFachada;
import br.com.expertsunited.model.entity.Cliente;

@ManagedBean()
public class clienteMB {

	Cliente cliente = new Cliente();
	
	boolean campo = true;
	
	public boolean isCampo() {
		return campo;
	}

	public void setCampo(boolean campo) {
		this.campo = campo;
	}
	List<Cliente> listaCliente;
	
	
	public clienteMB() {
		// TODO Auto-generated constructor stub
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cf) {
		this.cliente = cf;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
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
	public void alterar() {
		ClienteFachada fachada = new ClienteFachada();
		try {
			fachada.updateCF(cliente);
		}catch(Exception e) {
			e.getMessage();
		}
	}
	public void desbloquearCampo() {
		this.campo = false;
	}
}
