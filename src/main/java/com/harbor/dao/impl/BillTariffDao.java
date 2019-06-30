package com.harbor.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.harbor.dao.IBillTariffDao;
import com.harbor.model.BillTariff;
import com.harbor.model.Patient;

@Repository
@Transactional
public class BillTariffDao implements IBillTariffDao{
	
	@PersistenceContext
	private EntityManager emf;

	@Override
	public BillTariff saveBillTariff(BillTariff billTariff) {
		emf.persist(billTariff);
		return billTariff;
		
	}
}
