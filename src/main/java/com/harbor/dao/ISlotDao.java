package com.harbor.dao;

import com.harbor.model.Slot;

public interface ISlotDao {

	Slot findById(long id);

	Slot saveSlot(Slot slot);

}
