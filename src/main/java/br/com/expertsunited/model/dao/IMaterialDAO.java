package br.com.expertsunited.model.dao;

import java.util.List;

import br.com.expertsunited.model.entity.Material;

public interface IMaterialDAO {
	public void create(Material material);
	public void update(Material material);
	public void remove(Material material);
	public List<Material> getList();
	public Material getByID(int id);
}
