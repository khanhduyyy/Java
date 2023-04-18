/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Home
 */
@Embeddable
public class OrderDetailID implements Serializable {

    @Column(name = "OrderID")
    private int OrderID;

    @Column(name = "VegetableID")
    private int VegetableID;

    public OrderDetailID() {
    }

    public OrderDetailID(int OrderID, int VegetableID) {
        this.OrderID = OrderID;
        this.VegetableID = VegetableID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getVegetableID() {
        return VegetableID;
    }

    public void setVegetableID(int VegetableID) {
        this.VegetableID = VegetableID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.OrderID;
        hash = 97 * hash + this.VegetableID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderDetailID other = (OrderDetailID) obj;
        if (this.OrderID != other.OrderID) {
            return false;
        }
        return this.VegetableID == other.VegetableID;
    }
    
    
}
