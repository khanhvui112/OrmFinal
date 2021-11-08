package com.training.services;

import com.training.dao.imp.BaseDaoImp;
import com.training.entities.Computer;
import com.training.utils.BeanValidatorBeanUtils;
import com.training.utils.ValidationBean;

import java.util.List;

/**
 * @author: VuiSK
 * @created: 08/11/2021-3:22 PM
 * @mailto: sanvankhanh@gmail.com
 */

public class ComputerServices {
    public boolean insert(List<Computer> computerList){
        BaseDaoImp baseDaoImp = new BaseDaoImp(Computer.class);
        for (Computer computer : computerList){
            ValidationBean validation = BeanValidatorBeanUtils.validationBean(computer);
            if(!validation.isSuccess()){
                System.out.println(validation);
                return false;
            }
        }
        return baseDaoImp.insert(computerList);
    }
}
