package br.com.expertsunited.facade;

import java.util.List;

import br.com.expertsunited.controler.regra.GraficaNegocio;
import br.com.expertsunited.model.entity.Grafica;

public class GraficaFachada {
	
	private final GraficaNegocio graNeg;
	
	public GraficaFachada() {
		graNeg = new GraficaNegocio();
	}
	
	public void createGrafica(Grafica grafica) throws Exception{
		graNeg.validarNuloGrafica(grafica);
		graNeg.inserirGrafica(grafica);
	}
	
	public void updateGrafica(Grafica grafica) throws Exception{
		graNeg.alterarGrafica(grafica);
	}
	
	public void removeGrafica(Grafica grafica) throws Exception{
		graNeg.removerGrafica(grafica);
	}
	
	public Grafica getByIdCategoria(int id) throws Exception{
		return graNeg.buscarPorIdGrafica(id);
	}
	
	public List<Grafica> getListGrafica() throws Exception{
		return graNeg.listaGrafica();
	}
	
}
