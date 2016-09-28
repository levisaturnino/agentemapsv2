package br.com.agentemaps.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.agentemaps.model.DestinoFezes;
import br.com.agentemaps.util.HibernateUtil;

public class DestinoFezesDAOImpl implements DestinoFezesDAO{

	Session sessao = null;
	Transaction transacao = null;

	public void salvar(DestinoFezes destinoFezes) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(destinoFezes);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel inserir o destino de fezes. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de insersão. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void atualizar(DestinoFezes destinoFezes) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(destinoFezes);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível alterar o destino de fezes. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de atualização. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void excluir(DestinoFezes destinoFezes) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(destinoFezes);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel excluir o destino de fezes. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de excluir. Mensagem: " + e2.getMessage());
			}
		}
	}



	public DestinoFezes getDestinoFezes(long codigo) {

		DestinoFezes destinoFezes = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(DestinoFezes.class);
			filtro.add(Restrictions.eq("destino de fezes", codigo));
			destinoFezes = (DestinoFezes) filtro.uniqueResult();
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
		return destinoFezes;
	}



	public List<DestinoFezes> listar() {

		List<DestinoFezes> destinosFezes = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(DestinoFezes.class);

			destinosFezes = filtro.list();
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
		return destinosFezes;
	}

}
