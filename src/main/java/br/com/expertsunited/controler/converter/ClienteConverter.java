package br.com.expertsunited.controler.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.expertsunited.facade.ClienteFachada;
import br.com.expertsunited.model.entity.Cliente;

@FacesConverter(value = "clienteConverter", forClass = Cliente.class)
public class ClienteConverter implements Converter{

	public Object getAsObject(FacesContext context, UIComponent component, String pString) {
		ClienteFachada f = new ClienteFachada();
		Cliente cli = null;
		if(pString == null || pString.isEmpty()) {
			return null;
		}
		Integer id = Integer.valueOf(pString);
		try {
			cli = f.getByIdCliente(id);
		}catch(Exception ex) {
			ex.getMessage();
		}
		return cli;
	}

	public String getAsString(FacesContext context, UIComponent component, Object pOb) {
		Cliente cliente = (Cliente) pOb;
		if(cliente == null || cliente.getIdUsuario() == 0) {
			return null;
		}
		return String.valueOf(cliente.getIdUsuario());
	}

}
