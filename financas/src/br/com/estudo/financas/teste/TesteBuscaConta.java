package br.com.estudo.financas.teste;

import javax.persistence.EntityManager;

import br.com.estudo.financas.modelo.Conta;
import br.com.estudo.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 1);

		conta.setTitular("João");
		conta.setAgencia("111");

		System.out.println(conta.getTitular());

		em.getTransaction().commit();

		EntityManager em2 = new JPAUtil().getEntityManager();

		em2.getTransaction().begin();
		
		conta.setTitular("Luan");
		em2.merge(conta);
		em2.getTransaction().commit();
		em2.close();
		
	}
}
