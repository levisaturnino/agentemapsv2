package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.Administrador;
import br.com.agentemaps.model.Agente;

public interface AgenteDAO {
	
	public void salvar(Agente administrador);

	public List<Agente> listar();

	public void atualizar(Agente administrador);

	public void excluir(Agente administrador);
	
	public Agente getAgente(long id);

}
