package br.com.agentemaps.main;

import br.com.agentemaps.dao.AdministradorDAOImpl;
import br.com.agentemaps.model.Administrador;
import br.com.agentemaps.util.HibernateUtil;

public class BancoTeste {

	public static void main(String[] args) {
	

		
		
	HibernateUtil.getSessionFactory().openSession();

	
	Administrador admin = new Administrador();
	
	
	AdministradorDAOImpl administradorServiceImpl = new AdministradorDAOImpl();
	

	
	admin.setNome("sSaturnino");
	admin.setCpf("432432423423");
	admin.setLogin("leviSaturnino");
	admin.setSenha("1234");
	
	
//	AdministradorServiceImpl adminImpl = new AdministradorServiceImpl();
	
	
	//adminImpl.salvar(admin);
	

	administradorServiceImpl.salvar(admin);

	
	
	System.out.println("Cadastros gerados com sucesso!");
		

	}

}
