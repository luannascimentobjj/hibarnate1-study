package br.com.estudo.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.estudo.financas.modelo.Conta;
import br.com.estudo.financas.modelo.Movimentacao;
import br.com.estudo.financas.modelo.TipoMovimentacao;
import br.com.estudo.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" + 
		" and m.tipo = :pTipo " +
		" group by m.data ";
		
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> medias  = query.getResultList();
		Double double1 = medias.get(0);
		System.out.println("A media do dia 09 é: " + medias.get(0));
		
		em.getTransaction().commit();
		em.close();
		
		
	}
	
}
