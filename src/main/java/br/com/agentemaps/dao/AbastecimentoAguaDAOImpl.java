package br.com.agentemaps.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.agentemaps.model.AbastecimentoAgua;
import br.com.agentemaps.util.HibernateUtil;

public class AbastecimentoAguaDAOImpl implements AbastecimentoAguaDAO {
	
	Session sessao = null;
	Transaction transacao = null;

	public void salvar(AbastecimentoAgua abastecimentoAgua) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(abastecimentoAgua);
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



	public void atualizar(AbastecimentoAgua abastecimentoAgua) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(abastecimentoAgua);
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

	public void excluir(AbastecimentoAgua abastecimentoAgua) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(abastecimentoAgua);
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
	
	public AbastecimentoAgua getAbastecimentoAgua(long codigo) {

		AbastecimentoAgua abastecimentoAgua = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(AbastecimentoAgua.class);
			filtro.add(Restrictions.eq("abastecimento de �gua", codigo));
			abastecimentoAgua = (AbastecimentoAgua) filtro.uniqueResult();
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
		return abastecimentoAgua;
	}
	
	public List<AbastecimentoAgua> listar() {

		List<AbastecimentoAgua> abastecimentosAgua = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(AbastecimentoAgua.class);

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
