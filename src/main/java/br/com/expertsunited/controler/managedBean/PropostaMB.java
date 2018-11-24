package br.com.expertsunited.controler.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
//import javax.faces.model.SelectItem;
import javax.faces.bean.SessionScoped;

import br.com.expertsunited.facade.GraficaFachada;
import br.com.expertsunited.facade.PropostaFachada;
import br.com.expertsunited.facade.SolicitacaoFachada;
import br.com.expertsunited.model.entity.Grafica;
import br.com.expertsunited.model.entity.Proposta;
import br.com.expertsunited.model.entity.Solicitacao;

@ManagedBean()
@SessionScoped
public class PropostaMB implements Serializable{
	private static final long serialVersionUID = 1L;

	private Proposta proposta;
	private List<Proposta> props;
	private List<Grafica> grafs;
	
	public PropostaMB() {
		proposta = new Proposta();
	}

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	public List<Proposta> getProps() {
		PropostaFachada fp = new PropostaFachada();
		try {
			props = fp.getListPropotaByGrafica();
		}catch(Exception ex) {
			ex.getMessage();
		}
		return props;
	}

	public void setProps(List<Proposta> props) {
		this.props = props;
	}
	
	public List<Grafica> getGrafs() {
		GraficaFachada fg = new GraficaFachada();
		try {
			grafs = fg.getListGrafica();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grafs;
	}

	public void setGrafs(List<Grafica> grafs) {
		this.grafs = grafs;
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
