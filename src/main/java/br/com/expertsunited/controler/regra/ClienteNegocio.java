package br.com.expertsunited.controler.regra;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import br.com.expertsunited.model.dao.ClienteDAO;
import br.com.expertsunited.model.dao.IClienteDAO;
import br.com.expertsunited.model.entity.Cliente;


public class ClienteNegocio {
	private final IClienteDAO clienteDAO;
	
	public ClienteNegocio() {
		clienteDAO = new ClienteDAO();
	}
	
	public void validarNuloCF(Cliente cliente) throws Exception{
//		if(cliente == null) {
//			throw new Exception("Cliente não instanciado!");
//		}
//		if(cliente.getNome().equals("") == true || cliente.getNome() == null) {
//			throw new Exception("Nome do cliente em branco");
//		}
//		if(cliente.getCpf().equals("") == true || cliente.getCpf() == null) {
//			throw new Exception("Cpf do cliente em branco");
//		}
//		if(cliente.getEmail().equals("") == true || cliente.getEmail() == null) {
//			throw new Exception("Email do cliente em branco");
//		}
//		if(cliente.getTelefone().equals("") == true || cliente.getTelefone() == null) {
//			throw new Exception("Telefone do cliente em branco");
//		}
//		if(cliente.getLogin().equals("") == true || cliente.getLogin() == null) {
//			throw new Exception("Login do cliente em branco");
//		}
//		if(cliente.getSenha().equals("") == true || cliente.getSenha() == null) {
//			throw new Exception("Senha do cliente em branco");
//		}
	}
		
	public void inserirCliente(Cliente cliente, AjaxBehaviorEvent event) throws Exception{
		try {
			clienteDAO.create(cliente);
			System.out.println("passou aqui");
			FacesContext
			.getCurrentInstance()
			.addMessage(
					null,
					new FacesMessage("Cliente cadastrado com sucesso!!!")
					);
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public void alterarCliente(Cliente cliente) throws Exception{
		try {
			clienteDAO.update(cliente);
		}catch (Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}

	public void removerCliente(Cliente cliente) throws Exception{
		try {
			clienteDAO.remove(cliente);
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public Cliente buscarPorId(int id) throws Exception{
		try {
			Cliente consulta = clienteDAO.getByID(id);
			return consulta;
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
	
	public List<Cliente> listarTodos() throws Exception{
		try {
			List<Cliente> lista = clienteDAO.getList();
			return lista;
		}catch(Exception ex) {
			throw new Exception("Erro: " + ex.getMessage());
		}
	}
}
