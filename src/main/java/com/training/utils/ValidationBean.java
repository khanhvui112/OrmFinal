package com.training.utils;

import org.hibernate.validator.engine.HibernateConstraintViolation;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: VuiSK
 * @created: 08/11/2021-2:00 PM
 * @mailto: sanvankhanh@gmail.com
 */

public class ValidationBean {
    private String message;
    private boolean success;

    public ValidationBean(String message) {
//        true
        this.message = message;
        this.success = true;
    }

    public ValidationBean(Set<? extends ConstraintViolation<?>> violations) {
//        false
        this.success = false;
        this.message = violations.stream()
                .map(msg ->msg.getMessage())
                .collect(Collectors.joining(", "));
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "All information {" +
                "message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}
