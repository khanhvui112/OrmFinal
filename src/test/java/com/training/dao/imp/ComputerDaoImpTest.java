package com.training.dao.imp;

import com.training.entities.Computer;
import com.training.services.ComputerServices;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: VuiSK
 * @created: 08/11/2021-2:43 PM
 * @mailto: sanvankhanh@gmail.com
 */

class ComputerDaoImpTest {

    @Test
    void findByManufacture() {
        ComputerDaoImp manufactureDaoImp = new ComputerDaoImp();
        String name = "Apple";
        Integer status = 0;
        assertNotNull(manufactureDaoImp.findByManufacture(name,status));
    }

    @Test
    void find_byManufacture_and_status() {
        ComputerDaoImp computerDaoImp = new ComputerDaoImp();
        String name = "Apple";
        Integer status = 0;
        List<Computer> computerList = computerDaoImp.findByManufacture(name, status);
        System.out.println(computerList);
        assertNotNull(computerList);
    }

    @Test
    void find_byDate_and_status() {
        ComputerDaoImp computerDaoImp = new ComputerDaoImp();
        String dateStr = "20/11/2021";
        LocalDate date = localDate(dateStr);
        Integer status = 0;
        List<Computer> computerList = computerDaoImp.findByStatus(status, date);
        System.out.println(computerList);
        assertNotNull(computerList);
    }

    @Test
    void insert_computer_true_test() {
        String dateStr = "20/11/2021";
        LocalDate date  = localDate(dateStr);
        Computer computer = new Computer(1,"Macbook Pro",date,12563.45,"good","AP225614",0,"faild",1);
        Computer computer1 = new Computer(2,"Samsung book",date,82563.45,"good","SA225614",1,"faild",2);
        Computer computer2 = new Computer(3,"Macbook Pro M1",date,892563.45,"good","AP55214",0,"ss",1);
        Computer computer3 = new Computer(4,"Macbook AIR",date,252563.45,"good","AP77441",1,"gg",1);
        ComputerServices services = new ComputerServices();
        List<Computer> computerList = new ArrayList<>();
        computerList.add(computer1);
        computerList.add(computer2);
        computerList.add(computer3);
        assertTrue(services.insert(computerList));
    }
    private static LocalDate localDate(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
        LocalDate date = LocalDate.parse(s, formatter);
        return date;
    }

}