package br.com.expertsunited.facade;

import java.util.List;

import br.com.expertsunited.controler.regra.CategoriaNegocio;
import br.com.expertsunited.model.entity.Categoria;

public class CategoriaFachada {

	
	private final CategoriaNegocio catNeg;
	
	public CategoriaFachada() {
		
		catNeg = new CategoriaNegocio();
		
	}
	
	public void createCategoria(Categoria categoria) throws Exception{
		catNeg.validarNuloCategoria(categoria);
		catNeg.inserirCategoria(categoria);
	}
	
	public void updateCategoria(Categoria categoria) throws Exception{
		catNeg.alterarCategaria(categoria);
	}
	
	public void removeCategoria(Categoria categoria) throws Exception{
		catNeg.removerCategoria(categoria);
	}
	
	public Categoria getByIdCategoria(int id) throws Exception{
		return catNeg.buscarPorIdCategoria(id);
	}
	
	public List<Categoria> getListMaterial() throws Exception{
		return catNeg.listaCategoria();
	}
	
}
