package br.com.expertsunited.model.dao;

import java.util.List;

import br.com.expertsunited.model.entity.ClienteJuridico;


public interface IClienteJuridicoDAO {

	public void create(ClienteJuridico cliente);
	public void update(ClienteJuridico cliente);
	public void remove(ClienteJuridico cliente);
	public ClienteJuridico getById (int id);
	public List<ClienteJuridico> getList ();
}
