package br.com.expertsunited.controler.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.expertsunited.facade.ClienteFachada;
import br.com.expertsunited.model.entity.ClienteFisico;

@ManagedBean()
public class clienteMB {

	ClienteFisico cf = new ClienteFisico();
	
	List<ClienteFisico> listaCliente;
	
	public clienteMB() {
		// TODO Auto-generated constructor stub
	}

	public ClienteFisico getCf() {
		return cf;
	}

	public void setCf(ClienteFisico cf) {
		this.cf = cf;
	}

	public List<ClienteFisico> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<ClienteFisico> listaCliente) {
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
