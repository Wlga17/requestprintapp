package br.com.expertsunited.controler.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.expertsunited.facade.ClienteFachada;
import br.com.expertsunited.model.entity.Cliente;

@ManagedBean()
public class clienteMB {

	Cliente cf = new Cliente();
	
	List<Cliente> listaCliente;
	
	public clienteMB() {
		// TODO Auto-generated constructor stub
	}

	public Cliente getCf() {
		return cf;
	}

	public void setCf(Cliente cf) {
		this.cf = cf;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	public void inserir() {
		if(this.cf != null) {
			ClienteFachada fachada = new ClienteFachada();
			try {
				fachada.createCF(cf);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
