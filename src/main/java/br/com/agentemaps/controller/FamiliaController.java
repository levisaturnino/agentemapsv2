package br.com.agentemaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

	@PostConstruct
	public void init() {
		familia = new Familia();
	}



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
		return "familiacadastrar";
	}

	public String prepararAlterarFamilia() {
		familia = (Familia) (listaFamilias.getRowData());
		return "cadastrarFamilia";
	}

	public String excluirFamilia() {
		Familia FamiliaTemp = (Familia) (listaFamilias.getRowData());
		FamiliaDAO dao = new FamiliaDAOImpl();
		dao.excluir(FamiliaTemp);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
				"A Familia " + FamiliaTemp.getChefeFamilia() + " foi excluído"));

		return "";
	}

	public String adicionarFamilia() {
		FamiliaDAOImpl dao = new FamiliaDAOImpl();
		dao.salvar(familia);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Familia Cadastrada com Sucesso!."));

		return "listarFamilia";
	}

	public String alterarFamilia() {
		FamiliaDAO dao = new FamiliaDAOImpl();
		dao.atualizar(familia);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Familia alterada com Sucesso!."));
		return "listarFamilia";
	}
}
