package br.com.expertsunited.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.entity.ClienteFisico;


public class ClienteFisicoDAO implements IClienteFisicoDAO{

	private final EntityManager em = UtilJPA.getEntityManager();
	
	/**
	 * Método para persistir um novo objeto ClienteFisico
	 * @param cliente 
	 */
	public void create(ClienteFisico cliente) {
		try {
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
		}catch(Exception ex) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}

	/**
	 * Método para atualizar um objeto ClienteFisico já persistido
	 * @param cliente
	 */
	public void update(ClienteFisico cliente) {
		try {
			em.getTransaction().begin();
			em.merge(cliente);
			em.getTransaction().commit();
		}catch (Exception ex) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}

	/**
	 * Método para excluir um objeto ClienteFisico já persistido
	 * @param cliente
	 */
	public void remove(ClienteFisico cliente) {
		try {
			cliente = em.find(ClienteFisico.class, cliente.getId());
			em.getTransaction().begin();
			em.remove(cliente);
			em.getTransaction().commit();
		}catch (Exception ex) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}

	/**
	 * Método para buscar um objeto ClienteFisico informando seu ID
	 * @param id
	 */
	public ClienteFisico getById(int id) {
		ClienteFisico cliente = null;
		try {
			cliente = em.find(ClienteFisico.class, id);
		}catch (Exception ex) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return cliente;
	}

	/**
	 * Método para listar todas os objetos ClienteFisico persistidos
	 */
	public List<ClienteFisico> getList() {
		List<ClienteFisico> clientes = null;
		try {
			Query consulta = em.createQuery("SELECT cf FROM ClienteFisico cf");
			clientes = consulta.getResultList();
		}catch (Exception ex) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return clientes;
	}
}
