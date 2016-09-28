package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.DestinoFezes;

public interface DestinoFezesDAO {
	
	public void salvar(DestinoFezes destinoFezes);

	public List<DestinoFezes> listar();

	public void atualizar(DestinoFezes destinoFezes);

	public void excluir(DestinoFezes destinoFezes);

}
