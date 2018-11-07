package test;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.dao.MaterialDAO;
import br.com.expertsunited.model.entity.Categoria;
import br.com.expertsunited.model.entity.Material;

public class MaterialDAOTest {
	EntityManager eManager = UtilJPA.getEntityManager();
	MaterialDAO materialDao = new MaterialDAO();
	
	@Test
	public void createTest() {
		Categoria categoria = eManager.find(Categoria.class, 1);
		Material material = new Material();
		
		material.setNome("Panfleto 15x21cm - couchê 90g - 4x0");
		material.setCategoria(categoria);
		
		materialDao.create(material);
	}
}
