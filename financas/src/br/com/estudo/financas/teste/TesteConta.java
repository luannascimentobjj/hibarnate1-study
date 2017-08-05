package br.com.estudo.financas.teste;

import javax.persistence.EntityManager;

import br.com.estudo.financas.modelo.Conta;
import br.com.estudo.financas.util.JPAUtil;

public class TesteConta {
	
	public static void main(String[] args) {
	
		Conta conta = new Conta();
		
		conta.setId(1);
		conta.setTitular("Lucas");
		conta.setAgencia("1234");
		conta.setBanco("BB");
		conta.setNumero("456");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		conta = em.find(Conta.class, 1);
		
		em.remove(conta);
		
		conta.setBanco("Santander");
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	

}
