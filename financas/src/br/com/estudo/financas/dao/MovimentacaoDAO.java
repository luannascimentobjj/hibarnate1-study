package br.com.estudo.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estudo.financas.modelo.Conta;
import br.com.estudo.financas.modelo.TipoMovimentacao;

public class MovimentacaoDAO {

	private EntityManager em;
	
	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}



	public List<Double> getMediasPorDiaETipo(TipoMovimentacao saida, Conta conta) {
		
		String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo "
				+ " group by m.data ";

		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		return query.getResultList();
	}
	
	

}
