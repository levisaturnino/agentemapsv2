package br.com.agentemaps.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.agentemaps.model.Situacao;
import br.com.agentemaps.util.HibernateUtil;

public class SituacaoDAOImpl implements SituacaoDAO {
	
	Session sessao = null;
	Transaction transacao = null;

	public void salvar(Situacao Situacao) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(Situacao);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("N�o foi poss�vel inserir o abastecimento de �gua. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar opera��o de inser��o. Mensagem: " + e2.getMessage());
			}
		}
	}



	public void atualizar(Situacao Situacao) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(Situacao);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("N�o foi possivel alterar o abastecimento de �gua. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar opera��o de atualiza��o. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void excluir(Situacao Situacao) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(Situacao);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("N�o foi possivel excluir o abastecimento de �gua. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar opera��o de excluir. Mensagem: " + e2.getMessage());
			}
		}
	}
	
	public Situacao getSituacao(long codigo) {

		Situacao Situacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Situacao.class);
			filtro.add(Restrictions.eq("abastecimento de �gua", codigo));
			Situacao = (Situacao) filtro.uniqueResult();
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
				System.out.println("Erro ao fechar opera��o de consulta. Mensagem: " + e.getMessage());
			}
		}
		return Situacao;
	}
	
	public List<Situacao> listar() {

		List<Situacao> abastecimentosAgua = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Situacao.class);

			abastecimentosAgua = filtro.list();
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
				System.out.println("Erro ao fechar opera��o de consulta. Mensagem: " + e.getMessage());
			}
		}
		return abastecimentosAgua;
	}

}
