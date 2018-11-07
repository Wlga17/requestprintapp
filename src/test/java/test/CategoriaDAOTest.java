package test;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.dao.CategoriaDAO;
import br.com.expertsunited.model.entity.Categoria;

public class CategoriaDAOTest {
	EntityManager eManager = UtilJPA.getEntityManager();
	CategoriaDAO categoriaDao = new CategoriaDAO();
	
//	@Test
//	public void createTest() {
//		Categoria categoria = new Categoria();
//		
//		
//		categoria.setNome("Criação");
//		
//		categoriaDao.create(categoria);
//	}
	
//	@Test
//	public void updateTest() {
//		Categoria categoria = eManager.find(Categoria.class, 3);
//		
//		categoria.setNome("Banner Vertical");
//		categoriaDao.update(categoria);
//	}
	
//	@Test
//	public void removeTest() {
//		Categoria categoria = eManager.find(Categoria.class, 5);
//		
//		categoriaDao.remove(categoria);
//	}
	
//	@Test
//	public void getListTest() {
//		for (Categoria c: categoriaDao.getList()) {
//			System.out.println("Categoria: " + c.getNome());
//		}
//	}
	
//	@Test
//	public void getByIDTest() {
//		Categoria categoria = categoriaDao.getByID(2);
//		
//		System.out.println(categoria.getNome());
//	}
}
