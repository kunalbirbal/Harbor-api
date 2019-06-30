package com.harbor.service.impl;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.harbor.dao.IAppointmentDao;
import com.harbor.dao.IBillDao;
import com.harbor.dao.IBillTariffDao;
import com.harbor.dao.ITariffDao;
import com.harbor.model.Appointment;
import com.harbor.model.Bill;
import com.harbor.model.BillTariff;
import com.harbor.model.TariffRates;
import com.harbor.service.IBillService;

@Service
@Transactional
public class BillServiceImpl implements IBillService {

	@Autowired
	IAppointmentDao appointmentDao;

	@Autowired
	IBillDao billDao;

	@Autowired
	ITariffDao tariffDao;

	@Autowired
	IBillTariffDao billTariffDao;

	@Override
	public Bill createBill(Bill req) {

		Bill newBill = new Bill();

		if (req.getAppointment_id() > 0) {
			Appointment appointment = appointmentDao.findById(req.getAppointment_id());
			newBill.setAppointment(appointment);
		}

		Principal principal = SecurityContextHolder.getContext().getAuthentication();

		System.out.println(principal);

		newBill.setAdditional_charges(req.getAdditional_charges());
		newBill.setDiscount_amount(req.getDiscount_amount());

		newBill.setNet_amount(req.getNet_amount());
		newBill.setPaid_amount(req.getPaid_amount());
		newBill.setCreated(new Date());
		newBill.setUpdated(new Date());
		// newBill.setCreated_by();
		newBill.setPayment_mode(req.getPayment_mode());

		Bill savedBill = billDao.saveBill(newBill);

		if (savedBill != null) {
			for (BillTariff billTariff : req.getBill_tariffs()) {
				TariffRates tariff_rate = tariffDao.findTariffRateById(billTariff.getTariff_rate_id());

				BillTariff newBillTariff = new BillTariff();
				newBillTariff.setAmount(billTariff.getAmount());
				newBillTariff.setBill(savedBill);
				newBillTariff.setTariff_rate(tariff_rate);
				newBillTariff.setRemark(billTariff.getRemark());
				newBillTariff.setCreated(new Date());
				newBillTariff.setUpdated(new Date());
				billTariffDao.saveBillTariff(newBillTariff);

			}
		}

		return savedBill;
	}

	@Override
	public List<Bill> searchBill(Bill searchCriteria) {

		return billDao.searchBill(searchCriteria);
	}

	@Override
	public Bill getBillById(long billId) {
		Bill bill = billDao.findById(billId);
		List<BillTariff> tariffs = billDao.getAppliedTariffsByBillId(billId);
		bill.setBill_tariffs(tariffs);

		return bill;
	}

}
