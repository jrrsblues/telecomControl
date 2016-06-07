package com.cabecadevento.controleredetelecom.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.cabecadevento.controleredetelecom.model.Contagem;
import com.cabecadevento.controleredetelecom.model.Preventivas;
import com.cabecadevento.controleredetelecom.service.NegocioException;



public class PreventivasRepository  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Preventivas porID(Long id){
		return manager.find(Preventivas.class,id);
	}
	
	
	public List<Preventivas> buscarPreventivasRaizes(){
		return manager.createQuery("from Preventivas", Preventivas.class).getResultList();
	}
	
	public List<Preventivas> buscarUfRaizes(){
		return manager.createQuery("SELECT c.uf from Preventivas c GROUP BY c.uf").getResultList();
	}
	
	public List<Preventivas> buscarMesRaizes(){
		return manager.createQuery("SELECT c.mes from Preventivas c GROUP BY c.mes order by mesint").getResultList();
	}
	
	public List<Preventivas> buscarAnoRaizes(){
		return manager.createQuery("SELECT c.ano from Preventivas c GROUP BY c.ano").getResultList();
	}
	
	public List<Preventivas> buscarSiteRaizes(){
		return manager.createQuery("SELECT c.site from Preventivas c GROUP BY c.site").getResultList();
	}
	
	public List<Preventivas> buscarSitePorPreventivas(int ano, String mes, String uf){
		return manager.createQuery("SELECT c.site from Preventivas c where c.ano = :raizano and c.uf = :raizuf and c.mes = :raizmes GROUP BY c.site")
				.setParameter("raizano", ano)
				.setParameter("raizuf", uf)
				.setParameter("raizmes", mes)
				.getResultList();
	}
	
	public List<Preventivas> buscarTipoPreventivaPorPreventivas(int ano, String mes, String uf, String site){
		return manager.createQuery("SELECT c.tipopreventiva from Preventivas c where c.ano = :raizano and c.uf = :raizuf and c.mes = :raizmes and c.site = :raizsite GROUP BY c.tipopreventiva")
				.setParameter("raizano", ano)
				.setParameter("raizuf", uf)
				.setParameter("raizmes", mes)
				.setParameter("raizsite", site)
				.getResultList();
	}
	
	public Preventivas buscaPreventivaPorAnoMesUTipopreventivaSite(int ano, String mes, String uf, String tipopreventiva, String site){
	  try {
		return manager.createQuery("from Preventivas c where c.ano = :raizano and c.uf = :raizuf and c.mes = :raizmes and c.tipopreventiva = :raiztipopreventiva and c.site = :raizsite", Preventivas.class)
				.setParameter("raizano", ano)
				.setParameter("raizuf", uf)
				.setParameter("raizmes", mes)
				.setParameter("raiztipopreventiva", tipopreventiva)
				.setParameter("raizsite", site)
				.getSingleResult();
	   } catch (NoResultException e) {
		   throw new NegocioException("A preventiva de " + tipopreventiva + " para o site " + site + " não esta agendada no mês de " + mes + "!");
	   }
	}
	
	public int remover(Long id) {
		try {
			System.out.println(id);
			Preventivas preventiva = manager.find(Preventivas.class, id);
			manager.getTransaction().begin();
			manager.remove(preventiva);
			manager.getTransaction().commit();
			
			return 1;
		} catch (NoResultException e) {
			   throw new NegocioException("A preventiva de " + id + " não foi excluída!");
		}
	}
	
	public Preventivas salvar(Preventivas preventiva){
		
		return preventiva = manager.merge(preventiva);
		
	}
	
	public int atualizaPreventivaPorId(Long id, Integer anofim, String mesfim, String uffim, String sitefim,
			String tipopreventivafim, String executor, Date dataplanejada, Date dataexecutada,
			String auditor, Date dataauditada, String resultadoauditoria, String motivorejeicao,
			String preventivacorrigida, Date datacorrecao){
		  try {
		  
			  Preventivas preventiva = manager.find(Preventivas.class, id);
			  manager.getTransaction().begin();
			    preventiva.setAno(anofim);
			    preventiva.setMes(mesfim);
			    preventiva.setUf(uffim);
			    preventiva.setSite(sitefim);
			    preventiva.setTipopreventiva(tipopreventivafim);
			    preventiva.setExecutor(executor);
			    preventiva.setDataplanejada(dataplanejada);
			    preventiva.setDataexecutada(dataexecutada);
			    preventiva.setAuditor(auditor);
			    preventiva.setDataauditoria(dataauditada);
			    preventiva.setResultadoauditoria(resultadoauditoria);
			    preventiva.setRejeicaointernamotivo(motivorejeicao);
			    preventiva.setPreventivacorrigida(preventivacorrigida);
			    preventiva.setDatacorrecao(datacorrecao);
			  manager.getTransaction().commit();
			  
			  return 1;

		   } catch (NoResultException e) {
			   throw new NegocioException("A preventiva do " + mesfim + " não foi atualizada corretamente!");
		   }
	}
	
	public List<Preventivas> buscarPreventivasExecutadas(){
		return manager.createQuery("SELECT c.id, c.mes, c.uf, c.site, c.tipopreventiva, c.executor, c.resultadoauditoria from Preventivas c where c.executor is not null order by c.mesint")
				.getResultList();
	}
	
	public Contagem buscaContagemPorAnoMesTipopreventiva(int ano, String mes, String tipopreventiva, String uf){
		  try {
			return manager.createQuery("from Contagem c where c.ano = :raizano and c.mes =:raizmes and c.tipopreventiva =:raiztipopreventiva and c.uf =:raizuf", Contagem.class)
					.setParameter("raizano", ano)
					.setParameter("raizmes", mes)
					.setParameter("raiztipopreventiva", tipopreventiva)
					.setParameter("raizuf", uf)
					.getSingleResult();
		   } catch (NoResultException e) {
			   throw new NegocioException("Contagem não encontrada!");
		   }
	}

}