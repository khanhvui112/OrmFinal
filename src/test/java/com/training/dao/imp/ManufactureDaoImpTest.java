package com.training.dao.imp;

import com.training.entities.Computer;
import com.training.entities.Manufacture;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: VuiSK
 * @created: 08/11/2021-2:43 PM
 * @mailto: sanvankhanh@gmail.com
 */

class ManufactureDaoImpTest {

    @Test
    void find_all_manufacture_test() {
        BaseDaoImp baseDaoImp = new BaseDaoImp(Manufacture.class);
        List<Manufacture> manufactureList = new ArrayList<>();
        manufactureList = baseDaoImp.findAll();
        System.out.println(manufactureList);
        assertNotNull(manufactureList);
    }

    @Test
    void find_byId_manufacture_test() {
        BaseDaoImp baseDaoImp = new BaseDaoImp(Manufacture.class);
        Manufacture manufacture =(Manufacture) baseDaoImp.findById(1);
        System.out.println(manufacture);
        assertNotNull(manufacture);
    }


    @Test
    void insert_manufacture_true_test() {
        BaseDaoImp baseDaoImp = new BaseDaoImp(Manufacture.class);
        Manufacture manufacture1 = new Manufacture("AH205","APPLE","123456789");
        Manufacture manufacture2 = new Manufacture("BH205","SAMSUNG","852145621");
        Manufacture manufacture3 = new Manufacture("CH205","INTEL","85412365");
        Manufacture manufacture4 = new Manufacture("AH205","APPLE","8745122");

        List<Manufacture> manufactureList = new ArrayList<>();

        manufactureList.add(manufacture1);
        manufactureList.add(manufacture2);
        manufactureList.add(manufacture3);
        manufactureList.add(manufacture4);
        assertTrue(baseDaoImp.insert(manufactureList));
    }

    @Test
    void update_manufacture_true_test() {
        BaseDaoImp baseDaoImp = new BaseDaoImp(Manufacture.class);
        Manufacture manufacture1 = new Manufacture(4,"EH205","XIAOMI","85412225");
        assertTrue(baseDaoImp.update(manufacture1));
    }
    @Test
    void update_manufacture_false_test() {
        BaseDaoImp baseDaoImp = new BaseDaoImp(Manufacture.class);
        Manufacture manufacture1 = new Manufacture(15,"EH205","XIAOMI","85412225");
        assertFalse(baseDaoImp.update(manufacture1));
    }

    @Test
    void delete_manufacture_true_test() {
        BaseDaoImp baseDaoImp = new BaseDaoImp(Manufacture.class);
        assertTrue(baseDaoImp.delete(4));
    }

    @Test
    void delete_manufacture_false_test() {
        BaseDaoImp baseDaoImp = new BaseDaoImp(Manufacture.class);
        assertFalse(baseDaoImp.delete(54));
    }
    private static LocalDate localDate(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
        LocalDate date = LocalDate.parse(s, formatter);
        return date;
    }

}