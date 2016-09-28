package br.com.agentemaps.dao;

import java.util.List;

import br.com.agentemaps.model.TratamentoAgua;

public interface TratamentoAguaDAO {

	public void salvar(TratamentoAgua tratamentoAgua);

	public List<TratamentoAgua> listar();

	public void atualizar(TratamentoAgua tratamentoAgua);

	public void excluir(TratamentoAgua tratamentoAgua);

}
