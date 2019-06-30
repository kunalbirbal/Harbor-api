package com.harbor.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.harbor.dao.IBillDao;
import com.harbor.model.Appointment;
import com.harbor.model.Bill;
import com.harbor.model.BillTariff;

@Repository
@Transactional
public class BillDaoImpl implements IBillDao {

	@PersistenceContext
	private EntityManager emf;

	@Override
	public Bill saveBill(Bill bill) {
		emf.persist(bill);
		return bill;

	}

	@Override
	public List<Bill> searchBill(Bill searchCriteria) {

		Criteria criteria = emf.unwrap(Session.class).createCriteria(Bill.class);
		// Criteria c1 = criteria.createCriteria("slot", "slot",
		// JoinType.LEFT_OUTER_JOIN);
		// c1.createAlias("slot.doctor", "sltdoc", JoinType.NONE);

		if (searchCriteria.getId() > 0) {
			criteria.add(Restrictions.eq("id", (long) searchCriteria.getId()));
		}

		criteria.addOrder(Order.desc("updated"));
		//
		// if (null != searchCriteria.getDate()) {
		// Date fromDate = searchCriteria.getDate();
		// Calendar cal = Calendar.getInstance();
		// cal.setTime(fromDate);
		// cal.set(Calendar.HOUR, 0);
		// cal.set(Calendar.MINUTE, 0);
		// cal.set(Calendar.SECOND, 0);
		//
		// fromDate = cal.getTime();
		//
		// criteria.add(Restrictions.ge("created", fromDate));
		// }
		//
		// if (null != searchCriteria.getDate()) {
		// Date toDate = searchCriteria.getDate();
		// Calendar cal = Calendar.getInstance();
		// cal.setTime(toDate);
		// cal.add(Calendar.HOUR_OF_DAY, 23);
		// toDate = cal.getTime();
		// criteria.add(Restrictions.le("created", toDate));
		// }

		List<Bill> list = criteria.list();
		return list;
	}

	@Override
	public Bill findById(long id) {
		Bill bill = emf.find(Bill.class, id);
		
		return bill;
	}

	@Override
	public List<BillTariff> getAppliedTariffsByBillId(long id) {

		Criteria criteria = emf.unwrap(Session.class).createCriteria(BillTariff.class);
		criteria.add(Restrictions.eq("bill.id", id));
		List<BillTariff> list = criteria.list();
		return list;

	}

}
