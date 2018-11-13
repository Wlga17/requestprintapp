package br.com.expertsunited.controler.regra;

import java.util.List;

import br.com.expertsunited.model.dao.IPropostaDAO;
import br.com.expertsunited.model.dao.PropostaDAO;
import br.com.expertsunited.model.entity.Proposta;

public class PropostaNegocio {

	private final IPropostaDAO daoProposta;
	
	public PropostaNegocio() {
		daoProposta = new PropostaDAO();
	}
	
	public void validarNuloProposta(Proposta proposta) throws Exception{
		if(proposta == null) {
			throw new Exception("Proposta não instanciada");
		}
		if(proposta.getDescricao().equals("") == true || proposta.getDescricao() == null) {
			throw new Exception("Descrição em branco");
		}
		if(proposta.getDataProposta().equals("") == true || proposta.getDataProposta() == null) {
			throw new Exception("Data da proposta em branco");
		}
	}
	
	public void inserirProposta(Proposta proposta) throws Exception{
		try {
			daoProposta.create(proposta);
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public void alterarProposta(Proposta proposta) throws Exception{
		try {
			daoProposta.update(proposta);
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public void removerProposta(Proposta proposta) throws Exception{
		try {
			daoProposta.remove(proposta);
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public Proposta buscaPorIdProposta(int id) throws Exception{
		try {
			Proposta consulta = daoProposta.getByID(id);
			return consulta;
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public List<Proposta> listarTodasProposta() throws Exception{
		try {
			List<Proposta> lista = daoProposta.getList();
			return lista;
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
}
