package com.harbor.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.harbor.dao.ISlotDao;
import com.harbor.model.Doctor;
import com.harbor.model.Patient;
import com.harbor.model.Slot;

@Repository
@Transactional
public class SlotDaoImpl implements ISlotDao {
	@PersistenceContext
	private EntityManager emf;
	
	@Override
	public Slot findById(long id) {
		Slot slot = emf.find(Slot.class, id);
		return slot;
	}
	
	@Override
	public Slot saveSlot(Slot slot) {
		emf.persist(slot);
		return slot;
		
	}

}
