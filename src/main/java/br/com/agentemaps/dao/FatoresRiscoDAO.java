package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.FatoresRisco;

public interface FatoresRiscoDAO {

	public void salvar(FatoresRisco fatoresRisco);

	public List<FatoresRisco> listar();

	public void atualizar(FatoresRisco fatoresRisco);

	public void excluir(FatoresRisco fatoresRisco);

}
