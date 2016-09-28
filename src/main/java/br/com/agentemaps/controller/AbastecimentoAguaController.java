package br.com.agentemaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.AbastecimentoAguaDAO;
import br.com.agentemaps.dao.AbastecimentoAguaDAOImpl;
import br.com.agentemaps.model.AbastecimentoAgua;

@ManagedBean
@SessionScoped
public class AbastecimentoAguaController {

	private AbastecimentoAgua abastecimentoAgua;
	private DataModel<AbastecimentoAgua> listaAbastecimentosAgua;

	public AbastecimentoAguaController() {
		abastecimentoAgua = new AbastecimentoAgua();
	}

	public DataModel<AbastecimentoAgua> getListarAbastecimentoAguas() {
		List<AbastecimentoAgua> lista = new AbastecimentoAguaDAOImpl().listar();
		listaAbastecimentosAgua = new ListDataModel<AbastecimentoAgua>(lista);
		return listaAbastecimentosAgua;
	}

	public AbastecimentoAgua getAbastecimentoAgua() {
		return abastecimentoAgua;
	}

	public void setAbastecimentoAgua(AbastecimentoAgua abastecimentoAgua) {
		this.abastecimentoAgua = abastecimentoAgua;
	}

	public String prepararAdicionarAbastecimentoAgua() {
		abastecimentoAgua = new AbastecimentoAgua();
		return "";
	}

	public String prepararAlterarAbastecimentoAgua() {
		abastecimentoAgua = (AbastecimentoAgua) (listaAbastecimentosAgua.getRowData());
		return "";
	}

	public String excluirAbastecimentoAgua() {
		AbastecimentoAgua AbastecimentoAguaTemp = (AbastecimentoAgua) (listaAbastecimentosAgua.getRowData());
		AbastecimentoAguaDAO dao = new AbastecimentoAguaDAOImpl();
		dao.excluir(AbastecimentoAguaTemp);
		return "";
	}

	public String adicionarAbastecimentoAgua() {
		AbastecimentoAguaDAOImpl dao = new AbastecimentoAguaDAOImpl();
		dao.salvar(abastecimentoAgua);
		return "";
	}

	public String alterarAbastecimentoAgua() {
		AbastecimentoAguaDAO dao = new AbastecimentoAguaDAOImpl();
		dao.atualizar(abastecimentoAgua);
		return "";
	}
}
