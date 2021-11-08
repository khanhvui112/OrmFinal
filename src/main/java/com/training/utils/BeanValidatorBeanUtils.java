package com.training.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author: VuiSK
 * @created: 08/11/2021-2:06 PM
 * @mailto: sanvankhanh@gmail.com
 */

public class BeanValidatorBeanUtils {
    public static ValidationBean validationBean(Object o){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        if (violations.isEmpty()){
            return new ValidationBean("Your bean is OK.");
        }else {
            return new ValidationBean(violations);
        }
    }
}
