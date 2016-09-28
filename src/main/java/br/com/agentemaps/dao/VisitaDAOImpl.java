package br.com.agentemaps.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.agentemaps.model.Visita;
import br.com.agentemaps.util.HibernateUtil;

public class VisitaDAOImpl implements VisitaDAO{

	Session sessao = null;
	Transaction transacao = null;

	public void salvar(Visita visita) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(visita);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível inserir a visita. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de insersão. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void atualizar(Visita visita) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(visita);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível alterar a visita. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de atualização. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void excluir(Visita visita) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(visita);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível excluir a visita. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de excluir. Mensagem: " + e2.getMessage());
			}
		}
	}



	public Visita getVisita(long codigo) {

		Visita visita = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Visita.class);
			filtro.add(Restrictions.eq("visita", codigo));
			visita = (Visita) filtro.uniqueResult();
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
		return visita;
	}



	public List<Visita> listar() {

		List<Visita> visitas = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Visita.class);

			visitas = filtro.list();
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
		return visitas;
	}

}
