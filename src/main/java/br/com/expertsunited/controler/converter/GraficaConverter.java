package br.com.expertsunited.controler.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.expertsunited.facade.GraficaFachada;
import br.com.expertsunited.model.entity.Grafica;

@FacesConverter(value = "graficaConverter", forClass = Grafica.class)
public class GraficaConverter implements Converter{

	public Object getAsObject(FacesContext context, UIComponent component, String pString) {
		GraficaFachada f = new GraficaFachada();
		Grafica grafica = null;
		if(pString == null || pString.isEmpty()) {
			return null;
		}
		Integer id = Integer.valueOf(pString);
		try {
			grafica = f.getByIdGrafica(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grafica;
	}

	public String getAsString(FacesContext context, UIComponent component, Object pOb) {
		Grafica grafica = (Grafica) pOb;
		if(grafica == null || grafica.getIdUsuario() == 0) {
			return null;
		}
		return String.valueOf(grafica.getIdUsuario());
	}
	
}
