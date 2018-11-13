package br.com.expertsunited.controler.managedBean;

import javax.faces.bean.ManagedBean;

import br.com.expertsunited.facade.GraficaFachada;
import br.com.expertsunited.model.entity.Grafica;

@ManagedBean()
public class graficaMB {
	Grafica grafica = new Grafica();
	
	public graficaMB() {
		// TODO Auto-generated constructor stub
	}

	public Grafica getGrafica() {
		return grafica;
	}

	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
	}
	
	public void inserir() {
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
