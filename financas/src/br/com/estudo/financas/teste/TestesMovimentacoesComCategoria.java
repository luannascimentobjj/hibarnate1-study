package br.com.estudo.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.estudo.financas.modelo.Categoria;
import br.com.estudo.financas.modelo.Conta;
import br.com.estudo.financas.modelo.Movimentacao;
import br.com.estudo.financas.modelo.TipoMovimentacao;
import br.com.estudo.financas.util.JPAUtil;

public class TestesMovimentacoesComCategoria {

	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");
		Conta conta = new Conta();
		conta.setId(2);
		
	
		
		Movimentacao mov1 = new Movimentacao();
		mov1.setData(Calendar.getInstance());
		mov1.setDescricao("Viagem para SP");
		mov1.setTipo(TipoMovimentacao.SAIDA);
		mov1.setValor(new BigDecimal("100.0"));
		mov1.setCategoria(Arrays.asList(categoria1, categoria2));
		mov1.setConta(conta);
		
		
		Movimentacao mov2 = new Movimentacao();
		mov2.setData(Calendar.getInstance());
		mov2.setDescricao("Viagem para RJ");
		mov2.setTipo(TipoMovimentacao.SAIDA);
		mov2.setValor(new BigDecimal("300.0"));
		mov2.setCategoria(Arrays.asList(categoria1, categoria2));
		mov2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(categoria1);
		em.persist(categoria2);
		em.persist(mov1);
		em.persist(mov2);
		
		em.getTransaction().commit();
		
		em.close();
		
	}
	
}
