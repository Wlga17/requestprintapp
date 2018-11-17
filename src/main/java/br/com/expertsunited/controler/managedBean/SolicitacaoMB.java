package br.com.expertsunited.controler.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.expertsunited.facade.SolicitacaoFachada;
import br.com.expertsunited.model.entity.Solicitacao;

@ManagedBean(name = "SolicitacaoMB")
public class SolicitacaoMB {
	
	private Solicitacao solicitacao;
	private List<Solicitacao> listaSolicitacao;
	
	public SolicitacaoMB() {
		solicitacao = new Solicitacao();
	}
	
	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public List<Solicitacao> getListaSolicitacao() {
		return listaSolicitacao;
	}

	public void setListaSolicitacao(List<Solicitacao> listaSolicitacao) {
		this.listaSolicitacao = listaSolicitacao;
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
