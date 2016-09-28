package br.com.agentemaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.DestinoFezesDAO;
import br.com.agentemaps.dao.DestinoFezesDAOImpl;
import br.com.agentemaps.model.DestinoFezes;

@ManagedBean
@SessionScoped
public class DestinoFezesController {
	
	private DestinoFezes destinoFezes;
	private DataModel<DestinoFezes> listaDestinosFezes;	

	public DestinoFezesController() { 
		destinoFezes = new DestinoFezes(); 
	}

	public DataModel<DestinoFezes> getListarDestinosFezes() {
		List<DestinoFezes> lista = new DestinoFezesDAOImpl().listar();
		listaDestinosFezes = new ListDataModel<DestinoFezes>(lista);
		return listaDestinosFezes;
	}

	public DestinoFezes getDestinoFezes() {
		return destinoFezes;
	}

	public void setDestinoFezes(DestinoFezes destinoFezes) {
		this.destinoFezes = destinoFezes;
	}

	public String prepararAdicionarDestinoFezes() {
		destinoFezes = new DestinoFezes();
		return "";
	}

	public String prepararAlterarDestinoFezes() {
		destinoFezes = (DestinoFezes) (listaDestinosFezes.getRowData());
		return "";
	}

	public String excluirDestinoFezes() {
		DestinoFezes DestinoFezesTemp = (DestinoFezes) (listaDestinosFezes.getRowData());
		DestinoFezesDAO dao = new DestinoFezesDAOImpl();
		dao.excluir(DestinoFezesTemp);
		return "";
	}

	public String adicionarDestinoFezes() {
		DestinoFezesDAOImpl dao = new DestinoFezesDAOImpl();
		dao.salvar(destinoFezes);
		return "";
	}

	public String alterarDestinoFezes() {
		DestinoFezesDAO dao = new DestinoFezesDAOImpl();
		dao.atualizar(destinoFezes);
		return "";
	}
}
