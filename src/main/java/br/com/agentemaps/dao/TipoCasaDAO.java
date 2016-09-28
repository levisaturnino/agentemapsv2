package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.TipoCasa;

public interface TipoCasaDAO {

	public void salvar(TipoCasa tipoCasa);

	public List<TipoCasa> listar();

	public void atualizar(TipoCasa tipoCasa);

	public void excluir(TipoCasa tipoCasa);

}
