package br.com.agentemaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
	
	
	public void info() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
	}

	public void warn() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Watch out for PrimeFaces."));
	}

	public void error() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
	}

	public void fatal() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
	}
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
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Membro Cadastrada com Sucesso!."));
		return "";
	}

	public String alterarMembro() {
		MembroDAO dao = new MembroDAOImpl();
		dao.atualizar(membro);
		return "";
	}
}
