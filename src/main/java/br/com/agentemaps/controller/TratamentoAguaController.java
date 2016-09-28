package br.com.agentemaps.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agentemaps.dao.TratamentoAguaDAO;
import br.com.agentemaps.dao.TratamentoAguaDAOImpl;
import br.com.agentemaps.model.TratamentoAgua;

@ManagedBean
@SessionScoped
public class TratamentoAguaController {
		
	private TratamentoAgua tratamentoAgua;
	private DataModel<TratamentoAgua> listaTratamentosAgua;	
	
	public TratamentoAguaController() { 
		tratamentoAgua = new TratamentoAgua(); 
	}

	public DataModel<TratamentoAgua> getListarTratamentosAgua() {
		List<TratamentoAgua> lista = new TratamentoAguaDAOImpl().listar();
		listaTratamentosAgua = new ListDataModel<TratamentoAgua>(lista);
		return listaTratamentosAgua;
	}

	public TratamentoAgua getTratamentoAgua() {
		return tratamentoAgua;
	}

	public void setTratamentoAgua(TratamentoAgua tratamentoAgua) {
		this.tratamentoAgua = tratamentoAgua;
	}

	public String prepararAdicionarTratamentoAgua() {
		tratamentoAgua = new TratamentoAgua();
		return "";
	}

	public String prepararAlterarTratamentoAgua() {
		tratamentoAgua = (TratamentoAgua) (listaTratamentosAgua.getRowData());
		return "";
	}

	public String excluirTratamentoAgua() {
		TratamentoAgua TratamentoAguaTemp = (TratamentoAgua) (listaTratamentosAgua.getRowData());
		TratamentoAguaDAO dao = new TratamentoAguaDAOImpl();
		dao.excluir(TratamentoAguaTemp);
		return "";
	}

	public String adicionarTratamentoAgua() {
		TratamentoAguaDAOImpl dao = new TratamentoAguaDAOImpl();
		dao.salvar(tratamentoAgua);
		return "";
	}

	public String alterarTratamentoAgua() {
		TratamentoAguaDAO dao = new TratamentoAguaDAOImpl();
		dao.atualizar(tratamentoAgua);
		return "";
	}
}
