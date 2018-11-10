package br.com.expertsunited.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.entity.Proposta;

public class PropostaDAO implements IPropostaDAO {
	EntityManager eManager = UtilJPA.getEntityManager();
	
	/**
	 * Método para persistir um novo objeto Proposta
	 * @param proposta 
	 */
	public void create(Proposta proposta) {
		try {
			eManager.getTransaction().begin();
			eManager.persist(proposta);
			eManager.getTransaction().commit();
		} catch (Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}

	/**
	 * Método para atualizar um objeto Proposta já persistido
	 * @param proposta
	 */
	public void update(Proposta proposta) {
		try {
			eManager.getTransaction().begin();
			eManager.merge(proposta);
			eManager.getTransaction().commit();
		}catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para excluir um objeto Proposta já persistido
	 * @param proposta
	 */
	public void remove(Proposta proposta) {
		try {
			eManager.find(Proposta.class, proposta.getId());
			eManager.getTransaction().begin();
			eManager.remove(proposta);
			eManager.getTransaction().commit();
		}catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
			
		}finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para listar todas os objetos Proposta persistidos 
	 */
	public List<Proposta> getList() {
		List<Proposta> propostas = null;
		try {
			propostas = eManager.createQuery("FROM Proposta").getResultList();

		}catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
		return propostas;
	}

	/**
	 * Método para buscar um objeto Proposta informando seu ID
	 * @param id
	 */
	public Proposta getByID(int id) {
		Proposta proposta = null;
		try {
			proposta = eManager.find(Proposta.class, id);
		}catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
		return proposta;
	}

}
