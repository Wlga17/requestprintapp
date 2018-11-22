package br.com.expertsunited.facade;

import java.util.List;

import br.com.expertsunited.controler.regra.GraficaNegocio;
import br.com.expertsunited.model.entity.Grafica;

public class GraficaFachada {
	
	private final GraficaNegocio graNeg;
	
	public GraficaFachada() {
		graNeg = new GraficaNegocio();
	}
	
	/**
   * Chama as regras de negocio para cadastro de uma Gráfica
   * @param gráfia todos os dados da gráfica
   * @throws Exception
   */
	public void createGrafica(Grafica grafica) throws Exception{
		graNeg.validaGrafica(grafica);
		graNeg.inserirGrafica(grafica);
	}
	
	/**
   * Atualiza os dados de uma Gráfica
   * @param gráfica dados da gráfica
   * @throws Exception
   */
	public void updateGrafica(Grafica grafica) throws Exception{
		graNeg.alterarGrafica(grafica);
	}
	
	/**
   * Remove um registro do banco de dados
   * @param gráfica dados da gráfica a ser excluída
   * @throws Exception
   */
	public void removeGrafica(Grafica grafica) throws Exception{
		graNeg.removerGrafica(grafica);
	}
	
	/**
   * Retorna uma Gráfica baseado no dado passado
   * @param id ID da Gráfica a ser consultado
   * @return A Gráfica encontrada ou NULL
   * @throws Exception
   */
	public Grafica getByIdGrafica(int id) throws Exception{
		return graNeg.buscarPorIdGrafica(id);
	}
	
	/**
   * Retorna a lista de todos as Gráficas
   * @return Lista de Grafica
   * @throws Exception
   */
	public List<Grafica> getListGrafica() throws Exception{
		return graNeg.listaGrafica();
	}
	
	/**
   * Retorna uma Gráfica baseado no dado passado
   * @param id ID da Gráfica a ser consultado
   * @return A Gráfica encontrada ou NULL
   * @throws Exception
   */
	public List<Grafica> getByNameGrafica(String nome) throws Exception{
		return graNeg.buscarPorNomeGrafica(nome);
	}
	
}
