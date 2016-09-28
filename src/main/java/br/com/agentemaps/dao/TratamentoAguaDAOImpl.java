package br.com.agentemaps.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.agentemaps.model.TratamentoAgua;
import br.com.agentemaps.util.HibernateUtil;

public class TratamentoAguaDAOImpl implements TratamentoAguaDAO{

	Session sessao = null;
	Transaction transacao = null;

	public void salvar(TratamentoAgua tratamentoAgua) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(tratamentoAgua);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível inserir o tratamento de água. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de insersão. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void atualizar(TratamentoAgua tratamentoAgua) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(tratamentoAgua);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível alterar o tratamento de água. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de atualização. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void excluir(TratamentoAgua tratamentoAgua) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(tratamentoAgua);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível excluir o tratamento de água. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de excluir. Mensagem: " + e2.getMessage());
			}
		}
	}



	public TratamentoAgua getTratamentoAgua(long codigo) {

		TratamentoAgua tratamentoAgua = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(TratamentoAgua.class);
			filtro.add(Restrictions.eq("tratamento de água", codigo));
			tratamentoAgua = (TratamentoAgua) filtro.uniqueResult();
			this.transacao.commit();
			transacao.commit();

		} catch (Throwable e) {
			if (this.transacao.isActive()) {
				this.transacao.rollback();
			}
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de consulta. Mensagem: " + e.getMessage());
			}
		}
		return tratamentoAgua;
	}



	public List<TratamentoAgua> listar() {

		List<TratamentoAgua> tratamentosAgua = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(TratamentoAgua.class);

			tratamentosAgua = filtro.list();
			this.transacao.commit();

		} catch (Throwable e) {
			if (this.transacao.isActive()) {
				this.transacao.rollback();
			}
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de consulta. Mensagem: " + e.getMessage());
			}
		}
		return tratamentosAgua;
	}

}
