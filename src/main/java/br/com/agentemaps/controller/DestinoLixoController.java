package br.com.agentemaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.DestinoLixoDAO;
import br.com.agentemaps.dao.DestinoLixoDAOImpl;
import br.com.agentemaps.model.DestinoLixo;

@ManagedBean
@SessionScoped
public class DestinoLixoController {
		
	private DestinoLixo destinoLixo;
	private DataModel<DestinoLixo> listaDestinosLixo;	
	
	public DestinoLixoController() { 
		destinoLixo = new DestinoLixo(); 
	}

	public DataModel<DestinoLixo> getListarDestinosLixo() {
		List<DestinoLixo> lista = new DestinoLixoDAOImpl().listar();
		listaDestinosLixo = new ListDataModel<DestinoLixo>(lista);
		return listaDestinosLixo;
	}

	public DestinoLixo getDestinoLixo() {
		return destinoLixo;
	}

	public void setDestinoLixo(DestinoLixo destinoLixo) {
		this.destinoLixo = destinoLixo;
	}

	public String prepararAdicionarDestinoLixo() {
		destinoLixo = new DestinoLixo();
		return "";
	}

	public String prepararAlterarDestinoLixo() {
		destinoLixo = (DestinoLixo) (listaDestinosLixo.getRowData());
		return "";
	}

	public String excluirDestinoLixo() {
		DestinoLixo DestinoLixoTemp = (DestinoLixo) (listaDestinosLixo.getRowData());
		DestinoLixoDAO dao = new DestinoLixoDAOImpl();
		dao.excluir(DestinoLixoTemp);
		return "";
	}

	public String adicionarDestinoLixo() {
		DestinoLixoDAOImpl dao = new DestinoLixoDAOImpl();
		dao.salvar(destinoLixo);
		return "";
	}

	public String alterarDestinoLixo() {
		DestinoLixoDAO dao = new DestinoLixoDAOImpl();
		dao.atualizar(destinoLixo);
		return "";
	}
}
