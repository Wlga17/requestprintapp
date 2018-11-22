package br.com.expertsunited.facade;

import java.util.List;

import br.com.expertsunited.controler.regra.PropostaNegocio;
import br.com.expertsunited.model.entity.Proposta;

public class PropostaFachada {

	private final PropostaNegocio propostaNegocio;
	
	public PropostaFachada() {
		propostaNegocio = new PropostaNegocio();
	}
	
	/**
     * Chama as regras de negocio para cadastro de uma Proposta
     * @param proposta Todos os dados da Proposta
     * @throws Exception
     */
	public void createProposta(Proposta proposta) throws Exception{
		propostaNegocio.validarNuloProposta(proposta);
		propostaNegocio.inserirProposta(proposta);
	}
	
	/**
     * Atualiza os dados de uma Proposta
     * @param proposta Dados da Proposta
     * @throws Exception
     */
	public void updateProposta(Proposta proposta) throws Exception{
		propostaNegocio.alterarProposta(proposta);
	}
	
	/**
     * Remove um registro do banco de dados
     * @param proposta Dados da Proposta a ser excluido
     * @throws Exception
     */
	public void removeProposta(Proposta proposta) throws Exception{
		propostaNegocio.removerProposta(proposta);
	}
	
	/**
     * Retorna uma Proposta baseado no dado passado
     * @param id ID da Proposta a ser consultado
     * @return A Proposta encontrado ou NULL
     * @throws Exception
     */
	public Proposta getByIdProposta(int id) throws Exception{
		return propostaNegocio.buscaPorIdProposta(id);
	}
	
	/**
     * Retorna a lista de todos as Propostas
     * @return Lista de Proposta
     * @throws Exception
     */
	public List<Proposta> getListProposta() throws Exception{
		return propostaNegocio.listarTodasProposta();
	}
	
	/**
     * Retorna a lista de todos as Propostas de uma certa grafica
     * @return Lista de Proposta
     * @throws Exception
     */
	public List<Proposta> getListPropotaByGrafica() throws Exception{
		return propostaNegocio.listarPropotaPorGrafica();
	}
}
