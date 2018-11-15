package br.com.expertsunited.model.dao;

import java.util.List;

import br.com.expertsunited.model.entity.Usuario;

public interface IUsuarioDAO {
	public void create(Usuario usuario);
	public void update(Usuario usuario);
	public void remove(Usuario usuario);
	public List<Usuario> getList();
	public Usuario getByID(int id);
}
