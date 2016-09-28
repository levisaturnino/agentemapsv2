package br.com.agentemaps.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.agentemaps.model.Agente;
import br.com.agentemaps.util.HibernateUtil;

public class AgenteDAOImpl implements AgenteDAO{

	Session sessao = null;
	Transaction transacao = null;

	public void salvar(Agente agente) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(agente);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível inserir o Agente. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de insersão. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void atualizar(Agente agente) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(agente);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível alterar o agente. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de atualização. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void excluir(Agente agente) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(agente);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível excluir o agente. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de excluir. Mensagem: " + e2.getMessage());
			}
		}
	}



	public Agente getAgente(long codigo) {

		Agente agente = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Agente.class);
			filtro.add(Restrictions.eq("agente", codigo));
			agente = (Agente) filtro.uniqueResult();
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
		return agente;
	}



	public List<Agente> listar() {

		List<Agente> agentes = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Agente.class);

			agentes = filtro.list();
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
		return agentes;
	}

}
