package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.Hipertenso;

public interface HipertensoDAO {

	public void salvar(Hipertenso hipertenso);

	public List<Hipertenso> listar();

	public void atualizar(Hipertenso hipertenso);

	public void excluir(Hipertenso hipertenso);

}
