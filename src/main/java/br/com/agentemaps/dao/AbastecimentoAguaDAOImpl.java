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
			System.out.println("Não foi possível inserir o abastecimento de água. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e2.getMessage());
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
			System.out.println("Não foi possivel alterar o abastecimento de água. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de atualização. Mensagem: " + e2.getMessage());
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
			System.out.println("Não foi possivel excluir o abastecimento de água. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de excluir. Mensagem: " + e2.getMessage());
			}
		}
	}
	
	public AbastecimentoAgua getAbastecimentoAgua(long codigo) {

		AbastecimentoAgua abastecimentoAgua = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(AbastecimentoAgua.class);
			filtro.add(Restrictions.eq("abastecimento de água", codigo));
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
				System.out.println("Erro ao fechar operação de consulta. Mensagem: " + e.getMessage());
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
				System.out.println("Erro ao fechar operação de consulta. Mensagem: " + e.getMessage());
			}
		}
		return abastecimentosAgua;
	}

}
