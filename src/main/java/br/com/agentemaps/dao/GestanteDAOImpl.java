package br.com.agentemaps.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.agentemaps.model.Gestante;
import br.com.agentemaps.util.HibernateUtil;

public class GestanteDAOImpl implements GestanteDAO{

	Session sessao = null;
	Transaction transacao = null;

	public void salvar(Gestante gestante) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(gestante);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("N�o foi poss�vel inserir a Gestante. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar opera��o de insers�o. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void atualizar(Gestante gestante) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(gestante);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("N�o foi poss�vel alterar a gestante. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar opera��o de atualiza��o. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void excluir(Gestante gestante) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(gestante);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("N�o foi poss�vel excluir a gestante. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar opera��o de excluir. Mensagem: " + e2.getMessage());
			}
		}
	}



	public Gestante getGestante(long codigo) {

		Gestante gestante = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Gestante.class);
			filtro.add(Restrictions.eq("gestante", codigo));
			gestante = (Gestante) filtro.uniqueResult();
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
		return gestante;
	}



	public List<Gestante> listar() {

		List<Gestante> gestantes = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Gestante.class);

			gestantes = filtro.list();
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
		return gestantes;
	}

}
