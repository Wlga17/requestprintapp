package br.com.expertsunited.controler.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.expertsunited.facade.SolicitacaoFachada;
import br.com.expertsunited.model.entity.Solicitacao;

@FacesConverter(value = "solicitacaoConverter", forClass = Solicitacao.class)
public class SolicitacaoConverter implements Converter{

	public Object getAsObject(FacesContext context, UIComponent component, String pString) {
		SolicitacaoFachada f = new SolicitacaoFachada();
		Solicitacao solicitacao = null;
		if(pString == null || pString.isEmpty()) {
			return null;
		}
		Integer id = Integer.valueOf(pString);
		try {
			solicitacao = f.getByIdSolicitacao(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return solicitacao;
	}

	public String getAsString(FacesContext context, UIComponent component, Object pOb) {
		Solicitacao solicitacao = (Solicitacao) pOb;
		if(solicitacao == null || solicitacao.getId() == 0) {
			return null;
		}
		return String.valueOf(solicitacao.getId());
	}
	
}
