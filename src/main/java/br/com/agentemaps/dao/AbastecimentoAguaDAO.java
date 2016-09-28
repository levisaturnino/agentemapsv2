package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.AbastecimentoAgua;

public interface AbastecimentoAguaDAO {
	
	public void salvar(AbastecimentoAgua abastecimentoAgua);

	public List<AbastecimentoAgua> listar();

	public void atualizar(AbastecimentoAgua abastecimentoAgua);

	public void excluir(AbastecimentoAgua abastecimentoAgua);



}
