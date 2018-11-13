package br.com.expertsunited.controler.regra;

import java.util.List;

import br.com.expertsunited.model.dao.GraficaDAO;
import br.com.expertsunited.model.dao.IGraficaDAO;
import br.com.expertsunited.model.entity.Grafica;

public class GraficaNegocio {

	private final IGraficaDAO daoGrafica;
	
	public GraficaNegocio() {
		daoGrafica = new GraficaDAO();
	}
	
	public void validaGrafica(Grafica grafica) throws Exception{
		if(grafica == null) {
			throw new Exception("Gráfica não instanciada");
		}
		if(grafica.getNome().equals("") == true || grafica.getNome() == null) {
			throw new Exception("Informe o nome da Gráfica");
		}
		if(grafica.getEmail().equals("") ||grafica.getEmail() == null) {
			throw new Exception("Informe o email da Gráfica");
		}
		if(grafica.getTelefone().equals("") ||grafica.getTelefone() == null) {
			throw new Exception("Informe o telefone da Gráfica");
		}
		if(grafica.getCnpj().equals("") ||grafica.getCnpj() == null) {
			throw new Exception("Informe o CNPJ da Gráfica");
		}
		if(grafica.getLogin().equals("") || grafica.getLogin() == null) {
			throw new Exception("Informe um login para a Gráfica");
		}
		if(grafica.getSenha().equals("") || grafica.getSenha() == null) {
			throw new Exception("Informe uma senha para a Gráfica");
		}	
	}
	
	public void inserirGrafica(Grafica grafica) throws Exception{
		try {
			daoGrafica.create(grafica);
		}
		catch(Exception ex) {			
			throw new Exception("Erro:" + ex.getMessage());
		}
	}
	
	public void alterarGrafica(Grafica grafica) throws Exception{
		try {
			daoGrafica.update(grafica);
		}
		catch(Exception ex) {
			throw new Exception("Erro:" + ex.getMessage());
		}
	}
	
	public void removerGrafica(Grafica grafica) throws Exception{
		try {
			daoGrafica.remove(grafica);
		}
		catch(Exception ex){
			throw new Exception("Erro:" + ex.getMessage());
		}
	}
	
	public Grafica buscarPorIdGrafica(int id) throws Exception{
		try {
			Grafica consultaGrafica = daoGrafica.getByID(id);
			return(consultaGrafica);
		}
		catch(Exception ex) {
			throw new Exception("Erro:" + ex.getMessage());
		}
	}
	
	public List<Grafica> listaGrafica() throws Exception{
		try {
			List<Grafica> lista = daoGrafica.getList();
			return(lista);
		}
		catch(Exception ex){
			throw new Exception("Erro:" + ex.getMessage() );
		}
	}
	
}
