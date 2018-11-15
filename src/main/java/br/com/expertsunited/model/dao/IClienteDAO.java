package br.com.expertsunited.model.dao;

import java.util.List;

import br.com.expertsunited.model.entity.Cliente;

public interface IClienteDAO {
	public void create(Cliente cliente);
	public void update(Cliente cliente);
	public void remove(Cliente cliente);
	public List<Cliente> getList();
	public Cliente getByID(int id);
}
