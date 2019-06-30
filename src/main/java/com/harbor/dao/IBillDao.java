package com.harbor.dao;

import java.util.List;

import com.harbor.model.Appointment;
import com.harbor.model.Bill;
import com.harbor.model.BillTariff;

public interface IBillDao {

	Bill saveBill(Bill bill);

	List<Bill> searchBill(Bill searchCriteria);

	Bill findById(long id);

	List<BillTariff> getAppliedTariffsByBillId(long id);

}
