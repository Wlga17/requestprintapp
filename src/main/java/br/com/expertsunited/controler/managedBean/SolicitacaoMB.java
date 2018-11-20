package br.com.expertsunited.controler.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.expertsunited.facade.SolicitacaoFachada;
import br.com.expertsunited.model.entity.Solicitacao;

@ManagedBean(name = "SolicitacaoMB")
public class SolicitacaoMB {
	
	private Solicitacao solicitacao;
	private List<Solicitacao> sols;
	
	public SolicitacaoMB() {
		solicitacao = new Solicitacao();
	}
	
	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public List<Solicitacao> getSols() {
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
	
	public void inserirSolicitacao() {
		if(this.solicitacao != null) {
			SolicitacaoFachada fachada = new SolicitacaoFachada();
			try {
				fachada.createSolicitacao(solicitacao);
			}catch(Exception ex) {
				ex.getMessage();
			}
		}
	}
	

}
