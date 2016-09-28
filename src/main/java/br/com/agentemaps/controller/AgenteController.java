package br.com.agentemaps.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.AgenteDAO;
import br.com.agentemaps.dao.AgenteDAOImpl;
import br.com.agentemaps.model.Agente;
@ManagedBean
@SessionScoped
public class AgenteController {
	private Agente agente;
	private DataModel<Agente> listaAgentes;

	public DataModel<Agente> getListarAgentes() {
		List<Agente> lista = new AgenteDAOImpl().listar();
		listaAgentes = new ListDataModel<Agente>(lista);
		return listaAgentes;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente Agente) {
		this.agente = Agente;
	}

	public String prepararAdicionarAgente() {
		agente = new Agente();
		return "04cadastrarAgente";
	}

	public String prepararAlterarAgente() {
		agente = (Agente) (listaAgentes.getRowData());
		return "04cadastrarAgente";
	}

	public String excluirAgente() {
		Agente AgenteTemp = (Agente) (listaAgentes.getRowData());
		AgenteDAO dao = new AgenteDAOImpl();
		dao.excluir(AgenteTemp);
		return "listaagente";
	}

	public String adicionarAgente() {
		AgenteDAOImpl dao = new AgenteDAOImpl();
		dao.salvar(agente);
		return "listaagente";
	}

	public String alterarAgente() {
		AgenteDAO dao = new AgenteDAOImpl();
		dao.atualizar(agente);
		return "listaagente";
	}
}
