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
	
	public void validarNuloGrafica(Grafica grafica) throws Exception{
		if(grafica == null) {
			throw new Exception("Grafica não instanciada");
		}
		if(grafica.getNome().equals("") == true || grafica.getNome() == null) {
			throw new Exception("nome da grafica em branco");
		}
		if(grafica.getEmail().equals("") ||grafica.getEmail() == null) {
			throw new Exception("email da grafica em branco");
		}
		if(grafica.getTelefone().equals("") ||grafica.getTelefone() == null) {
			throw new Exception("telefone da grafica em branco");
		}
		if(grafica.getCnpj().equals("") ||grafica.getCnpj() == null) {
			throw new Exception("cnpj da grafica em branco");
		}
		if(grafica.getLogin().equals("") || grafica.getLogin() == null) {
			throw new Exception("login da grafica em branco");
		}
		if(grafica.getSenha().equals("") || grafica.getSenha() == null) {
			throw new Exception("senha da grafica em branco");
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
