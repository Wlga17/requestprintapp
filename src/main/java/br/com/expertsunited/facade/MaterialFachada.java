package br.com.expertsunited.facade;

import java.util.List;

import br.com.expertsunited.controler.regra.MaterialNegocio;
import br.com.expertsunited.model.entity.Material;

public class MaterialFachada {
	
	private final MaterialNegocio matNeg;
    
	public MaterialFachada() {
		matNeg = new MaterialNegocio();
	}
	
	/**
	    * Chama as regras de negocio para cadastro de um Material
	    * @param material Todos os dados do material
	    * @throws Exception
	    */
	
	public void createMaterial(Material material) throws Exception{
		matNeg.validarNuloMaterial(material);
		matNeg.inserirMaterial(material);
	}
	
	/**
     * Atualiza os dados de um Material
     * @param material Dados do Material
     * @throws Exception
     */
	
	public void updateMaterial(Material material) throws Exception{
		matNeg.alterarMaterial(material);
	}
	
	/**
     * Remove um registro do banco de dados
     * @param material Dados do Material a ser excluido
     * @throws Exception
     */
	
	public void removeMaterial(Material material) throws Exception{
		matNeg.removerMaterial(material);
	}

	/**
     * Retorna um Material baseado no dado passado
     * @param id ID do Material a ser consultado
     * @return O Material encontrado ou NULL
     * @throws Exception
     */
	
	public Material getByIdMaterial(int id) throws Exception{
		return matNeg.buscarPorIdMaterial(id);
	}
	
	/**
     * Retorna a lista de todos os materiais
     * @return Lista de Material
     * @throws Exception.
     */
	
	public List<Material> getListMaterial() throws Exception{
		return matNeg.listarMaterial();
	}
	

}
