package br.com.expertsunited.model.dao;

import java.util.List;

import br.com.expertsunited.model.entity.Categoria;

public interface ICategoriaDAO {
	public void create(Categoria categoria);
	public void update(Categoria categoria);
	public void remove(Categoria categoria);
	public List<Categoria> getList();
	public Categoria getByID(int id);
}
