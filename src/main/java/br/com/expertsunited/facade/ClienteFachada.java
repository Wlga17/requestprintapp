package br.com.expertsunited.facade;

import java.util.List;

import br.com.expertsunited.controler.regra.ClienteNegocio;
import br.com.expertsunited.model.entity.Cliente;



public class ClienteFachada {

	private final ClienteNegocio cliNeg;
	
	public ClienteFachada() {
		cliNeg = new ClienteNegocio();
	}
	
	/**
     * Chama as regras de negocio para cadastro de um Cliente
     * @param cliente Todos os dados do Cliente
     * @throws Exception
     */
	public void createCF(Cliente cliente) throws Exception {
		//cliNeg.validarNuloCF(cliente);
		cliNeg.inserirCliente(cliente);
	}
	
	/**
     * Atualiza os dados de um Cliente
     * @param cliente Dados do Cliente
     * @throws Exception
     */
	public void updateCF(Cliente cliente) throws Exception {
		cliNeg.alterarCliente(cliente);
	}
	
	/**
     * Remove um registro do banco de dados
     * @param cliente Dados do Cliente a ser excluido
     * @throws Exception
     */
	public void removeCF(Cliente cliente) throws Exception {
		cliNeg.removerCliente(cliente);
	}
	
	/**
     * Retorna um Cliente baseado no dado passado
     * @param id ID do Cliente a ser consultado
     * @return O Cliente encontrado ou NULL
     * @throws Exception
     */
	public Cliente getByIdCliente(int id) throws Exception {
		return cliNeg.buscarPorId(id);
	}
	
	/**
     * Retorna a lista de todos os Cliente
     * @return Lista de Cliente
     * @throws Exception
     */
	public List<Cliente> getListCF() throws Exception {
		return cliNeg.listarTodos();
	}
}