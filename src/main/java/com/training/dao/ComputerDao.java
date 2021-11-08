package com.training.dao;

import com.training.entities.Computer;
import com.training.entities.Manufacture;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author: VuiSK
 * @created: 08/11/2021-2:28 PM
 * @mailto: sanvankhanh@gmail.com
 */

public interface ComputerDao {
    List<Computer> findByManufacture(String manufacturerName, Integer status);
    List<Computer> findByStatus(Integer status, LocalDate date);

}
