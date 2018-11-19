package br.com.expertsunited.controler.managedBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.expertsunited.facade.UsuarioFachada;
import br.com.expertsunited.model.entity.Usuario;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public LoginMB() {
		usuario = new Usuario();
	}

	public Usuario getLogin() {
		return usuario;
	}

	public void setLogin(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String realizarLogin() throws Exception {
		UsuarioFachada usuarioFach = new UsuarioFachada();
		if(usuarioFach.login(usuario)) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("usuario", usuario);
			UsuarioFachada userFachada = new UsuarioFachada();

			Usuario usuarioLogado = userFachada.getUsuarioLogado(usuario.getLogin(), usuario.getSenha());
			System.out.println("usuario logado LOGIN: " + usuarioLogado.getLogin());
			System.out.println("usuario logado SENHA: " + usuarioLogado.getSenha());
			System.out.println("usuario logado ID: " + usuarioLogado.getIdUsuario());
			System.out.println("usuario logado IsGrafica: " + usuarioLogado.getIsGrafica());
			if (usuarioLogado.getIsGrafica() == 1) {
				return "/app/grafica/index?faces-redirect=true";
			}
			return "/app/cliente/index?faces-redirect=true";
		} else {
			return "/seguranca/login?faces-redirect=true";
		}
	}
	
	public String realizarLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/seguranca/login?faces-redirect=true";
	}
	
	public String cadastroGrafica() throws Exception {
		return "/cadastro/grafica?faces-redirect=true";
	}
	
	public String cadastroCliente() throws Exception {
		return "/cadastro/cliente?faces-redirect=true";
	}
}
