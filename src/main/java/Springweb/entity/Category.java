/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.entity;

import javax.persistence.*;

@Entity
@Table(name ="Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer CatagoryID;
    
    private String Name;
    
    private String Description;

    public Integer getCatagoryID() {
        return CatagoryID;
    }

    public void setCatagoryID(Integer CatagoryID) {
        this.CatagoryID = CatagoryID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
