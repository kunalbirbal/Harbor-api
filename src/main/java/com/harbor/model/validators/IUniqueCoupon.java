package com.harbor.model.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.harbor.model.validators.impl.UniqueCouponValidator;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCouponValidator.class)
public @interface IUniqueCoupon {
	String message() default "Coupon name already exist.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
