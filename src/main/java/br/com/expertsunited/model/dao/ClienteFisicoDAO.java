package br.com.expertsunited.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.entity.ClienteFisico;


public class ClienteFisicoDAO implements IClienteFisicoDAO{

	private final EntityManager eManager = UtilJPA.getEntityManager();
	
	/**
	 * Método para persistir um novo objeto ClienteFisico
	 * @param cliente 
	 */
	public void create(ClienteFisico cliente) {
		try {
			eManager.getTransaction().begin();
			eManager.persist(cliente);
			eManager.getTransaction().commit();
		}catch(Exception ex) {
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
	}

	/**
	 * Método para atualizar um objeto ClienteFisico já persistido
	 * @param cliente
	 */
	public void update(ClienteFisico cliente) {
		try {
			eManager.getTransaction().begin();
			eManager.merge(cliente);
			eManager.getTransaction().commit();
		}catch (Exception ex) {
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
		
	}

	/**
	 * Método para excluir um objeto ClienteFisico já persistido
	 * @param cliente
	 */
	public void remove(ClienteFisico cliente) {
		try {
			cliente = eManager.find(ClienteFisico.class, cliente.getId());
			eManager.getTransaction().begin();
			eManager.remove(cliente);
			eManager.getTransaction().commit();
		}catch (Exception ex) {
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
		
	}

	/**
	 * Método para buscar um objeto ClienteFisico informando seu ID
	 * @param id
	 */
	public ClienteFisico getById(int id) {
		ClienteFisico cliente = null;
		try {
			cliente = eManager.find(ClienteFisico.class, id);
		}catch (Exception ex) {
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
		return cliente;
	}

	/**
	 * Método para listar todas os objetos ClienteFisico persistidos
	 */
	@SuppressWarnings("unchecked")
	public List<ClienteFisico> getList() {
		List<ClienteFisico> clientes = null;
		try {
			Query consulta = eManager.createQuery("SELECT cf FROM ClienteFisico cf");
			clientes = consulta.getResultList();
		}catch (Exception ex) {
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
		return clientes;
	}
}
