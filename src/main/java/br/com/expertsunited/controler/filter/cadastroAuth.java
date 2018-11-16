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
import javax.servlet.http.HttpSession;

import br.com.expertsunited.model.entity.Usuario;

@WebFilter(filterName = "cadastroAuth", urlPatterns = {"/cadastro/*"})
public class cadastroAuth implements Filter {

  public cadastroAuth() {
      // TODO Auto-generated constructor stub
  }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = (HttpSession) req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if (usuario == null) {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
