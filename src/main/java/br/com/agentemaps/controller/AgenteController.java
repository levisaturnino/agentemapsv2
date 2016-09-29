package br.com.agentemaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.AgenteDAO;
import br.com.agentemaps.dao.AgenteDAOImpl;
import br.com.agentemaps.model.Agente;

@ManagedBean
@SessionScoped
public class AgenteController {
		
	private Agente agente;
	private DataModel<Agente> listaAgentes;	
	
	
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
			agente = new Agente(); 
	 }
	
	 
	public AgenteController() { 
		agente = new Agente(); 
	}

	public DataModel<Agente> getListarAgentes() {
		List<Agente> lista = new AgenteDAOImpl().listar();
		listaAgentes = new ListDataModel<Agente>(lista);
		return listaAgentes;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public String prepararAdicionarAgente() {
		agente = new Agente();
		return "cadastrarAgente";
	}

	public String prepararAlterarAgente() {
		agente = (Agente) (listaAgentes.getRowData());
		return "cadastrarAgente";
	}

	public String excluirAgente() {
		Agente AgenteTemp = (Agente) (listaAgentes.getRowData());
		AgenteDAO dao = new AgenteDAOImpl();
		dao.excluir(AgenteTemp);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "O agente "+AgenteTemp.getNome()+" foi excluído"));
		return "listarAgente";
	}

	public String adicionarAgente() {
		AgenteDAOImpl dao = new AgenteDAOImpl();
		dao.salvar(agente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Agente Cadastrado com Sucesso!."));
		return "listarAgente";
	}

	public String alterarAgente() {
		AgenteDAO dao = new AgenteDAOImpl();
		dao.atualizar(agente);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",  "Agente alterado com Sucesso!."));

		return "listarAgente";
	}
}
