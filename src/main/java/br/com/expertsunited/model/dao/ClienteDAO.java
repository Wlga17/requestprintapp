package br.com.expertsunited.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.entity.Cliente;

public class ClienteDAO implements IClienteDAO {
	EntityManager eManager = UtilJPA.getEntityManager();
	
	/**
	 * Método para persistir um novo objeto Cliente
	 * @param cliente 
	 */
	public void create(Cliente cliente) {
		try {
			System.out.println("chegou aqui");
			eManager.getTransaction().begin();
			eManager.persist(cliente);
			eManager.getTransaction().commit();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para atualizar um objeto Cliente já persistido
	 * @param cliente
	 */
	public void update(Cliente cliente) {
		try {
			eManager.getTransaction().begin();
			eManager.merge(cliente);
			eManager.getTransaction().commit();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para excluir um objeto Cliente já persistido
	 * @param cliente
	 */
	public void remove(Cliente cliente) {
		try {
			cliente = eManager.find(Cliente.class, cliente.getIdUsuario());
			eManager.getTransaction().begin();
			eManager.remove(cliente);
			eManager.getTransaction().commit();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para listar todos os objetos Clientes persistidos
	 */
	@SuppressWarnings("unchecked")
	public List<Cliente> getList() {
		List<Cliente> clientes = null;
		try {
			clientes = eManager.createQuery("FROM Cliente").getResultList();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
		return clientes;
	}
	
	/**
	 * Método para buscar um objeto Cliente informando seu ID
	 * @param id
	 */
	public Cliente getByID(int id) {
		Cliente cliente = null;
		try {
			cliente = eManager.find(Cliente.class, id);
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
		return cliente;
	}
}
