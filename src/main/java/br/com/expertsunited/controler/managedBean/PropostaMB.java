package br.com.expertsunited.controler.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import br.com.expertsunited.facade.GraficaFachada;
import br.com.expertsunited.facade.PropostaFachada;
import br.com.expertsunited.facade.SolicitacaoFachada;
import br.com.expertsunited.model.entity.Grafica;
import br.com.expertsunited.model.entity.Proposta;
import br.com.expertsunited.model.entity.Solicitacao;

@ManagedBean()
public class PropostaMB {

	private Proposta proposta;
	private List<Proposta> listaProposta;
	private List<SelectItem> grafs;
	private List<SelectItem> sols;
	
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
	
	/*public List<Grafica> getGrafs() {
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
	*/
	public List<SelectItem> getGrafs() {
		GraficaFachada fg = new GraficaFachada();
		try {
			for (Grafica g : fg.getListGrafica()) {
			SelectItem sl = new SelectItem(g.getIdUsuario(), g.getNome());	
			grafs.add(sl);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return grafs;
	}

	public void setGrafs(List<SelectItem> grafs) {
		this.grafs = grafs;
	}

	/*public List<Solicitacao> getSols() {
		SolicitacaoFachada fs = new SolicitacaoFachada();
		try {
			sols = fs.getListSolicitacao();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sols;
	}

	public void setSols(List<Solicitacao> sols) {
		this.sols = sols;
	}
	*/
	public List<SelectItem> getSols() {
		SolicitacaoFachada fs = new SolicitacaoFachada();
		try {
			for(Solicitacao s : fs.getListSolicitacao()) {
				SelectItem sl = new SelectItem(s.getId(), s.getTitulo());
				sols.add(sl);
			}
		}catch (Exception e) {
			e.getMessage();
		}
		return sols;
	}

	public void setSols(List<SelectItem> sols) {
		this.sols = sols;
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
