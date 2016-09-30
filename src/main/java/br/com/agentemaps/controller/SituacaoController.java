package br.com.agentemaps.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.SituacaoDAO;
import br.com.agentemaps.dao.SituacaoDAOImpl;
import br.com.agentemaps.model.Situacao;

@ManagedBean
@SessionScoped
public class SituacaoController {
		
	private Situacao situacao;
	private DataModel<Situacao> listaTiposCasa;	
	
	public SituacaoController() { 
		situacao = new Situacao(); 
	}

	public DataModel<Situacao> getListarTiposCasa() {
		List<Situacao> lista = new SituacaoDAOImpl().listar();
		listaTiposCasa = new ListDataModel<Situacao>(lista);
		return listaTiposCasa;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao Situacao) {
		this.situacao = Situacao;
	}

	public String prepararAdicionarSituacao() {
		situacao = new Situacao();
		return "";
	}

	public String prepararAlterarSituacao() {
		situacao = (Situacao) (listaTiposCasa.getRowData());
		return "";
	}

	public String excluirSituacao() {
		Situacao situacaoTemp = (Situacao) (listaTiposCasa.getRowData());
		SituacaoDAO dao = new SituacaoDAOImpl();
		dao.excluir(situacaoTemp);
		return "";
	}

	public String adicionarSituacao() {
		SituacaoDAOImpl dao = new SituacaoDAOImpl();
		dao.salvar(situacao);
		return "";
	}

	public String alterarSituacao() {
		SituacaoDAO dao = new SituacaoDAOImpl();
		dao.atualizar(situacao);
		return "";
	}
}
