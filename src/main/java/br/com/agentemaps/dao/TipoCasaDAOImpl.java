package br.com.agentemaps.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.agentemaps.model.TipoCasa;
import br.com.agentemaps.util.HibernateUtil;

public class TipoCasaDAOImpl implements TipoCasaDAO{

	Session sessao = null;
	Transaction transacao = null;

	public void salvar(TipoCasa tipoCasa) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(tipoCasa);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível inserir o tipo de casa. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de insersão. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void atualizar(TipoCasa tipoCasa) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(tipoCasa);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível alterar o tipo de casa. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de atualização. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void excluir(TipoCasa tipoCasa) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(tipoCasa);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possível excluir o tipo de casa. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de excluir. Mensagem: " + e2.getMessage());
			}
		}
	}



	public TipoCasa getTipoCasa(long codigo) {

		TipoCasa tipoCasa = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(TipoCasa.class);
			filtro.add(Restrictions.eq("tipo de casa", codigo));
			tipoCasa = (TipoCasa) filtro.uniqueResult();
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
		return tipoCasa;
	}



	public List<TipoCasa> listar() {

		List<TipoCasa> tiposCasa = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(TipoCasa.class);

			tiposCasa = filtro.list();
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
		return tiposCasa;
	}

}
