package br.com.expertsunited.controler.regra;

import java.util.List;

import br.com.expertsunited.model.dao.CategoriaDAO;
import br.com.expertsunited.model.dao.ICategoriaDAO;
import br.com.expertsunited.model.entity.Categoria;

public class CategoriaNegocio {

	private final ICategoriaDAO daoCategoria;
	
	public CategoriaNegocio() {
		daoCategoria = new CategoriaDAO();			
	}
	
	public void validarNuloCategoria(Categoria categoria) throws Exception {
		if(categoria == null) {
			throw new Exception("Categoria não instaciada");
		}
		if (categoria.getNome().equals("") == true || categoria.getNome() == null) {
			throw new Exception("Nome da categoria em branco");
		}
		
	}
	
	public void inserirCategoria(Categoria categoria) throws Exception{
		try {
			daoCategoria.create(categoria);
		}
		catch(Exception ex) {
			throw new Exception("Erro:" + ex.getMessage());
		}
	}
		
	public void alterarCategaria(Categoria categoria) throws Exception{
		try {
			daoCategoria.update(categoria);
		}
		catch(Exception ex) {
			throw new Exception("Erro" + ex.getMessage());
		}
			
	}
	
	public void removerCategoria(Categoria categoria) throws Exception{
		try {
			daoCategoria.remove(categoria);
		}
		catch(Exception ex) {
			throw new Exception("Erro:" + ex.getMessage());
		}

	}
	
	public Categoria buscarPorIdCategoria(int id) throws Exception{
		try {
			Categoria consultaCategoria = daoCategoria.getByID(id);
			return(consultaCategoria);
		}
		catch(Exception ex) {
			throw new Exception("Erro:" + ex.getMessage());
		}
	}
	
	public List<Categoria> listaCategoria() throws Exception{
		try {
			List<Categoria> lista = daoCategoria.getList();
			return(lista);
		}
		catch(Exception ex) {
			throw new Exception("Erro:" + ex.getMessage());
		}
	}
	
}
