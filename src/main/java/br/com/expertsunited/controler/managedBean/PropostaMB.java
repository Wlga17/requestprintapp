package br.com.expertsunited.controler.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.expertsunited.facade.PropostaFachada;
import br.com.expertsunited.model.entity.Proposta;

@ManagedBean()
public class PropostaMB {

	private Proposta proposta;
	private List<Proposta> listaProposta;
	
	public PropostaMB() {
		proposta = new Proposta();
	}

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}
	
	public List<Proposta> getListaProposta() {
		return listaProposta;
	}

	public void setListaProposta(List<Proposta> listaProposta) {
		this.listaProposta = listaProposta;
	}

	public void inserir() {
		if(this.proposta != null) {
			PropostaFachada fachada = new PropostaFachada(); 
			try {
				fachada.createProposta(proposta);
			}catch(Exception ex) {
				ex.getMessage();
			}
		}
	}
}
