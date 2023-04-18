/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Springweb.service;

import Springweb.entity.CartItem;
import java.util.Collection;
import org.springframework.stereotype.Service;



/**
 *
 * @author Home
 */
@Service
public interface ShoppingCartService {

    void add(CartItem item);

    double getAmount();

    Collection<CartItem> getCartItem();

    int getCount();

    void remove(int vegetableID);

    void update(int vegetableID, int quantity);

    void clear();
    
    
    
}
