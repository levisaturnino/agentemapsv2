package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.Familia;

public interface FamiliaDAO {

	public void salvar(Familia familia);

	public List<Familia> listar();

	public void atualizar(Familia familia);

	public void excluir(Familia familia);

}
