package com.nexti.teste.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    private int idCustomer;
    private String name;
    private String documentNumber;
    private Date birthDate;

    public Customer() {
    }

    public Customer(String name, String documentNumber, Date birthDate) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.birthDate = birthDate;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Client{" + "idClient=" + idCustomer + ", name='" + name + '\'' + ", documentNumber='" + documentNumber
                + '\'' + ", birthDate=" + birthDate + '}';
    }
}
