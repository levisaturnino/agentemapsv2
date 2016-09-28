package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.Diabetico;

public interface DiabeticoDAO {

	public void salvar(Diabetico diabetico);

	public List<Diabetico> listar();

	public void atualizar(Diabetico diabetico);

	public void excluir(Diabetico diabetico);

}
