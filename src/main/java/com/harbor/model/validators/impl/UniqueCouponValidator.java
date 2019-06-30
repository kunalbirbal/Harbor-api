package com.harbor.model.validators.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.harbor.model.validators.IUniqueCoupon;

public class UniqueCouponValidator implements ConstraintValidator<IUniqueCoupon, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initialize(IUniqueCoupon constraint) {
		// TODO Auto-generated method stub
		
	}
}
