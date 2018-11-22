package br.com.expertsunited.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.entity.Grafica;

public class GraficaDAO implements IGraficaDAO {
	EntityManager eManager = UtilJPA.getEntityManager();
	
	/**
	 * Método para persistir um novo objeto Grafica
	 * @param grafica 
	 */
	public void create(Grafica grafica) {
		try {
			eManager.getTransaction().begin();
			eManager.persist(grafica);
			eManager.getTransaction().commit();
		} catch (Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para atualizar um objeto Grafica já persistido
	 * @param grafica
	 */
	public void update(Grafica grafica) {
		try	{
			eManager.getTransaction().begin();
			eManager.merge(grafica);
			eManager.getTransaction().commit();
		} catch (Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para excluir um objeto Grafica já persistido
	 * @param grafica
	 */
	public void remove(Grafica grafica) {
		try {
			grafica = eManager.find(Grafica.class, grafica.getIdUsuario());
			eManager.getTransaction().begin();
			eManager.remove(grafica);
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
	public List<Grafica> getList() {
		List<Grafica> graficas = null;
		try {
			graficas = eManager.createQuery("FROM Grafica").getResultList();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
		
		return graficas;
	}
	
	/**
	 * Método para buscar um objeto Grafica informando seu ID
	 * @param id
	 */
	public Grafica getByID(int id) {
		Grafica grafica = null;
		try {
			grafica = eManager.find(Grafica.class, id);
		} catch(Exception exp) {
			exp.getStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
		return grafica;
	}
	
	/**
	 * Método para buscar um objeto Grafica informando seu Nome
	 * @param nome
	 */
	@SuppressWarnings("unchecked")
	public List<Grafica> getByName(String nome) {
		List<Grafica> graficas = null;
		try {
			graficas = eManager.createQuery("SELECT g FROM Grafica g WHERE g.nome LIKE :nome")
					.setParameter("nome", "%" + nome.toLowerCase() + "%").getResultList();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
			return null;
		} finally {
			eManager.close();
		}
		return graficas;
	}
}
