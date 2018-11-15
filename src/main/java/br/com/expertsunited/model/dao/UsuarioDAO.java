package br.com.expertsunited.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.entity.Usuario;

public class UsuarioDAO implements IUsuarioDAO {
	EntityManager eManager = UtilJPA.getEntityManager();
	
	/**
	 * Método para persistir um novo objeto Usuario
	 * @param usuario 
	 */
	public void create(Usuario usuario) {
		try {
			eManager.getTransaction().begin();
			eManager.persist(usuario);
			eManager.getTransaction().commit();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para atualizar um objeto Usuario já persistido
	 * @param usuario
	 */
	public void update(Usuario usuario) {
		try {
			eManager.getTransaction().begin();
			eManager.merge(usuario);
			eManager.getTransaction().commit();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para excluir um objeto Usuario já persistido
	 * @param usuario
	 */
	public void remove(Usuario usuario) {
		try {
			usuario = eManager.find(Usuario.class, usuario.getIdUsuario());
			eManager.getTransaction().begin();
			eManager.remove(usuario);
			eManager.getTransaction().commit();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * Método para listar todos os objetos Usuarios persistidos
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> getList() {
		List<Usuario> usuarios = null;
		try {
			usuarios = eManager.createQuery("FROM Usuario").getResultList();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
		return usuarios;
	}
	
	/**
	 * Método para buscar um objeto Usuario informando seu ID
	 * @param id
	 */
	public Usuario getByID(int id) {
		Usuario usuario = null;
		try {
			usuario = eManager.find(Usuario.class, id);
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
		return usuario;
	}
}
