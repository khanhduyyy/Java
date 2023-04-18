/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author Home
 */
@Entity
@Table(name = "orderdetail")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailID primaryKey = new OrderDetailID();
    
    @ManyToOne
    @MapsId("OrderID")
    @JoinColumn(name = "OrderID")
    private Order order;

    private Integer Quantity;
    
    private Float Price;

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float Price) {
        this.Price = Price;
    }
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    @ManyToOne
    @MapsId("VegetableID")
    @JoinColumn(name = "VegetableID")
    private Vegetable vegetable;
}
