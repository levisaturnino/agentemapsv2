package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.Situacao;

public interface SituacaoDAO {
	
	public void salvar(Situacao situacao);

	public List<Situacao> listar();

	public void atualizar(Situacao situacao);

	public void excluir(Situacao situacao);



}
