package test;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.dao.GraficaDAO;
import br.com.expertsunited.model.entity.Grafica;

public class GraficaDAOTest {
//	@Test
//	public void createTest() {
//		Grafica grafica = new Grafica();
//		GraficaDAO graficaDao = new GraficaDAO();
//		
//		grafica.setNome("Delete me");
//		grafica.setCnpj("8974.3256.84");
//		grafica.setEmail("deleteme@grafica.com");
//		grafica.setTelefone("8199756-8451");
//		grafica.setFornecedor(true);
//		grafica.setAvaliacao(2);
//		grafica.setLogin("deletemeadmin");
//		grafica.setSenha("novasenha");
//		
//		graficaDao.create(grafica);
//	}
	
//	@Test
//	public void updateTest() {
//		EntityManager eManager = UtilJPA.getEntityManager();
//		GraficaDAO graficaDao = new GraficaDAO();
//		Grafica grafica = eManager.find(Grafica.class, 3);
//		grafica.setNome("Graphic SpeedArt");
//		
//		graficaDao.update(grafica);
//	}
	
//	@Test
//	public void deleteGraficaTest() {
//		EntityManager eManager = UtilJPA.getEntityManager();
//		GraficaDAO graficaDao = new GraficaDAO();
//		Grafica grafica = eManager.find(Grafica.class, 4);
//		
//		graficaDao.remove(grafica);
//	}
	
//	@Test
//	public void getListTest() {
//		GraficaDAO graficaDao = new GraficaDAO();
//		
//		for(Grafica g: graficaDao.getList()) {
//			System.out.println("Gráfica: " + g.getNome());
//		}
//	}
	
//	@Test
//	public void getByIDTest() {
//		GraficaDAO graficaDao = new GraficaDAO();
//		Grafica grafica = graficaDao.getByID(1);
//		System.out.println(grafica.getNome());
//	}
}
