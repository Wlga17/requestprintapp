package br.com.expertsunited.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.entity.Material;

public class MaterialDAO implements IMaterialDAO {
	EntityManager eManager = UtilJPA.getEntityManager();
	
	/**
	 * Método para persistir um novo objeto Material
	 * @param material 
	 */
	public void create(Material material) {
		try {
			eManager.getTransaction().begin();
			eManager.persist(material);
			eManager.getTransaction().commit();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para atualizar um objeto Material já persistido
	 * @param material
	 */
	public void update(Material material) {
		try {
			eManager.getTransaction().begin();
			eManager.merge(material);
			eManager.getTransaction().commit();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para excluir um objeto Material já persistido
	 * @param material
	 */
	public void remove(Material material) {
		try {
			material = eManager.find(Material.class, material.getId());
			eManager.getTransaction().begin();
			eManager.remove(material);
			eManager.getTransaction().commit();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para listar todas os objetos Material persistidos
	 */
	@SuppressWarnings("unchecked")
	public List<Material> getList() {
		List<Material> materiais = null;
		try {
			materiais = eManager.createQuery("FROM Material").getResultList();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
		
		return materiais;
	}
	
	/**
	 * Método para buscar um objeto Material informando seu ID
	 * @param id
	 */
	public Material getByID(int id) {
		Material material = null;
		try {
			material = eManager.find(Material.class, id);
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
		
		return material;
	}
}
