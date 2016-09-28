package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.Administrador;
import br.com.agentemaps.model.Agente;

public interface AgenteDAO {
	
	public void salvar(Agente agente);

	public List<Agente> listar();

	public void atualizar(Agente agente);

	public void excluir(Agente agente);
	
	public Agente getAgente(long id);

}
