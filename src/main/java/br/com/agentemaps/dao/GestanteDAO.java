package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.Gestante;

public interface GestanteDAO {

	public void salvar(Gestante gestante);

	public List<Gestante> listar();

	public void atualizar(Gestante gestante);

	public void excluir(Gestante gestante);

}
