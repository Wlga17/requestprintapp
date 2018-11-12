package br.com.expertsunited.model.dao;

import java.util.List;

import br.com.expertsunited.model.entity.MaterialSolicitacao;

public interface IMaterialSolicitacaoDAO {


		public void create (MaterialSolicitacao materialsolicitacao);
		public void update (MaterialSolicitacao materialsolicitacao);
		public void remove (MaterialSolicitacao materialsolicitacao);
		public List<MaterialSolicitacao> getlist();
		public MaterialSolicitacao getByID(int id);
	
}
