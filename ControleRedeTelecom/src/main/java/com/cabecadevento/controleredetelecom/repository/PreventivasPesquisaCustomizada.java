package com.cabecadevento.controleredetelecom.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.cabecadevento.controleredetelecom.repository.filter.PreventivaFilter;

import org.apache.commons.lang3.StringUtils;

import com.cabecadevento.controleredetelecom.model.Preventivas;

public class PreventivasPesquisaCustomizada implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Preventivas> filtrados(PreventivaFilter filtro) {
		Session session = this.manager.unwrap(Session.class);

		Criteria criteria = session.createCriteria(Preventivas.class);
				// fazemos uma associação (join) com preventivas e nomeamos como "c"
				//.createAlias("id", "c");
		
		if (filtro.getIdDe() != null) {
			// id deve ser maior ou igual (ge = greater or equals) a filtro.getIdDe
			criteria.add(Restrictions.ge("id", filtro.getIdDe()));
		}

		if (filtro.getIdAte() != null) {
			// id deve ser menor ou igual (le = lower or equal) a filtro.numeroDe
			criteria.add(Restrictions.le("id", filtro.getIdAte()));
		}

		if (filtro.getDataPlanejadaDe() != null) {
			criteria.add(Restrictions.ge("dataplanejada", filtro.getDataPlanejadaDe()));
		}
		
		if (filtro.getDataPlanejadaAte() != null) {
			criteria.add(Restrictions.le("dataplanejada", filtro.getDataPlanejadaAte()));
		}
		
		if (StringUtils.isNotBlank(filtro.getExecutor())) {
			criteria.add(Restrictions.ilike("executor", filtro.getExecutor(), MatchMode.ANYWHERE));
		}
		
		
		return criteria.addOrder(Order.asc("id")).list();
	}	
	
}
