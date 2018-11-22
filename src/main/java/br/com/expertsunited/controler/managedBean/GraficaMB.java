package br.com.expertsunited.controler.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.expertsunited.facade.GraficaFachada;
import br.com.expertsunited.model.entity.Grafica;

@ManagedBean(name ="GraficaMB")
public class GraficaMB {
	
	private Grafica grafica;
	private List<Grafica> listar;
	
	public GraficaMB() {
		grafica = new Grafica();
	}

	public Grafica getGrafica() {
		return grafica;
	}

	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
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
}
