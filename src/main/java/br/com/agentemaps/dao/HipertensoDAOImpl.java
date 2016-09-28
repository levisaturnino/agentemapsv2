package br.com.agentemaps.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.agentemaps.model.Hipertenso;
import br.com.agentemaps.util.HibernateUtil;

public class HipertensoDAOImpl implements HipertensoDAO{

	Session sessao = null;
	Transaction transacao = null;

	public void salvar(Hipertenso hipertenso) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(hipertenso);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("N�o foi poss�vel inserir o hipertenso. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar opera��o de insers�o. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void atualizar(Hipertenso hipertenso) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(hipertenso);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("N�o foi poss�vel alterar o hipertenso. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar opera��o de atualiza��o. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void excluir(Hipertenso hipertenso) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(hipertenso);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("N�o foi poss�vel excluir o hipertenso. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar opera��o de excluir. Mensagem: " + e2.getMessage());
			}
		}
	}



	public Hipertenso getHipertenso(long codigo) {

		Hipertenso hipertenso = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Hipertenso.class);
			filtro.add(Restrictions.eq("hipertenso", codigo));
			hipertenso = (Hipertenso) filtro.uniqueResult();
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
		return hipertenso;
	}



	public List<Hipertenso> listar() {

		List<Hipertenso> hipertensos = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Hipertenso.class);

			hipertensos = filtro.list();
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
		return hipertensos;
	}

}
