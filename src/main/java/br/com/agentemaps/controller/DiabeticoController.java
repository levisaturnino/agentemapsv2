package br.com.agentemaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.DiabeticoDAO;
import br.com.agentemaps.dao.DiabeticoDAOImpl;
import br.com.agentemaps.model.Diabetico;

@ManagedBean
@SessionScoped
public class DiabeticoController {
		
	private Diabetico diabetico;
	private DataModel<Diabetico> listaDiabeticos;	
	
	public DiabeticoController() { 
		diabetico = new Diabetico(); 
	}

	public DataModel<Diabetico> getListarDiabeticos() {
		List<Diabetico> lista = new DiabeticoDAOImpl().listar();
		listaDiabeticos = new ListDataModel<Diabetico>(lista);
		return listaDiabeticos;
	}

	public Diabetico getDiabetico() {
		return diabetico;
	}

	public void setDiabetico(Diabetico diabetico) {
		this.diabetico = diabetico;
	}

	public String prepararAdicionarDiabetico() {
		diabetico = new Diabetico();
		return "";
	}

	public String prepararAlterarDiabetico() {
		diabetico = (Diabetico) (listaDiabeticos.getRowData());
		return "";
	}

	public String excluirDiabetico() {
		Diabetico DiabeticoTemp = (Diabetico) (listaDiabeticos.getRowData());
		DiabeticoDAO dao = new DiabeticoDAOImpl();
		dao.excluir(DiabeticoTemp);
		return "";
	}

	public String adicionarDiabetico() {
		DiabeticoDAOImpl dao = new DiabeticoDAOImpl();
		dao.salvar(diabetico);
		return "";
	}

	public String alterarDiabetico() {
		DiabeticoDAO dao = new DiabeticoDAOImpl();
		dao.atualizar(diabetico);
		return "";
	}
}
