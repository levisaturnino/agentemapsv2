package br.com.agentemaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.FamiliaDAO;
import br.com.agentemaps.dao.FamiliaDAOImpl;
import br.com.agentemaps.model.Familia;

@ManagedBean
@SessionScoped
public class FamiliaController {
		
	private Familia familia;
	private DataModel<Familia> listaFamilias;	
	
	public FamiliaController() { 
		familia = new Familia(); 
	}

	public DataModel<Familia> getListarFamilias() {
		List<Familia> lista = new FamiliaDAOImpl().listar();
		listaFamilias = new ListDataModel<Familia>(lista);
		return listaFamilias;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public String prepararAdicionarFamilia() {
		familia = new Familia();
		return "";
	}

	public String prepararAlterarFamilia() {
		familia = (Familia) (listaFamilias.getRowData());
		return "";
	}

	public String excluirFamilia() {
		Familia FamiliaTemp = (Familia) (listaFamilias.getRowData());
		FamiliaDAO dao = new FamiliaDAOImpl();
		dao.excluir(FamiliaTemp);
		return "";
	}

	public String adicionarFamilia() {
		FamiliaDAOImpl dao = new FamiliaDAOImpl();
		dao.salvar(familia);
		return "";
	}

	public String alterarFamilia() {
		FamiliaDAO dao = new FamiliaDAOImpl();
		dao.atualizar(familia);
		return "";
	}
}
