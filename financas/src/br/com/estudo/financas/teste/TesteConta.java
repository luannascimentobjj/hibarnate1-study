package br.com.estudo.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.estudo.financas.modelo.Conta;

public class TesteConta {
	
	public static void main(String[] args) {
	
		Conta conta = new Conta();
		
		conta.setTitular("Luan");
		conta.setAgencia("1234");
		conta.setBanco("Bradesco");
		conta.setNumero("456");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}
	
	

}
