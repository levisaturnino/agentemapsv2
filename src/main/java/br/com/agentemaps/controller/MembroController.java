package br.com.agentemaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.MembroDAO;
import br.com.agentemaps.dao.MembroDAOImpl;
import br.com.agentemaps.model.Membro;

@ManagedBean
@SessionScoped
public class MembroController {
		
	private Membro membro;
	private DataModel<Membro> listaMembros;	
	
	public MembroController() { 
		membro = new Membro(); 
	}

	public DataModel<Membro> getListarMembros() {
		List<Membro> lista = new MembroDAOImpl().listar();
		listaMembros = new ListDataModel<Membro>(lista);
		return listaMembros;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	public String prepararAdicionarMembro() {
		membro = new Membro();
		return "";
	}

	public String prepararAlterarMembro() {
		membro = (Membro) (listaMembros.getRowData());
		return "";
	}

	public String excluirMembro() {
		Membro MembroTemp = (Membro) (listaMembros.getRowData());
		MembroDAO dao = new MembroDAOImpl();
		dao.excluir(MembroTemp);
		return "";
	}

	public String adicionarMembro() {
		MembroDAOImpl dao = new MembroDAOImpl();
		dao.salvar(membro);
		return "";
	}

	public String alterarMembro() {
		MembroDAO dao = new MembroDAOImpl();
		dao.atualizar(membro);
		return "";
	}
}
