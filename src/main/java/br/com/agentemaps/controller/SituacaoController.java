package br.com.Situacaomaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.SituacaoDAO;
import br.com.agentemaps.dao.SituacaoDAOImpl;
import br.com.agentemaps.model.Situacao;

@ManagedBean
@SessionScoped
public class SituacaoController {
		
	private Situacao Situacao;
	private DataModel<Situacao> listaSituacaos;	
	
	
	  public void info() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
	    }
	     
	    public void warn() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Watch out for PrimeFaces."));
	    }
	     
	    public void error() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
	    }
	     
	    public void fatal() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
	    }
	
	
	
	 @PostConstruct
	 public void init(){
			Situacao = new Situacao(); 
	 }
	
	 
	public SituacaoController() { 
		Situacao = new Situacao(); 
	}

	public DataModel<Situacao> getListarSituacaos() {
		List<Situacao> lista = new SituacaoDAOImpl().listar();
		listaSituacaos = new ListDataModel<Situacao>(lista);
		return listaSituacaos;
	}

	public Situacao getSituacao() {
		return Situacao;
	}

	public void setSituacao(Situacao Situacao) {
		this.Situacao = Situacao;
	}

	public String prepararAdicionarSituacao() {
		Situacao = new Situacao();
		return "cadastrarSituacao";
	}

	public String prepararAlterarSituacao() {
		Situacao = (Situacao) (listaSituacaos.getRowData());
		return "cadastrarSituacao";
	}

	public String excluirSituacao() {
		Situacao SituacaoTemp = (Situacao) (listaSituacaos.getRowData());
		SituacaoDAO dao = new SituacaoDAOImpl();
		dao.excluir(SituacaoTemp);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "O Situacao foi excluído"));
		return "listarSituacao";
	}

	public String adicionarSituacao() {
		SituacaoDAOImpl dao = new SituacaoDAOImpl();
		dao.salvar(Situacao);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Situacao Cadastrado com Sucesso!."));
		return "listarSituacao";
	}

	public String alterarSituacao() {
		SituacaoDAO dao = new SituacaoDAOImpl();
		dao.atualizar(Situacao);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",  "Situacao alterado com Sucesso!."));

		return "listarSituacao";
	}
}
