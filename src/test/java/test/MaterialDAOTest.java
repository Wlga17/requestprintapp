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
		Categoria categoria = eManager.find(Categoria.class, 2);
		Material material = new Material();
		
		material.setNome("Laminado Fosco - couchê 250g - 4x4");
		material.setCategoria(categoria);
		
		materialDao.create(material);
	}
}
