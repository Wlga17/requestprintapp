package br.com.expertsunited.controler.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.expertsunited.facade.ClienteFachada;
import br.com.expertsunited.facade.GraficaFachada;
import br.com.expertsunited.model.entity.Grafica;

@ManagedBean(name ="GraficaMB")
@SessionScoped
public class GraficaMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Grafica grafica;
	private boolean campo = true;
	@ManagedProperty(value="#{loginMB.grafica}")
	private Grafica graf;
	private List<Grafica> listar;
	private List<Grafica> listarResultado;
	private String nomeGrafica;
	
	public String getNomeGrafica() {
		return nomeGrafica;
	}

	public void setNomeGrafica(String nomeGrafica) {
		this.nomeGrafica = nomeGrafica;
	}

	public GraficaMB() {
		grafica = new Grafica();
	}

	public Grafica getGrafica() {
		return grafica;
	}

	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
	}
	
	public boolean isCampo() {
		return campo;
	}

	public void setCampo(boolean campo) {
		this.campo = campo;
	}

	public Grafica getGraf() {
		return graf;
	}

	public void setGraf(Grafica graf) {
		this.graf = graf;
	}

	public List<Grafica> getListarResultado() {
		return listarResultado;
	}

	public void setListarResultado(List<Grafica> listarResultado) {
		this.listarResultado = listarResultado;
	}

	public List<Grafica> getListar() {
		GraficaFachada fachada = new GraficaFachada();
		try {
			listar = fachada.getListGrafica();
		} catch(Exception exp) {
			exp.printStackTrace();
		}
		return listar;
	}
	
	public void setListar(List<Grafica> listar) {
		this.listar = listar;
	}
	
	
	public String pesquisarGrafica() throws Exception {
		GraficaFachada fachada = new GraficaFachada();
		this.listarResultado = fachada.getByNameGrafica(nomeGrafica);
		return "Faltar terminar ainda";
	}
	
	public void inserir() {
		getGrafica().setIsGrafica(1);
		if (this.grafica != null) {
			GraficaFachada fachada = new GraficaFachada();
			try {
				fachada.createGrafica(grafica);
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}
	}
	
	public void editarGrafica() {
		GraficaFachada fachada = new GraficaFachada();
		try {
			fachada.updateGrafica(graf);
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void desbloquearCampo() {
		this.campo = false;
	}
	
}
