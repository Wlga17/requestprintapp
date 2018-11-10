package br.com.expertsunited.facade;

import java.util.List;

import br.com.expertsunited.controler.regra.SolicitacaoNegocio;
import br.com.expertsunited.model.entity.Solicitacao;

public class SolicitacaoFachada {

	private final SolicitacaoNegocio solNeg;
	
	public SolicitacaoFachada() {
		solNeg = new SolicitacaoNegocio();
	}
	
	/**
     * Chama as regras de negocio para cadastro de uma Solicitacao
     * @param solicitacao Todos os dados da Solicitacao
     * @throws Exception
     */
	public void createSolicitacao(Solicitacao solicitacao) throws Exception{
		solNeg.validarNuloSolicitacao(solicitacao);
		solNeg.inserirSolicitacao(solicitacao);
	}
	
	/**
     * Atualiza os dados de uma Solicitacao
     * @param solicitacao Dados da Solicitacao
     * @throws Exception
     */
	public void updateSolicitacao(Solicitacao solicitacao) throws Exception{
		solNeg.alterarSolicitacao(solicitacao);
	}
	
	/**
     * Remove um registro do banco de dados
     * @param solicitacao Dados da Solicitacao a ser excluido
     * @throws Exception
     */
	public void removeSolicitacao(Solicitacao solicitacao) throws Exception{
		solNeg.removerSolicitacao(solicitacao);
	}
	
	/**
     * Retorna uma Solicitacao baseado no dado passado
     * @param id ID da Solicitacao a ser consultado
     * @return A Solicitacao encontrado ou NULL
     * @throws Exception
     */
	public Solicitacao getByIdSolicitacao(int id) throws Exception{
		return solNeg.buscarPorIdSolicitacao(id);
	}
	
	/**
     * Retorna a lista de todos as Solicitacao
     * @return Lista de Solicitacao
     * @throws Exception
     */
	public List<Solicitacao> getListSolicitacao() throws Exception{
		return solNeg.listarTodasSolicitacoes();
	}
}
