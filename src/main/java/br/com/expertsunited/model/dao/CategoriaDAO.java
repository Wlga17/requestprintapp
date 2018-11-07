package br.com.expertsunited.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.entity.Categoria;

public class CategoriaDAO implements ICategoriaDAO {
	EntityManager eManager = UtilJPA.getEntityManager();
	
	/**
	 * Método para persistir um novo objeto Categoria
	 * @param categoria 
	 */
	public void create(Categoria categoria) {
		try {
			eManager.getTransaction().begin();
			eManager.persist(categoria);
			eManager.getTransaction().commit();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para atualizar um objeto Categoria já persistido
	 * @param categoria
	 */
	public void update(Categoria categoria) {
		try {
			eManager.getTransaction().begin();
			eManager.merge(categoria);
			eManager.getTransaction().commit();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para excluir um objeto Categoria já persistido
	 * @param categoria
	 */
	public void remove(Categoria categoria) {
		try {
			categoria = eManager.find(Categoria.class, categoria.getId());
			eManager.getTransaction().begin();
			eManager.remove(categoria);
			eManager.getTransaction().commit();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para listar todas os objetos Grafica persistidos
	 */
	@SuppressWarnings("unchecked")
	public List<Categoria> getList() {
		List<Categoria> categorias = null;
		try {
			categorias = eManager.createQuery("FROM Categoria").getResultList();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
		
		return categorias;
	}
	
	/**
	 * Método para buscar um objeto Categoria informando seu ID
	 * @param id
	 */
	public Categoria getByID(int id) {
		Categoria categoria = null;
		try {
			categoria = eManager.find(Categoria.class, id);
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
		
		return categoria;
	}
}
