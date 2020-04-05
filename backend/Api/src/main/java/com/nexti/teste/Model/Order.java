package com.nexti.teste.Model;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private int idOrder;
    private int idCustomer;
    private BigDecimal total;
    private Date createdAt;
    private Date updatedAt;

    public Order() {
    }

    public Order(int idCustomer, BigDecimal total) {
        this.idCustomer = idCustomer;
        this.total = total;
        this.createdAt = Calendar.getInstance().getTime();
        this.updatedAt = this.createdAt;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", total=" + total + ", createdAt=" + createdAt + "}";
    }
}
