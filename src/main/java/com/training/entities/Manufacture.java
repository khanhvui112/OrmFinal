package com.training.entities;

import javax.persistence.*;
import java.util.List;

/**
 * @author: VuiSK
 * @created: 08/11/2021-1:23 PM
 * @mailto: sanvankhanh@gmail.com
 */
@Entity
@Table(name = "Manufacture")
public class Manufacture {
    @Id
    @Column(name = "manufacture_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int manufactureId;

    @Column(name = "short_name", columnDefinition = "varchar(255)")
    private String shortName;

    @Column(name = "full_name", columnDefinition = "varchar(255)")
    private String fullName;

    @Column(name = "contact", columnDefinition = "varchar(255)")
    private String contact;

//    Map
    @OneToMany(mappedBy = "manufacture", orphanRemoval = true
            , cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Computer> computerList;

//    Constructor

    public Manufacture() {
    }

    public Manufacture(int manufactureId, String shortName, String fullName, String contact) {
        this.manufactureId = manufactureId;
        this.shortName = shortName;
        this.fullName = fullName;
        this.contact = contact;
    }

    public Manufacture(String shortName, String fullName, String contact) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.contact = contact;
    }
//    Getter setter

    public int getManufactureId() {
        return manufactureId;
    }

    public void setManufactureId(int manufactureId) {
        this.manufactureId = manufactureId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Computer> getComputerList() {
        return computerList;
    }

    public void setComputerList(List<Computer> computerList) {
        this.computerList = computerList;
    }

    public Manufacture(int manufactureId, String shortName, String fullName, String contact, List<Computer> computerList) {
        this.manufactureId = manufactureId;
        this.shortName = shortName;
        this.fullName = fullName;
        this.contact = contact;
        this.computerList = computerList;
    }
    //    ToString

    @Override
    public String toString() {
        return "Manufacture\n" +
                "manufactureId=" + manufactureId +"\t\t\t"+
                "shortName=" + shortName + "\t\t\t"+
                "fullName=" + fullName + "\t\t\t"+
                "contact=" + contact +"\n";
    }


}
