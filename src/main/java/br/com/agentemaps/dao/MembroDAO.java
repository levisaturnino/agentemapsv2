package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.Membro;

public interface MembroDAO {

	public void salvar(Membro membro);

	public List<Membro> listar();

	public void atualizar(Membro membro);

	public void excluir(Membro membro);

}
