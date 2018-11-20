package test;

import org.junit.Test;

import br.com.expertsunited.facade.SolicitacaoFachada;
import br.com.expertsunited.model.dao.SolicitacaoDAO;
import br.com.expertsunited.model.entity.Solicitacao;

public class SolicitacaoDAOTeste {
	
@Test
public void createTest() {
	Solicitacao sol = new Solicitacao();
	SolicitacaoDAO soliDao = new SolicitacaoDAO();
	
	sol.setTitulo("Cartão João Almeida");
	sol.setDataSolicitacao("12/25/2018");
	sol.setDataEntrega("30/12/2018");
	sol.setObservacao("Preciso disso tudo pronto");
	
	soliDao.create(sol);
}

//	@Test
//	public void getListTest() {
//		SolicitacaoFachada f = new SolicitacaoFachada();
//		
//		try {
//			for(Solicitacao s : f.getListSolicitacao()) {
//				System.out.println("Titulo da solicitação: " + s.getTitulo());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
