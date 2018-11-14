package br.com.expertsunited.controler.managedBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.expertsunited.model.entity.Login;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Login login;
	
	public LoginMB() {
		login = new Login();
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	public String realizarLogin() {
		if(login.getLogin().equals("useradmin") && login.getSenha().equals("passfree")) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("usuario", login);
			return "/app/index?faces-redirect=true";
		} else {
			return "/seguranca/login?faces-redirect=true";
		}
	}
	
	public String realizarLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/seguranca/login?faces-redirect=true";
	}
}
