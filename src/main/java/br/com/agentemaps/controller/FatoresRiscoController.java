package br.com.agentemaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.FatoresRiscoDAO;
import br.com.agentemaps.dao.FatoresRiscoDAOImpl;
import br.com.agentemaps.model.FatoresRisco;

@ManagedBean
@SessionScoped
public class FatoresRiscoController {
		
	private FatoresRisco fatoresRisco;
	private DataModel<FatoresRisco> listaFatoresRisco;	
	
	public FatoresRiscoController() { 
		fatoresRisco = new FatoresRisco(); 
	}

	public DataModel<FatoresRisco> getListarFatoresRisco() {
		List<FatoresRisco> lista = new FatoresRiscoDAOImpl().listar();
		listaFatoresRisco = new ListDataModel<FatoresRisco>(lista);
		return listaFatoresRisco;
	}

	public FatoresRisco getFatoresRisco() {
		return fatoresRisco;
	}

	public void setFatoresRisco(FatoresRisco fatoresRisco) {
		this.fatoresRisco = fatoresRisco;
	}

	public String prepararAdicionarFatoresRisco() {
		fatoresRisco = new FatoresRisco();
		return "";
	}

	public String prepararAlterarFatoresRisco() {
		fatoresRisco = (FatoresRisco) (listaFatoresRisco.getRowData());
		return "";
	}

	public String excluirFatoresRisco() {
		FatoresRisco FatoresRiscoTemp = (FatoresRisco) (listaFatoresRisco.getRowData());
		FatoresRiscoDAO dao = new FatoresRiscoDAOImpl();
		dao.excluir(FatoresRiscoTemp);
		return "";
	}

	public String adicionarFatoresRisco() {
		FatoresRiscoDAOImpl dao = new FatoresRiscoDAOImpl();
		dao.salvar(fatoresRisco);
		return "";
	}

	public String alterarFatoresRisco() {
		FatoresRiscoDAO dao = new FatoresRiscoDAOImpl();
		dao.atualizar(fatoresRisco);
		return "";
	}
}
