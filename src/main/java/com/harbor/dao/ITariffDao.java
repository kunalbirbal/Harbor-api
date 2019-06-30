package com.harbor.dao;

import com.harbor.model.TariffRates;

public interface ITariffDao {

	TariffRates findTariffRateById(long id);

}
