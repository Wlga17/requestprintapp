package br.com.expertsunited.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
			Query consulta = eManager.createQuery("SELECT p FROM Proposta p");
			propostas = consulta.getResultList();

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

	/**
	 * Método para listar todas os objetos Proposta da grafica
	 * que estiver logada no site 
	 */
	public List<Proposta> getListByIDGrafica() {
		List<Proposta> propostas = null;
		try {
			String consulta = "SELECT p FROM Proposta p where p.grafica = '3'";
			TypedQuery<Proposta> lista = eManager.createQuery(consulta, Proposta.class);
			propostas = lista.getResultList();
		} catch(Exception ex) {
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
		return propostas;
	}

}
