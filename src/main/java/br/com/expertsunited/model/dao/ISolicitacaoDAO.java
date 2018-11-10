package br.com.expertsunited.model.dao;

import java.util.List;

import br.com.expertsunited.model.entity.Solicitacao;

public interface ISolicitacaoDAO {

	public void create(Solicitacao solicitacao);
	public void update(Solicitacao solicitacao);
	public void remove(Solicitacao solicitacao);
	public Solicitacao getById(int id);
	public List<Solicitacao> getList();
}
