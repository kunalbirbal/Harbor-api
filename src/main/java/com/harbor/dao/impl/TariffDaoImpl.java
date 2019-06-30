package com.harbor.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.harbor.dao.ITariffDao;
import com.harbor.model.Doctor;
import com.harbor.model.TariffRates;


@Repository
@Transactional
public class TariffDaoImpl implements ITariffDao{
	
	@PersistenceContext
	private EntityManager emf;

	@Override
	public TariffRates findTariffRateById(long id){
		TariffRates tariffRate = emf.find(TariffRates.class, id);
		return tariffRate;
	}
}
