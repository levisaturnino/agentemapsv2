package br.com.agentemaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.HipertensoDAO;
import br.com.agentemaps.dao.HipertensoDAOImpl;
import br.com.agentemaps.model.Hipertenso;

@ManagedBean
@SessionScoped
public class HipertensoController {
		
	private Hipertenso hipertenso;
	private DataModel<Hipertenso> listaHipertensos;	
	
	public HipertensoController() { 
		hipertenso = new Hipertenso(); 
	}

	public DataModel<Hipertenso> getListarHipertensos() {
		List<Hipertenso> lista = new HipertensoDAOImpl().listar();
		listaHipertensos = new ListDataModel<Hipertenso>(lista);
		return listaHipertensos;
	}

	public Hipertenso getHipertenso() {
		return hipertenso;
	}

	public void setHipertenso(Hipertenso hipertenso) {
		this.hipertenso = hipertenso;
	}

	public String prepararAdicionarHipertenso() {
		hipertenso = new Hipertenso();
		return "";
	}

	public String prepararAlterarHipertenso() {
		hipertenso = (Hipertenso) (listaHipertensos.getRowData());
		return "";
	}

	public String excluirHipertenso() {
		Hipertenso HipertensoTemp = (Hipertenso) (listaHipertensos.getRowData());
		HipertensoDAO dao = new HipertensoDAOImpl();
		dao.excluir(HipertensoTemp);
		return "";
	}

	public String adicionarHipertenso() {
		HipertensoDAOImpl dao = new HipertensoDAOImpl();
		dao.salvar(hipertenso);
		return "";
	}

	public String alterarHipertenso() {
		HipertensoDAO dao = new HipertensoDAOImpl();
		dao.atualizar(hipertenso);
		return "";
	}
}
