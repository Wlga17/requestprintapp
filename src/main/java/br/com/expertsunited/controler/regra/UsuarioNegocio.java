package br.com.expertsunited.controler.regra;

import br.com.expertsunited.model.dao.IUsuarioDAO;
import br.com.expertsunited.model.dao.UsuarioDAO;
import br.com.expertsunited.model.entity.Usuario;

public class UsuarioNegocio {
	private final IUsuarioDAO usuarioDAO;
	
	public UsuarioNegocio() {
		usuarioDAO = new UsuarioDAO();
	}
	
	public boolean validaLoginSenha(Usuario usuario) throws Exception {
		if(usuario.getLogin().equals("") || usuario.getLogin() == null) {
			throw new Exception("Informe o seu login");
		}
		if(usuario.getSenha().equals("") || usuario.getSenha() == null) {
			throw new Exception("Informe a sua senha");
		}
		Usuario usuarioLogin = usuarioDAO.getUsuario(usuario.getLogin(), usuario.getSenha());
		if (usuarioLogin != null) {
			return true;
		}
		return false;
	}
	
	public Usuario getUsuario(String login, String senha) throws Exception {
		Usuario usuario = usuarioDAO.getUsuario(login, senha);
		if (usuario != null) {
			return usuario;
		}
		return null;
	}
	
	public boolean loginGrafica(Usuario usuario) throws Exception {
		Usuario usuarioLogin = usuarioDAO.getUsuario(usuario.getLogin(), usuario.getSenha());
		if (usuarioLogin != null && usuarioLogin.getIsGrafica() == 1) {
			return true;
		}
		return false;
	}
}
