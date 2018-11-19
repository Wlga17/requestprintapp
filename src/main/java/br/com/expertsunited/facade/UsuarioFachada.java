package br.com.expertsunited.facade;

import br.com.expertsunited.controler.regra.UsuarioNegocio;
import br.com.expertsunited.model.entity.Usuario;

public class UsuarioFachada {
	private final UsuarioNegocio usuarioNeg;
	
	public UsuarioFachada() {
		usuarioNeg = new UsuarioNegocio();
	}
	
	public boolean login(Usuario usuario) throws Exception {
		return usuarioNeg.validaLoginSenha(usuario);
	}
	
	public Usuario getUsuarioLogado(String login, String senha) throws Exception {
		return usuarioNeg.getUsuario(login, senha);
	}
	
	public boolean tipoLogin(Usuario usuario) throws Exception {
		return usuarioNeg.loginGrafica(usuario);
	}
}
