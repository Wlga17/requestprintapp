package br.com.expertsunited.model.dao;

import java.util.List;

import br.com.expertsunited.model.entity.Grafica;

public interface IGraficaDAO {
	public void create(Grafica grafica);
	public void update(Grafica grafica);
	public void remove(Grafica grafica);
	public List<Grafica> getList();
	public Grafica getByID(int id);
}
