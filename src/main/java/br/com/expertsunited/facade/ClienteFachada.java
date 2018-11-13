package br.com.expertsunited.facade;

import java.util.List;

import br.com.expertsunited.controler.regra.ClienteNegocio;
import br.com.expertsunited.model.entity.ClienteFisico;
import br.com.expertsunited.model.entity.ClienteJuridico;


public class ClienteFachada {

	private final ClienteNegocio cliNeg;
	
	public ClienteFachada() {
		cliNeg = new ClienteNegocio();
	}
	
	/**
     * Chama as regras de negocio para cadastro de um ClienteFisico
     * @param cliente Todos os dados do ClienteFisico
     * @throws Exception
     */
	public void createCF(ClienteFisico cliente) throws Exception {
		//cliNeg.validarNuloCF(cliente);
		cliNeg.inserirClienteCF(cliente);
	}
	
	/**
     * Atualiza os dados de um ClienteFisico
     * @param cliente Dados do ClienteFisico
     * @throws Exception
     */
	public void updateCF(ClienteFisico cliente) throws Exception {
		cliNeg.alterarClienteCF(cliente);
	}
	
	/**
     * Remove um registro do banco de dados
     * @param cliente Dados do ClienteFisico a ser excluido
     * @throws Exception
     */
	public void removeCF(ClienteFisico cliente) throws Exception {
		cliNeg.removerClienteCF(cliente);
	}
	
	/**
     * Retorna um ClienteFisico baseado no dado passado
     * @param id ID do ClienteFisico a ser consultado
     * @return O ClienteFisico encontrado ou NULL
     * @throws Exception
     */
	public ClienteFisico getByIdCF(int id) throws Exception {
		return cliNeg.buscarPorIdCF(id);
	}
	
	/**
     * Retorna a lista de todos os ClienteFisico
     * @return Lista de ClienteFisico
     * @throws Exception
     */
	public List<ClienteFisico> getListCF() throws Exception {
		return cliNeg.listarTodosCF();
	}

	
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	
	
	/**
     * Chama as regras de negocio para cadastro de um ClienteJuridico
     * @param cliente Todos os dados do ClienteJuridico
     * @throws Exception
     */
	public void createCJ(ClienteJuridico cliente) throws Exception{
		cliNeg.validarNuloCJ(cliente);
		cliNeg.inserirClienteCJ(cliente);
	}
	
	/**
     * Atualiza os dados de um ClienteJuridico
     * @param cliente Dados do ClienteJuridico
     * @throws Exception
     */
	public void updateCJ(ClienteJuridico cliente) throws Exception{
		cliNeg.alterarClienteCJ(cliente);
	}
	
	/**
     * Remove um registro do banco de dados
     * @param cliente Dados do ClienteJuridico a ser excluido
     * @throws Exception
     */
	public void removeCJ(ClienteJuridico cliente) throws Exception{
		cliNeg.removerClienteCJ(cliente);
	}
	
	/**
     * Retorna um ClienteJuridico baseado no dado passado
     * @param id ID do ClienteJuridico a ser consultado
     * @return O ClienteJuridico encontrado ou NULL
     * @throws Exception
     */
	public ClienteJuridico getByIdCJ(int id) throws Exception{
		return cliNeg.buscarPorIdCJ(id);
	}
	
	/**
     * Retorna a lista de todos os ClienteJuridico
     * @return Lista de ClienteJuridico
     * @throws Exception
     */
	public List<ClienteJuridico> getListCJ() throws Exception{
		return cliNeg.listarTodosCJ();
	}
}