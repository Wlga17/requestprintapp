package br.com.expertsunited.controler.regra;

import java.util.List;

import br.com.expertsunited.model.dao.IMaterialDAO;
import br.com.expertsunited.model.dao.MaterialDAO;
import br.com.expertsunited.model.entity.Material;

public class MaterialNegocio {
	
	
	private final IMaterialDAO daoMaterial;
	
	public MaterialNegocio() {
		
		daoMaterial = new MaterialDAO();
	}
	
	public void validarNuloMaterial(Material material) throws Exception{	
		if(material == null) {
			throw new Exception("Material não instanciado");
		}
		if(material.getNome().equals("") == true || material.getNome() == null) {
			throw new Exception("Nome do material em branco");
		}	
		
	}
	
	public void inserirMaterial(Material material) throws Exception{
		try {
			daoMaterial.create(material);
		}
		catch(Exception ex) {
			throw new Exception("Erro:" + ex.getMessage());
		}
	}
	
	public void alterarMaterial(Material material)throws Exception {
		try {
			daoMaterial.update(material);
		}
		catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public void removerMaterial(Material material)throws Exception {
		try {
			daoMaterial.remove(material);
		}
		catch(Exception ex) {
			throw new Exception("Erro" + ex.getMessage());
		}
	}
	
	public Material buscarPorIdMaterial(int id)throws Exception{
		try {
			Material consultaMaterial = daoMaterial.getByID(id);
			return(consultaMaterial);
		}
		catch(Exception ex){
			throw new Exception("Erro" + ex.getMessage());
		}
	}
	
	public List<Material> listarMaterial() throws Exception{
		try {
			List<Material> lista = daoMaterial.getList();
			return(lista);
		}
		catch(Exception ex) {
			throw new Exception("Erro" + ex.getMessage());
		}
	}
	
}
