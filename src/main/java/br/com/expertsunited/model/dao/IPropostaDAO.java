package br.com.expertsunited.model.dao;

import java.util.List;
import br.com.expertsunited.model.entity.Proposta;

public interface IPropostaDAO {
	public void create(Proposta proposta);
	public void update(Proposta proposta);
	public void remove(Proposta proposta);
	public List<Proposta> getList();
	public Proposta getByID(int id);
	public List<Proposta> getListByIDGrafica();
}
