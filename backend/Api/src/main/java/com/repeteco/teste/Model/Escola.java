package com.repeteco.teste.Model;

import javax.persistence.*;

@Entity
@Table(name = "escola")
public class Escola {

    @Id
    @GeneratedValue
    private int idEscola;
    private String city;
    private String name;
    private String neighborhood;

    public Escola (){}

    public Escola(int idEscola, String name, String neighborhood, String city) {
        this.idEscola = idEscola;
        this.name = name;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    public int getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(int idEscola) {
        this.idEscola = idEscola;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Escola{" +
                "idEscola=" + idEscola +
                ", name='" + name + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
