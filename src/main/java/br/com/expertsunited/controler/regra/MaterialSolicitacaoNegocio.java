package br.com.expertsunited.controler.regra;

import java.util.List;

import br.com.expertsunited.model.dao.IMaterialSolicitacaoDAO;
import br.com.expertsunited.model.dao.MaterialSolicitacaoDAO;
import br.com.expertsunited.model.entity.MaterialSolicitacao;

public class MaterialSolicitacaoNegocio {

	private final IMaterialSolicitacaoDAO daoMatSol;
	
	public MaterialSolicitacaoNegocio() {
		daoMatSol = new MaterialSolicitacaoDAO();
	}
	
	public void validarNuloMatSol(MaterialSolicitacao matSol) throws Exception{
		if(matSol == null) {
			throw new Exception("Não instanciado!");
		}
		if(matSol.getQuantidade() <= 0 ) {
			throw new Exception("Quantidade em branco!");
		}
	}
	
	public void inserirMatSol(MaterialSolicitacao matSol) throws Exception{
		try {
			daoMatSol.create(matSol);
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public void alterarMatSol(MaterialSolicitacao matSol) throws Exception{
		try {
			daoMatSol.update(matSol);
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public void removerMatSol(MaterialSolicitacao matSol) throws Exception{
		try {
			daoMatSol.remove(matSol);
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public MaterialSolicitacao buscarPorIdMatSol(int id) throws Exception{
		try {
			MaterialSolicitacao consulta = daoMatSol.getByID(id);
			return consulta;
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public List<MaterialSolicitacao> listarTodosMatSol() throws Exception{
		try {
			List<MaterialSolicitacao> lista = daoMatSol.getlist();
			return lista;
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
}
