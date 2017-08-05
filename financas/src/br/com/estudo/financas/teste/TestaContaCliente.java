package br.com.estudo.financas.teste;

import javax.persistence.EntityManager;

import br.com.estudo.financas.modelo.Cliente;
import br.com.estudo.financas.modelo.Conta;
import br.com.estudo.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Luan");
		cliente.setEndereco("Rua Fluindo, 123");
		cliente.setProfissao("Professor");
		
		
		Conta conta = new Conta();
		conta.setId(2);
		cliente.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		
	}
	
}
