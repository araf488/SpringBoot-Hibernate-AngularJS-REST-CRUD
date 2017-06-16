package com.mycompany.entity;
// Generated Apr 20, 2017 7:16:43 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product",
         catalog = "concretepage"
)
public class Product implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    
    @Column(name = "pname", nullable = false, length = 100)
    private String pname;
    @Column(name = "price", nullable = false, precision = 22, scale = 0)
    private double price;
    @Column(name = "qty", nullable = false)
    private int qty;

    public Product() {
    }

    public Product(String pname, double price, int qty) {
        this.pname = pname;
        this.price = price;
        this.qty = qty;
    }
    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return this.pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}