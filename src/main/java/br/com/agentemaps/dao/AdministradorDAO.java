package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.Administrador;


public interface AdministradorDAO {

	public void salvar(Administrador administrador);

	public List<Administrador> listar();

	public void atualizar(Administrador administrador);

	public void excluir(Administrador administrador);
	
	public Administrador getAdministrador(long id);


}
