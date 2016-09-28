package br.com.agentemaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.TipoCasaDAO;
import br.com.agentemaps.dao.TipoCasaDAOImpl;
import br.com.agentemaps.model.TipoCasa;

@ManagedBean
@SessionScoped
public class TipoCasaController {
		
	private TipoCasa tipoCasa;
	private DataModel<TipoCasa> listaTiposCasa;	
	
	public TipoCasaController() { 
		tipoCasa = new TipoCasa(); 
	}

	public DataModel<TipoCasa> getListarTiposCasa() {
		List<TipoCasa> lista = new TipoCasaDAOImpl().listar();
		listaTiposCasa = new ListDataModel<TipoCasa>(lista);
		return listaTiposCasa;
	}

	public TipoCasa getTipoCasa() {
		return tipoCasa;
	}

	public void setTipoCasa(TipoCasa tipoCasa) {
		this.tipoCasa = tipoCasa;
	}

	public String prepararAdicionarTipoCasa() {
		tipoCasa = new TipoCasa();
		return "";
	}

	public String prepararAlterarTipoCasa() {
		tipoCasa = (TipoCasa) (listaTiposCasa.getRowData());
		return "";
	}

	public String excluirTipoCasa() {
		TipoCasa TipoCasaTemp = (TipoCasa) (listaTiposCasa.getRowData());
		TipoCasaDAO dao = new TipoCasaDAOImpl();
		dao.excluir(TipoCasaTemp);
		return "";
	}

	public String adicionarTipoCasa() {
		TipoCasaDAOImpl dao = new TipoCasaDAOImpl();
		dao.salvar(tipoCasa);
		return "";
	}

	public String alterarTipoCasa() {
		TipoCasaDAO dao = new TipoCasaDAOImpl();
		dao.atualizar(tipoCasa);
		return "";
	}
}
