package br.com.expertsunited.model.dao;

import java.util.List;

import br.com.expertsunited.model.entity.ClienteFisico;


public interface IClienteFisicoDAO {

	public void create(ClienteFisico cliente);
	public void update(ClienteFisico cliente);
	public void remove(ClienteFisico cliente);
	public ClienteFisico getById (int id);
	public List<ClienteFisico> getList ();
}
