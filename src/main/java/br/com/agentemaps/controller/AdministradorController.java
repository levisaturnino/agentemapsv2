package br.com.agentemaps.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.AdministradorDAO;
import br.com.agentemaps.dao.AdministradorDAOImpl;
import br.com.agentemaps.model.Administrador;


@ManagedBean
@SessionScoped
public class AdministradorController {
	
	private Administrador administrador;
	private DataModel<Administrador> listaAdministradores;

	public DataModel<Administrador> getListarAdministradores() {
		List<Administrador> lista = new AdministradorDAOImpl().listar();
		listaAdministradores = new ListDataModel<Administrador>(lista);
		return listaAdministradores;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public String prepararAdicionarAdministrador() {
		administrador = new Administrador();
		return "gerenciarAdministrador";
	}

	public String prepararAlterarAdministrador() {
		administrador = (Administrador) (listaAdministradores.getRowData());
		return "gerenciarAdministrador";
	}

	public String excluirAdministrador() {
		Administrador administradorTemp = (Administrador) (listaAdministradores.getRowData());
		AdministradorDAO dao = new AdministradorDAOImpl();
		dao.excluir(administradorTemp);
		return "index";
	}

	public String adicionarAdministrador() {
		AdministradorDAOImpl dao = new AdministradorDAOImpl();
		dao.salvar(administrador);
		return "index";
	}

	public String alterarAdministrador() {
		AdministradorDAO dao = new AdministradorDAOImpl();
		dao.atualizar(administrador);
		return "index";
	}
}
