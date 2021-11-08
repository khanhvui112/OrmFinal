package com.training.entities;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

/**
 * @author: VuiSK
 * @created: 08/11/2021-1:29 PM
 * @mailto: sanvankhanh@gmail.com
 */
@Entity
@Table(name = "Computer")
public class Computer {
    @Id
    @Column(name = "computer_id")
    private int computerId;

    @Column(name = "computer_name")
    private String computerName;

    @Column(name = "registration_date", columnDefinition = "date")
    @FutureOrPresent(message = "{registrationDate.valid}")
    private LocalDate registrationDate;

    @Column(name = "price", precision = 11,scale = 2)
    @Range(min = 0, message = "{price.min}")
    private double price;

    @Column(name = "descriptions", columnDefinition = "varchar(1000)")
    private String descriptions;

    @Column(name = "model", columnDefinition = "varchar(255)")
    private String model;

    @Column(name = "produce_status")
    @Range(min = 0, max = 1, message = "Status only accept 0('stop producing') or 1('producing'). ")
    private int produceStatus;

    @Column(name = "remark", columnDefinition = "varchar(255)")
    private String remark;

    @Column(name = "manufacture_id")
    private int manufacture_id;

//    Map Manufacture
    @ManyToOne
    @JoinColumn(name = "manufacture_id", referencedColumnName = "manufacture_id"
            , insertable = false, updatable = false)
    private Manufacture manufacture;

//    constructor
    public Computer() {
    }

    public Computer(int computerId, String computerName, LocalDate registrationDate, double price, String descriptions, String model, int produceStatus, String remark, int manufacture_id) {
        this.computerId = computerId;
        this.computerName = computerName;
        this.registrationDate = registrationDate;
        this.price = price;
        this.descriptions = descriptions;
        this.model = model;
        this.produceStatus = produceStatus;
        this.remark = remark;
        this.manufacture_id = manufacture_id;
    }

    public Computer(int computerId, String computerName, LocalDate registrationDate, double price, String descriptions, String model, int produceStatus, String remark) {
        this.computerId = computerId;
        this.computerName = computerName;
        this.registrationDate = registrationDate;
        this.price = price;
        this.descriptions = descriptions;
        this.model = model;
        this.produceStatus = produceStatus;
        this.remark = remark;
    }

    public Computer(String computerName, LocalDate registrationDate, double price, String descriptions, String model, int produceStatus, String remark, int manufacture_id) {
        this.computerName = computerName;
        this.registrationDate = registrationDate;
        this.price = price;
        this.descriptions = descriptions;
        this.model = model;
        this.produceStatus = produceStatus;
        this.remark = remark;
        this.manufacture_id = manufacture_id;
    }
//    Getter setter


    public int getComputerId() {
        return computerId;
    }

    public void setComputerId(int computerId) {
        this.computerId = computerId;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProduceStatus() {
        return produceStatus;
    }

    public void setProduceStatus(int produceStatus) {
        this.produceStatus = produceStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getManufacture_id() {
        return manufacture_id;
    }

    public void setManufacture_id(int manufacture_id) {
        this.manufacture_id = manufacture_id;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    //    ToString
    @Override
    public String toString() {
        return "Computer\n" +
                "computerId=" + computerId +"\t\t\t"+
                "computerName=" + computerName +"\t\t\t"+
                "registrationDate=" + registrationDate +"\t\t\t"+
                "price=" + price +"\t\t\t"+
                "descriptions=" + descriptions +"\t\t\t"+
                "model=" + model +"\t\t\t"+
                "produceStatus=" + produceStatus +"\t\t\t"+
                "remark='" + remark +"\t\t\t"+
                "manufacture_id=" + manufacture_id +"\n";
    }
}
