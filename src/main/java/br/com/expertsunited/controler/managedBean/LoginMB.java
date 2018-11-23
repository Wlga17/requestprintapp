package br.com.expertsunited.controler.managedBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.expertsunited.facade.ClienteFachada;
import br.com.expertsunited.facade.GraficaFachada;
import br.com.expertsunited.facade.UsuarioFachada;
import br.com.expertsunited.model.entity.Cliente;
import br.com.expertsunited.model.entity.Grafica;
import br.com.expertsunited.model.entity.Usuario;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private Cliente cliente;
	private Grafica grafica;
	
	public LoginMB() {
		usuario = new Usuario();
	}

	public Usuario getLogin() {
		return usuario;
	}

	public void setLogin(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Grafica getGrafica() {
		return grafica;
	}

	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
	}
	
	public String realizarLogin() throws Exception {
		UsuarioFachada usuarioFach = new UsuarioFachada();
		ClienteFachada clienteFach = new ClienteFachada();
		GraficaFachada graficaFach = new GraficaFachada();
		if(usuarioFach.login(usuario)) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("usuario", usuario);
			UsuarioFachada userFachada = new UsuarioFachada();

			usuario = userFachada.getUsuarioLogado(usuario.getLogin(), usuario.getSenha());
			
			if (usuario.getIsGrafica() == 1) {
				grafica = (Grafica) graficaFach.getByIdGrafica(usuario.getIdUsuario());
				return "/app/grafica/index?faces-redirect=true";
			} else {
				cliente = (Cliente) clienteFach.getByIdCliente(usuario.getIdUsuario());
				return "/app/cliente/index?faces-redirect=true";
			}
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
