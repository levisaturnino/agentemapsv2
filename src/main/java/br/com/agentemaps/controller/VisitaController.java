package br.com.agentemaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.VisitaDAO;
import br.com.agentemaps.dao.VisitaDAOImpl;
import br.com.agentemaps.model.Visita;

@ManagedBean
@SessionScoped
public class VisitaController {
		
	private Visita visita;
	private DataModel<Visita> listaVisitas;	
	
	public VisitaController() { 
		visita = new Visita(); 
	}

	public DataModel<Visita> getListarVisitas() {
		List<Visita> lista = new VisitaDAOImpl().listar();
		listaVisitas = new ListDataModel<Visita>(lista);
		return listaVisitas;
	}

	public Visita getVisita() {
		return visita;
	}

	public void setVisita(Visita visita) {
		this.visita = visita;
	}

	public String prepararAdicionarVisita() {
		visita = new Visita();
		return "";
	}

	public String prepararAlterarVisita() {
		visita = (Visita) (listaVisitas.getRowData());
		return "";
	}

	public String excluirVisita() {
		Visita VisitaTemp = (Visita) (listaVisitas.getRowData());
		VisitaDAO dao = new VisitaDAOImpl();
		dao.excluir(VisitaTemp);
		return "";
	}

	public String adicionarVisita() {
		VisitaDAOImpl dao = new VisitaDAOImpl();
		dao.salvar(visita);
		return "";
	}

	public String alterarVisita() {
		VisitaDAO dao = new VisitaDAOImpl();
		dao.atualizar(visita);
		return "";
	}
}
