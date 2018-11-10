package br.com.expertsunited.controler.regra;

import java.util.List;

import br.com.expertsunited.model.dao.ISolicitacaoDAO;
import br.com.expertsunited.model.dao.SolicitacaoDAO;
import br.com.expertsunited.model.entity.Solicitacao;

public class SolicitacaoNegocio {

	private final ISolicitacaoDAO daoSolicitacao;
	
	public SolicitacaoNegocio() {
		daoSolicitacao = new SolicitacaoDAO();
	}
	
	public void validarNuloSolicitacao(Solicitacao solicitacao) throws Exception{
		if(solicitacao == null) {
			throw new Exception("Solicitação não instanciado!");
		}
		if(solicitacao.getTitulo().equals("") == true || solicitacao.getTitulo() == null) {
			throw new Exception("Titulo da solicitação em branco!");
		}
		if(solicitacao.getDataSolicitacao().equals("") == true || solicitacao.getDataSolicitacao() == null) {
			throw new Exception("Data da solicitação em branco!");
		}
		if(solicitacao.getDataEntrega().equals("") == true || solicitacao.getDataEntrega() == null) {
			throw new Exception("Data da entrega em branco!");
		}
		if(solicitacao.getObservacao().equals("") == true || solicitacao.getObservacao() == null) {
			throw new Exception("Observação da solicitação em branco!");
		}
	}
	
	public void inserirSolicitacao(Solicitacao solicitacao) throws Exception{
		try {
			daoSolicitacao.create(solicitacao);
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public void alterarSolicitacao(Solicitacao solicitacao) throws Exception{
		try {
			daoSolicitacao.update(solicitacao);
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public void removerSolicitacao(Solicitacao solicitacao) throws Exception{
		try {
			daoSolicitacao.remove(solicitacao);
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public Solicitacao buscarPorIdSolicitacao(int id) throws Exception{
		try {
			Solicitacao consulta = daoSolicitacao.getById(id);
			return consulta;
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public List<Solicitacao> listarTodasSolicitacoes() throws Exception{
		try {
			List<Solicitacao> lista = daoSolicitacao.getList();
			return lista;
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
}
