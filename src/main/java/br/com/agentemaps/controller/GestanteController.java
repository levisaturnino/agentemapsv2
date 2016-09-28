package br.com.agentemaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.GestanteDAO;
import br.com.agentemaps.dao.GestanteDAOImpl;
import br.com.agentemaps.model.Gestante;

@ManagedBean
@SessionScoped
public class GestanteController {
		
	private Gestante gestante;
	private DataModel<Gestante> listaGestantes;	
	
	public GestanteController() { 
		gestante = new Gestante(); 
	}

	public DataModel<Gestante> getListarGestantes() {
		List<Gestante> lista = new GestanteDAOImpl().listar();
		listaGestantes = new ListDataModel<Gestante>(lista);
		return listaGestantes;
	}

	public Gestante getGestante() {
		return gestante;
	}

	public void setGestante(Gestante gestante) {
		this.gestante = gestante;
	}

	public String prepararAdicionarGestante() {
		gestante = new Gestante();
		return "";
	}

	public String prepararAlterarGestante() {
		gestante = (Gestante) (listaGestantes.getRowData());
		return "";
	}

	public String excluirGestante() {
		Gestante GestanteTemp = (Gestante) (listaGestantes.getRowData());
		GestanteDAO dao = new GestanteDAOImpl();
		dao.excluir(GestanteTemp);
		return "";
	}

	public String adicionarGestante() {
		GestanteDAOImpl dao = new GestanteDAOImpl();
		dao.salvar(gestante);
		return "";
	}

	public String alterarGestante() {
		GestanteDAO dao = new GestanteDAOImpl();
		dao.atualizar(gestante);
		return "";
	}
}
