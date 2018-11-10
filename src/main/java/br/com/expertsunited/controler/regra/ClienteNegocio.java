package br.com.expertsunited.controler.regra;

import java.util.List;

import br.com.expertsunited.model.dao.ClienteFisicoDAO;
import br.com.expertsunited.model.dao.ClienteJuridicoDAO;
import br.com.expertsunited.model.dao.IClienteFisicoDAO;
import br.com.expertsunited.model.dao.IClienteJuridicoDAO;
import br.com.expertsunited.model.entity.ClienteFisico;
import br.com.expertsunited.model.entity.ClienteJuridico;


public class ClienteNegocio {

	private final IClienteFisicoDAO daoCF;
	private final IClienteJuridicoDAO daoCJ;
	
	public ClienteNegocio() {
		daoCF = new ClienteFisicoDAO();
		daoCJ = new ClienteJuridicoDAO();
	}
	
	public void validarNuloCF(ClienteFisico cliente) throws Exception{
		if(cliente == null) {
			throw new Exception("Cliente não instanciado!");
		}
		if(cliente.getNome().equals("") == true || cliente.getNome() == null) {
			throw new Exception("Nome do cliente em branco");
		}
		if(cliente.getCpf().equals("") == true || cliente.getCpf() == null) {
			throw new Exception("Cpf do cliente em branco");
		}
		if(cliente.getEmail().equals("") == true || cliente.getEmail() == null) {
			throw new Exception("Email do cliente em branco");
		}
		if(cliente.getTelefone().equals("") == true || cliente.getTelefone() == null) {
			throw new Exception("Telefone do cliente em branco");
		}
		if(cliente.getLogin().equals("") == true || cliente.getLogin() == null) {
			throw new Exception("Login do cliente em branco");
		}
		if(cliente.getSenha().equals("") == true || cliente.getSenha() == null) {
			throw new Exception("Senha do cliente em branco");
		}
	}
		
	public void inserirClienteCF(ClienteFisico cliente) throws Exception{
		try {
			daoCF.create(cliente);
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public void alterarClienteCF(ClienteFisico cliente) throws Exception{
		try {
			daoCF.update(cliente);
		}catch (Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}

	public void removerClienteCF(ClienteFisico cliente) throws Exception{
		try {
			daoCF.remove(cliente);
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public ClienteFisico buscarPorIdCF(int id) throws Exception{
		try {
			ClienteFisico consulta = daoCF.getById(id);
			return consulta;
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public List<ClienteFisico> listarTodosCF() throws Exception{
		try {
			List<ClienteFisico> lista = daoCF.getList();
			return lista;
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////
	
	
	public void validarNuloCJ(ClienteJuridico cliente) throws Exception{
		if(cliente == null) {
			throw new Exception("Cliente não instanciado!");
		}
		if(cliente.getNome().equals("") == true || cliente.getNome() == null) {
			throw new Exception("Nome do cliente em branco");
		}
		if(cliente.getCnpj().equals("") == true || cliente.getCnpj() == null) {
			throw new Exception("Cnpj do cliente em branco");
		}
		if(cliente.getEmail().equals("") == true || cliente.getEmail() == null) {
			throw new Exception("Email do cliente em branco");
		}
		if(cliente.getTelefone().equals("") == true || cliente.getTelefone() == null) {
			throw new Exception("Telefone do cliente em branco");
		}
		if(cliente.getLogin().equals("") == true || cliente.getLogin() == null) {
			throw new Exception("Login do cliente em branco");
		}
		if(cliente.getSenha().equals("") == true || cliente.getSenha() == null) {
			throw new Exception("Senha do cliente em branco");
		}
	}
	
	public void inserirClienteCJ(ClienteJuridico cliente) throws Exception{
		try {
			daoCJ.create(cliente);
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public void alterarClienteCJ(ClienteJuridico cliente) throws Exception{
		try {
			daoCJ.update(cliente);
		}catch (Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public void removerClienteCJ(ClienteJuridico cliente) throws Exception{
		try {
			daoCJ.remove(cliente);
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public ClienteJuridico buscarPorIdCJ(int id) throws Exception{
		try {
			ClienteJuridico consulta = daoCJ.getById(id);
			return consulta;
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public List<ClienteJuridico> listarTodosCJ() throws Exception{
		try {
			List<ClienteJuridico> lista = daoCJ.getList();
			return lista;
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
}
