package br.com.agentemaps.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.agentemaps.model.FatoresRisco;
import br.com.agentemaps.util.HibernateUtil;

public class FatoresRiscoDAOImpl implements FatoresRiscoDAO{

	Session sessao = null;
	Transaction transacao = null;

	public void salvar(FatoresRisco fatoresRisco) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(fatoresRisco);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível inserir o fatores de risco. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de insersão. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void atualizar(FatoresRisco fatoresRisco) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(fatoresRisco);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível alterar o fator de risco. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de atualização. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void excluir(FatoresRisco fatoresRisco) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(fatoresRisco);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível excluir o fator de risco. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de excluir. Mensagem: " + e2.getMessage());
			}
		}
	}



	public FatoresRisco getFatoresRisco(long codigo) {

		FatoresRisco fatoresRisco = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(FatoresRisco.class);
			filtro.add(Restrictions.eq("fatores de risco", codigo));
			fatoresRisco = (FatoresRisco) filtro.uniqueResult();
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
		return fatoresRisco;
	}



	public List<FatoresRisco> listar() {

		List<FatoresRisco> fatoresRisco = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(FatoresRisco.class);

			fatoresRisco = filtro.list();
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
		return fatoresRisco;
	}

}
