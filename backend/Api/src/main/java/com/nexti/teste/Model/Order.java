package com.nexti.teste.Model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private int idOrder;
    private Integer amt_purchase;
    private Date dt_purchase;

    @Column(name = "id_client")
    private int idClient;

    @Column(name = "id_products_order")
    private int idProductsOrder;


    public Order() {}

    public Order(int idClient, int idProductsOrder, Integer amt_purchase, Date dt_purchase) {
        this.idClient = idClient;
        this.idProductsOrder = idProductsOrder;
        this.amt_purchase = amt_purchase;
        this.dt_purchase = Calendar.getInstance().getTime();
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getAmt_purchase() {
        return amt_purchase;
    }

    public void setAmt_purchase(Integer amt_purchase) {
        this.amt_purchase = amt_purchase;
    }

    public Date getDt_purchase() {
        return dt_purchase;
    }

    public void setDt_purchase(Date dt_purchase) {
        this.dt_purchase = dt_purchase;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdProductsOrder() {
        return idProductsOrder;
    }

    public void setIdProductsOrder(int idProductsOrder) {
        this.idProductsOrder = idProductsOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", amt_purchase=" + amt_purchase +
                ", dt_purchase=" + dt_purchase +
                ", idClient=" + idClient +
                ", idProductsOrder=" + idProductsOrder +
                '}';
    }
}
