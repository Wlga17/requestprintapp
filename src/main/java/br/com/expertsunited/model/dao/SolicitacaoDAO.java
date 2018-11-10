package br.com.expertsunited.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.entity.Solicitacao;

public class SolicitacaoDAO implements ISolicitacaoDAO{

	EntityManager eManager = UtilJPA.getEntityManager();
	
	/**
	 * Método para persistir um novo objeto Solicitacao
	 * @param solicitacao 
	 */
	public void create(Solicitacao solicitacao) {
		try {
			eManager.getTransaction().begin();
			eManager.persist(solicitacao);
			eManager.getTransaction().commit();
		}catch(Exception ex) {
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
	}

	/**
	 * Método para atualizar um objeto Solicitacao já persistido
	 * @param solicitacao
	 */
	public void update(Solicitacao solicitacao) {
		try {
			eManager.getTransaction().begin();
			eManager.merge(solicitacao);
			eManager.getTransaction().commit();
		}catch(Exception ex){
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
	}

	/**
	 * Método para excluir um objeto Solicitacao já persistido
	 * @param solicitacao
	 */
	public void remove(Solicitacao solicitacao) {
		try {
			solicitacao = eManager.find(Solicitacao.class, solicitacao.getId());
			eManager.getTransaction().begin();
			eManager.remove(solicitacao);
			eManager.getTransaction().commit();
		}catch(Exception ex) {
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
	}

	/**
	 * Método para buscar um objeto Solicitacao informando seu ID
	 * @param id
	 */
	public Solicitacao getById(int id) {
		Solicitacao solicitacao = null;
		try {
			solicitacao = eManager.find(Solicitacao.class, id);
		}catch(Exception ex) {
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
		return solicitacao;
	}

	/**
	 * Método para listar todas os objetos Solicitacao persistidos
	 */
	@SuppressWarnings("unchecked")
	public List<Solicitacao> getList() {
		List<Solicitacao> solicitacoes = null;
		try {
			Query consulta = eManager.createQuery("SELECT s FROM Solicitacao s");
			solicitacoes = consulta.getResultList();
		}catch(Exception ex) {
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
		return solicitacoes;
	}

}
