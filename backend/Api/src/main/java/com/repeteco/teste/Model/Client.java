package com.repeteco.teste.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue
    private int idClient;
    private String name;
    private String cpf;
    private char gender;
    private Date birthDate;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
    private String type;


    public Client() {}

    public Client(String name, String cpf, char gender, Date birthDate, String email, String phoneNumber, String address,
                  String password) {
        this.name = name;
        this.cpf = cpf;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
