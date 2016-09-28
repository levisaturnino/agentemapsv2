package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.Visita;

public interface VisitaDAO {
	
	public void salvar(Visita visita);

	public List<Visita> listar();

	public void atualizar(Visita visita);

	public void excluir(Visita visita);

}
