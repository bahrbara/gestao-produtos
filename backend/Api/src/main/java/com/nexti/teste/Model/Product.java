package com.nexti.teste.Model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private int idProduct;
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer amount;

    public Product() {}

    public Product(String sku, String name, String description, BigDecimal price, Integer amount) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descrition) {
        this.description = descrition;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", descrition='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
