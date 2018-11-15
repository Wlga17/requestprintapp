package test;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.dao.ClienteDAO;
import br.com.expertsunited.model.entity.Cliente;

public class ClienteDAOTest {
	EntityManager eManager = UtilJPA.getEntityManager();
	ClienteDAO cliDAO = new ClienteDAO();
//	@Test
//	public void createTest() {
//		Cliente cliente = new Cliente();
//		
//		cliente.setNome("Grafica MeExlui");
//		cliente.setCnpj("0007.412.478");
//		cliente.setEmail("meexclui@email.com");
//		cliente.setTelefone("81 3254-8461");
//		cliente.setLogin("meexcluiplease");
//		cliente.setSenha("passmeexclui");
//		cliente.setIsGrafica(1);
//		
//		cliDAO.create(cliente);
//	}
	
//	@Test
//	public void updateTest() {
//		Cliente cliente = eManager.find(Cliente.class, 4);
//		cliente.setNome("Ordem e Progresso");
//		
//		cliDAO.update(cliente);
//	}
	
//	@Test
//	public void deleteTest() {
//		Cliente cliente = eManager.find(Cliente.class, 5);
//		
//		cliDAO.remove(cliente);
//	}
	
//	@Test
//	public void getListTest() {
//		for(Cliente cli: cliDAO.getList()) {
//			System.out.println("Gráfica " + cli.getNome());
//		}
//	}
	
//	@Test
//	public void getByIDTest() {
//		Cliente cliente = cliDAO.getByID(4);
//		System.out.println(cliente.getNome());
//	}
}
