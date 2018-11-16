package br.com.expertsunited.controler.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.expertsunited.model.entity.Usuario;

@WebFilter(filterName = "cadastrograficaAuth", urlPatterns = {"/cadastro/teste.xhtml"})
public class cadastrograficaAuth implements Filter {

  public cadastrograficaAuth() {
      // TODO Auto-generated constructor stub
  }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = (HttpSession) req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if (usuario == null) {
			res.sendRedirect(req.getContextPath() + "/cadastro/teste.xhtml");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
