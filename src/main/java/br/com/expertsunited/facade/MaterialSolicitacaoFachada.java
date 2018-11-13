package br.com.expertsunited.facade;

import java.util.List;

import br.com.expertsunited.controler.regra.MaterialSolicitacaoNegocio;
import br.com.expertsunited.model.entity.MaterialSolicitacao;

public class MaterialSolicitacaoFachada {

	private final MaterialSolicitacaoNegocio matSolNegocio;
	
	public MaterialSolicitacaoFachada() {
		matSolNegocio = new MaterialSolicitacaoNegocio();
	}
	
	/**
     * Chama as regras de negocio para cadastro de uma MaterialSolicitacao
     * @param matSol Todos os dados da MaterialSolicitacao
     * @throws Exception
     */
	public void createMatSol(MaterialSolicitacao matSol) throws Exception{
		matSolNegocio.validarNuloMatSol(matSol);
		matSolNegocio.inserirMatSol(matSol);
	}
	
	/**
     * Atualiza os dados de uma MaterialSolicitacao
     * @param matSol Dados da MaterialSolicitacao
     * @throws Exception
     */
	public void updateMatSol(MaterialSolicitacao matSol) throws Exception{
		matSolNegocio.alterarMatSol(matSol);
	}
	
	/**
     * Remove um registro do banco de dados
     * @param matSol Dados da MaterialSolicitacao a ser excluido
     * @throws Exception
     */
	public void removeMatSol(MaterialSolicitacao matSol) throws Exception{
		matSolNegocio.removerMatSol(matSol);
	}
	
	/**
     * Retorna uma MaterialSolicitacao baseado no dado passado
     * @param id ID da MaterialSolicitacao a ser consultado
     * @return A MaterialSolicitacao encontrado ou NULL
     * @throws Exception
     */
	public MaterialSolicitacao getByIdMatSol(int id) throws Exception{
		return matSolNegocio.buscarPorIdMatSol(id);
	}
	
	/**
     * Retorna a lista de todos as MaterialSolicitacao
     * @return Lista de MaterialSolicitacao
     * @throws Exception
     */
	public List<MaterialSolicitacao> getListMatSol() throws Exception{
		return matSolNegocio.listarTodosMatSol();
	}
}
