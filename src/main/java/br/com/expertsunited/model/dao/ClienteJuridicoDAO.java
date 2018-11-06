package br.com.expertsunited.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.entity.ClienteJuridico;


public class ClienteJuridicoDAO implements IClienteJuridicoDAO{

	private final EntityManager em = UtilJPA.getEntityManager();
	
	/**
	 * Método para persistir um novo objeto ClienteJuridico
	 * @param cliente 
	 */
	public void create(ClienteJuridico cliente) {
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
	 * Método para atualizar um objeto ClienteJuridico já persistido
	 * @param cliente
	 */
	public void update(ClienteJuridico cliente) {
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
	 * Método para excluir um objeto ClienteJuridico já persistido
	 * @param cliente
	 */
	public void remove(ClienteJuridico cliente) {
		try {
			cliente = em.find(ClienteJuridico.class, cliente.getId());
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
	 * Método para buscar um objeto ClienteJuridico informando seu ID
	 * @param id
	 */
	public ClienteJuridico getById(int id) {
		ClienteJuridico cliente = null;
		try {
			cliente = em.find(ClienteJuridico.class, id);
		}catch (Exception ex) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return cliente;
	}

	/**
	 * Método para listar todas os objetos ClienteJuridico persistidos
	 */
	public List<ClienteJuridico> getList() {
		List<ClienteJuridico> clientes = null;
		try {
			Query consulta = em.createQuery("SELECT cj FROM ClienteJuridico cj");
			clientes = consulta.getResultList();
		}catch (Exception ex) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return clientes;
	}

}
