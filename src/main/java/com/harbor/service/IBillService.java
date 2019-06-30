package com.harbor.service;

import java.util.List;

import com.harbor.model.Bill;

public interface IBillService {

	
	Bill createBill(Bill req);

	List<Bill> searchBill(Bill searchCriteria);

	Bill getBillById(long billId);

}
