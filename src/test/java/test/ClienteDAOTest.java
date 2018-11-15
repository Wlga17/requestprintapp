package test;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.dao.ClienteDAO;
import br.com.expertsunited.model.dao.UsuarioDAO;
import br.com.expertsunited.model.entity.Cliente;
import br.com.expertsunited.model.entity.Usuario;

public class ClienteDAOTest {
	EntityManager eManager = UtilJPA.getEntityManager();
	ClienteDAO cliDAO = new ClienteDAO();
	UsuarioDAO usuDAO = new UsuarioDAO();
//	@Test
//	public void createTest() {
//		Cliente cliente = new Cliente();
//		
//		cliente.setNome("inove");
//		cliente.setCnpj("0154.763.412");
//		cliente.setEmail("inove@email.com");
//		cliente.setTelefone("81 3468-8521");
//		cliente.setLogin("inove");
//		cliente.setSenha("inove123");
//		cliente.setIsGrafica(0);
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
//		Cliente cliente = eManager.find(Cliente.class, 4);
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
	
//	@Test
//	public void getUsuarioTest() {
//		Usuario usuario = usuDAO.getUsuario("ampla", "ampla123");
//		System.out.println("Usuário: " + usuario.getLogin() + " " + usuario.getSenha());
//	}
}
