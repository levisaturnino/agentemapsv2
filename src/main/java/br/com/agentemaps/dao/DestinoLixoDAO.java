package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.DestinoLixo;

public interface DestinoLixoDAO {

	public void salvar(DestinoLixo destinoLixo);

	public List<DestinoLixo> listar();

	public void atualizar(DestinoLixo destinoLixo);

	public void excluir(DestinoLixo destinoLixo);

}
