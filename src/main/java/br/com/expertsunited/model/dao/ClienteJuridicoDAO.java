package br.com.expertsunited.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.entity.ClienteJuridico;


public class ClienteJuridicoDAO implements IClienteJuridicoDAO{

	EntityManager eManager = UtilJPA.getEntityManager();
	
	/**
	 * Método para persistir um novo objeto ClienteJuridico
	 * @param cliente 
	 */
	public void create(ClienteJuridico cliente) {
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
	 * Método para atualizar um objeto ClienteJuridico já persistido
	 * @param cliente
	 */
	public void update(ClienteJuridico cliente) {
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
	 * Método para excluir um objeto ClienteJuridico já persistido
	 * @param cliente
	 */
	public void remove(ClienteJuridico cliente) {
		try {
			cliente = eManager.find(ClienteJuridico.class, cliente.getId());
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
	 * Método para buscar um objeto ClienteJuridico informando seu ID
	 * @param id
	 */
	public ClienteJuridico getById(int id) {
		ClienteJuridico cliente = null;
		try {
			cliente = eManager.find(ClienteJuridico.class, id);
		}catch (Exception ex) {
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
		return cliente;
	}

	/**
	 * Método para listar todas os objetos ClienteJuridico persistidos
	 */
	@SuppressWarnings("unchecked")
	public List<ClienteJuridico> getList() {
		List<ClienteJuridico> clientes = null;
		try {
			Query consulta = eManager.createQuery("SELECT cj FROM ClienteJuridico cj");
			clientes = consulta.getResultList();
		}catch (Exception ex) {
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
		return clientes;
	}

}
